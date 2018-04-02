package nhu.novahub.assignment4.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.stereotype.Service;

import nhu.novahub.assignment4.dao.RoleRepository;
import nhu.novahub.assignment4.dao.UserRepository;
import nhu.novahub.assignment4.entities.User;
@Service("customUserDetailsService")

public class CustomUserDetailsService implements UserDetailsService{

 private final UserRepository userRepository;

 private final RoleRepository roleRepository;

 @Autowired

    public CustomUserDetailsService(UserRepository userRepository,RoleRepository userRolesRepository) {

        this.userRepository = userRepository;

        this.roleRepository=userRolesRepository;

    }

 @Override

 public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

  User user=userRepository.findByEmail(username);

  if(null == user){

   throw new UsernameNotFoundException("No user present with email: "+ username);

  }else{

   List<String> userRoles=roleRepository.findRoleByEmail(username);
   return new CustomUserDetails(user,userRoles);

  }

 }

}
