package com.unla.grupo36.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.grupo36.entities.User;

@Repository("userRepository")
public interface IUserRepository extends JpaRepository<User, Serializable> {

	@Query("SELECT u FROM User u JOIN FETCH u.userRoles WHERE u.username = (:username)")
	public abstract User findByUsernameAndFetchUserRolesEagerly(@Param("username") String username);
	
	@Modifying
	@Query(value=
	"UPDATE User u set u.enabled=1 where u.id = :id"
	,nativeQuery = true)
	public abstract void activeUser(@Param("id") int id);
	
}
