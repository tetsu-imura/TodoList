package katachi.spring.todo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import katachi.spring.todo.model.ListItem;
import katachi.spring.todo.model.TodoItem;
import katachi.spring.todo.service.UserService;
import lombok.extern.slf4j.Slf4j;

/**
 * 削除画面コントローラー
 * @author T.Imura
 *
 */
@RequestMapping("/user")
@Controller
@Slf4j
public class DeleteController {

	@Autowired
	private UserService userService;

	/**
	 * 削除画面
	 * @param model
	 * @param principal
	 * @param id
	 * @return
	 */
	@GetMapping("/delete{id}")
	public String getDelete(
			Model model,
			Principal principal,
			@PathVariable("id") Integer id) {

		log.info("# DeleteController:getDelete() id:" + id);

		// ログインユーザー名をModelに登録
		userService.setLoginName(model, principal);

		// todo_itemsテーブルからデータ一件取得
		TodoItem todoItem = userService.getTodoItem(id);

		// 表示用に変換(姓名の結合、日付のフォーマット)
		ListItem listItem = userService.getListOne(todoItem);

		model.addAttribute("listItem", listItem);

		return "user/delete";
	}

	/**
	 * 削除実行
	 * @param model
	 * @param id
	 * @return
	 */
	@PostMapping("/delete")
	public String postDelete(
			Model model,
			@RequestParam("id") Integer id) {

		log.info("# DeleteController:postDelete() id:" + id);

		userService.deleteTodoItem(id);

		return "redirect:/user/list";
	}
}
