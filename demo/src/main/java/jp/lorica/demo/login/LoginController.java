package jp.lorica.demo.login;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {
	@GetMapping("/loginForm")
	public ModelAndView loginForm(ModelAndView mav) {
		mav.setViewName("login/loginForm");
		return mav;
	}
	
	@PostMapping("/login")
	public ModelAndView login(@RequestParam String id, @RequestParam String pass, ModelAndView mav) {
		
		//バリデーション
		if(id==null || pass==null || id.isEmpty() || pass.isEmpty()) {
			mav.addObject("errMsg", "ログインできません");
			
			// param.idで取得できるので不要
//			mav.addObject("id", id);
			mav.setViewName("login/loginForm");
			return mav;
		}
		// パラメーターならaddObjectは不要。param.id,param.passで取得できる
//		mav.addObject("id", id);
//		mav.addObject("pass", pass);
		mav.setViewName("login/success");
		
		return mav;
	}
}
