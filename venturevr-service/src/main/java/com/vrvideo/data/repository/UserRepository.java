package com.vrvideo.data.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vrvideo.data.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
  
	User findByUserId (long userId); 
	
	User findOneByUserName(String userName);
      
      @Transactional
      List<User> deleteUserByUserId(long userId);
      
      @Transactional
      List<User> deleteUserByUserName(String userName);
           
}
