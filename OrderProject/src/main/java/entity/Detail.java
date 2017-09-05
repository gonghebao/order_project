package entity;

import java.io.Serializable;
/*
 * 菜品管理里面明细 对象
 * */
public class Detail implements Serializable {
	private Integer foodid;	//菜品id（新增）
	private Integer orderid; //餐桌id(新增)
	private String name;  //菜名
	private Double price; //单价
	private Integer count;//数量
	
	
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public Integer getFoodid() {
		return foodid;
	}
	public void setFoodid(Integer foodid) {
		this.foodid = foodid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	
}
