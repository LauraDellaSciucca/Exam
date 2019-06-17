package javaExamProject.spring.service;

public interface FilterBusiness{
	
	 Object cFilter(String operator,int ...totalArea);
	
	 Object addressFilter(String address);
	
	 Object distanceFilter(double range, double latitude, double longitude);
	 
	 Object lFilter(String attribute,String operator, String value[]); //mancano 
	

}
