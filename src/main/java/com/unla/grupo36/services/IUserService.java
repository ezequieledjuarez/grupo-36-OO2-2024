package com.unla.grupo36.services;

import com.unla.grupo36.dtos.UserDTO;
import com.unla.grupo36.entities.User;

public interface IUserService{

	public User insertOrUpdate(UserDTO user);

	public void insertIfDatabaseIsEmpty(UserDTO userDTO);
}
