package javaExamProject.spring.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import javaExamProject.spring.model.Business;
import javaExamProject.spring.model.Metadata;
/**
 * classe necessaria  all'elaborazione  di informazioni richieste dall'utente
 * @author Angela D'Antonio
 * @author Laura Della Sciucca
 */

@Service("BusinessService")
public class BusinessServiceImplements implements BusinessService {

	private static ArrayList<Business> business;
	private static ArrayList<Metadata> metadata;

	/**
	 * Blocco di codice che viene eseguito prima dei blocchi di istanza e permette  di popolare 
	 *l' arraylist di business sopra definito.
	 */

	static {
		try {
			business = insertion();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return businessB, un ArrayList che contiene tutte i business recuperati dal parser  JSON e dal parser CSV 
	 * @throws IOException eccezione definita per individuare problemi relativi alla lettura e la scrittura di un file
	 */

	private static ArrayList<Business> insertion() throws IOException {
		ArrayList<Business> businessB = new ArrayList<Business>();
		String fileNameCSV = "business.csv";
		String fileNameJSON = "JsonFile.json";

		ParserJSON parse = new ParserJSON (fileNameJSON, fileNameCSV);
		String url_json = "https://www.dati.gov.it/api/3/action/package_show?id=e7aa5e37-b83d-4d80-b379-fb5845f7276b";

		parse.download(url_json,parse.getFileNameJSON());
		System.out.println("DONE");
		parse.downloadUsingStream(parse.getURL(fileNameJSON), parse.getFileNameCSV());
		List<List<String>> records = ParserCSV.readFile(parse.getFileNameCSV());


		ParserCSV.parserCSV(records);
		ArrayList<Business> business = ParserCSV.getBusiness();

		System.out.println("Rows accepted : " + business.size());
		for(int i = 0; i < business.size(); i++) {
			businessB.add(new Business(business.get(i)));
		} 

		BusinessServiceImplements.setMetadata(new ArrayList<Metadata>());

		return businessB;
	}

	/**
	 *  il metodo restituisce tutte i business
	 */
	public ArrayList<Business> getBusiness() {
		return business;
	}
	/**
	 * il metodo restituisce tutti i metdati
	 */

	public ArrayList<Metadata> getMetadata() {
		return metadata;
	}

	/**
	 * Permette di valorizzare la nostra classe metadata
	 * @param metadata, ArrayList di metadata è inizialemente vuoto
	 */

	public static void setMetadata(ArrayList<Metadata> metadata) {
		metadata.add(new Metadata("code","Codice","String"));
		metadata.add(new Metadata("site","Ubicazione","String"));
		metadata.add(new Metadata("expertise","Area di Competenza","String"));
		metadata.add(new Metadata("address","DescrizioneVia","String"));
		metadata.add(new Metadata("civic","Civico","String"));
		metadata.add(new Metadata("addressCode","CodiceVia ","String"));
		metadata.add(new Metadata("signboard","insegna","String"));
		metadata.add(new Metadata("commoditiesSector","settore_merceologico","String"));
		metadata.add(new Metadata("historicalSector","settore_storico_cf_n","String"));
		metadata.add(new Metadata("pHistoricalSector","settore_storico_cf_preval","String"));
		metadata.add(new Metadata("sHistoricalSector","settore_storico_cf_s","String"));
		metadata.add(new Metadata("totalArea","superficie_totale","Integer"));
		metadata.add(new Metadata("commercialArea","superficie_vendita","Integer"));
		metadata.add(new Metadata("municipality","municipio","Integer"));
		metadata.add(new Metadata("longitude","LONGIT","double"));
		metadata.add(new Metadata("latitude","LATIT","double"));
		metadata.add(new Metadata("location","Location","array of double"));
		BusinessServiceImplements.metadata = metadata;
	}


	/**
	 * il metodo restituisce l'attivita' in base al codice 
	 * @param code, codice dell'attivita' che l'utente sta cercando
	 */

	public Business findBusinessByCode(String code) {
		Business store = null;
		for(int i = 0; i < business.size(); i++ ) {
			if (business.get(i).getCode().equals(code)) {
				store = business.get(i);
				return store;
			}
		}
		return store;
	}
	/**
	 * il metodo restituisce l'attivita' in base al municipio
	 * @param value, municipio dell'attivita' che l'utente sta cercando
	 */
	public ArrayList<Business> findBusinessByMunicipality(String value) {
		ArrayList<Business> store = new ArrayList<Business>();
		for(Business b : business)
		{
			if (Integer.toString(b.getMunicipality()).equals(value)) {

				store.add(b);
			}
		}return store;

	}

	/** @param variable, variabile su cui si effettua il conteggio di attivita'
	 * @value value, valore della variabile che l'utente sceglie per eseguire il conteggio
	 * @return n, conteggio finale
	 */

	public int countBusiness(String variable, String value) {
		int n= 0;
		switch(variable) {
		case "municipality":
			n = 0; 
			for(Business b : business) {
				if (b.getMunicipality() == Integer.parseInt(value)) {
					n++;	
				}
			}
			break;

		case "address":
			n = 0;
			for(Business b : business) {
				if (b.getAddress().equals(value)) {
					n++;
				}
			}
			break;

		case "pHistoricalSector":
			n = 0;
			for(Business b : business) {
				if (b.getpHistoricalSector().equals(value)) {
					n++;
				}
			}
			break;

		case "CommoditiesSector":
			n = 0;
			for(Business b : business) {
				if(b.getCommoditiesSector().equals(value))
					n++;
			}
			break;
		}
		return n;
	}

	/**
	 * Restituisce l'oggetto messaggio valorizzato da un stringa che specifica la media delle attivita' 
	 * presenti con un determinato attributo e valore richiesti dall'utente
	 * @return messagge, risposta all'utente
	 */

	public String avgBusiness(String variable, String value) {
		String message = "";
		double t = 0;
		int count = 0;
		switch(variable) {

		case "municipality": 
			count = this.countBusiness("municipality", value);
			t=(double)count/(double)business.size();
			message = "La media dei business con valore di municipio pari a: " + value + " e': " + t;
			break;

		case "address": 
			count = this.countBusiness("address", value);
			t=(double)count/(double)business.size();
			message = "La media dei business con via pari a: " + value + " e': " + t;
			break;

		case "pHistoricalSector":
			count = this.countBusiness("pHistoricalSector", value);
			t=(double)count/(double)business.size();
			message = "La media dei business con valore di settore storico pari a: " + value + " e': " + t;
			break;

		case "CommoditiesSector":
			count = this.countBusiness("CommoditiesSector", value);
			t=(double)count/(double)business.size();
			message = "La media dei business con valore di settore merceologico pari a: " + value + " e': " + t;
			break;

		}
		return message;
	}

	/**
	 * restituisce l'oggetto messaggio valorizzato da una stringa che specifica  la variabile, scelta dall'utente, con piu' business (max)
	 * @return message,  risposta all'utente
	 */


	public String maxBusiness(String variable) {
		int max = 0;
		String message = "";
		int count = 0;
		switch(variable) {
		case "municipality": 
			for(Business b : business) {
				count = this.countBusiness("municipality", Integer.toString(b.getMunicipality()));
				if(count > max) {
					max = count;
					message = "Il municipio con più business: " + Integer.toString(b.getMunicipality()) + " e il numero di business e': " + max;
				}
			}
			break;
		case "address": 
			for(Business b : business) {
				count = this.countBusiness("address", (b.getAddress()));
				if(count > max) {
					max = count;
					message = "La via con più business: " + b.getAddress() + " e il numero di business e': " + max;
				}
			}
			break;

		case "pHistoricalSector":
			for(Business b : business) {
				count = this.countBusiness("pHistoricalSector", (b.getpHistoricalSector()));
				if(count > max) {
					max = count;
					message = "Il settore storico con più business: " + b.getpHistoricalSector() + " e il numero di business e': " + max;
				}
			}
			break;
		case "CommoditiesSector":
			for(Business b : business) {
				count = this.countBusiness("CommoditiesSector", (b.getCommoditiesSector()));
				if(count > max) {
					max = count;
					message = "Il settore merceologico con più business: " + b.getCommoditiesSector() + " e il numero di business e': " + max;
				}
			}
			break;
		}
		return message;
	}


	/**
	 *restituisce l'oggetto messaggio valorizzato da una stringa che specifica  la variabile, scelta dall'utente, con meno business (min)
	 * @return message,  risposta all'utente
	 */
	public String minBusiness(String variable) {
		int min = 1000;
		String message = "";
		int count = 0;
		switch(variable) {
		case "municipality": 
			for(Business b : business) {
				count = this.countBusiness("municipality", Integer.toString(b.getMunicipality()));
				if(count < min) {
					min = count;
					message = "Il municipio con minor numero di business: " + Integer.toString(b.getMunicipality()) + " e il numero di business e': " + min;
				}
			}
			break;
		case "address": 
			for(Business b : business) {
				count = this.countBusiness("address", (b.getAddress()));
				if(count < min) {
					min = count;
					message = "La viaa con minor numero di business: " + b.getAddress() + " e il numero di business e': " + min;
				}
			}
			break;

		case "pHistoricalSector":
			for(Business b : business) {
				count = this.countBusiness("pHistoricalSector", (b.getpHistoricalSector()));
				if(count < min) {
					min = count;
					message = "Il settore storico con minor numero di business: " + b.getpHistoricalSector() + " e il numero di business e': " + min;
				}
			}
			break;
		case "CommoditiesSector":
			for(Business b : business) {
				count = this.countBusiness("CommoditiesSector", (b.getCommoditiesSector()));
				if(count < min) {
					min = count;
					message = "Il settore merceologico con minor numero di business: " + b.getCommoditiesSector() + " e il numero di business e': " + min;
				}
			}
			break;
		}
		return message;
	}

	/**
	 * restituisce la somma delle superifici totali occupate da i business con variabile uguale a municipio e valore scelto dall'utente
	 * @param n, totale delle superifici business
	 * 
	 */
	public int sumBusiness(String variable, String value) {
		int n = 0;
		if(variable.equals("municipality")){

			for(Business b : business)

				if(Integer.toString(b.getMunicipality()).equals(value))
					n += b.getTotalArea();
		}

		return n;
	}


	/**
	 * Metodo che utilizziamo per calcolare la deviazione standard delle superifici totali delle attività
	 * @return avg, media utile al calcolo della deviazione standard
	 */

	private double avgTotalArea() {
		double count=0.0;
		double sommaArea= 0.0;
		double avg=0.0;
		for(Business b : business){
			if(b.getTotalArea()== 0) {
				continue;

			}
			else 
			{
				sommaArea += b.getTotalArea(); 
				count++;
			}

		}
		avg= sommaArea/count;

		return avg;

	}

	/**
	 * metodo utile al calcolo della deviazione standard di tutte le superfici totali delle attivita'
	 * @return message, risposta all'utente con una stringa che specifica il risultato del calcol i business considerati nel calcolo, la media e il numeratore.
	 */
	public String devStdBusiness() {
		String message="";
		double count=0.0;

		double avg = avgTotalArea ();

		double num= 0.0;


		for(Business b : business){
			if(b.getTotalArea()== 0) {
				continue;

			}else {
				num += Math.pow((b.getTotalArea() - avg), 2);
				count++;
			}

		}


		double devStdB = Math.sqrt( num / count);

		message="the standard deviation of Total Area is:  " + devStdB+ ". \n total  business counted: "+count+". \n avg: "+avg+". \n numerator: "+num;

		return message; 
	}

	/** ci permette di filtrare le attività per superifici totali iin base all'operatore scelto (minore, maggiore..)
	 * @param operator, operatore scelto dall'utente
	 * @param totalArea valore scelto dall'utente con cui filtrare le attivita'
	 **@return bus, arraylist di tutte le attività che soddisfano la richiesta
	 */



	public ArrayList<Business>cFilter(String operator,int...totalArea)  {

		ArrayList<Business> bus = new ArrayList<Business>();


		switch(operator) {

		case ">": 
			for (Business b: business)
			{
				if(b.getTotalArea()>totalArea[0])
				{
					bus.add(b);
				}

			}



			break;

		case ">=": 
			for (Business b: business)
			{
				if(b.getTotalArea()>=totalArea[0])
				{
					bus.add(b);
				}

			}


			break;

		case "<": 
			for (Business b: business)
			{
				if(b.getTotalArea()<totalArea[0])
				{
					bus.add(b);
				}

			}


			break;

		case "<=": 
			for (Business b: business)
			{
				if(b.getTotalArea()<=totalArea[0])
				{
					bus.add(b);
				}

			}


			break;

		case "==": 
			for (Business b: business)
			{
				if(b.getTotalArea()==totalArea[0])
				{
					bus.add(b);
				}

			}


			break;

		case "=><=": 
			String message ="";
			if(totalArea.length!=2) {
				message="You have to insert two areas!";
				System.out.println(message); 
			}
			if(totalArea[0] > totalArea[1]) {
				message="The first parameter must be less than or equal to the second";
				System.out.println(message); 
			}
			else 
			{
				for (Business b: business) {
					if(b.getTotalArea()<=totalArea[1] && b.getTotalArea()>=totalArea[0])
					{
						bus.add(b);
					}
				}

			}

			break;
		}

		return bus;

	}

	/**
	 * permette di filtrare le attivita' in base alla via inserita dall'utente
	 * @return bus, ArrayList delle attivita' filtrate
	 */


	public ArrayList<Business>addressFilter(String address) {

		ArrayList<Business> bus = new ArrayList<Business>();

		for(Business b: business) {
			if (b.getAddress().equals(address)) {
				bus.add(b);
			}
		}
		return bus;

	}
	/**
	 * permette di filtrare le attivita' che rientrano in un certo range di distanza a partire da un punto definito dalla latitudine e la longitudine
	 * @param range, distanza che si vuole calcolare
	 * @param latitude, latitudine a partire dalla quale si vuole calcolare la distanza
	 * @param longitude, longitudine a partire dalla quale si vuole calcolare la distanza
	 */

	public ArrayList<Business>distanceFilter(double range, double latitude, double longitude) {

		ArrayList<Business> bus = new ArrayList<Business>();
		for(Business b : business) {
			double latDiff = (b.getLatitude() - latitude);
			double lonDiff = (b.getLongitude() - longitude);
			double t = Math.sqrt(latDiff*latDiff + lonDiff*lonDiff);
			if(t <= range ) 
				bus.add(b);		

		}
		return bus;		
	}

	/**
	 * Metodo privato utile ai filtri logici per effettuare verifiche sulle variabili passate
	 *  @see filterN, @see filterNot, @see lFilter
	 * @return check, valore booleano 
	 */

	private Boolean variable (String variable, String value[], Business b ) {
		boolean check = false;

		if(value.length == 1) {
			switch(variable) {
			case "code": 
				if(b.getCode().contains(value[0]))
					check = true;
				break;
			case "address": 
				if(b.getAddress().contains(value[0])) {
					check = true;
				}
				break;
			case "civic":
				if(b.getCivic().contains(value[0]))
					check = true;
				break;
			case "addressCode":
				if(b.getAddressCode().contains(value[0]))
					check = true;
				break;
			case "signboard":
				if(b.getSignboard().contains(value[0]))
					check = true;
				break;
			case "pHistoricalSector":
				if(b.getpHistoricalSector().contains(value[0]))
					check = true;
				break;
			case "totalArea":
				if(b.getTotalArea() == Integer.parseInt(value[0]))
					check = true;
				break;
			case "municipality": 

				if(b.getMunicipality() == Integer.parseInt(value[0])) {
					check = true;
				}
				break;
			}
		}else {
			switch (variable) {

			case "code": 
				check = false; 
				for(int i = 0 ; i < value.length ; i++) {
					if(b.getCode()== value[i]) {
						check =true;
					}
				}
				break;
			case "address": 
				check = false;
				for(int i = 0 ; i < value.length ; i++) {
					if(b.getAddress()== value[i]) {
						check =true;
					}
				}
				break;
			case "civic":
				check = false;
				for(int i = 0 ; i < value.length ; i++) {
					if(b.getCivic().contains(value[i])) {
						check =true;
					}
				}
				break;
			case "addressCode":
				check = false;
				for(int i = 0 ; i < value.length ; i++) {
					if(b.getAddressCode().contains(value[i])) {
						check =true;
					}
				}
				break;
			case "signboard":
				check = false;
				for(int i = 0 ; i < value.length ; i++) {
					if(b.getSignboard().contains(value[i])) {
						check =true;
					}
				}
				break;
			case "pHistoricalSector":
				check = false;
				for(int i = 0 ; i < value.length ; i++) {
					if(b.getpHistoricalSector().contains(value[i])) {
						check =true;
					}
				}
				break;
			case "totalArea":
				check = false; 

				for(int i = 0 ; i < value.length ; i++) {
					if(b.getTotalArea() == Integer.parseInt(value[i])) {
						check =true;
					}
				}
				break;

			case "municipality":
				check = false; 
				for(int i = 0 ; i < value.length ; i++) {
					if(b.getMunicipality()== Integer.parseInt(value[i])) {
						check =true;
					}
				}
				break;
			}
		}
		return check;
	}

	/**
	 *Metodo che permette di filtrare i business scegliendo tra l'operatore "nin" oppure "in"
	 *con l'operatore in ritorna un arraylist contenente tutti i business con valori speficiati dall'utente
	 *con l'operatore nin ritorna un arraylist contenente tutti i business tranne quelli con valori specificati dall'utente
	 *@return bus
	 */
	public ArrayList<Business> filterN(String field, String operator, String values){
		String val[] = values.split(",");
		boolean check;
		ArrayList<Business> bus = new ArrayList<Business>();

		switch(operator) {

		case "nin":

			for(Business b :business) {
				check=false;
				if(variable(field,val,b)==false) {
					check=true;
				}

				if(check==true) {
					bus.add(b);
				}
			} 
			break;
		case "in":
			for(Business b :business) {
				check=false;

				if(variable(field,val,b)==true) {
					check=true;
				}

				if(check==true) {
					bus.add(b);
				}
			}


			break; 
		}


		return bus;
	}
	/**
	 * Metodo che permette il filtraggio dei business, omettendo quelli con valori specificati dall'utente (not)
	 * @return bus, arrayList di business che varia in base alla scelta dell'utente
	 */

	public ArrayList<Business>filterNot(String field, String operator, String values) {
		ArrayList<Business> bus = new ArrayList<Business>();
		String s[] = new String [1];
		s[0] = values; 
		if(operator.equals("not")){
			for(Business b: business) {
				if(variable(field,s,b)==false) {
					bus.add(b);
				}
			}

		}
		return bus;

	}

	/**
	 * Metodo che permette il filtraggio dei business secondo l'operatore and oppure or.
	 * In fase di richiesta l'utente puo' scegliere due attributi con i rispettivi valori, entrambi separati dalla virgola
	 * @return bus, Arraylist di business che varia in base alla scelta dell'utente
	 */
	public ArrayList<Business> lFilter(String var, String operator, String  value) {
		String varA [] = var.split(",");
		String valA [] = value.split(",");
		String valueA [] = new String [1];
		String valueB []= new String [1];

		valueA[0] = valA[0];
		valueB[0] = valA[1];

		ArrayList<Business> bus = new ArrayList<Business>();
		boolean check = false; 

		switch(operator) {
		case "and": 
			for (Business b : business) {
				check = false;
				boolean check1 = (variable(varA[0],valueA,b));
				boolean check2 = (variable(varA[1],valueB,b));
				if( check1 && check2) {
					check = true;
				} 
				if(check == true) {
					bus.add(b);
				}
			}
			break;
		case "or" :
			for (Business b : business) {
				check = false;
				boolean check1 = (variable(varA[0],valueA,b));
				boolean check2 = (variable(varA[1],valueB,b));
				if( check1 || check2) {
					check = true;
				} 
				if(check == true) {
					bus.add(b);
				}
			}
			break;
		}
		return bus;
	}





}




