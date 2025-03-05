package edu.icet.serivce.custom.impl;


import edu.icet.Model.Admin;
import edu.icet.repository.custom.AdminRepository;
import edu.icet.serivce.custom.ForgetPasswordSerivce;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

@Service
@Primary
@RequiredArgsConstructor
public class ForgetPasswordServiceImpl implements ForgetPasswordSerivce {

    // In-memory OTP storage; for production use a persistent store or cache with TTL.
    private final Map<String, String> otpStorage = new ConcurrentHashMap<>();

    // Inject your user repository (or service) to update the password.
    private final AdminRepository userRepository;

    public boolean sendOtp(String email) {
        String otp = generateOTP();
        boolean emailSent = sendEmail(email, otp);
        if (emailSent) {
            otpStorage.put(email, otp);
            return true;
        }
        return false;
    }

    private boolean sendEmail(String recipientEmail, String otp) {
        // Email server configuration
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        // Replace these with your actual email and app password (or use environment variables)
        String myEmail = "your-email@gmail.com";
        String password = "your-app-specific-password";


        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myEmail, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Password Reset OTP");
            message.setText("Your OTP is: " + otp);
            Transport.send(message);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private String generateOTP() {
        StringBuilder otp = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < 6; i++) {
            otp.append(rand.nextInt(10));
        }
        return otp.toString();
    }

    public boolean resetPassword(String email, String otp, String newPassword) {
        String storedOtp = otpStorage.get(email);
        if (storedOtp != null && storedOtp.equals(otp)) {
            // OTP is correct; update the user's password
            Admin user = userRepository.findByEmail(email);
            if (user != null) {
                // Update the password (ensure to hash it in a real-world application)
                user.setPassword(newPassword);
                userRepository.save(user);
                // Clear the stored OTP after successful reset
                otpStorage.remove(email);
                return true;
            }
        }
        return false;
    }
}
