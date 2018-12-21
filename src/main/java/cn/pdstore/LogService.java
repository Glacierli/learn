package cn.pdstore;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

/**
 * 日志的业务层
 */
import org.springframework.stereotype.Service;

@Service
public class LogService {

		// TODO Auto-generated method stub
		//插入数据
		public void insertlog(Log lg){
			Connection conn=null;
			PreparedStatement ps =null;
			String name= lg.getName();
			String passworld= lg.getPassworld();
			try {
				//获取连接器
				 conn = JDBCUtils.getConn();
				 conn.setAutoCommit(false);
				 //sql语句
				String sql="insert into log"+ " values(null,?,?,?,now())";
				//获取传输器
				ps = conn.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2, passworld);
				ps.setInt(3, 0); //0为修改操作
				
				//执行SQL语句
				ps.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("失败!!");
				e.printStackTrace();
			}
			finally {
				JDBCUtils.close(conn, ps, null);
			}
			
		}
		
	}

	
	

