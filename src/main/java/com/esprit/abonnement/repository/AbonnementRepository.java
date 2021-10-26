package com.esprit.abonnement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.abonnement.entities.Abonnement;



@Repository
public interface AbonnementRepository extends JpaRepository<Abonnement, Long>  {

	@Query("SELECT firstName FROM Abonnement")
    public List<String> getAllabonnementsByNames();
	
	@Query("SELECT u FROM Abonnement u where u.firstName=:firstName")
    public List<Abonnement> getabonnementByNames(@Param("firstName")String firstName);
	
	@Query("SELECT count(*) FROM Abonnement")
	public int countab();
	
	 @Query("SELECT typeCard FROM Abonnement")
	    public List<String> abonnementCards();
	    
}

