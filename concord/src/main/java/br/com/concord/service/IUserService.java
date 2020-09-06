package br.com.concord.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.com.concord.model.User;
import br.com.concord.web.dto.UserRegistrationDto;

public interface IUserService extends UserDetailsService{
	
	User save(UserRegistrationDto registrationDto);
}
