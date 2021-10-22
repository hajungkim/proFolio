package com.ssafy.profolio.domain.portfolio;

import com.ssafy.profolio.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    List<Portfolio> getByUser(User user);
    Portfolio save(Portfolio portfolio);
    Portfolio getById(Long id);
}
