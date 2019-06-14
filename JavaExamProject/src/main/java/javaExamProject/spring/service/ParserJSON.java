package javaExamProject.spring.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;


public class ParserJSON {
	private String json; 
	private String fileName;
	protected ParserJSON(String json, String fileName){
		this.json = json; 
		this.fileName = fileName ; 
	}

	protected String getFileName() {
		return fileName;
	}

	protected void setFileName(String fileName) {
		this.fileName = fileName;
	}

	protected String getJson() {
		return json;
	}

	protected void setJson(String json) {
		this.json = json;
	}

	public String getURL (String json) {
		String urlAddress = "";
		JSONObject obj = new JSONObject(json);
		String name = obj.getJSONObject("result").getString("name");
		String revisionTime = obj.getJSONObject("result").getString("revision_timestamp");


		System.out.println("NAME : " + name);
		System.out.println("LAST REVISION : " + revisionTime);


		JSONObject objI = (JSONObject) (obj.get("result"));
		JSONArray objA = (JSONArray) (objI.get("resources"));

		for (Object o: objA) {

			if ( o instanceof JSONObject ) {
				JSONObject o1 = (JSONObject)o; 
				String format = (String)o1.get("format");
				String urlD = (String)o1.get("url");
				System.out.println(format + " | " + urlD);
				if(format.equals("csv")) {
					System.out.println("There is a CSV");
					urlAddress = urlD; 
					return urlAddress;

				}
				System.out.println(urlD);
			}

		}return urlAddress;
	}

