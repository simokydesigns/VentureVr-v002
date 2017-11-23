package com.vrvideo.data.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vrvideo.data.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
  
	User findByUserId (long userId); 
      
      @Transactional
      List<User> deleteUserByUserId(long userId);
      
      @Transactional
      List<User> deleteUserByLastNameAndFirstName(String lastName, String firstName);
}
