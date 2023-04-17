package katachi.spring.todo.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import katachi.spring.todo.form.InputForm;
import katachi.spring.todo.model.User;
import katachi.spring.todo.service.UserService;
import lombok.extern.slf4j.Slf4j;

/**
 * 登録画面コントローラー
 * @author T.Imura
 *
 */
@RequestMapping("/user")
@Controller
@Slf4j
public class RegistrationController {

	@Autowired
	private UserService userService;

	/**
	 * 登録画面
	 * @param model
	 * @param principal
	 * @param form
	 * @return
	 */
	@GetMapping("/registration")
	public String getRegistration(
			Model model,
			Principal principal,
			@ModelAttribute InputForm form) {

		log.info("# RegistrationController:getRegistration()");

		// ログインユーザー名をModelに登録
		userService.setLoginName(model, principal);

		// ユーザー(担当者)一覧をモデルに登録する
		List<User> users = userService.getUsers();
		model.addAttribute("users", users);

		model.addAttribute("form", form);

		return "user/registration";
	}

	/**
	 * 登録実行
	 * @param model
	 * @param principal
	 * @param form
	 * @param bindingResult
	 * @return
	 */
	@PostMapping("/registration")
	public String postRegistration(
			Model model,
			Principal principal,
			@ModelAttribute @Validated InputForm form,
			BindingResult bindingResult) {

		log.info("# RegistrationController:postRegistration()");

		// バリデーション
		if (bindingResult.hasErrors()) {
			return getRegistration(model, principal, form);
		}

		Date date = new Date();

		// 完了の場合、今日の日付
		Date finishedDate = null;
		if(form.getIsFinished() != null) {
			finishedDate = date;
		}

		// 受け取った情報をデータベースに保存する
		userService.addTodoItem(
				form.getUserId(),		// 担当者
				form.getItemName(),		// 項目名
				date,					// 登録日(本日の日付)
				form.getExpireDate(),	// 期限日
				finishedDate);			// 完了(本日の日付 or null)

		return "redirect:/user/list";
	}
}
