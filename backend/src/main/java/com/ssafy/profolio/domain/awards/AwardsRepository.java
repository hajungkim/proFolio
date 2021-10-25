package com.ssafy.profolio.domain.awards;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AwardsRepository extends JpaRepository<Awards, Long> {

    List<Awards> findByUserId(Long userId);
}
