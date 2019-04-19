package domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	private String userId;
	private String password;
	private String name;
	private String email;
	private String phone;
	private String gender;
	private Date regDate;
}