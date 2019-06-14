package javaExamProject.spring.model;

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

	public Business() {}

	public double[] getLocation() {
		return location;
	}


	public void setLocation(double[] location) {
		this.location = location;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getSite() {
		return site;
	}


	public void setSite(String site) {
		this.site = site;
	}


	public String getExpertise() {
		return expertise;
	}


	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCivic() {
		return civic;
	}


	public void setCivic(String civic) {
		this.civic = civic;
	}


	public String getAddressCode() {
		return addressCode;
	}


	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
	}


	public String getSignboard() {
		return signboard;
	}


	public void setSignboard(String signboard) {
		this.signboard = signboard;
	}


	public String getCommoditiesSector() {
		return commoditiesSector;
	}


	public void setCommoditiesSector(String commoditiesSector) {
		this.commoditiesSector = commoditiesSector;
	}


	public String getHistoricalSector() {
		return historicalSector;
	}


	public void setHistoricalSector(String historicalSector) {
		this.historicalSector = historicalSector;
	}


	public String getpHistoricalSector() {
		return pHistoricalSector;
	}


	public void setpHistoricalSector(String pHistoricalSector) {
		this.pHistoricalSector = pHistoricalSector;
	}


	public String getsHistoricalSector() {
		return sHistoricalSector;
	}


	public void setsHistoricalSector(String sHistoricalSector) {
		this.sHistoricalSector = sHistoricalSector;
	}


	public int getTotalArea() {
		return totalArea;
	}


	public void setTotalArea(int totalArea) {
		this.totalArea = totalArea;
	}


	public int getCommercialArea() {
		return commercialArea;
	}


	public void setCommercialArea(int commercialArea) {
		this.commercialArea = commercialArea;
	}


	public int getMunicipality() {
		return municipality;
	}


	public void setMunicipality(int municipality) {
		this.municipality = municipality;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}


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
