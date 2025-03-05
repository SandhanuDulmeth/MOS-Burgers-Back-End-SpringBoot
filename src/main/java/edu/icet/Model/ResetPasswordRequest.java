package edu.icet.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResetPasswordRequest {
    private String email;
    private String otp;
    private String newPassword;
}
