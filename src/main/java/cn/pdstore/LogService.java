package cn.pdstore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 日志的业务层
 */
import org.springframework.stereotype.Service;

@Service
public class LogService {

	// TODO Auto-generated method stub
	// 插入数据
	public void insertlog(Log lg) {
		Connection conn = null;
		PreparedStatement ps = null;
		String name = lg.getName();
		String passworld = lg.getPassworld();
		int cz = lg.getCz();
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String t = df.format(new Date());
		

		try {
			// 获取连接器
			conn = JDBCUtils.getConn();
			conn.setAutoCommit(false);
			// sql语句
			String sql = "insert into log" + " values(null,?,?,?,?)";
			// 获取传输器
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, passworld);
			ps.setInt(3, cz); // 0为修改操作
			ps.setObject(4, t);
			// 执行SQL语句
			ps.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("失败!!");
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, ps, null);
		}

	}

	private Timestamp newTimestamp(long currentTimeMillis) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Log> findall() {
		//查询数据
					Connection conn=null;
					PreparedStatement ps =null;
					ResultSet rs =null; 
					Log log=null;
					List<Log> list=new ArrayList<>();
					try {
						//获取连接器
						 conn = JDBCUtils.getConn();
						 
						 //sql语句
						String sql="select*from log order by shijian desc";
						//获取传输器
						ps = conn.prepareStatement(sql);
						//执行SQL语句
						rs = ps.executeQuery();
						
						while(rs.next()){
							log=new Log(
								rs.getInt("id"),
								rs.getString("name"),
								rs.getString("passworld"),
								rs.getInt("cz"),
								rs.getTimestamp("shijian"));
							list.add(log);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("失败!!");
						e.printStackTrace();
					}
					finally {
						JDBCUtils.close(conn, ps, rs);
					}
					return list;
				}

	public void delbyid(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//1.获取连接对象
			conn = JDBCUtils.getConn();
			conn.setAutoCommit(false);
			//2.声明sql语句,获取传输器
			String sql = "delete from log where id=?";
			ps = conn.prepareStatement(sql);
			//3.设置sql参数
			ps.setInt(1, id);
			//4.执行sql语句,完成删除操作
			ps.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("删除失败!");
			throw new RuntimeException("删除失败!");
		} finally{
			//释放资源
			JDBCUtils.close(conn, ps, null);
		}
		
	}
		
	}
		
	


