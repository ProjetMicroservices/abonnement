package com.esprit.abonnement.service;

import java.util.List;

import com.esprit.abonnement.entities.Abonnement;;



public interface IabonnementServiceImpl {

	List<Abonnement> getAllabonnement();
	public Long addabonnement(Abonnement abonnement);
	public long deleteabonnementByID(Long id );
	public Abonnement updateabonnement(Abonnement newabonnement);
	public List<Abonnement> getabonnementByNames(String firstName);
	List<String> getAllabonnementByNames();
}
