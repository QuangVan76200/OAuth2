//package com.example.demo.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.oauth2.client.registration.ClientRegistration;
//import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
//import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
//import org.springframework.security.oauth2.core.AuthorizationGrantType;
//
//@Configuration
//@EnableOAuth2Client
//public class OAuth2ClientConfig {
//
//	@Bean
//	public ClientRegistrationRepository clientRegistrationRepository() {
//		// Define your client registration details here
//		return new InMemoryClientRegistrationRepository(clientRegistration());
//	}
//
//	private ClientRegistration clientRegistration() {
//		// Define your client registration details here
//		return ClientRegistration
//				.withRegistrationId("146560137520-2ikv5of57o632dcimgnrsog7por5pa2f.apps.googleusercontent.com")
//				.clientId("524634499753053").clientId("ebcba0de613f8ae2f529")
//				.clientId("146560137520-2ikv5of57o632dcimgnrsog7por5pa2f.apps.googleusercontent.com")
//				.clientSecret("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").clientSecret("48bec3c4f7bcf72efcd96d2f630ce9c7")
//				.clientSecret("30a0073792b924053feed9fe244abab7cd141957")
//				.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//				.redirectUri("http://localhost:8080/login/oauth2/code/my-client-id").build();
//	}
//}
