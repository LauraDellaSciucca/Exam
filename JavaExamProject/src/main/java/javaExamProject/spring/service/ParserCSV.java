package javaExamProject.spring.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import javaExamProject.spring.model.Business;

public class ParserCSV {
	final static String COMMA_DELIMITER = ";";
	private static ArrayList <Business> business;

	public static ArrayList<Business> getBusiness() {
		return business;
	}

	public static void setBusiness(ArrayList<Business> business) {
		ParserCSV.business = business;
	}

	public static List<List<String>> readFile(String file) throws FileNotFoundException {
		List<List<String>> records = new ArrayList<>();
		int i = 0;
		try (Scanner scanner = new Scanner(new File(file))) {
			while (scanner.hasNextLine()) {
				records.add(getRecordFromLine(scanner.nextLine()));
				i++;
				//System.out.println(getRecordFromLine(scanner.nextLine()));
			}
		}
		System.out.println("righe : "+i);
		return records;
	}
	
	//ArrayList( arraylistf(...,...,..., ), arraylistf(...,...,...).....) records
	
	private static List<String> getRecordFromLine(String line) {
		List<String> values = new ArrayList<String>();
		try (Scanner rowScanner = new Scanner(line)) {
			rowScanner.useDelimiter(COMMA_DELIMITER);
			while(rowScanner.hasNext()) {
				values.add(rowScanner.next());
			}
			rowScanner.close();
		}
		return values;
	}
	
	public static void parserCSV( List<List<String>> records) {
		ArrayList <Business> business = new ArrayList <Business>();
		List<String> line;
		
		int ri = 0; 
		for(int i = 1; i< records.size() ; i++) {
			line = records.get(i);
			if(line.size() < 17) {
				ri++;
			}else {
				
				double location[]= new double[2];
				
				if(line.get(14).isEmpty()) {
					location[0] = 0; 
				}else {
					location[0] = Double.parseDouble(line.get(14));
				}
				if(line.get(15).isEmpty()) {
					location[1] = 0;
				}else {
					location[1] = Double.parseDouble(line.get(15));
				}

				Business b = new Business(
						line.get(0).trim().replace("/", "-").isEmpty() ? "codeNotFound" : line.get(0).trim().replace("/", "-"),
					    line.get(1).trim().replace("|","-").replace(" ", "").isEmpty() ? "siteNotFound": line.get(1).trim().replace("|","-").replace(" ", ""),
					    line.get(2).trim().replace(" ", "").isEmpty()? "expertiseNotFound": line.get(2).trim().replace(" ", ""),
					    line.get(3).trim().replace(" ", "").isEmpty()? "addressNotFound" : line.get(3).trim().replace(" ", ""),
					    line.get(4).trim().isEmpty()? "civicNotFound" : line.get(4).trim(),
					    line.get(5).trim().isEmpty()? "addresscCodeNotFound" : line.get(5).trim(),
					    line.get(6).trim().replace(" ", "").isEmpty()? "signboardNotFound" : line.get(6).trim().replace(" ", ""),
                        line.get(7).trim().replace("|","-").isEmpty()? "commoditiesSectorNotFound" : line.get(7).trim().replace("|", "-"),
				        line.get(8).trim().replace("|","-").isEmpty()? "historicalSectorNotFound" : line.get(8).trim().replace("|","-"),
						line.get(9).trim().isEmpty()? "pHistoricalSectorNotFound" : line.get(9).trim(),
					    line.get(10).trim().replace("|","-").replace("/", "-").isEmpty()? "sHistoricalSectorNotFound" : line.get(10).trim().replace("|","-").replace("/", "-"),
					    line.get(11).trim().isEmpty()? 0 : Integer.parseInt(line.get(11).trim()),
						line.get(12).trim().isEmpty()? 0 : Integer.parseInt(line.get(12).trim()),
						line.get(13).trim().isEmpty()? 0 : Integer.parseInt(line.get(13).trim()),
						line.get(14).trim().isEmpty()? 0.0 : Double.parseDouble(line.get(14).trim()),
						line.get(15).trim().isEmpty()? 0.0 : Double.parseDouble(line.get(15).trim()),
					    location);
				
				business.add(b);

				}
			}
		setBusiness(business);
		System.out.println("Riga insufficiente : "+ri);
	}
	
	/*
	
	public static void main(String[] args) throws IOException {
		
		List<List<String>> records = ParserCSV.readFile("business.csv");
		ParserCSV.parserCSV(records);
		ArrayList <Business> business = ParserCSV.getBusiness();
		for(int i=0; i < business.size();i++)
		System.out.println("AAA :" + business.get(i).toString());
		System.out.println(business.size());
	}
	
		*/
	
	}

