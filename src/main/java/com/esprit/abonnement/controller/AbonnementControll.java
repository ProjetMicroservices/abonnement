package com.esprit.abonnement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import com.esprit.abonnement.entities.Abonnement;


import com.esprit.abonnement.service.AbonnementService;

@RestController
@RequestMapping(value = "/abonnements")
public class AbonnementControll {
@Autowired
AbonnementService abonnementService;


//Configuration de la methode POST
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Long> addabonnement(@RequestBody Abonnement abonnement){
		return new ResponseEntity<>(abonnementService.addabonnement(abonnement), HttpStatus.OK);
	}
	
//Configuration de la methode PUT
		//Execution URL: http://localhost:8282/abonnements/search
		@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseStatus(HttpStatus.OK)
		public ResponseEntity<Abonnement> updateabonnement(@PathVariable(value = "id") int id,
				@RequestBody Abonnement abonnement){
			return new ResponseEntity<>(abonnementService.updateabonnement(abonnement), HttpStatus.OK);
		}


		//Configuation de la methode Delete
		//Execution URL: http://localhost:8282/api/candidats/{id}
		@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseStatus(HttpStatus.OK)
		public ResponseEntity<Abonnement> deleteCandidat(@PathVariable(value = "id") long id){
			abonnementService.deleteabonnementByID(id);
			return new ResponseEntity<>(HttpStatus.OK);
			
		}
		
		//Configuration de la methode GET All
		//Execution URL: http://localhost:8282/abonnements/
		@GetMapping
		@ResponseStatus(HttpStatus.OK)
		public List<Abonnement> getAllabonnement(){
			return abonnementService.getAllabonnement();
		}
		
		//Configuration de la methode de recherche GET specifique avec PathParam
		//il faut que les noms des methodes ici Candidat Resst API) et celles dans CandidatService n'aient pas le meme nom, sinon ca degere une erreue de mapping
		//Execution URL: http://localhost:8282/api/candidats
		@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseStatus(HttpStatus.OK)
		public ResponseEntity<List<Abonnement>> gettabonnementByNames(@PathVariable(value = "firstName") String firstName){
			return new ResponseEntity<>(abonnementService.getabonnementByNames(firstName) , HttpStatus.OK);
		}

		 @GetMapping(value = "getNombre")
		    @ResponseBody
			public int getNombreabonnementJPQL() {
				
				return abonnementService.getNombreabonnementJPQL();
			}
		 
		 
		    @GetMapping(value = "getAllCards")
		    @ResponseBody
			public List<String> getAllCardsNamesJPQL() {
				
				return abonnementService.getAllNamesJPQL();
			}


}
