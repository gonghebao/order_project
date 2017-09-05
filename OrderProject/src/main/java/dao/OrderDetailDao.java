package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Detail;
import util.DBUtil;

public class OrderDetailDao implements Serializable{
	public List<Detail> findAll(int id){
		List<Detail> list = new ArrayList<Detail>();
		Connection conn = null;
		try {
			conn = DBUtil.gtConnection();
			String sql = "SELECT d.food_id foodid,f.foodname,f.price,d.foodcount "
					+ "FROM food_1705 f,orders_1705 o,orderDetail_1705 d "
					+ "WHERE o.dd_id=? AND f.ID=d.food_id AND o.dd_id = d.orderid "
					+ "order by d.food_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Detail e = new Detail();
				e.setFoodid(rs.getInt("foodid"));
				e.setName(rs.getString("foodname"));
				e.setPrice(rs.getDouble("price"));
				e.setCount(rs.getInt("foodcount"));
				list.add(e);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return list;
	}
}
