package javaExamProject.spring.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.springframework.stereotype.Service;
import javaExamProject.spring.model.Business;
import javaExamProject.spring.model.Metadata;

@Service("BusinessService")
public class BusinessServiceImplements implements BusinessService {
	private static ArrayList<Business> business;
	private static ArrayList<Metadata> metadata;

	public ArrayList<Business> getBusiness() {
		return business;
	}

	public static void setBusiness(ArrayList<Business> business) {
		BusinessServiceImplements.business = business;
	}


	static {
		try {
			business = insertion();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public ArrayList<Metadata> getMetadata() {
		return metadata;
	}


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

	public ArrayList<Business> findBusinessByMunicipality(String value) {
		ArrayList<Business> store = new ArrayList<Business>();
		for(Business b : business)
		{
			if (Integer.toString(b.getMunicipality()).equals(value)) {

				store.add(b);
			}
		}return store;

	}



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


	public int sumBusiness(String variable, String value) {
		int n = 0;

		for(Business b : business)
			switch (variable) {
			case "municipality": 
				if(Integer.toString(b.getMunicipality()).equals(value))
					n += b.getTotalArea();

			case "pHistoricalSector": 
				if(b.getpHistoricalSector().equals(value))
					n++;

			}

		return n;
	}




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


	public ArrayList<Business>addressFilter(String address) {

		ArrayList<Business> bus = new ArrayList<Business>();

		for(Business b: business) {
			if (b.getAddress().equals(address)) {
				bus.add(b);
			}
		}
		return bus;

	}

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


	public ArrayList<Business> filterN(String field, String operator, String values){
		String val[] = values.split(",");
		boolean check;
		ArrayList<Business> bus = new ArrayList<Business>();

		switch(operator) {

		case "nin":
			//for(int i = 0 ; i< val.length ; i++ )
			//s	System.out.println("val "+i+" :" +val[i]);
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
	private static ArrayList<Business> insertion() throws IOException {

		String json = "{\"help\":\"Return the metadata of a dataset (package) and its resources. :param id: the id or name of the dataset :type id: string\",\"success\":true,\"result\":{\"id\":\"e7aa5e37-b83d-4d80-b379-fb5845f7276b\",\"name\":\"attivit-commerciali-media-grande-distribuzione\",\"title\":\"Attivit\\u00e0\\u00a0commerciali: media e grande distribuzione\",\"author_email\":\"opendatamilano@comune.milano.it\",\"maintainer_email\":\"opendatamilano@comune.milano.it\",\"license_url\":\"http:\\/\\/creativecommons.org\\/licenses\\/by\\/4.0\\/\",\"license_id\":\"CC-BY 4.0\",\"notes\":\"\\u003Cp\\u003EIl dataset contiene l\\u0027elenco delle attivit\\u00e0 commerciali di media e grande distribuzione, (con superficie di vendita superiore a 250 mq). Oltre a localizzazione per via e numero civico e superficie di vendita, sono presenti altre informazioni desunte dall\\u0027archivio amministrativo. Per l\\u0027interpretazione del dato bisogna considerare che la normativa relativa al commercio ha subito nel tempo numerose modifiche, sia rispetto alla nomenclatura e alla classificazione delle attivit\\u00e0, sia rispetto al tipo e numero di informazioni rilevate. In alcuni casi le novit\\u00e0 normative hanno introdotto variabili non presenti negli archivi, andando ad arricchire di informazioni il dataset. Queste variazioni tuttavia non si ripercuotono in modo retroattivo nell\\u0027archivio, ma vengono aggiornate alla prima occasione in cui il titolare si rivolge agli uffici per comunicare una qualsiasi variazione (trasloco, subentro, variazione di superficie di vendita, cumulo attivit\\u00e0....).\\u00a0 Pertanto le informazioni contenute nel dataset non sono necessariamente omogenee, perch\\u00e8 riferite al momento dell\\u0027ultima comunicazione.Per approfondimenti: \\u003Ca href=\\u0022http:\\/\\/fareimpresa.comune.milano.it\\/\\u0022\\u003Ehttp:\\/\\/fareimpresa.comune.milano.it\\/\\u003C\\/a\\u003E\\u003C\\/p\\u003E\\n\",\"state\":\"Active\",\"log_message\":\"Update to resource \\u0027ds50_economia_media_grande_distribuzione.geojson\\u0027\",\"revision_timestamp\":\"2019-05-27T14:00:01+02:00\",\"metadata_created\":\"2017-11-09T14:34:11+01:00\",\"metadata_modified\":\"2019-05-16T14:15:32+02:00\",\"creator_user_id\":\"9bcba160-349c-4d14-8a53-d4168349d053\",\"type\":\"Dataset\",\"resources\":[{\"id\":\"d12a1913-c838-421a-ba39-5b1e241ecebe\",\"revision_id\":\"\",\"url\":\"http:\\/\\/dati.comune.milano.it\\/dataset\\/e7aa5e37-b83d-4d80-b379-fb5845f7276b\\/resource\\/cbce9044-f7e6-45c9-a53d-e753adbcd63c\\/download\\/economia_media_grande_distribuzione_coord.csv\",\"description\":\"\",\"format\":\"csv\",\"state\":\"Active\",\"revision_timestamp\":\"Domenica 19 Maggio 2019\",\"name\":\"DS50_economia_media_grande_distribuzione\",\"mimetype\":\"csv\",\"size\":\"\",\"created\":\"\",\"resource_group_id\":\"25936114-3cb9-4c9d-a75c-6ab29dffdeb2\",\"last_modified\":\"\"},{\"id\":\"f5512289-7839-42f7-a18b-83062b8599e8\",\"revision_id\":\"\",\"url\":\"http:\\/\\/dati.comune.milano.it\\/dataset\\/e7aa5e37-b83d-4d80-b379-fb5845f7276b\\/resource\\/e820781c-2946-4766-b94c-cd8de256eb74\\/download\\/economia_media_grande_distribuzione_coord.json\",\"description\":\"\",\"format\":\"json\",\"state\":\"Active\",\"revision_timestamp\":\"Domenica 19 Maggio 2019\",\"name\":\"ds50_economia_media-grande-distribuzione.json\",\"mimetype\":\"json\",\"size\":\"\",\"created\":\"\",\"resource_group_id\":\"25936114-3cb9-4c9d-a75c-6ab29dffdeb2\",\"last_modified\":\"\"},{\"id\":\"3bb8e137-d5cc-476d-ab1e-d95539b7ed7e\",\"revision_id\":\"\",\"url\":\"http:\\/\\/dati.comune.milano.it\\/dataset\\/e7aa5e37-b83d-4d80-b379-fb5845f7276b\\/resource\\/bc58e9ea-5d57-4266-8fb4-e50042e24b53\\/download\\/economia_media_grande_distribuzione.geojson\",\"description\":\"\",\"format\":\"geojson\",\"state\":\"Active\",\"revision_timestamp\":\"Domenica 19 Maggio 2019\",\"name\":\"ds50_economia_media_grande_distribuzione.geojson\",\"mimetype\":\"geojson\",\"size\":\"\",\"created\":\"\",\"resource_group_id\":\"25936114-3cb9-4c9d-a75c-6ab29dffdeb2\",\"last_modified\":\"\"}],\"tags\":[{\"id\":\"312542e2-d9ea-4c0d-ade7-5a45d8ffc04f\",\"vocabulary_id\":\"2\",\"name\":\"fare_impresa\"},{\"id\":\"27941d09-d81a-4971-8c27-54a3f292fd5e\",\"vocabulary_id\":\"2\",\"name\":\"zona\"}],\"groups\":[{\"display_name\":\"Economia e finanze\",\"description\":\"\\u003Cp\\u003EThis concept identifies datasets covering such domains as economy or finance.\\u003C\\/p\\u003E\\n\",\"id\":\"d51ce83d-0d00-4955-afbd-2c9240ee7596\",\"title\":\"ECON\",\"name\":\"Economia e finanze\"}],\"organization\":[{\"title\":\"Comune di Milano\",\"description\":\"\",\"id\":\"25936114-3cb9-4c9d-a75c-6ab29dffdeb2\",\"image_url\":\"https:\\/\\/www.dati.gov.it\\/sites\\/default\\/files\\/comune_milano.png\",\"name\":\"group\\/comune-milano\",\"created\":\"2018-01-08T11:46:21+01:00\",\"type\":\"organization\"}],\"extras\":[{\"key\":\"\",\"value\":\"\"}],\"_catalog_parent_name\":\"Comune di Milano\",\"_catalog_source_url\":\"http:\\/\\/dati.comune.milano.it\\/api\\/3\\/action\\/package_list\"}}";
		ArrayList<Business> businessB = new ArrayList<Business>();
		String fileCSV = "business.csv";
		String fileJSON = "JSONFile.json";

		ParserJSON parsejson = new ParserJSON(json, fileCSV);

		parsejson.downloadUsingStream(parsejson.getURL(json), parsejson.getFileName());
		List<List<String>> records = ParserCSV.readFile(fileCSV);


		ParserCSV.parserCSV(records);
		ArrayList<Business> business = ParserCSV.getBusiness();

		System.out.println("Rows accepted : " + business.size());
		for(int i = 0; i < business.size(); i++) {
			businessB.add(new Business(business.get(i)));
		} 

		BusinessServiceImplements.setMetadata(new ArrayList<Metadata>());

		return businessB;
	}



}




