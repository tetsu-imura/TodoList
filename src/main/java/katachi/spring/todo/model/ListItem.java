package katachi.spring.todo.model;

import lombok.Data;

/**
 * 一覧画面Model
 * @author T.Imura
 *
 */
@Data
public class ListItem {

	private Integer	id;					// ID
	private String	itemName;			// 項目名
	private Integer	userId;				// ユーザーID
	private String	userName;			// 担当者(姓＋名)
	private String	registrationDate;	// 登録日
	private String	expireDate;			// 期限日
	private String	finishedDate;		// 完了日
	private Integer	isDeleted;			// 削除フラグ
}
