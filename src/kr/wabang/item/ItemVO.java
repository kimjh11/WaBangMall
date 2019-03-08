package kr.wabang.item;

public class ItemVO {
	private String iCode;//상품코드
	private String iCategoryStr;//카테고리
	private String iCategory[];
	private String iName;//상품명
	private int iPrice;//상품원가
	private int iDiscount;//할인율
	private String iThumbnailStr;//썸네일
	private String iThumbnail[];
	private String iOptStr;//옵션
	private String iOpt[];
	private String iOptName[];//옵션명
	private int iOptPrice[];//옵션가
	private String iColorStr;//색상
	private String iColor[];
	private String iDetail;//상세설명
	private String iRegdate;//등록일
	
	
	public String toString() {
		String data = "iCode : "+iCode+"\n";
				data += "iCategoryStr : "+iCategoryStr+"\n";
				data += "iName : "+iName+"\n";
				data += "iPrice : "+iPrice+"\n";
				data += "iDiscount : "+iDiscount+"\n";
				data += "iThumnailStr : "+iThumbnailStr+"\n";
				data += "iOptStr : "+iOptStr+"\n";
				data += "iColorStr : "+iColorStr+"\n";
				data += "iDetail : "+iDetail+"\n";
				data += "iRegdate : "+iRegdate+"\n";
		return data;
	}
	
	
	public String getiCode() {
		return iCode;
	}
	
	public void setiCode(String iCode) {
		this.iCode = iCode;
	}
	
	public String getiCategoryStr() {
		return iCategoryStr;
	}
	
	public void setiCategoryStr(String iCategoryStr) {
		this.iCategoryStr = iCategoryStr;
		iCategory = iCategoryStr.split("|");	
	}
	
	public String[] getiCategory() {
		return iCategory;
	}
	public void setiCategory(String[] iCategory) {
		this.iCategory = iCategory;
	}
	
	public String getiName() {
		return iName;
	}
	
	public void setiName(String iName) {
		this.iName = iName;
	}
	
	public int getiPrice() {
		return iPrice;
	}
	
	public void setiPrice(int iPrice) {
		this.iPrice = iPrice;
	}
	
	public int getiDiscount() {
		return iDiscount;
	}
	
	public void setiDiscount(int iDiscount) {
		this.iDiscount = iDiscount;
	}
	
	public String getiThumbnailStr() {
		return iThumbnailStr;
	}
	
	public void setiThumbnailStr(String iThumnailStr) {
		this.iThumbnailStr = iThumnailStr;
		iThumbnail = iThumnailStr.split("|");
	}
	
	public String[] getiThumbnail() {
		return iThumbnail;
	}
	
	public void setiThumbnail(String[] iThumnail) {
		this.iThumbnail = iThumnail;
	}
	
	public String getiOptStr() {
		return iOptStr;
	}
	
	public void setiOptStr(String iOptStr) {
		this.iOptStr = iOptStr;
		iOpt = iOptStr.split("|");
	}
	
	public String[] getiOpt() {
		return iOpt;
	}
	public void setiOpt(String[] iOpt) {
		this.iOpt = iOpt;
	}
	
	public int[] getiOptPrice() {
		return iOptPrice;
	}
	public void setiOptPrice(int[] iOptPrice) {
		this.iOptPrice = iOptPrice;
	}
	public String getiColorStr() {
		return iColorStr;
	}
	public void setiColorStr(String iColorStr) {
		this.iColorStr = iColorStr;
	}
	public String[] getiColor() {
		return iColor;
	}
	public void setiColor(String[] iColor) {
		this.iColor = iColor;
	}
	public String getiDetail() {
		return iDetail;
	}
	public void setiDetail(String iDetail) {
		this.iDetail = iDetail;
	}
	public String getiRegdate() {
		return iRegdate;
	}
	public void setiRegdate(String iRegdate) {
		this.iRegdate = iRegdate;
	}
	
}
