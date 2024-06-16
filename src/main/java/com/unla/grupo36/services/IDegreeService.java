package com.unla.grupo36.services;
import java.util.List;

import com.unla.grupo36.dtos.DegreeDTO;
import com.unla.grupo36.entities.Degree;


public interface IDegreeService {

	public List<Degree> getAll();

	public DegreeDTO insertOrUpdate(DegreeDTO degreeModel);

	public boolean remove(int id);
}

