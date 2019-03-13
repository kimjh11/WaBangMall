package kr.wabang.order;

public class BasketVO2 {
	private String iCode;
	private String iCategory;
	private String iName;
	private String i_Thumbnail;
	
	private String mId;

	private String bCountStr;
	private String bSelectOptStr;
	private String bColorStr;
	
	private int bCode;
	private String[] bCount;
	private String[] bSelectOpt;
	private String[] bColor;
	private int bPrice;//원가
	private int bPayment;//총결제금액(옵션+수량적용)
	private String bRegdate;
	
	
	
	public BasketVO2() {}

	
	public String getiCode() {
		return iCode;
	}

	public void setiCode(String iCode) {
		this.iCode = iCode;
	}

	public String getiCategory() {
		return iCategory;
	}


	public void setiCategory(String iCategory) {
		this.iCategory = iCategory;
	}


	public String getiName() {
		return iName;
	}


	public void setiName(String iName) {
		this.iName = iName;
	}


	public String getiThumbnail() {
		return iThumbnail;
	}


	public void setiThumbnail(String iThumbnail) {
		this.iThumbnail = iThumbnail;
	}


	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getbCountStr() {
		return bCountStr;
	}


	public void setbCountStr(String bCountStr) {
		this.bCountStr = bCountStr;
	}


	public String getbSelectOptStr() {
		return bSelectOptStr;
	}


	public void setbSelectOptStr(String bSelectOptStr) {
		this.bSelectOptStr = bSelectOptStr;
	}


	public String getbColorStr() {
		return bColorStr;
	}


	public void setbColorStr(String bColorStr) {
		this.bColorStr = bColorStr;
	}


	public int getbCode() {
		return bCode;
	}


	public void setbCode(int bCode) {
		this.bCode = bCode;
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

