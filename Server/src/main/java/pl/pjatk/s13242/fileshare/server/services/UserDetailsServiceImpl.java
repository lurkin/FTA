package pl.pjatk.s13242.fileshare.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.pjatk.s13242.fileshare.server.entities.Account;
import pl.pjatk.s13242.fileshare.server.repos.AccountRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AccountRepository repository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = repository.findByEmail(email);


        if (account == null) {
            throw new UsernameNotFoundException(email + " not found.");
        }

        return new User(account.getEmail(), account.getPassword(), account.getRoles());

    }
}
