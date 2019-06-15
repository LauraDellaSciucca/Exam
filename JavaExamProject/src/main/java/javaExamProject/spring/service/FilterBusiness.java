package javaExamProject.spring.service;

public interface FilterBusiness<E,T> {
	
	public Object cFilter(String operator,int values);
	
	public Object addressFilter(String address);	
	

}
