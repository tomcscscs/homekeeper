package data;

public class Avatars {
	String id;
	String alt;
	String imageUrl;

	public Avatars() {
		super();
	}

	public Avatars(String id, String alt, String imageUrl) {
		super();
		this.id = id;
		this.alt = alt;
		this.imageUrl = imageUrl;
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
