package cn.pdstore;

import java.util.List;

public interface UserloginMapper {
	public void insertuser(Userlogin u);
	// 查询所有
		public List<Userlogin> selectAl();
		//根据id 查询
		public Userlogin finbyi(Userlogin u);
		public void updat(Userlogin u);
		public void de(Userlogin u);
}
