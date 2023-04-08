package katachi.spring.todo.service;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.ui.Model;

import katachi.spring.todo.model.ListItem;
import katachi.spring.todo.model.TodoItem;
import katachi.spring.todo.model.User;

/**
 * ユーザーサービスインターフェース
 * @author T.Imura
 
 */
public interface UserService {

	/**
	 * usersテーブルから全件取得する。
	 * @return
	 */
	public List<User> getUsers();

	/**
	 * todo_itemsテーブルから全件取得する。
	 * @return
	 */
	public List<TodoItem> getTodoItems();

	/**
	 * todo_itemsテーブルに一件追加する。
	 * @param userId
	 * @param itemName
	 * @param registrationDate
	 * @param expireDate
	 * @param finishedDate
	 */
	public void addTodoItem(
			Integer userId,
			String itemName,
			Date registrationDate,
			Date expireDate,
			Date finishedDate
	);

	/**
	 * todo_itemsテーブルから一件取得する。
	 * @param id
	 * @return
	 */
	public TodoItem getTodoItem(Integer id);

	/**
	 * 日付フォーマットして表示用リスト一件を取得する。
	 * @param item
	 * @return
	 */
	public ListItem getListOne(TodoItem item);

	/**
	 * todo_itemsテーブルから一件削除(論理削除)する。
	 * @param id
	 */
	public void deleteTodoItem(Integer id);

	/**
	 * todo_itemsテーブルを一件更新する。
	 * @param id
	 * @param itemName
	 * @param userId
	 * @param expireDate
	 * @param finishedDate
	 */
	public void updateTodoItem(
			Integer id,
			String itemName,
			Integer userId,
			Date expireDate,
			Date finishedDate
	);

	/**
	 * 検索ワードでデータを取得する。
	 * @param word
	 * @return
	 */
	public List<TodoItem> searchByWord(String word);

	/**
	 * usersテーブルから姓＋名を取得する。
	 * @param user
	 * @return
	 */
	public String getUserName(String user);

	/**
	 * Modelに姓＋名を登録する。
	 * @param model
	 * @param principal
	 */
	public void setLoginName(Model model, Principal principal);

	/**
	 * ModelにTodoリストを登録する。
	 * @param model
	 * @param todoItems
	 */
	public void setTodoItems(Model model, List<TodoItem> todoItems);

	/**
	 * idのユーザーが存在するかチェックする。
	 * @param id
	 * @return
	 */
	public String isExist(Integer id);
}
