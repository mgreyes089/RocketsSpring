package com.example.rocketsspring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RocketRepository extends JpaRepository<Rocket, Long> {
}
