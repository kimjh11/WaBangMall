package kr.wabang.item;

public class ItemVO {
	private String code;
	private String category;
	private String name;
	private int price;
	private int discount;
	private String thumbnail="";
	private String delThumb;
	private String option;
	private String color;
	private String detail="";
	private String delDetail;
	private String regdate;
	private String newFileName[];
	private String editFileName[];
	private String path;
	private String titlethumbnail;
	private int disprice;

	
	public String setVO() {
		String allVO = "code = "+code+"\n";
			   allVO += "category = "+category+"\n";
			   allVO += "name = "+name+"\n";
			   allVO += "price = "+price+"\n";
			   allVO += "discount = "+discount+"\n";
			   allVO += "thumbnail = "+thumbnail+"\n";
			   allVO += "delThumb = "+delThumb+"\n";
			   allVO += "option = "+option+"\n";
			   allVO += "color = "+color+"\n";
			   allVO += "detail = "+detail+"\n";
			   allVO += "delDetail = "+delDetail+"\n";
			   allVO += "regdate = "+regdate+"\n";
			   allVO += "newFileName = "+newFileName+"\n";
			   allVO += "path = "+path+"\n";
		return allVO;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String[] getNewFileName() {
		return newFileName;
	}
	public void setNewFileName(String[] newFileName) {
		this.newFileName = newFileName;
		//占쏙옙占실뱄옙占쏙옙占쏙옙 null占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占�
		if(newFileName[3] !=null) {
			this.thumbnail += newFileName[3]+"|";
		}if(newFileName[2] !=null) {
			this.thumbnail += newFileName[2]+"|";
		}if(newFileName[1] !=null) {
			this.thumbnail += newFileName[1]+"|";
		}if(newFileName[0] !=null) {
			this.detail = newFileName[0];
		}
	}
	
	public String[] getEditFileName() {
		return editFileName;
	}

	public void setEditFileName(String[] editFileName) {
		this.editFileName = editFileName;
		//
		if(delDetail!=null && !delDetail.equals("")) {
			if(editFileName[0] !=null) {
				System.out.println("�궘�젣 �뵒�뀒�씪 = "+delDetail);
				this.detail = editFileName[1];
				  if(editFileName[1] !=null) {
					  this.thumbnail += editFileName[3]+"|";
				  }if(editFileName[2] !=null) {
					  this.thumbnail += editFileName[2]+"|";
				  }if(editFileName[3] !=null) {
					  this.thumbnail +=editFileName[0]+"|"; }
			}
		}else if(delDetail==null || delDetail.equals("")) {
			if(editFileName[0] !=null) {
				this.thumbnail += editFileName[2]+"|";
			}if(editFileName[1] !=null) {
				this.thumbnail += editFileName[1]+"|";
			}if(editFileName[2] !=null) {
				this.thumbnail += editFileName[0]+"|"; }				
			System.out.println("!!!thumbnail = "+thumbnail);		
		}
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getDelThumb() {
		return delThumb;
	}

	public void setDelThumb(String delThumb) {
		this.delThumb = delThumb;
	}

	public String getDelDetail() {
		return delDetail;
	}

	public void setDelDetail(String delDetail) {
		this.delDetail = delDetail;
	}

	public String getTitlethumbnail() {
		return titlethumbnail;
	}

	public void setTitlethumbnail(String titlethumbnail) {
		this.titlethumbnail = titlethumbnail;
	}

	public int getDisprice() {
		return disprice;
	}

	public void setDisprice(int disprice) {
		this.disprice = disprice;
	}
	
	
	
};
