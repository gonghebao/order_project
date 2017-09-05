package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import entity.Order;
import util.DBUtil;

public class OrderDao implements Serializable {
	
	//查询订单信息
	public List<Order> findAll(){
		List<Order> list = new ArrayList<Order>();
		Connection conn = null;
		try {
			conn = DBUtil.gtConnection();
			String sql = "SELECT * FROM orders_1705 WHERE orderdate IS NOT NULL ORDER BY dd_id";
			Statement smt = conn.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			while(rs.next()){
				Order o = new Order();
				o.setDdID(rs.getInt("dd_id"));
				o.setTableID(rs.getString("table_id"));
				o.setOrderDate(rs.getDate("orderDate"));
				o.setTotalPrice(rs.getDouble("totalPrice"));
				o.setOrdersTatus(rs.getInt("ordersTatus"));
				list.add(o);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询订信息错误",e);
		}finally{
			DBUtil.close(conn);
		}
		return list;
	}
	public void deleteFrderList(int id){
		Connection conn = null;
		try {
			conn = DBUtil.gtConnection();
			String sql = "delete from orders_1705 WHERE dd_id=?";
			PreparedStatement ps =  conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("删除失败",e);
		}finally{
			DBUtil.close(conn);
		}
	}
	public static void main(String[] args) {
		OrderDao dao = new OrderDao();
		List<Order> o = dao.findAll();
		for(Order d : o){
			System.out.println(d);
		}
		
	}
	
	
}
