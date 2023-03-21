package com.fu.fcredit.user.controller;

import com.fu.fcredit.user.entity.User;
import com.fu.fcredit.user.model.ChangePasswordRequest;
import com.fu.fcredit.user.service.UserService;
import com.fu.fcredit.user.validate.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fcredit/profile")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserValidator validator;

    @PutMapping("/{username}")
    public ResponseEntity<String> updateProfile(@PathVariable("username") String username,
                                                @RequestBody User user) {
        userService.updateUser(username, user);

        return ResponseEntity.ok("Thành công!");
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getProfile(@PathVariable("username") String username) {
        User user = userService.getUser(username);

        user.setPassword(null);

        return ResponseEntity.ok(user);
    }

    @PutMapping("/password/{username}")
    public ResponseEntity<String> changePassword(@PathVariable("username") String username,
                                                 @RequestBody ChangePasswordRequest data) {


        validator.validateForChangePassword(username, data);

        userService.updatePassword(username, data.getNewPassword());

        return ResponseEntity.ok("Thành công");
    }

}
