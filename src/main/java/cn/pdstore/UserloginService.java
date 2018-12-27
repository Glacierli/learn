package cn.pdstore;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserloginService {

	private SqlSessionFactory sqlSessionFactory; 
	
	//插入用户信息
	public void insertuser(Userlogin u) throws Exception{
		InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
		 sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		 SqlSession sqlsession = sqlSessionFactory.openSession();
		 UserloginMapper mapper = sqlsession.getMapper(UserloginMapper.class);
		 mapper.insertuser(u);
		/*String statement ="cn.pdstore.UserlogMapper.insertuser";
		sqlsession.insert(statement, u);*/
		sqlsession.commit();
		
	}
	// 查询所有
	public List<Userlogin> selectAll() throws Exception {
		InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
		 sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		 SqlSession sqlsession = sqlSessionFactory.openSession();
		 UserloginMapper mapper = sqlsession.getMapper(UserloginMapper.class);
		 List<Userlogin> selectList = mapper.selectAl();
		 /*String statement="cn.pdstore.UserlogMapper.selectAll";
		 List<Userlogin> selectList = sqlsession.selectList(statement);*/
		return selectList;
	}
	//根据id 查询
	public Userlogin finbyid(Userlogin u) throws Exception{
		InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
		 sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		 SqlSession sqlsession = sqlSessionFactory.openSession();
		 UserloginMapper mapper = sqlsession.getMapper(UserloginMapper.class);
		 Userlogin selectOne = mapper.finbyi(u);
		/* String statement="cn.pdstore.UserlogMapper.finbyid";
		 Userlogin selectOne = sqlsession.selectOne(statement, u);*/
		return selectOne;
		
	}
	public void update(Userlogin u) throws Exception {
		// TODO Auto-generated method stub
		InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
		 sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		 SqlSession sqlsession = sqlSessionFactory.openSession();
		 UserloginMapper mapper = sqlsession.getMapper(UserloginMapper.class);
		 mapper.updat(u);
		 sqlsession.commit();
		 System.out.println(u);
	}
	public void del(Userlogin u) throws IOException {
		// TODO Auto-generated method stub
		InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
		 sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		 SqlSession sqlsession = sqlSessionFactory.openSession();
		 UserloginMapper mapper = sqlsession.getMapper(UserloginMapper.class);
		 mapper.de(u);
		/* String statement="cn.pdstore.UserlogMapper.del";
		 sqlsession.delete(statement, u);*/
		 sqlsession.commit();
	}

}
