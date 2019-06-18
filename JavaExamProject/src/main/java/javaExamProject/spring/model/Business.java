package javaExamProject.spring.model;
/**
 * Con questa classe rappresentiamo le attivita', ovvero il nostro modello di dati.
 * @author Angela D'Antonio 
 * @author Laura Della Sciucca
 */
public class Business {
	private String code;
	private String site;
	private String expertise;
	private String address;
	private String civic;
	private String addressCode;
	private String signboard;
	private String commoditiesSector;
	private String historicalSector;
	private String pHistoricalSector;
	private String sHistoricalSector;
	private int totalArea;
	private int commercialArea;
	private int municipality;
	private double longitude;
	private double latitude;
	private double location[];


	/**
	 * Primo metodo costruttore, permette l'istanziazione dell'attivita'
	 * 
	 * @param code codice, sottoforma di stringa, che identifica le attivita' 
	 * @param site rappresenta l'ubicazione dell'attivita'
	 * @param expertise rappresenta l'area di competenza dell'attivita'
	 * @param address rappresenta la via dell'attivita'
	 * @param civic rappresenta il numero civico dell'attivita'
	 * @param addressCode rappresenta il codice via dell'attivita' (numerico)
	 * @param signboard rappresenta l'insegna dell'attivita'
	 * @param commoditiesSector rappresenta il settore merceologico del'attivita'
	 * @param historicalSector rappresenta il settore storico dell'attivita'
	 * @param pHistoricalSector rappresenta il settore storico prevalente dell'attivita'
	 * @param sHistoricalSector rappresenta un ltro tipo di settore storico dell'attivita'
	 * @param totalArea rappresenta la superficie totale occupata dall'attivita'
	 * @param commercialArea rappresenta la superficie totale di vendita dell'attivita'
	 * @param municipality rappresenta il municipio dell'attivita'
	 * @param longitude rappresenta la longitudine dell'attivita'
	 * @param latitude rappresenta la latitudine dell'attivita'
	 * @param location rappresenta ,tramite un array, latitudine e longitudine dell'attivita'
	 */
	public Business(String code, String site, String expertise, String address, String civic, String addressCode,
			String signboard, String commoditiesSector, String historicalSector, String pHistoricalSector,
			String sHistoricalSector, int totalArea, int commercialArea, int municipality, double longitude, double latitude,
			double location[]
			) {
		super();
		this.code = code;
		this.site = site;
		this.expertise = expertise;
		this.address = address;
		this.civic = civic;
		this.addressCode = addressCode;
		this.signboard = signboard;
		this.commoditiesSector = commoditiesSector;
		this.historicalSector = historicalSector;
		this.pHistoricalSector = pHistoricalSector;
		this.sHistoricalSector = sHistoricalSector;
		this.totalArea = totalArea;
		this.commercialArea = commercialArea;
		this.municipality = municipality;
		this.longitude = longitude;
		this.latitude = latitude;
		this.location = location;

	}
	/**
	 * costruttore di copia, permette di istanziare  un'attivita'
	 * con le stesse caratteristiche dell'attivita' che gli viene passata come parametro
	 * @param b
	 */
	public Business(Business b) {
		super();
		this.code = b.getCode();
		this.site = b.getSite();
		this.expertise = b.getExpertise();
		this.address = b.getAddress();
		this.civic = b.getCivic();
		this.addressCode = b.getAddressCode();
		this.signboard = b.getSignboard();
		this.commoditiesSector = b.getCommoditiesSector();
		this.historicalSector = b.getHistoricalSector();
		this.pHistoricalSector = b.getpHistoricalSector();
		this.sHistoricalSector = b.getsHistoricalSector();
		this.totalArea = b.getTotalArea();
		this.commercialArea = b.getCommercialArea();
		this.municipality = b.getMunicipality();
		this.longitude = b.getLongitude();
		this.latitude = b.getLatitude();
		this.location = b.getLocation();

	}

	/**
	 * 
	 * @return location, posizione dell'attivita' 
	 */


	public double[] getLocation() {
		return location;
	}
	/**
	 * 
	 * @param location posizione con cui valorizzo l'attivita'
	 */

	public void setLocation(double[] location) {
		this.location = location;
	}
	/**
	 * 
	 * @return codice, codice associato all'attivita'
	 */


	public String getCode() {
		return code;
	}

	/**
	 * 
	 * @param code, codice con cui valorizzo l'attivita'
	 */


	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 
	 * @return site, ubicazione dell'attivita'
	 */


	public String getSite() {
		return site;
	}
	/**
	 * 
	 * @param site, ubicazione con cui valorizzo l'attivita'
	 */


	public void setSite(String site) {
		this.site = site;
	}

	/**
	 * 
	 * @return expertise, area di competenza dell'attivita'
	 */


	public String getExpertise() {
		return expertise;
	}

	/**
	 * 
	 * @param expertise, area di competenza con cui valorizzo l'attivita'
	 */


	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	/**
	 * 
	 * @return address, via dell'attivita'
	 */


