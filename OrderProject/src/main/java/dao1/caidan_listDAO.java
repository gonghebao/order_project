package dao1;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import entity1.caidan_list;

public class caidan_listDAO {
	private SqlSession session;
	//获取所有菜的信息 并显示在caidan.web页面下
	public List<caidan_list> findcaidan(caidan_list caidan){
		String config = "SqlMapConfig.xml";
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		//会读取SqlMapConfig.xml 创建 Map  key是sqlId value 是  PreparedStatement 
		SqlSessionFactory ssf = ssfb.build(caidan_listDAO.class.getClassLoader().getResourceAsStream(config));
		session = ssf.openSession();
		System.out.println(session);
		List<caidan_list> list =  session.selectList("test.findcaidan",caidan);
		System.out.println(list);
		session.close();
		return list;
	}
}
