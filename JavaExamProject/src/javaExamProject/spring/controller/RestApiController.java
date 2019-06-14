package javaExamProject.spring.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
}
