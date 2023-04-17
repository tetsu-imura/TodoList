package katachi.spring.todo.form;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 * 入力フォーム
 * @author T.Imura
 *
 */
@Data
public class InputForm {

	@NotBlank
	@Length(max=100)
	private String itemName;		// 項目名

	private Integer userId;			// 担当者

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date expireDate;		// 期限日

	private Integer isFinished;		// 完了

}
