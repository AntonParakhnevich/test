package com.example.test.test.repository;

import com.example.test.test.model.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudioRepository extends JpaRepository<Studio, Long> {

  Integer countByPhoneAndName(String phone, String name);
}
