package javaExamProject.spring.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;
/**
 * classe che permette di effettuare il parse del json 
 * @author Angela D'Antonio
 * @author Laura Della Siucca
 *
 */

public class ParserJSON {
	private String fileNameCSV; 
	private String fileNameJSON;
	protected ParserJSON(String fileNameJSON, String fileNameCSV){
		this.fileNameCSV = fileNameCSV; 
		this.fileNameJSON = fileNameJSON ; 
	}

	
	public String getFileNameCSV() {
		return fileNameCSV;
	}


	public void setFileNameCSV(String fileNameCSV) {
		this.fileNameCSV = fileNameCSV;
	}


	public String getFileNameJSON() {
		return fileNameJSON;
	}


	public void setFileNameJSON(String fileNameJSON) {
		this.fileNameJSON = fileNameJSON;
	}
	
	/**
	 * metodo che ci permette ldi scaricare il file dal web e memorizzarlo all'interno del nostro computer
	 * @param urlStr, parametro a cui passiamo l'url da dove bisogna scaricare il file
	 * @param file, nome del file dove memorizziamo il contenuto scaricato
	 */
	
	protected void download(String urlStr, String file) {
		try {
			FileWriter fW =new FileWriter(file);
			BufferedWriter bW =new BufferedWriter (fW);
			URL url = new URL(urlStr);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			BufferedReader read = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			FileOutputStream fis = new FileOutputStream(file);
			String line = read.readLine();
			while(line!=null) {
				bW.write(line);
				line = read.readLine();
				bW.flush();
				bW.close();
			}
			fis.close();
			read.close();
		} catch(MalformedURLException ex) {
			ex.printStackTrace();
		} catch(IOException ioex) {
			ioex.printStackTrace();
		}

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

	/**
	 * E' l'effetivo parser del JSON, di fatti passandogli un contenuto json con questo metodo è possibile individuare l'url relativo al file csv
	 * @param nomeFileJSON , nome file in cui e' memorizzato il JSON
	 * @return urlAddress,  l'indirizzo del file.csv
	 * @throws FileNotFoundException
	 */

	protected String getURL (String nomeFileJSON)throws FileNotFoundException {
			BufferedReader reader = new BufferedReader(new FileReader(nomeFileJSON));
			String json = "";
			try {
				String line = reader.readLine();
				while(line!=null) {
					json += line;
					line = reader.readLine();
					reader.close();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			String urlAddress = "";
			JSONObject obj = new JSONObject(json);
			String name = obj.getJSONObject("result").getString("name");
			String revisione_time = obj.getJSONObject("result").getString("revision_timestamp");


		System.out.println("NAME : " + name);
		System.out.println("LAST REVISION : " + revisione_time);


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





	

}