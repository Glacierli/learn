package cn.pdstore;

import java.util.List;

public interface LogMapper {
	public void insertlog(Log u);
	public List<Log> selectAll();
	public void del(Log u) ;
}
