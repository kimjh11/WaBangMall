package kr.wabang.order;

public class ShoppingListVO {
	private String iCode;
	private String mId;
	private String[] bCount;
	private String[] bSelectOpt;
	private String[] bColor;
	private int bPrice;//원가
	private int bPayment;//총결제금액(옵션+수량적용)
	private String bRegdate;
	
	public ShoppingListVO() {}

	
	public String getiCode() {
		return iCode;
	}

	public void setiCode(String iCode) {
		this.iCode = iCode;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String[] getbCount() {
		return bCount;
	}

	public void setbCount(String[] bCount) {
		this.bCount = bCount;
	}

	public String[] getbSelectOpt() {
		return bSelectOpt;
	}

	public void setbSelectOpt(String[] bSelectOpt) {
		this.bSelectOpt = bSelectOpt;
	}

	public String[] getbColor() {
		return bColor;
	}

	public void setbColor(String[] bColor) {
		this.bColor = bColor;
	}

	public int getbPrice() {
		return bPrice;
	}

	public void setbPrice(int bPrice) {
		this.bPrice = bPrice;
	}

	public int getbPayment() {
		return bPayment;
	}

	public void setbPayment(int bPayment) {
		this.bPayment = bPayment;
	}

	public String getbRegdate() {
		return bRegdate;
	}

	public void setbRegdate(String bRegdate) {
		this.bRegdate = bRegdate;
	}
}

