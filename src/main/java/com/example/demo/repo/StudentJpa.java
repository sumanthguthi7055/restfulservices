package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentJpa extends JpaRepository<Student,Integer>{

	@Query(value="select mobile from student",nativeQuery=true)
	List<String> getMobile();
	
	//Student findByMobile();
	@Query(value="update student set mail=:mail,mobile=:mobile,name=:name WHERE id=:ide",nativeQuery = true)
	void updateRow(String mail, String mobile, String name, int ide);

	@Query(value="select id from student",nativeQuery = true)
	List<Integer> getID();
	

}
