package data;

public class Users {
	String id;
	String password;
	int birth;
	String gender;
	String nickname;
	String avatarId;

	Avatars avatar;// 이렇게도 실행 할 수 있구나.

	public Users() {
		super();
	}

	public Users(String id, String password, int birth, String gender, String nickname, String avatarId,
			Avatars avatar) {
		super();
		this.id = id;
		this.password = password;
		this.birth = birth;
		this.gender = gender;
		this.nickname = nickname;
		this.avatarId = avatarId;
		this.avatar = avatar;
	}
	

	public Users(String id, String password, int birth, String gender, String nickname, String avatarId) {
		super();
		this.id = id;
		this.password = password;
		this.birth = birth;
		this.gender = gender;
		this.nickname = nickname;
		this.avatarId = avatarId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getBirth() {
		return birth;
	}

	public void setBirth(int birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAvatarId() {
		return avatarId;
	}

	public void setAvatarId(String avatarId) {
		this.avatarId = avatarId;
	}

	public Avatars getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatars avatar) {
		this.avatar = avatar;
	}

}
