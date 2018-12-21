package cn.pdstore;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class LoginService {
	//插入数据
	public void adduser(Userlogin u){
		Connection conn=null;
		PreparedStatement ps =null;
		String name= u.getName();
		String passworld= u.getPassworld();
		try {
			//获取连接器
			 conn = JDBCUtils.getConn();
			 conn.setAutoCommit(false);
			 //sql语句
			String sql="insert into user"+ " values(null,?,?)";
			//获取传输器
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, passworld);
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
	
	//查询数据
		public List<Userlogin> finduser(){
			Connection conn=null;
			PreparedStatement ps =null;
			ResultSet rs =null; 
			Userlogin user=null;
			List<Userlogin> list=new ArrayList<>();
			try {
				//获取连接器
				 conn = JDBCUtils.getConn();
				 
				 //sql语句
				String sql="select*from user";
				//获取传输器
				ps = conn.prepareStatement(sql);
				//执行SQL语句
				rs = ps.executeQuery();
				
				while(rs.next()){
					user=new Userlogin(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("passworld")
						
							);
					list.add(user);
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
        //通过id查询，回显数据使用
		public Userlogin finbyid(int id) {
			Connection conn=null;
			PreparedStatement ps =null;
			ResultSet rs =null; 
			Userlogin user=null;
			try {
				//获取连接器
				 conn = JDBCUtils.getConn();
				 //sql语句
				String sql="select*from user"+ " where id=?";
				//获取传输器
				ps = conn.prepareStatement(sql);
				ps.setInt(1, id);
				//执行SQL语句
				rs = ps.executeQuery();
				
				while(rs.next()){
					user=new Userlogin(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("passworld")
						
							);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("失败!!");
				e.printStackTrace();
			}
			finally {
				JDBCUtils.close(conn, ps, rs);
			}
			return user;
		 	}
		//修改用户信息
		public void updateuser(int id, String name, String passworld) {
			// TODO Auto-generated method stub
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				//1.从连接池中获取一个连接对象
				conn = JDBCUtils.getConn();
				conn.setAutoCommit(false);
				//2.声明sql语句, 获取传输器
				String sql = "update user"
						+ " set name=?,passworld=?"
						+" where id=?";
				ps = conn.prepareStatement(sql);
				//3.设置sql参数
				ps.setString(1, name);
				ps.setString(2, passworld);
				ps.setInt(3, id);
				//4.执行sql语句
 				ps.executeUpdate();
 				conn.commit();
			} catch (Exception e) {
				e.printStackTrace();//记得打印异常信息!!
				System.out.println("修改失败!!");
				throw new RuntimeException("修改失败!!");
			} finally{
				//5.释放资源
				JDBCUtils.close(conn, ps, null);
			}
			
		}
		//删除
		public void deluser(int id) {
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				//1.获取连接对象
				conn = JDBCUtils.getConn();
				conn.setAutoCommit(false);
				//2.声明sql语句,获取传输器
				String sql = "delete from user where id=?";
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
	
	
	
