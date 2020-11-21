package jamierhys.maintainme.maintainmeserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jamierhys.maintainme.maintainmeserver.entities.EntityUser;
import jamierhys.maintainme.maintainmeserver.repositories.EntityUserRepository;

@Service
public class EntityUserDetailServiceImpl implements UserDetailsService {
    @Autowired EntityUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        EntityUser currentUser = repository.findByUsername(username);
        UserDetails user = new User(
            username, 
            currentUser.getPassword(),
            true,
            true,
            true,
            true,
            AuthorityUtils.createAuthorityList(currentUser.getRole()));
        
        return user;
    }
}