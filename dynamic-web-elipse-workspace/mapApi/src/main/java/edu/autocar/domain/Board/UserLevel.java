package edu.autocar.domain.Board;

public enum UserLevel {
	ADMIN("admin","관리자"),
	NORMAL("normal","노멀"),
	SILVER("silver","실버"),
	GOLD("gold","골드");
	
	private String value;
	private String label;
	
	private UserLevel(String value, String label) {
		this.value = value;
		this.label = label;
	}
}
