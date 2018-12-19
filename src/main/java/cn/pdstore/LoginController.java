package cn.pdstore;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/task2")
public class LoginController {

	
	
	//默认请求方式为get
	@RequestMapping(value="/doIndexUI")
	public String logintwo(){
		return "logintwo";
	}
	@RequestMapping(value="/push")
	public void user(ModelMap map,Userlogin u ){
		map.put("use",u);
	   
	}
	//默认请求方式为get
	/*	@RequestMapping(value="/login",method=RequestMethod.POST )
		@ResponseBody
		public String  demo(ModelMap map,Userlogin u){
		
			map.put("user", loginService.inUserlogin(u));
			return "login";
			
		
		}*/
	
}
