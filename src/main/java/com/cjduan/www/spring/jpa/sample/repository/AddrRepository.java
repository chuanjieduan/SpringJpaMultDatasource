package com.cjduan.www.spring.jpa.sample.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cjduan.www.spring.jpa.sample.domain.Addr;

public interface AddrRepository extends JpaRepository<Addr, Integer> {
}
