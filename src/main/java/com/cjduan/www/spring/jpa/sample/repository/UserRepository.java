package com.cjduan.www.spring.jpa.sample.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cjduan.www.spring.jpa.sample.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
