package com.esprit.abonnement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.abonnement.entities.Abonnement;


import com.esprit.abonnement.repository.AbonnementRepository;





@Service
public class AbonnementService implements IabonnementServiceImpl  {


@Autowired
AbonnementRepository abonnementRepository ;


List<Long> list = new ArrayList<Long>();
List<Long> listc = new ArrayList<Long>();
List<Abonnement> listab = new ArrayList<Abonnement>();







///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
@Override
public String toString() {
	return "AbonnementService []";
}







@Override
public List<Abonnement> getAllabonnement() {
	return	(List<Abonnement>) abonnementRepository.findAll();
}







@Override
public Long addabonnement(Abonnement abonnement) {
	abonnementRepository.save(abonnement);
	return abonnement.getId();
}







@Override
public long deleteabonnementByID(Long id) {
	Abonnement abonnement = abonnementRepository.findById(id).get();
	abonnementRepository.delete(abonnement);
	return 0;
	
}







@Override
public Abonnement updateabonnement (Abonnement abonnement) {
	
	
	return abonnementRepository.save(abonnement);

}







@Override
public List<String> getAllabonnementByNames() {
	return abonnementRepository.getAllabonnementsByNames();
}







@Override
public List<Abonnement>  getabonnementByNames(String firstName){
	return abonnementRepository.getabonnementByNames(firstName);
}

public int getNombreabonnementJPQL() {
	return abonnementRepository.countab();
}

public List<String> getAllNamesJPQL() {
	return abonnementRepository.abonnementCards();

}
}
