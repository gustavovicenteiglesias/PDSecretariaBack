package com.unsada.app.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import com.unsada.app.modelo.Escuela;
import com.unsada.app.modelo.Profesor;

@Transactional
public interface EscuelaDaoApi extends CrudRepository<Escuela, Integer> {
	
	 Optional<Escuela> findByNombre(String nombre);
	 Iterable<Escuela> findByNombreLike(String nombre);
	 @Query(value="select p.*, e.* from profesor p\r\n" + 
				"inner join rel_escuelas_profesores r\r\n" + 
				"ON r.fk_profesores=p.id AND r.fk_escuelas=:id\r\n" + 
				"inner join escuela e on e.id_escuela=r.fk_escuelas",nativeQuery = true)
		 Iterable<Escuela> proofesporescuela(@Param("id") int id);
}

