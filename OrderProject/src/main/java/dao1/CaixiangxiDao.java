package dao1;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import entity1.Caixiangxi;

public class CaixiangxiDao {
	private SqlSession session;

	public Caixiangxi findById(int id){
		String config = "SqlMapConfig.xml";
		SqlSessionFactoryBuilder ssdf = new SqlSessionFactoryBuilder();
		SqlSessionFactory ssf = ssdf.build(CaixiangxiDao
				.class.getClassLoader()
				.getResourceAsStream(config));
		session = ssf.openSession();
		Caixiangxi list = new Caixiangxi();
		System.out.println("dao:"+id);
		list = session.selectOne("test.findcaixiangxi", id);
		System.out.println(list);
		session.close();
		return list;
	}
//	public static void main(String[] args) {
//		CaixiangxiDao dao = new CaixiangxiDao();
//		System.out.println(1);
//		List<Caixiangxi> list = dao.findById(33);
//		System.out.println(list);
//	}
}
