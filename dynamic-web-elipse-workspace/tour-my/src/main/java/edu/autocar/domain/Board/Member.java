package edu.autocar.domain.Board;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor

public class Member {
	@NotEmpty(message="ID는 필수 항목입니다")
	private String userId;
	@NotEmpty(message="비밀번호는 필수 항목입니다")
	@Length(min=6)
	private String password;
	private String name;
	private String salt;
	//private UserLevel userLevel;
	private UserLevel userLevel;
	private String email;
	private String phone;
	private String address;
	private Date regDate;
	private Date updateDate;
	
	public Member() {
		userLevel = UserLevel.NORMAL;
	}
	//boolean type의 getter
	public boolean isAdmin() {
		return userLevel==UserLevel.ADMIN;
	}
}