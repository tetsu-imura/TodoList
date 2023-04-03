package katachi.spring.todo.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import katachi.spring.todo.form.InputForm;
import katachi.spring.todo.model.ListItem;
import katachi.spring.todo.model.TodoItem;
import katachi.spring.todo.model.User;
import katachi.spring.todo.service.UserService;
import lombok.extern.slf4j.Slf4j;

/**
 * 更新画面コントローラー
 * @author T.Imura
 *
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class UpdateController {

	@Autowired
	private UserService userService;

	/**
	 * 更新画面
	 * @param model
	 * @param principal
	 * @param form
	 * @param id
	 * @return
	 */
	@GetMapping("/update{id}")
	public String getUpdate(
			Model model,
			Principal principal,
			@ModelAttribute InputForm form,
			@PathVariable("id") Integer id) {

		log.info("# updateController:getUpdate() id:" + id);

		// ログインユーザー名をModelに登録
		userService.setLoginName(model, principal);

		// ユーザー(担当者)一覧を取得してモデルに登録する
		List<User> users = userService.getUsers();
		model.addAttribute("users", users);

		// todo_itemsテーブルからデータ一件取得
		TodoItem todoItem = userService.getTodoItem(id);

		// 表示用に変換(姓名の結合、日付のフォーマット)
		ListItem listItem = userService.getListOne(todoItem);

		model.addAttribute("listItem", listItem);

		return "user/update";
	}

	/**
	 * 更新実行
	 * @param model
	 * @param principal
	 * @param id
	 * @param form
	 * @param bindingResult
	 * @return
	 */
	@PostMapping("/update")
	public String postUpdate(
			Model model,
			Principal principal,
			@RequestParam("id") Integer id,
			@ModelAttribute @Validated InputForm form,
			BindingResult bindingResult) {

		log.info("# updateController:postUpdate() id:" + id);

		// 不正な担当者の場合、エラー
		if(userService.isExist(form.getUserId()) == null) {
			FieldError fieldError = new FieldError(bindingResult.getObjectName(),
				"userId", "正しい担当者を選択してください");
			bindingResult.addError(fieldError);
		}

		if (bindingResult.hasErrors()) {
			return getUpdate(model, principal, form, id);
		}

		Date finishedDate = new Date();
		if(form.getIsFinished() == null) {
			finishedDate = null;
		}

		userService.updateTodoItem(
				id,
				form.getItemName(),
				form.getUserId(),
				form.getExpireDate(),
				finishedDate);

		return "redirect:/user/list";
	}
}
