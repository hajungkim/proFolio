package com.ssafy.profolio.domain.career;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CareerRepository extends JpaRepository<Career, Long> {

    List<Career> findByUserId(Long userId);
}
