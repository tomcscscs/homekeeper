package data;

public class Avatars {
	String id;
	String alt;
	String imageUrl;

	public Avatars() {
		super();
	}

	public Avatars(String id, String alt, String image_url) {
		super();
		this.id = id;
		this.alt = alt;
		this.imageUrl = image_url;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public String getImage_url() {
		return imageUrl;
	}

	public void setImage_url(String image_url) {
		this.imageUrl = image_url;
	}

}
