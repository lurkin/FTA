package pl.pjatk.s13242.fileshare.server.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.s13242.fileshare.server.entities.Account;
import pl.pjatk.s13242.fileshare.server.entities.File;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByEmail(String email);
}
