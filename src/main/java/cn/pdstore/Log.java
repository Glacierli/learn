package cn.pdstore;

import java.util.Date;

/*
 * log实体类
 */
public class Log {
private int id;
private String name;
private String passworld;
private Date time;
private int cz;


public Log() {
	super();
}
public Log(int id, String name, String passworld, Date time, int cz) {
	super();
	this.id = id;
	this.name = name;
	this.passworld = passworld;
	this.time = time;
	this.cz = cz;
}
@Override
public String toString() {
	return "Log [id=" + id + ", name=" + name + ", passworld=" + passworld + ", time=" + time + ", cz=" + cz + "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassworld() {
	return passworld;
}
public void setPassworld(String passworld) {
	this.passworld = passworld;
}
public Date getTime() {
	return time;
}
public void setTime(Date time) {
	this.time = time;
}
public int getCz() {
	return cz;
}
public void setCz(int cz) {
	this.cz = cz;
}

}
