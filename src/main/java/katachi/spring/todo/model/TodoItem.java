package katachi.spring.todo.model;

import java.util.Date;

import lombok.Data;

/**
 * 
 * @author T.Imura
 *
 */
@Data
public class TodoItem {

	// todo_itemsテーブルのデータ
	private Integer	id;					// ID
	private Integer	userId;				// ユーザーID
	private String	itemName;			// 項目名
	private Date	registrationDate;	// 登録日
	private Date	expireDate;			// 期限日
	private Date	finishedDate;		// 完了日
	private Integer	isDeleted;			// 削除フラグ
	private Date	createDateTime;		// 登録日時
	private Date	updateDateTime;		// 更新日時

	private String	userName;			// ユーザー名(usersテーブルから結合)
}
