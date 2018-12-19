package cn.pdstore;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/task2")
public class LoginController {

	private Userlogin user;

	// 默认请求方式为get
	@RequestMapping(value = "/login")
	public String logintwo() {
		return "logintwo";
	}

	@RequestMapping(value = "/push")
	public String user(ModelMap map, Userlogin u) {
		user = u;
		map.put("use", u);
		return "redirect:/task2/demo.do";
	}

	@RequestMapping("/demo")
	public String loadDemoPage(ModelMap map) {
		map.put("use", user);
		return "demo";
	}

	@RequestMapping("edit")
	public String loadeditPage(ModelMap map) {
		map.put("use", user);
		return "/edit";
	}

	@RequestMapping(value = "/editt")
	@ResponseBody
	public void show(@RequestParam(value = "name") String name, @RequestParam(value = "passworld") String passworld,
			ModelMap map) {
		System.out.println("username" + name + "password:" + passworld);
		user.setName(name);
		user.setPassworld(passworld);
		map.put("use", user);
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
