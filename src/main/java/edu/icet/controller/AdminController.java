package edu.icet.controller;

import edu.icet.Model.LoginRequest;
import edu.icet.serivce.custom.AdminService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/AdminController")
@RequiredArgsConstructor
public class AdminController {

    final AdminService adminService;

    @PostMapping("/login")
    public ResponseEntity<Boolean> authenticate(@RequestBody LoginRequest loginRequest) {
        if (loginRequest.getPassword() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
        }

        String storedPassword = adminService.getPassword(loginRequest.getEmail());
        if (storedPassword != null && storedPassword.equals(loginRequest.getPassword())) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
    }




}
