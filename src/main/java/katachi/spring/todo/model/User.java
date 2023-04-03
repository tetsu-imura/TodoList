package katachi.spring.todo.model;

import java.util.Date;

import lombok.Data;

/**
 * 
 * @author T.Imura
 *
 */
@Data
public class User {

	private Integer	id;				// ID
	private String	user;			// ログインユーザー名
	private String	pass;			// ログインパスワード
	private String	familyName;		// ユーザー姓
	private String	firstName;		// ユーザー名
	private Integer	isAdmin;		// 管理者権限
	private Integer	isDeleted;		// 削除フラグ
	private Date	createDateTime;	// 登録日時
	private Date	updateDateTime;	// 更新日時

}
