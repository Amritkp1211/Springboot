package com.customException.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customException.entiy.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

}
