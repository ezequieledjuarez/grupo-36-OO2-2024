package com.unla.grupo36.services.implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unla.grupo36.dtos.UserDTO;
import com.unla.grupo36.entities.UserRole;
import com.unla.grupo36.helpers.BCryptPasswordEncoderHelper;
import com.unla.grupo36.repositories.IUserRepository;
import com.unla.grupo36.repositories.IUserRoleRepository;
import com.unla.grupo36.services.IUserService;

@Service("userService")
public class UserService implements UserDetailsService, IUserService{

	private IUserRepository userRepository;
	private IUserRoleRepository userRoleRepository;
	
	private ModelMapper modelMapper = new ModelMapper();

	
	public UserService(IUserRepository userRepository, IUserRoleRepository userRoleRepository) {
		this.userRepository = userRepository;
		this.userRoleRepository = userRoleRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.unla.grupo36.entities.User user = userRepository.findByUsernameAndFetchUserRolesEagerly(username);
		return buildUser(user, buildGrantedAuthorities(user.getUserRoles()));
	}
	
	public com.unla.grupo36.entities.User insertOrUpdate(UserDTO userToInsert) {
		com.unla.grupo36.entities.User user = new com.unla.grupo36.entities.User(userToInsert.getUsername(), BCryptPasswordEncoderHelper.encodePassword(userToInsert.getPassword()), true); 
		
		return userRepository.save(user);
	}

	private User buildUser(com.unla.grupo36.entities.User user, List<GrantedAuthority> grantedAuthorities) {
		return new User(user.getUsername(), user.getPassword(), user.isEnabled(),
						true, true, true, //accountNonExpired, credentialsNonExpired, accountNonLocked,
						grantedAuthorities);
	}

	private List<GrantedAuthority> buildGrantedAuthorities(Set<UserRole> userRoles) {
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for(UserRole userRole: userRoles) {
			grantedAuthorities.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		return new ArrayList<>(grantedAuthorities);
	}

	@Override
	@Transactional
	public void insertIfDatabaseIsEmpty(UserDTO userDTO) {
		List<com.unla.grupo36.entities.User> users = userRepository.findAll();
		
		if(users.isEmpty()) {
			com.unla.grupo36.entities.User user = userRepository.save(modelMapper.map(userDTO, com.unla.grupo36.entities.User.class));
			userRepository.activeUser(user.getId());
			userRoleRepository.save(new UserRole(1, user, "ROLE_ADMIN"));
		}
			
	}



}
