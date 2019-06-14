package javaExamProject.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javaExamProject.spring.model.Business;
import javaExamProject.spring.service.BusinessService;
import javaExamProject.spring.util.Error;

@RestController
@RequestMapping("/api")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);
	
	@Autowired
	BusinessService BusinessService; 
	
	@RequestMapping(value = "/business/", method = RequestMethod.GET)
	public ResponseEntity<List<Business>> listAll() {
		List<Business> business = BusinessService.getBusiness();
		if (business.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Business>>(business, HttpStatus.OK);
	}
	
	
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
	
	
	@RequestMapping(value = "/business/count/{variable}/value/{value}", method = RequestMethod.GET)
	public ResponseEntity<?> countBusiness(@PathVariable("variable")String variable , @PathVariable("value") String value) {
		logger.info("Counting Business with variable {} and value {}", variable,value);
		String response = BusinessService.countBusiness(variable, value);
		if (response.isEmpty()) {
			logger.error("Error request, variable {}  with value {} not found.", variable,value);
			return new ResponseEntity(new Error("Error request, variable : " + variable +" with value : "+value+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
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
	
}
