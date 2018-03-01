package com.vrvideo.data.repository;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vrvideo.data.entity.Establishment;


public interface EstablishmentRepository extends JpaRepository<Establishment, Long> {
	
	 Establishment findEstablishmentByUserId (long userId); 
    
     @Transactional
     List<Establishment> deleteEstablishmentByUserId(long userId);
     
}