	protected void downloadUsingStream(String urlStr, String file) throws IOException, FileSystemException{
		File f = new File(file);
		if(f.exists()==true) {
			if(f.delete()) {	
					try (InputStream in  = URI.create(urlStr).toURL().openStream()) { 
							Files.copy(in, Paths.get(file));

					}
			}else {
				throw new FileSystemException ("cancellazione file non avvenuta");
			}
		}else {
			try (InputStream in  = URI.create(urlStr).toURL().openStream()) { 
				Files.copy(in, Paths.get(file));

			}
		}
			
	}

/*
	public static void main(String[] args) throws IOException {
		String json = "{\"help\":\"Return the metadata of a dataset (package) and its resources. :param id: the id or name of the dataset :type id: string\",\"success\":true,\"result\":{\"id\":\"e7aa5e37-b83d-4d80-b379-fb5845f7276b\",\"name\":\"attivit-commerciali-media-grande-distribuzione\",\"title\":\"Attivit\\u00e0\\u00a0commerciali: media e grande distribuzione\",\"author_email\":\"opendatamilano@comune.milano.it\",\"maintainer_email\":\"opendatamilano@comune.milano.it\",\"license_url\":\"http:\\/\\/creativecommons.org\\/licenses\\/by\\/4.0\\/\",\"license_id\":\"CC-BY 4.0\",\"notes\":\"\\u003Cp\\u003EIl dataset contiene l\\u0027elenco delle attivit\\u00e0 commerciali di media e grande distribuzione, (con superficie di vendita superiore a 250 mq). Oltre a localizzazione per via e numero civico e superficie di vendita, sono presenti altre informazioni desunte dall\\u0027archivio amministrativo. Per l\\u0027interpretazione del dato bisogna considerare che la normativa relativa al commercio ha subito nel tempo numerose modifiche, sia rispetto alla nomenclatura e alla classificazione delle attivit\\u00e0, sia rispetto al tipo e numero di informazioni rilevate. In alcuni casi le novit\\u00e0 normative hanno introdotto variabili non presenti negli archivi, andando ad arricchire di informazioni il dataset. Queste variazioni tuttavia non si ripercuotono in modo retroattivo nell\\u0027archivio, ma vengono aggiornate alla prima occasione in cui il titolare si rivolge agli uffici per comunicare una qualsiasi variazione (trasloco, subentro, variazione di superficie di vendita, cumulo attivit\\u00e0....).\\u00a0 Pertanto le informazioni contenute nel dataset non sono necessariamente omogenee, perch\\u00e8 riferite al momento dell\\u0027ultima comunicazione.Per approfondimenti: \\u003Ca href=\\u0022http:\\/\\/fareimpresa.comune.milano.it\\/\\u0022\\u003Ehttp:\\/\\/fareimpresa.comune.milano.it\\/\\u003C\\/a\\u003E\\u003C\\/p\\u003E\\n\",\"state\":\"Active\",\"log_message\":\"Update to resource \\u0027ds50_economia_media_grande_distribuzione.geojson\\u0027\",\"revision_timestamp\":\"2019-05-27T14:00:01+02:00\",\"metadata_created\":\"2017-11-09T14:34:11+01:00\",\"metadata_modified\":\"2019-05-16T14:15:32+02:00\",\"creator_user_id\":\"9bcba160-349c-4d14-8a53-d4168349d053\",\"type\":\"Dataset\",\"resources\":[{\"id\":\"d12a1913-c838-421a-ba39-5b1e241ecebe\",\"revision_id\":\"\",\"url\":\"http:\\/\\/dati.comune.milano.it\\/dataset\\/e7aa5e37-b83d-4d80-b379-fb5845f7276b\\/resource\\/cbce9044-f7e6-45c9-a53d-e753adbcd63c\\/download\\/economia_media_grande_distribuzione_coord.csv\",\"description\":\"\",\"format\":\"csv\",\"state\":\"Active\",\"revision_timestamp\":\"Domenica 19 Maggio 2019\",\"name\":\"DS50_economia_media_grande_distribuzione\",\"mimetype\":\"csv\",\"size\":\"\",\"created\":\"\",\"resource_group_id\":\"25936114-3cb9-4c9d-a75c-6ab29dffdeb2\",\"last_modified\":\"\"},{\"id\":\"f5512289-7839-42f7-a18b-83062b8599e8\",\"revision_id\":\"\",\"url\":\"http:\\/\\/dati.comune.milano.it\\/dataset\\/e7aa5e37-b83d-4d80-b379-fb5845f7276b\\/resource\\/e820781c-2946-4766-b94c-cd8de256eb74\\/download\\/economia_media_grande_distribuzione_coord.json\",\"description\":\"\",\"format\":\"json\",\"state\":\"Active\",\"revision_timestamp\":\"Domenica 19 Maggio 2019\",\"name\":\"ds50_economia_media-grande-distribuzione.json\",\"mimetype\":\"json\",\"size\":\"\",\"created\":\"\",\"resource_group_id\":\"25936114-3cb9-4c9d-a75c-6ab29dffdeb2\",\"last_modified\":\"\"},{\"id\":\"3bb8e137-d5cc-476d-ab1e-d95539b7ed7e\",\"revision_id\":\"\",\"url\":\"http:\\/\\/dati.comune.milano.it\\/dataset\\/e7aa5e37-b83d-4d80-b379-fb5845f7276b\\/resource\\/bc58e9ea-5d57-4266-8fb4-e50042e24b53\\/download\\/economia_media_grande_distribuzione.geojson\",\"description\":\"\",\"format\":\"geojson\",\"state\":\"Active\",\"revision_timestamp\":\"Domenica 19 Maggio 2019\",\"name\":\"ds50_economia_media_grande_distribuzione.geojson\",\"mimetype\":\"geojson\",\"size\":\"\",\"created\":\"\",\"resource_group_id\":\"25936114-3cb9-4c9d-a75c-6ab29dffdeb2\",\"last_modified\":\"\"}],\"tags\":[{\"id\":\"312542e2-d9ea-4c0d-ade7-5a45d8ffc04f\",\"vocabulary_id\":\"2\",\"name\":\"fare_impresa\"},{\"id\":\"27941d09-d81a-4971-8c27-54a3f292fd5e\",\"vocabulary_id\":\"2\",\"name\":\"zona\"}],\"groups\":[{\"display_name\":\"Economia e finanze\",\"description\":\"\\u003Cp\\u003EThis concept identifies datasets covering such domains as economy or finance.\\u003C\\/p\\u003E\\n\",\"id\":\"d51ce83d-0d00-4955-afbd-2c9240ee7596\",\"title\":\"ECON\",\"name\":\"Economia e finanze\"}],\"organization\":[{\"title\":\"Comune di Milano\",\"description\":\"\",\"id\":\"25936114-3cb9-4c9d-a75c-6ab29dffdeb2\",\"image_url\":\"https:\\/\\/www.dati.gov.it\\/sites\\/default\\/files\\/comune_milano.png\",\"name\":\"group\\/comune-milano\",\"created\":\"2018-01-08T11:46:21+01:00\",\"type\":\"organization\"}],\"extras\":[{\"key\":\"\",\"value\":\"\"}],\"_catalog_parent_name\":\"Comune di Milano\",\"_catalog_source_url\":\"http:\\/\\/dati.comune.milano.it\\/api\\/3\\/action\\/package_list\"}}";
		String fileName = "business.csv";
		ParserJSON parse = new ParserJSON (json, fileName);
		parse.downloadUsingStream(parse.getURL(json), parse.getFileName());
		

	}

*/
	

}