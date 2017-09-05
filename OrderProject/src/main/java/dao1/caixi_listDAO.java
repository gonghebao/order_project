package dao1;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import entity1.caixi_list;

public class caixi_listDAO {
	private SqlSession session;
	public List<caixi_list> findcaixi(caixi_list clist){
		String config = "SqlMapConfig.xml";
		SqlSessionFactoryBuilder ssfb = 
				new SqlSessionFactoryBuilder();
		SqlSessionFactory ssf = ssfb.build(Test.class.getClassLoader().getResourceAsStream(config));
		session = ssf.openSession();
		List<caixi_list> list = session.selectList("test.findcaixi",clist);
		session.close();
		return list;
	}
//	public static void main(String[] args) {
//		caixi_listDAO dao = new caixi_listDAO();
//		List<caixi_list> list = dao.findcaixi("川菜");
//		System.out.println(list);
//	}
}
