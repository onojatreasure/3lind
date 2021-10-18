package com.treasureio.line.repositories;

import com.treasureio.line.models.File;
import org.springframework.data.jpa.repository.JpaRepository;



public interface FileRepository extends JpaRepository<File, String> {
}
