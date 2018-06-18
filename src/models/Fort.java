package models;

public class Fort {

	private int idFort;
	private String name;
	private String urlImageFort;
	
	public Fort(int idFort, String name, String urlImageFort) {
		this.idFort = idFort;
		this.name = name;
		this.urlImageFort = urlImageFort;
	}

	public int getIdFort() {
		return idFort;
	}

	public String getName() {
		return name;
	}

	public String getUrlImageFort() {
		return urlImageFort;
	}
}