package com.example.rocketsspring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PropellerRepository extends JpaRepository<Propeller, Long> {
    @Transactional
    List<Rocket> deleteAllByRocketId(Long id);

}
