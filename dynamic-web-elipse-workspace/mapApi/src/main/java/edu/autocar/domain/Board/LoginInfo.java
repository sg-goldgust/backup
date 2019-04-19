package edu.autocar.domain.Board;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginInfo {
	@NotEmpty(message = "사용자 Id 입력은 필수입니다")
	private String userId;
	@NotEmpty(message = "비밀번호 입력은 필수입니다")
	private String password;
	
	private String reason;
	private String target;
}
