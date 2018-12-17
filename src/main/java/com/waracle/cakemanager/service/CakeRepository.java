package com.waracle.cakemanager.service;

import com.waracle.cakemanager.domain.CakeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CakeRepository extends JpaRepository<CakeEntity, Long> {
}
