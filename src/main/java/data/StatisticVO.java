package data;

public class StatisticVO {
	String userId;
	int maxA;

	public StatisticVO() {
		super();
	}

	public StatisticVO(String userId, int maxA) {
		super();
		this.userId = userId;
		this.maxA = maxA;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getMaxA() {
		return maxA;
	}

	public void setMaxA(int maxA) {
		this.maxA = maxA;
	}

}
