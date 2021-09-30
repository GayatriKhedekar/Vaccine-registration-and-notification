package com.vaccination.server.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vaccination.server.models.bookslotModel;

public interface bookslotRepo extends JpaRepository<bookslotModel, Long>{
	
	
	public List<bookslotModel> findAllBysid(long uid);
	
	public List<bookslotModel> findAllByuid(long uid);
	
	public List<bookslotModel> findAllByhid(long hid);
	
	@Query("SELECT COUNT(u) FROM bookslotModel u WHERE u.uid=:uid and taken=1")
	public String countTakenId(@Param("uid") long uid);

}
