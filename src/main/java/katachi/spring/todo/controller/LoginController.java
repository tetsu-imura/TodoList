package katachi.spring.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import katachi.spring.todo.form.LoginForm;
import lombok.extern.slf4j.Slf4j;

/**
 * ログイン画面コントローラー
 * @author T.Imura
 *
 */
@Slf4j
@Controller
public class LoginController {

	/**
	 * ログイン画面
	 * @param model
	 * @param form
	 * @return
	 */
	@GetMapping("/login")
	public String getLogin(
			Model model,
			@ModelAttribute LoginForm form) {

		log.info("# LoginController:getLogin()");

		return "login";
	}

}
