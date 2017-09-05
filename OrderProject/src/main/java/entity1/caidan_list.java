package entity1;

public class caidan_list {
	private Integer id;
	private String foodname;
	private String foodtype_id;
	private double price;
	private double mprice;
	private String remark;
	private String img;
	private Integer start;
	private Integer end;
	public String getFoodname() {
		return foodname;
	}
	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}
	public String getFoodtype_id() {
		return foodtype_id;
	}
	public void setFoodtype_id(String foodtype_id) {
		this.foodtype_id = foodtype_id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getMprice() {
		return mprice;
	}
	public void setMprice(double mprice) {
		this.mprice = mprice;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getEnd() {
		return end;
	}
	public void setEnd(Integer end) {
		this.end = end;
	}
	@Override
	public String toString() {
		return "caidan_list [foodname=" + foodname + ", foodtype_id=" + foodtype_id + ", price=" + price + ", mprice="
				+ mprice + ", remark=" + remark + ", img=" + img + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
