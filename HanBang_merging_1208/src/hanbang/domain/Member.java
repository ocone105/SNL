package hanbang.domain;


public class Member {
	
	private String id;
	private String password;
	private String name;
	private String phoneNumber;
	private String email;
	private int memberTypeId;
	
	public Member() {
	}
	
	public Member(String memberId, String password, String name, String phoneNumber, String email, int memberTypeId) {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMemberTypeId() {
		return memberTypeId;
	}

	public void setMemberTypeId(int memberTypeId) {
		this.memberTypeId = memberTypeId;
	}
	
}
