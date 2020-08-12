//
package com.moly7x.springmvcboot;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.moly7x.springmvcboot.model.Ailen;

@Repository
public interface AilenRepo extends JpaRepository<Ailen, Integer>{
	
//	List<Ailen> findByAname(String aname);
	
	@Query("from Ailen where aname = :name")
	List<Ailen> find(@Param("name") String aname);

}
