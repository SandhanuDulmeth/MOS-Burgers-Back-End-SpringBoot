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
    public ResponseEntity<Boolean> sendOtp(@RequestBody ResetPasswordRequest request) {
        boolean sent = forgetPasswordService.sendOtp(request.getEmail());
        if (sent) {
            return ResponseEntity.ok(Boolean.TRUE);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Boolean.FALSE);
    }

    @PostMapping("/resetPassword")
    public ResponseEntity<Boolean> resetPassword(@RequestBody ResetPasswordRequest request) {
        boolean reset = forgetPasswordService.resetPassword(
                request.getEmail(), request.getOtp(), request.getNewPassword());
        if (reset) {
            return ResponseEntity.ok(Boolean.TRUE);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Boolean.FALSE);
    }
}
