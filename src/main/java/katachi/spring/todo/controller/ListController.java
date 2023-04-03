package katachi.spring.todo.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import katachi.spring.todo.model.TodoItem;
import katachi.spring.todo.service.UserService;
import lombok.extern.slf4j.Slf4j;

/**
 * 一覧画面コントローラー
 * @author T.Imura
 *
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class ListController {

	@Autowired
	private UserService userService;

	/**
	 * 一覧画面
	 * @param model
	 * @param principal
	 * @param search
	 * @return
	 */
	@GetMapping("/list")
	public String getList(
			Model model,
			Principal principal,
			@RequestParam(name="search", required=false) String search) {

		log.info("# ListController:getList() search:" + search);

		// ログインユーザー名をModelに登録
		userService.setLoginName(model, principal);

		List<TodoItem> todoItems = new ArrayList<>();
		if(search == null) {
			todoItems = userService.getTodoItems();
		} else {
			todoItems = userService.searchByWord(search);
		}
		// 検索ワードを検索欄に残す
		model.addAttribute("search", search);

		// TodoリストをModelに登録
		userService.setTodoItems(model, todoItems);

		return "user/list";
	}
}
