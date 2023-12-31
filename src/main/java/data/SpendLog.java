package data;

import java.sql.Date;

public class SpendLog {//그래 결국엔 여기에 로그 데이터들이 있으니 여기에 있는 데이터를 추출하기 위해서 메소드를 만든거야.
	int no;
	String userId;
	int amt;
	Date spendAt;
	String useDesc;
	int categoryId;
	
	Category category;

	
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public SpendLog(int no, String userId, int amt, Date spendAt, String useDesc, int categoryId, Category category) {
		super();
		this.no = no;
		this.userId = userId;
		this.amt = amt;
		this.spendAt = spendAt;
		this.useDesc = useDesc;
		this.categoryId = categoryId;
		this.category = category;
	}

	public SpendLog() {
		super();
	}

	public SpendLog(int no, String userId, int amt, Date spendAt, String useDesc, int categoryId) {//카테고리 없는 버전.
		super();
		this.no = no;
		this.userId = userId;
		this.amt = amt;
		this.spendAt = spendAt;
		this.useDesc = useDesc;
		this.categoryId = categoryId;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getAmt() {
		return amt;
	}

	public void setAmt(int amt) {
		this.amt = amt;
	}

	public Date getSpendAt() {
		return spendAt;
	}

	public void setSpendAt(Date spendAt) {
		this.spendAt = spendAt;
	}

	public String getUseDesc() {
		return useDesc;
	}

	public void setUseDesc(String useDesc) {
		this.useDesc = useDesc;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

}
