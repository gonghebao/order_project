package entity1;

import java.io.Serializable;

public class foodcarbean{
	private String foodName;//菜名
	private String price;//单价
	private String mprice;//会员价
	private Integer foodCount;//数量
	private double Prices;
	
	public Integer getDd_id() {
		return dd_id;
	}
	public void setDd_id(Integer dd_id) {
		this.dd_id = dd_id;
	}
	private Integer dd_id;
	
	
	public double getPrices() {
		return Prices;
	}
	public void setPrices(double prices) {
		Prices = prices;
	}
	//餐桌表
	private String tableName;//餐桌名
	private String table_id;
	private Double sumprice; //小计
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getMprice() {
		return mprice;
	}
	public void setMprice(String mprice) {
		this.mprice = mprice;
	}
	public Integer getFoodCount() {
		return foodCount;
	}
	public void setFoodCount(Integer foodCount) {
		this.foodCount = foodCount;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getTable_id() {
		return table_id;
	}
	public void setTable_id(String table_id) {
		this.table_id = table_id;
	}
	public Double getSumprice() {
		return sumprice;
	}
	public void setSumprice(Double sumprice) {
		this.sumprice = sumprice;
	}
	
	
	
}
