package br.com.concord.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.concord.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{

}
