package cn.pdstore;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/task2")
public class LoginController {

	@Autowired
	private LoginService loginService;
	@Autowired
	private LogService logService;
	//定义全局变量
	//private Userlogin user;
	// 默认请求方式为get 首页
	@RequestMapping(value = "/login")
	public String logintwo() {
		return "logintwo";
	}
     //存数据然后跳转到下一个控制层
	@RequestMapping(value = "/push")
	public String user(ModelMap map, Userlogin u) {
		//调用service中的方法将数据存入数据中
		loginService.adduser(u);
		//跳转向控制层首页
		return "redirect:/task2/demo.do";
	}

	//跳转到demo页面
	@RequestMapping("/demo")
	public String loadDemoPage(ModelMap map) {
		//在这里获取数据库中的数据然后传到域中
		List<Userlogin> list = loginService.finduser();
		map.put("userlist", list);
		return "demo";
	}
	//通过页面传过来的id查询该条数据，存入域中并跳转到修改页
	@RequestMapping("edit")
	public String loadeditPage(@RequestParam(value = "id") int id, ModelMap map) {
		Userlogin user = loginService.finbyid(id);
		Log lg=new Log();
		lg.setName(user.getName());
		lg.setPassworld(user.getPassworld());
		logService.insertlog(lg);
		//先走查询再走修改
		map.put("use", user);
		return "/edit";
	}
	//删除
	@RequestMapping("del")
	public String del(@RequestParam(value = "id") int id, ModelMap map) {
		loginService.deluser(id);
		Userlogin user = loginService.finbyid(id);
		//先走查询再走修改
		return "redirect:/task2/demo.do";
	}
	//执行修改的操作，前台传过来的是ajax数据
	@RequestMapping(value = "/editt",method=RequestMethod.POST)
	@ResponseBody
	//ajax的json方式接收参数用@requestParam
	public void show(@RequestParam(value = "id") int  id,@RequestParam(value = "name") String name, @RequestParam(value = "passworld") String passworld,
			ModelMap map) {
		loginService.updateuser(id,name,passworld);
		//获取到前端传过来的name和pwd然后根据id进行修改
		//System.out.println("username" + name + "password:" + passworld);
		//user.setName(name);
		//user.setPassworld(passworld);
		//map.put("use", user);
	}

	// 默认请求方式为get
	/*
	 * @RequestMapping(value="/login",method=RequestMethod.POST )
	 * 
	 * @ResponseBody public String demo(ModelMap map,Userlogin u){
	 * 
	 * map.put("user", loginService.inUserlogin(u)); return "login";
	 * 
	 * 
	 * }
	 */

}