	public String getAddress() {
		return address;
	}

	/**
	 * 
	 * @param address, via con cui valorizzo l'attivita'
	 */


	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 
	 * @return civic, civico dell'attivita'
	 */


	public String getCivic() {
		return civic;
	}
	/**
	 * 
	 * @param civic, civico con cui valorizzo l'attivita'
	 */


	public void setCivic(String civic) {
		this.civic = civic;
	}
	/**
	 * 
	 * @return addressCode, codice via dell'attivita'
	 */

	public String getAddressCode() {
		return addressCode;
	}
	/**
	 * 
	 * @param addressCode, codice via con cui valorizzo l'attivita'
	 */


	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
	}
	/**
	 * 
	 * @return signboard, insegna dell'attivita'
	 */


	public String getSignboard() {
		return signboard;
	}
	/**
	 * 
	 * @param signboard, insegna con cui valorizzo l'attivita'
	 */


	public void setSignboard(String signboard) {
		this.signboard = signboard;
	}
	/**
	 * 
	 * @return commodietiesSector, settore merceologico dell'attivita'
	 */


	public String getCommoditiesSector() {
		return commoditiesSector;
	}
	/**
	 * 
	 * @param commoditiesSector, settore mercelogico con cui valorizzo l'attivita'
	 */


	public void setCommoditiesSector(String commoditiesSector) {
		this.commoditiesSector = commoditiesSector;
	}
	/**
	 * 
	 * @return historicalSector, settore storico dell'attivita'
	 */


	public String getHistoricalSector() {
		return historicalSector;
	}

	/**
	 * 
	 * @param historicalSector, settore storico con cui valorizzo l'attivita'
	 */


	public void setHistoricalSector(String historicalSector) {
		this.historicalSector = historicalSector;
	}
	/**
	 * 
	 * @return pHistoricalSector, settore storico prevalente dell'attivita'
	 */


	public String getpHistoricalSector() {
		return pHistoricalSector;
	}
	/**
	 * 
	 * @param pHistoricalSector, settore storico prevalente con cui valorizzo l'attivita'
	 */


	public void setpHistoricalSector(String pHistoricalSector) {
		this.pHistoricalSector = pHistoricalSector;
	}

	/**
	 * 
	 * @return sHistoricalSector, un altro tipo di settore storico dell'attivita'
	 */


	public String getsHistoricalSector() {
		return sHistoricalSector;
	}
	/**
	 * 
	 * @param sHistoricalSector, un altro tipo di settore storico dell'attività con cui valorizzo l'attivita'
	 */


	public void setsHistoricalSector(String sHistoricalSector) {
		this.sHistoricalSector = sHistoricalSector;
	}
	/**
	 * 
	 * @return totalArea, superficie totale dell'attivita'
	 */


	public int getTotalArea() {
		return totalArea;
	}
	/**
	 * 
	 * @param totalArea, superificie totale con cui valorizzo l'attivita'
	 */


	public void setTotalArea(int totalArea) {
		this.totalArea = totalArea;
	}
	/**
	 * 
	 * @return commercialArea, superficie totale di vendita dell'attivita'
	 */


	public int getCommercialArea() {
		return commercialArea;
	}
	/**
	 * 
	 * @param commercialArea, superficie totale di vendita con cui valorizzo l'attivita'
	 */


	public void setCommercialArea(int commercialArea) {
		this.commercialArea = commercialArea;
	}

	/**
	 * 
	 * @return municipality, municipio dell'attivita'
	 */


	public int getMunicipality() {
		return municipality;
	}

	/**
	 * 
	 * @param municipality, municipio con cui valorizzo l'attivita'
	 */


	public void setMunicipality(int municipality) {
		this.municipality = municipality;
	}

	/**
	 * 
	 * @return longitude, longitudine dell'attivita'
	 */


	public double getLongitude() {
		return longitude;
	}

	/**
	 * 
	 * @param longitude, longitudine con cui valorizzo l'attivita'
	 */


	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}

	/**
	 * 
	 * @return latitude, latitudine dell'attivita'
	 */


	public double getLatitude() {
		return latitude;
	}

	/**
	 * 
	 * @param latitude, latitudine con cui valorizzo l'attivita'
	 */


	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}

	/**
	 * Restituisce una rappresentazione testuale dell'oggetto attivita' in forma di stringa
	 */
	@Override
	public String toString() {
		return "Business [code=" + code + ", site=" + site + ", expertise=" + expertise + ", address=" + address
				+ ", civic=" + civic + ", addressCode=" + addressCode + ", signboard=" + signboard
				+ ", commoditiesSector=" + commoditiesSector + ", historicalSector=" + historicalSector
				+ ", pHistoricalSector=" + pHistoricalSector + ", sHistoricalSector=" + sHistoricalSector
				+ ", totalArea=" + totalArea + ", commercialArea=" + commercialArea + ", municipality=" + municipality
				+ ", longitude=" + longitude + ", latitude=" + latitude + ", location=" + location + "]";
	}


}
