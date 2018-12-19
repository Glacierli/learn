package cn.pdstore;
import java.io.Serializable;
public class Userlogin implements Serializable {

	private String name;
	private String passworld;

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

	@Override
	public String toString() {
		return "User [name=" + name + ", passworld=" + passworld + "]";
	}

}
