package katachi.spring.todo.service.impl;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import katachi.spring.todo.model.ListItem;
import katachi.spring.todo.model.TodoItem;
import katachi.spring.todo.model.User;
import katachi.spring.todo.repository.UserMapper;
import katachi.spring.todo.service.UserService;

/**
 * ユーザーサービス実装クラス
 * @author T.imura
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;

	@Override
	public List<User> getUsers() {
		return mapper.getUsers();
	}

	@Override
	public List<TodoItem> getTodoItems() {
		return mapper.getTodoItems();
	}

	@Override
	public void addTodoItem(
			Integer userId,
			String itemName,
			Date registrationDate,
			Date expireDate,
			Date finishedDate) {
		mapper.addTodoItem(userId, itemName, registrationDate, expireDate, finishedDate);
	}

	@Override
	public TodoItem getTodoItem(Integer id) {
		return mapper.getTodoItem(id);
	}

	@Override
	public ListItem getListOne(TodoItem item) {

		ListItem li = new ListItem();
		li.setId(item.getId());
		li.setItemName(item.getItemName());
		li.setUserId(item.getUserId());
		li.setUserName(item.getUserName());

		// 日付をフォーマットする
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		li.setRegistrationDate(df.format(item.getRegistrationDate()));
		li.setExpireDate(df.format(item.getExpireDate()));
		if(item.getFinishedDate() == null) {
			li.setFinishedDate("未"); // 完了日がnullのときは未完了
		} else {
			li.setFinishedDate(df.format(item.getFinishedDate()));
		}

		li.setIsDeleted(item.getIsDeleted());

		return li;
	}

	@Override
	public void deleteTodoItem(Integer id) {
		mapper.deleteTodoItem(id);
	}

	@Override
	public void updateTodoItem(
			Integer id,
			String itemName,
			Integer userId,
			Date expireDate,
			Date finishedDate) {
		mapper.updateTodoItem(id, itemName, userId, expireDate, finishedDate);
	}

	@Override
	public List<TodoItem> searchByWord(String word) {
		return mapper.searchByWord(word);
	}

	@Override
	public String getUserName(String user) {
		return mapper.getUserName(user);
	}

	@Override
	public void setLoginName(Model model, Principal principal) {

		String user = principal.getName();	// ログインuser="test1"を取得
		String name = getUserName(user);	// "テスト"＋"花子"を取得
		model.addAttribute("name", name);	// Modelに登録
	}

	@Override
	public void setTodoItems(Model model, List<TodoItem> todoItems) {

		// 期限過ぎている項目は赤色にする
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String today = df.format(date);
		model.addAttribute("today", today);

		List<ListItem> listItems = new ArrayList<ListItem>();
		for(TodoItem item: todoItems) {
			ListItem li = getListOne(item);
			if(li.getIsDeleted() == 0) {
				// 削除フラグがonの場合、表示しない
				listItems.add(li);
			}
		}

		model.addAttribute("listItems", listItems);
	}

	@Override
	public String isExist(Integer id) {
		return mapper.isExist(id);
	}
}
