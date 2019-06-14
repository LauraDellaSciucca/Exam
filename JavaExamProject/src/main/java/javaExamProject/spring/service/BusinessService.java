package javaExamProject.spring.service;

import java.util.ArrayList;

import javaExamProject.spring.model.Business;


public interface BusinessService {
	
	Business findBusinessByCode(String code);
	
	ArrayList<Business> findBusinessByMunicipality(String value);
	
	ArrayList <Business> getBusiness();
	
	String countBusiness(String variable, String value);
	
	String avgBusiness(String variable, String value);
	
	String maxBusiness(String variable);
	
	String minBusiness(String variable);
	
	int sumBusiness(String variable, String value);
	
	
	
	

}