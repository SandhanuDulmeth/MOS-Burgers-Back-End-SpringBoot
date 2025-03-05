package edu.icet.serivce.custom;

public interface ForgetPasswordSerivce {
    boolean sendOtp(String email);

    boolean resetPassword(String email, String otp, String newPassword);
}
