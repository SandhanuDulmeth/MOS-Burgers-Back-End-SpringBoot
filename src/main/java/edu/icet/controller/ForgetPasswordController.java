package edu.icet.controller;


import edu.icet.Model.ResetPasswordRequest;
import edu.icet.serivce.custom.ForgetPasswordSerivce;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin
public class ForgetPasswordController {

    private final ForgetPasswordSerivce forgetPasswordService;

    @PostMapping("/sendOtp")
    public ResponseEntity<String> sendOtp(@RequestBody ResetPasswordRequest request) {
        boolean sent = forgetPasswordService.sendOtp(request.getEmail());
        if (sent) {
            return ResponseEntity.ok("OTP sent successfully");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Failed to send OTP. Please try again.");
    }

    @PostMapping("/resetPassword")
    public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordRequest request) {
        boolean reset = forgetPasswordService.resetPassword(
                request.getEmail(), request.getOtp(), request.getNewPassword());
        if (reset) {
            return ResponseEntity.ok("Password reset successfully");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Invalid OTP or error resetting password.");
    }
}
