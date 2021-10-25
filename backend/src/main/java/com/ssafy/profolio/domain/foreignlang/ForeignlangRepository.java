package com.ssafy.profolio.domain.foreignlang;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ForeignlangRepository extends JpaRepository<Foreignlang, Long> {

    List<Foreignlang> findByUserId(Long userId);
}
