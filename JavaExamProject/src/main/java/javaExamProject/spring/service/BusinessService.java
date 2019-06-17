package javaExamProject.spring.service;

import java.util.ArrayList;

import javaExamProject.spring.model.Business;
import javaExamProject.spring.model.Metadata;


public interface BusinessService {



	Business findBusinessByCode(String code);

    ArrayList <Business> getBusiness();
    
    ArrayList<Metadata> getMetadata();

	int countBusiness(String variable, String value);

	String avgBusiness(String variable, String value);

	String maxBusiness(String variable);

	String minBusiness(String variable);

	int sumBusiness(String variable, String value);

	ArrayList<Business> findBusinessByMunicipality(String value);

	String devStdBusiness();
	
	ArrayList<Business> filterN(String field, String operator, String values);
	
	ArrayList<Business> filterNot(String field, String operator, String values);
	
	ArrayList<Business> cFilter(String operator,int ...totalArea);
	ArrayList<Business> addressFilter(String address);
	
	ArrayList<Business> distanceFilter(double range, double latitude, double longitude);
	
	ArrayList<Business> lFilter(String var, String operator, String  value);
	

}