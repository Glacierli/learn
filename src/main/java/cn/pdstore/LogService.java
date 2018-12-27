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
public class LogService {

	private SqlSessionFactory sqlSessionFactory; 
	
	//插入日志信息
	public void insertlog(Log u) throws Exception{
		InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
		 sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		 SqlSession sqlsession = sqlSessionFactory.openSession();
		String statement ="cn.pdstore.LogMapper.insertlog";
		sqlsession.insert(statement, u);
		sqlsession.commit();
		
	}
	// 查询所有
	public List<Log> selectAll() throws Exception {
		InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
		 sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		 SqlSession sqlsession = sqlSessionFactory.openSession();
		 String statement="cn.pdstore.LogMapper.selectAll";
		 List<Log> selectList = sqlsession.selectList(statement);
		return selectList;
	}
	//删除
	public void del(Log u) throws IOException {
		// TODO Auto-generated method stub
		InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
		 sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		 SqlSession sqlsession = sqlSessionFactory.openSession();
		 String statement="cn.pdstore.LogMapper.del";
		 sqlsession.delete(statement, u);
		 sqlsession.commit();
	}


}
