package com.ssafy.profolio.domain.resume;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumRepository extends JpaRepository<Resume, Long> {
    void delete(Resume resume);
    Resume getById(Long id);
}
