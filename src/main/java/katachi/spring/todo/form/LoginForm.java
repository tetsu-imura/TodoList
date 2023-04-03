package katachi.spring.todo.form;

import lombok.Data;

/**
 * ログインフォーム
 * @author T.Imura
 *
 */
@Data
public class LoginForm {

	private String userName;	// ユーザー名

	private Integer password;	// パスワード
}
