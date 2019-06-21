
package javaExamProject.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javaExamProject.spring.model.Business;
import javaExamProject.spring.model.Metadata;
import javaExamProject.spring.service.BusinessService;
import javaExamProject.spring.service.BusinessServiceImplements;

import javaExamProject.spring.util.Error;
/**
 * Con questa classe l'utente  può interagire con l'applicazione
 * @author Angela D'Antonio 
 * @author Laura Della Sciucca
 */
@RestController
@RequestMapping("/api")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	BusinessService BusinessService; 

	/**
	 * Restituisce tutte le attivita' che siamo riusciti a recuperare dal file CSV
	 */

	@RequestMapping(value = "/business/", method = RequestMethod.GET)
	public ResponseEntity<List<Business>> listAll() {
		List<Business> business = BusinessService.getBusiness();
		if (business.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Business>>(business, HttpStatus.OK);
	}

	/**
	 * Restituisce tutte le attivita' che siamo riusciti a recuperare dal file CSV 
	 * in base al codice scelto dall'utente
	 */


	@RequestMapping(value = "/business/code/{code}", method = RequestMethod.GET)
	public ResponseEntity<?> findBusinessByCode(@PathVariable("code") String codice) {
		logger.info("Fetching Business with code {}", codice);
		Business business = BusinessService.findBusinessByCode(codice);
		if (business == null) {
			logger.error("Business with id {} not found.", codice);
			return new ResponseEntity(new Error("Business with code " + codice + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Business>(business, HttpStatus.OK);
	}

	/**
	 * Restituisce tutte le attivita' con codice di municipio scelto dall'utente
	 */

	@RequestMapping(value = "/business/municipality/{code}", method = RequestMethod.GET)
	public ResponseEntity<?> findBusinessByMunicipality(@PathVariable("code") String codice) {
		logger.info("Fetching Business with code {}", codice);
		ArrayList<Business> business = BusinessService.findBusinessByMunicipality(codice);
		if (business == null) {
			logger.error("Business with id {} not found.", codice);
			return new ResponseEntity(new Error("Business with code " + codice + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ArrayList<Business>>(business, HttpStatus.OK);
	}


	/**
	 * Restituisce il conteggio di tutte le attivita' con un  attributo e variabile scelti dall'utente
	 */


	@RequestMapping(value = "/business/count/{variable}/value/{value}", method = RequestMethod.GET)
	public ResponseEntity<?> countBusiness(@PathVariable("variable")String variable , @PathVariable("value") String value) {
		logger.info("Counting Business with variable {} and value {}", variable,value);
		int response = BusinessService.countBusiness(variable, value);
		if (response == 0) {
			logger.error("Error request, variable {}  with value {} not found.", variable,value);
			return new ResponseEntity(new Error("Error request, variable : " + variable +" with value : "+value+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Integer>(response, HttpStatus.OK);
	}

	/**
	 * Restituisce la media di tutte le attivita' con un  attributo e variabile scelti dall'utente
	 */

	@RequestMapping(value = "/business/avg/{variable}/value/{value}", method = RequestMethod.GET)
	public ResponseEntity<?> avgBusiness(@PathVariable("variable")String variable , @PathVariable("value") String value) {
		logger.info("Counting Business with variable {} and value {}", variable,value);
		String response = BusinessService.avgBusiness(variable, value);
		if (response.isEmpty()) {
			logger.error("Error request, variable {}  with value {} not found.", variable,value);
			return new ResponseEntity(new Error("Error request, variable : " + variable +" with value : "+value+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	/**
	 * Restituisce il massimo di tutte le attivita' con variabile scelta dall'utente
	 */

	@RequestMapping(value = "/business/max/{variable}", method = RequestMethod.GET)
	public ResponseEntity<?> maxBusiness(@PathVariable("variable")String variable) {
		logger.info("Counting Business with variable {} ", variable);
		String response = BusinessService.maxBusiness(variable);
		if (response.isEmpty()) {
			logger.error("Error request, variable {}  with value {} not found.", variable);
			return new ResponseEntity(HttpStatus.NO_CONTENT);		
		}
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	/**
	 * Restituisce il minimo di tutte le attivita' con variabile scelta dall'utente
	 */

	@RequestMapping(value = "/business/min/{variable}", method = RequestMethod.GET)
	public ResponseEntity<?> minBusiness(@PathVariable("variable")String variable) {
		logger.info("Counting Business with variable {} ", variable);
		String response = BusinessService.minBusiness(variable);
		if (response.isEmpty()) {
			logger.error("Error request, variable {}  with value {} not found.", variable);
			return new ResponseEntity(HttpStatus.NO_CONTENT);		
		}
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	/**
	 * Restituisce la somma delle superfici totali delle attivita' con variabile municipio e  valore di municpio scelto dall'utente
	 */
	@RequestMapping(value = "/business/sum/{variable}/value/{value}", method = RequestMethod.GET)
	public ResponseEntity<?> sumBusiness(@PathVariable("variable")String variable , @PathVariable("value") String value) {
		logger.info("Counting Business with variable {} and value {}", variable,value);
		int response = BusinessService.sumBusiness(variable, value);
		if (response == 0) {
			logger.error("Error request, variable {}  with value {} not found.", variable,value);
			return new ResponseEntity(new Error("Error request, variable : " + variable +" with value : "+value+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Integer>(response, HttpStatus.OK);

	}

	/**
	 * Restituisce la deviazione standard delle superifici totali delle varie attivita'
	 */

	@RequestMapping(value = "/business/devStdB", method = RequestMethod.GET)
	public ResponseEntity<?> DevStdBusiness() {
		String response = BusinessService.devStdBusiness();
		if (response.isEmpty()) {
			logger.error("Error request, DevStd not found.");
			return new ResponseEntity(new Error("Error request, DevStd not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(response, HttpStatus.OK);

	}
	/**
	 * Filtra le varie attivita' in base alla superficie totale con un determinato operatore (>,<,=>,<=,=><=) scelto dall'utente
	 */

	@RequestMapping(value = "/business/cFilter", method = RequestMethod.GET)
	public ResponseEntity<?> cFilter(@RequestParam("totalArea") int[] totalArea, @RequestParam("operator") String operator) {
		logger.info("Filtering Business with totalArea {} and operator{}, ", totalArea, operator);
		ArrayList<Business> business = BusinessService.cFilter(operator,totalArea);
		if(business == null) {
			logger.error("Error request, business not found.");
			return new ResponseEntity(new Error("Error request, Business not found"), HttpStatus.NOT_FOUND);
		}
		ArrayList<Business> response = business;
		return new ResponseEntity<ArrayList<Business>>(response, HttpStatus.OK);
	}

	/**
	 * Filtra le varie attivita' in base alla via inserita dall'utente
	 */

	@RequestMapping(value = "/business/addressFilter", method = RequestMethod.GET)
	public ResponseEntity<?> addressFilter(@RequestParam("address") String address) {
		logger.info("Filtering Business with address {} , ", address);
		ArrayList<Business> business = BusinessService.addressFilter(address);
		if(business ==null) {
			logger.error("Error request, business not found.");
			return new ResponseEntity(new Error("Error request, Business not found"), HttpStatus.NOT_FOUND);

		}
		ArrayList<Business> response = business;
		return new ResponseEntity<ArrayList<Business>>(response, HttpStatus.OK);
	}

	/**
	 * Filtra le varie attivita' che rientrano in un determinato raggio di distanza {range}
	 * a partire da un punto {longitude},{latitude} scelto dall'utente
	 */

	@RequestMapping(value = "/business/dFilter", method = RequestMethod.GET)
	public ResponseEntity<?>  distanceFilter(@RequestParam("range") double range,@RequestParam("latitude") double latitude,@RequestParam("longitude") double longitude) {
		logger.info("Filtering Business with range {} ,latitude {} and longitude {} ", range,latitude,longitude);
		ArrayList<Business> business = BusinessService.distanceFilter(range,latitude,longitude);
		if(business == null) {
			logger.error("Error request, business not found.");
			return new ResponseEntity(new Error("Error request, Business not found"), HttpStatus.NOT_FOUND);
		}
		ArrayList<Business> response = business;
		return new ResponseEntity<ArrayList<Business>>(response, HttpStatus.OK);
	}
	/**
	 * Filtra le varie attività in base agli operatori "in" oppure "nin".
	 * Se l'utente sceglie l'operatore in, l'applicazione restitusce tutte le attivita' con l'attributo(field) e i valori scelti dall'utente(values)
	 * Se l'utente sceglie l'operatore nin, l'applicazione restituisce tutte le attivita' tranne quelle con l'attributo(field) e i valori scelti dall'utente(values)
	 */

	@RequestMapping(value = "/business/filterN", method = RequestMethod.GET)
	public ResponseEntity<?> filterN(@RequestParam("field") String field,@RequestParam("operator") String operator,@RequestParam("values") String values) {
		logger.info("Filtering Business with field {} ,operator {} and valuese {} ",field,operator,values);
		ArrayList<Business> business = BusinessService.filterN( field,  operator,  values);
		if(business == null) {
			logger.error("Error request, business not found.");
			return new ResponseEntity(new Error("Error request, Business not found"), HttpStatus.NOT_FOUND);
		}
		ArrayList<Business> response = business;
		return new ResponseEntity<ArrayList<Business>>(response, HttpStatus.OK);
	}
	/**
	 * Filtra le varie attivita' in base all'operatore "not".
	 * L'applicazione restituisce tutte le attivita' tranne quelle con le caratteristiche scelte dall'utente
	 */


	@RequestMapping(value = "/business/filterNot", method = RequestMethod.GET)
	public ResponseEntity<?> filterNot(@RequestParam("field") String field,@RequestParam("operator") String operator,@RequestParam("values") String values) {
		logger.info("Filtering Business with field {} ,operator {} and value {} ",field,operator,values);
		ArrayList<Business> business = BusinessService.filterN( field,  operator,  values);
		if(business == null) {
			logger.error("Error request, business not found.");
			return new ResponseEntity(new Error("Error request, Business not found"), HttpStatus.NOT_FOUND);
		}
		ArrayList<Business> response = business;
		return new ResponseEntity<ArrayList<Business>>(response, HttpStatus.OK);
	}
	/**
	 * Filtra le varie attivita' in base agli operatori "and" oppure "or" con determinate condizioni scelte dall'utente.
	 */

	@RequestMapping(value = "/business/lFilter", method = RequestMethod.GET)
	public ResponseEntity<?> lFilter(@RequestParam("variable") String variable, @RequestParam("operator") String operator, @RequestParam("value") String value) {
		ArrayList<Business> business = BusinessService.lFilter(variable,operator,value);
		logger.info("Filtering Business with {} {} {} ", variable, operator,value);

		if(business == null) {
			logger.error("Error request, business not found.");
			return new ResponseEntity(new Error("Error request, Business not found"), HttpStatus.NOT_FOUND);
		}
		ArrayList<Business> response = business;
		return new ResponseEntity<ArrayList<Business>>(response,HttpStatus.OK);
	}
	/**
	 * Restituisce i Metadati.
	 */
	@RequestMapping(value = "/business/metadata", method = RequestMethod.GET)
	public ResponseEntity<List<Metadata>> catalogueAll() {
		List<Metadata> metadata = BusinessService.getMetadata();

		if (metadata.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);	
		}
		return new ResponseEntity<List<Metadata>>(metadata, HttpStatus.OK);
	}

}
