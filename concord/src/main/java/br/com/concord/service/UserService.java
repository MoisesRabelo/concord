package br.com.concord.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.concord.model.User;
import br.com.concord.repository.UserRepository;

@Service
public class UserService implements IUserService
{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> findAll(){
		
		List<User> users = (List<User>) userRepository.findAll();
		
		return users;
	}
}
