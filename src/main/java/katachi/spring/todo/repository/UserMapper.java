package katachi.spring.todo.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import katachi.spring.todo.model.TodoItem;
import katachi.spring.todo.model.User;

/**
 * ユーザーマッパー
 * @author T.Imura
 *
 */
@Mapper
public interface UserMapper {

	// ユーザー一覧情報を取得する
	public List<User> getUsers();

	// todo_itemsテーブルからデータ取得
	public List<TodoItem> getTodoItems();

	// todo_itemsテーブルに一件追加
	public void addTodoItem(
			Integer userId,
			String itemName,
			Date registrationDate,
			Date expireDate,
			Date finishedDate
	);

	// todo_itemsテーブルから一件取得
	public TodoItem getTodoItem(Integer id);

	// todo_itemsテーブルの一件に削除フラグをたてる
	public void deleteTodoItem(Integer id);

	// todo_itemsテーブルの一件を更新する
	public void updateTodoItem(
			Integer id,
			String itemName,
			Integer userId,
			Date expireDate,
			Date finishedDate
	);

	// 検索ワードでデータを取得する
	public List<TodoItem> searchByWord(String word);

	// usersテーブルから"姓"＋"名"を取得する
	public String getUserName(String user);

	// idのユーザーが存在するかチェックする
	public String isExist(Integer id);
}
