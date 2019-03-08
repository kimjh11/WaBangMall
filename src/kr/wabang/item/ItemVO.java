package kr.wabang.item;

public class ItemVO {
	private String iCode;//��ǰ�ڵ�
	private String iCategoryStr;//ī�װ�
	private String iName;//��ǰ��
	private int iPrice;//��ǰ����
	private int iDiscount;//������
	private int noOptPrice;//����*������ (�ɼ�����X)
	private String iThumbnailStr;//�����
	private String iOptStr;//�ɼ�
	private String iColorStr;//����
	private String iDetail;//�󼼼���
	private String iRegdate;//�����
	
	
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
	
	public ItemVO(String iCode) {
		this.iCode = iCode;
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
	
	public int getNoOptPrice() {
		return noOptPrice;
	}

	public void setNoOptPrice(int iPrice, int iDiscount) {
		this.noOptPrice = iPrice-(int)Math.ceil(iPrice * ((double)iDiscount/100));
		
	}

	public String getiThumbnailStr() {
		return iThumbnailStr;
	}
	
	public void setiThumbnailStr(String iThumnailStr) {
		this.iThumbnailStr = iThumnailStr;
	}

	public String getiOptStr() {
		return iOptStr;
	}
	
	public void setiOptStr(String iOptStr) {
		this.iOptStr = iOptStr;
	}	

	public String getiColorStr() {
		return iColorStr;
	}
	
	public void setiColorStr(String iColorStr) {
		this.iColorStr = iColorStr;
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
