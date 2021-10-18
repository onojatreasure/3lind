package com.treasureio.line.repositories;

import com.treasureio.line.models.Check;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CheckRepository extends JpaRepository<Check, Long> {

    Optional<Check> findById(Long id);
}
