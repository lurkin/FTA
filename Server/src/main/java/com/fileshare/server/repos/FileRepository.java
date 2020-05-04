package com.fileshare.server.repos;

import com.fileshare.server.entities.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
