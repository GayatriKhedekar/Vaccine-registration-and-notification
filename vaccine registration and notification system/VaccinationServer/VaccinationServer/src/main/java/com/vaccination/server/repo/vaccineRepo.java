package com.vaccination.server.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaccination.server.models.vaccineModel;

public interface vaccineRepo extends JpaRepository<vaccineModel,Long> {

	
	public List<vaccineModel> findByhid(long hid);
	
	public List<vaccineModel> findAllBycity(String city);
	
	
}
