package com.example.test.test.repository;

import com.example.test.test.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

  Integer countByNameAndStudioId(String name, Long studioId);
}
