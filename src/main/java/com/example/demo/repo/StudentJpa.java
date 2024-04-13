package com.example.demo.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface StudentJpa extends JpaRepository<Student,Integer>{

	@Query(value="select mobile from student",nativeQuery=true)
	List<String> getMobile();

	@Query(value="select id from student",nativeQuery = true)
	List<Integer> getID();
	@Modifying
	@Query(value="update student s set s.mail=:mail,mobile=:mobile,name=:ename WHERE s.id=:ide",nativeQuery = true)
	void updateRow(@Param("mail") String mail,@Param("mobile") String mobile, @Param("ename") String ename, @Param("ide")int ide);

}
