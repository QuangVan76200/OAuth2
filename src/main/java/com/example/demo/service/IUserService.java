package com.example.demo.service;

import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.User;
import com.example.demo.security.CurrentUser;
import com.example.demo.security.UserPrincipal;

import io.jsonwebtoken.io.IOException;

public interface IUserService {

	Optional<User> updateUserProfile(String name, String email, MultipartFile imageUrl,
			@CurrentUser UserPrincipal userPrincipal) throws Exception;
}
