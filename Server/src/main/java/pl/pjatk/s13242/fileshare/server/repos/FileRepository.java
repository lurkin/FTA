package pl.pjatk.s13242.fileshare.server.repos;

import pl.pjatk.s13242.fileshare.server.entities.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
