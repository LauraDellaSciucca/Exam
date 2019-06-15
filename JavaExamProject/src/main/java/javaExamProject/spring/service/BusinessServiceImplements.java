package javaExamProject.spring.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import javaExamProject.spring.model.Business;

@Service("BusinessService")
public class BusinessServiceImplements implements BusinessService {
	private static ArrayList<Business> business;


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


	public Business findBusinessByCode(String code) {
		Business store = new Business();
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
		for(int i = 0; i < business.size(); i++ ) {
			if (Integer.toString(business.get(i).getMunicipality()).equals(value)) {

				store.addAll(business);
			}
		}
		return store;
	}


	public String countBusiness(String variable, String value) {
		String message = "";
		int n= 0;
		switch(variable) {
		case "municipality":
			n = 0; 
			for(Business b : business) {
				if (b.getMunicipality() == Integer.parseInt(value)) {
					n++;	
					message = "Il numero di business con municipio pari a " + value + " e' " + n;
				}
			}
			break;

		case "address":
			n = 0;
			for(Business b : business) {
				if (b.getAddress().equals(value)) {
					n++;
					message = "Il numero di business con via pari a " + value + " e' " + n;
				}
			}
			break;

		case "pHistoricalSector":
			n = 0;
			for(Business b : business) {
				if (b.getpHistoricalSector().equals(value)) {
					n++;
					message = "Il numero di business con settore storico pari a " + value + " e' " + n;
				}
			}
			break;

		case "CommoditiesSector":
			n = 0;
			for(Business b : business) {
				if(b.getCommoditiesSector().equals(value))
					n++;
				message = "Il numero di business con settore merceologico pari a " + value + " e' " + n;
			}
			break;
		}
		return message;
	}


	private int count(String variable, String value) {
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
			count = this.count("municipality", value);
			t=(double)count/(double)business.size();
			message = "La media dei business con valore di municipio pari a: " + value + " e': " + t;
			break;

		case "address": 
			count = this.count("address", value);
			t=(double)count/(double)business.size();
			message = "La media dei business con via pari a: " + value + " e': " + t;
			break;

		case "pHistoricalSector":
			count = this.count("pHistoricalSector", value);
			t=(double)count/(double)business.size();
			message = "La media dei business con valore di settore storico pari a: " + value + " e': " + t;
			break;

		case "CommoditiesSector":
			count = this.count("CommoditiesSector", value);
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
				count = this.count("municipality", Integer.toString(b.getMunicipality()));
				if(count > max) {
					max = count;
					message = "Il municipio con più business: " + Integer.toString(b.getMunicipality()) + " e il numero di business e': " + max;
				}
			}
			break;
		case "address": 
			for(Business b : business) {
				count = this.count("address", (b.getAddress()));
				if(count > max) {
					max = count;
					message = "La via con più business: " + b.getAddress() + " e il numero di business e': " + max;
				}
			}
			break;

		case "pHistoricalSector":
			for(Business b : business) {
				count = this.count("pHistoricalSector", (b.getpHistoricalSector()));
				if(count > max) {
					max = count;
					message = "Il settore storico con più business: " + b.getpHistoricalSector() + " e il numero di business e': " + max;
				}
			}
			break;
		case "CommoditiesSector":
			for(Business b : business) {
				count = this.count("CommoditiesSector", (b.getCommoditiesSector()));
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
				count = this.count("municipality", Integer.toString(b.getMunicipality()));
				if(count < min) {
					min = count;
					message = "Il municipio con minor numero di business: " + Integer.toString(b.getMunicipality()) + " e il numero di business e': " + min;
				}
			}
			break;
		case "address": 
			for(Business b : business) {
				count = this.count("address", (b.getAddress()));
				if(count < min) {
					min = count;
					message = "La viaa con minor numero di business: " + b.getAddress() + " e il numero di business e': " + min;
				}
			}
			break;

		case "pHistoricalSector":
			for(Business b : business) {
				count = this.count("pHistoricalSector", (b.getpHistoricalSector()));
				if(count < min) {
					min = count;
					message = "Il settore storico con minor numero di business: " + b.getpHistoricalSector() + " e il numero di business e': " + min;
				}
			}
			break;
		case "CommoditiesSector":
			for(Business b : business) {
				count = this.count("CommoditiesSector", (b.getCommoditiesSector()));
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

	public double devStdBusiness() {
		double n = 0;

		return n;
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

		return businessB;
	}

	public Object cFilter(String operator,int...totalArea) {

		List<Business> bus = new ArrayList<Business>();


		switch(operator) {
		case ">": {
			for (Business b: business)
			{
				if(b.getTotalArea()>totalArea[0])
				{
					bus.add(b);
				}

			}
		}

		case ">=": {
			for (Business b: business)
			{
				if(b.getTotalArea()>=totalArea[0])
				{
					bus.add(b);
				}

			}
		}

		case "<": {
			for (Business b: business)
			{
				if(b.getTotalArea()<totalArea[0])
				{
					bus.add(b);
				}

			}
		}

		case "<=": {
			for (Business b: business)
			{
				if(b.getTotalArea()<=totalArea[0])
				{
					bus.add(b);
				}

			}
		}

		case "==": {
			for (Business b: business)
			{
				if(b.getTotalArea()==totalArea[0])
				{
					bus.add(b);
				}

			}
		}

		case "=><=": {
			String message ="";
			{
				if(totalArea.length!=2) {
					message="You have to insert two areas!";
					return message;}
				if(totalArea[0] > totalArea[1]) {
					message="The first parameter must be less than or equal to the second";
					return message;}
				else 
				{
					for (Business b: business) {
						if(b.getTotalArea()<=totalArea[1] && b.getTotalArea()>=totalArea[0])
						{
							bus.add(b);
						}
						}
					
					}
				}

			}
		}


		
		return bus;

	}
	
	public Object addressFilter(String address) {
		
		List<Business> bus = new ArrayList<Business>();
		
		for(Business b: business) {
			if (b.getAddress().equals(address)) {
			return bus.add(b);
			}
		}
		return bus;
		
	}

}

