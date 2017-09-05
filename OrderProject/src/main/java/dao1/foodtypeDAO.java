package dao1;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import entity1.foodtype;

public class foodtypeDAO {
	private SqlSession session;
	public List<foodtype> findfoodtype(){
		String config = "SqlMapConfig.xml";
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		//会读取SqlMapConfig.xml 创建 Map  key是sqlId value 是  PreparedStatement 
		SqlSessionFactory ssf = ssfb.build(caidan_listDAO.class.getClassLoader().getResourceAsStream(config));
		session = ssf.openSession();
		List<foodtype> list = session.selectList("findfoodtype");
		session.close();
		return list;
	}
}
