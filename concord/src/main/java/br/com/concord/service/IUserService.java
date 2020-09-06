package br.com.concord.service;

import java.util.List;

import br.com.concord.model.User;

public interface IUserService {
	
	List<User> findAll();
}
