package dao1;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Detail;
import util.DBUtil;

public class CarDao implements Serializable {
	// 查询全部(根据餐桌id)
	public List<Detail> findAll(int tableId) {
		List<Detail> list = new ArrayList<Detail>();
		Connection conn = null;
		try {
			conn = DBUtil.gtConnection();
			String sql = "SELECT d.food_id foodid,f.foodname,f.price,d.foodcount "
					+ "FROM food_1705 f,orders_1705 o,orderDetail_1705 d "
					+ "WHERE o.dd_id=? AND f.ID=d.food_id AND o.dd_id = d.orderid order by d.food_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, tableId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Detail e = new Detail();
				e.setFoodid(rs.getInt("foodid"));
				e.setName(rs.getString("foodname"));
				e.setPrice(rs.getDouble("price"));
				e.setCount(rs.getInt("foodcount"));
				list.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询数据失败");
		} finally {
			DBUtil.close(conn);
		}
		return list;
	}
	public void updateState(int id){
		Connection conn = null;
		try {
			conn = DBUtil.gtConnection();
			String sql = "update dinnerTable_1705 set tablestatus = 1 where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询数据失败");
		} finally {
			DBUtil.close(conn);
		}
	}
	// 删除数据
	public void delete(int tableId, int foodid) {
		Connection conn = null;
		try {
			conn = DBUtil.gtConnection();
			String sql = "DELETE FROM (SELECT * FROM orderDetail_1705 WHERE orderid = ?) " + "where food_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, tableId);
			ps.setInt(2, foodid);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("删除数据失败");
		} finally {
			DBUtil.close(conn);
		}
	}

	// 修改菜品数量（根据餐桌id,菜品id）
	public void modify(int foodcount, int tableId, int foodid) {
		Connection conn = null;
		try {
			conn = DBUtil.gtConnection();
			String sql = "UPDATE orderDetail_1705 SET foodcount = ? " + "where orderid = ? and food_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, foodcount);
			ps.setInt(2, tableId);
			ps.setInt(3, foodid);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("增加数据失败");
		} finally {
			DBUtil.close(conn);
		}
	}

	// 插入数据（先判断餐桌id和菜品id是否存在）
	public void save(int tableId, int foodid) {
		Connection conn = null;
		try {
			conn = DBUtil.gtConnection();
			String sql = "INSERT INTO orderDetail_1705 " + "VALUES (orderDetail_1705_seq.nextval,?,?,1)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, tableId);
			ps.setInt(2, foodid);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("插入数据失败");
		} finally {
			DBUtil.close(conn);
		}
	}

	// 修改菜品数量（根据餐桌id,菜品id）
	public void saveNumber(int foodcount, int tableId, int foodid) {
		Connection conn = null;
		try {
			conn = DBUtil.gtConnection();
			String sql = "UPDATE orderDetail_1705 SET foodcount = ? " + "where orderid = ? and food_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, foodcount);
			ps.setInt(2, tableId);
			ps.setInt(3, foodid);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("增加数据失败");
		} finally {
			DBUtil.close(conn);
		}
	}
	//结账（总金额写入）
	public void payMent(double totalPrice, int tableId) {
		Connection conn = null;
		try {
			conn = DBUtil.gtConnection();
			String sql = "UPDATE orders_1705 " + "SET orderDate=SYSDATE,totalPrice=?,orderStatus=1 " + "where dd_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, totalPrice);
			ps.setInt(2, tableId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("付款失败");
		} finally {
			DBUtil.close(conn);
		}
	}
	
	
	//根据餐桌id与菜品id查询，返回true或false
	public Boolean findByfoodid(int tableId,int foodid) {
		List<Detail> list = new ArrayList<Detail>();
		Connection conn = null;
		try {
			conn = DBUtil.gtConnection();
			String sql = "SELECT * FROM orderDetail_1705 WHERE orderid = ? AND food_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, tableId);
			ps.setInt(2, foodid);
			ResultSet rs = ps.executeQuery();
			boolean flag = false;
			while(rs.next()){
				flag = ps.execute();
			}
			return flag;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("(根据id+foodid)查询数据失败");
		} finally {
			DBUtil.close(conn);
		}
	}
	
	//查询订单是否存在，不存在添加
	public Boolean findByDdid(int tableId) {
		List<Detail> list = new ArrayList<Detail>();
		Connection conn = null;
		try {
			conn = DBUtil.gtConnection();
			String sql = "SELECT * FROM orders_1705 WHERE dd_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, tableId);
			ResultSet rs = ps.executeQuery();
			boolean flag = false;
			while(rs.next()){
				flag = ps.execute();
			}
			return flag;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询Dd_id失败");
		} finally {
			DBUtil.close(conn);
		}
	}
	
	
	//查询数量
	public int getFoodNumber(int tableId,int foodid) {
		Connection conn = null;
		int Number = 0;
		try {
			conn = DBUtil.gtConnection();
			String sql = "SELECT * FROM orderDetail_1705 WHERE orderid = ? AND food_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, tableId);
			ps.setInt(2, foodid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Number = rs.getInt("foodcount");
			}
			return Number;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询数据失败");
		} finally {
			DBUtil.close(conn);
		}
	}
	//1.添加订单
	public void CreateDd_id(int tableId){
		Connection conn = null;
		try {
			conn = DBUtil.gtConnection();
			CarDao dao = new CarDao();
			String tabelname = dao.findByTableName(tableId);
			String sql = "INSERT INTO orders_1705 VALUES(?,?,null,null,0)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, tableId);
			ps.setString(2, tabelname);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("添加订单失败");
		} finally {
			DBUtil.close(conn);
		}
	}
	
	//2.查询餐桌名
	public String findByTableName(int id){
		Connection conn = null;
		String tableName = null;
		try {
			conn = DBUtil.gtConnection();
			String sql = "select * from dinnerTable_1705 where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tableName = rs.getString("tableName");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询餐桌名失败");
		} finally {
			DBUtil.close(conn);
		}
		return tableName;
	}
	
	
	
	public static void main(String[] args) {
		CarDao dao = new CarDao();
		//dao.CreateDd_id(11);
		System.out.println("ffff"+dao.findByDdid(1));
	}

	
	
}
