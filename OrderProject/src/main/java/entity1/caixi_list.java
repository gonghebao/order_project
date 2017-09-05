package entity1;

public class caixi_list {
	private Integer id;
	private String img;
	private String foodname;
	private Double price;
	private Integer start;
	private Integer end;
	private String foodtype_id;
	
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "caixi_list [id=" + id + ", img=" + img + ", foodname=" + foodname + ", price=" + price + ", start="
				+ start + ", end=" + end + ", foodtype_id=" + foodtype_id + "]";
	}
	public String getFoodname() {
		return foodname;
	}
	public void setFoodname(String foodname) {
		this.foodname = foodname;
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
	public String getFoodtype_id() {
		return foodtype_id;
	}
	public void setFoodtype_id(String foodtype_id) {
		this.foodtype_id = foodtype_id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
