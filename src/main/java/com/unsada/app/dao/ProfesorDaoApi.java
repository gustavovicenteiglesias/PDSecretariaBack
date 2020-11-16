package com.unsada.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.unsada.app.modelo.Escuela;
import com.unsada.app.modelo.Profesor;




@Transactional
public interface ProfesorDaoApi extends CrudRepository<Profesor, Integer>{
	@Query(value="select * from profesor ORDER by id DESC LIMIT 1",nativeQuery = true)
	Optional<Profesor> findUltimo();
	@Query(value="select p.* from profesor p\r\n" + 
			"inner join rel_escuelas_profesores r\r\n" + 
			"ON r.fk_profesores=p.id AND r.fk_escuelas=:id",nativeQuery = true)
	 Iterable<Profesor> proofesporescuela(@Param("id") int id);
}
