package data;

import java.sql.Date;

public class SpendLog {
	int no;
	String userId;
	int amt;
	Date spendAt;
	String useDesc;
	int categoryId;

	public SpendLog() {
		super();
	}

	public SpendLog(int no, String userId, int amt, Date spendAt, String useDesc, int categoryId) {
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
