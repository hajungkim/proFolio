package com.ssafy.profolio.domain.technologystack;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TechnologyStackRepository extends JpaRepository<TechnologyStack, Long> {

    List<TechnologyStack> findByUserId(Long userId);
}
