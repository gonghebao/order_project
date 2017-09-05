package dao1;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import entity1.caidan_list;

public class caidan_someDAO {
	private SqlSession session;
	//获取所有菜的信息 并显示在caidan.web页面下
	public List<caidan_list> findsome(caidan_list name){
		String config = "SqlMapConfig.xml";
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		//会读取SqlMapConfig.xml 创建 Map  key是sqlId value 是  PreparedStatement 
		SqlSessionFactory ssf = ssfb.build(caidan_someDAO.class.getClassLoader().getResourceAsStream(config));
		session = ssf.openSession();
		List<caidan_list> list =  session.selectList("test.findsome",name);
		System.out.println(list);
		session.close();
		return list;
	}
}
