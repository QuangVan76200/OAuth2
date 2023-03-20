package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.IUserDao;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ResponseMessage;
import com.example.demo.security.CurrentUser;
import com.example.demo.security.UserPrincipal;
import com.example.demo.service.IUserService;

@RestController
public class UserController {

	@Autowired
	private IUserDao userRepository;

	@Autowired
	private IUserService userService;

	@GetMapping("/user/me")
	@PreAuthorize("hasRole('USER')")
	public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
		return userRepository.findById(userPrincipal.getId())
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
	}

	@PostMapping("/user/me/update")
	@PreAuthorize("hasRole('USER')")
	// String name, String email, MultipartFile imageUrl, String password
	public ResponseEntity<?> updateUserProfile(@RequestParam String name, @RequestParam String email,
			@RequestParam MultipartFile imageUrl, @CurrentUser UserPrincipal userPrincipal) {
		try {
			User newInfoUser = userService.updateUserProfile(name, email, imageUrl, userPrincipal).get();
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseMessage("upadate successfully", "", newInfoUser));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseMessage("Failed", e.getMessage(), null));
		}

	}

}
