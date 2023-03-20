package com.example.demo.service.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.common.StoreFile;
import com.example.demo.common.ValidateCurrentUser;
import com.example.demo.dao.IFileDBDao;
import com.example.demo.dao.IUserDao;
import com.example.demo.entity.User;
import com.example.demo.exception.EmailAlreadyExistsException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.security.CurrentUser;
import com.example.demo.security.UserPrincipal;
import com.example.demo.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userRepository;

	@Autowired
	IFileDBDao iFileDBDao;

	@Autowired
	StoreFile storeFile;

	@Autowired
	private ValidateCurrentUser curentUser;

	@Override
	public Optional<User> updateUserProfile(String name, String email, MultipartFile imageUrl,
			@CurrentUser UserPrincipal userPrincipal) throws Exception {

		User authUser = curentUser.getCurrentUser(userPrincipal);
		
		if (authUser != null) {
			if (name.isBlank()) {
				authUser.setName(authUser.getName());
			}

			if (!email.isBlank()) {
				Optional<User> checkEmailUser = userRepository.findByEmail(email);
				if (!checkEmailUser.isPresent()) {
					authUser.setEmail(email);
				}

				throw new EmailAlreadyExistsException("Email already exists!");

			}

			if (imageUrl != null && imageUrl.getSize() > 0) {
				String imgUrl = storeFile.uploadFile(imageUrl).toString();
				authUser.setImageUrl(imgUrl);
			}

			userRepository.save(authUser);
			return Optional.of(authUser);
		} else {
			throw new UserNotFoundException("User not found!");
		}
	}

}
