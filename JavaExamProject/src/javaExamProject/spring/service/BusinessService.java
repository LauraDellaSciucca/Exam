package javaExamProject.spring.service;

import java.util.ArrayList;

import javaExamProject.spring.model.Business;


public interface BusinessService {
	
	Business getBusinessByCode(String code);
	
	ArrayList <Business> getBusiness();
	
	
	
	
	

}