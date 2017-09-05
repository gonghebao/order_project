package entity1;

public class Caixiangxi {
	private String foodName;
	private String img;
	private Double price;
	private Double mprice;
	public Double getMprice() {
		return mprice;
	}
	public void setMprice(Double mprice) {
		this.mprice = mprice;
	}
	private String remark;
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Caixiangxi [foodName=" + foodName + ", img=" + img + ", price=" + price + ", mprice=" + mprice
				+ ", remark=" + remark + "]";
	}
	
	
}
