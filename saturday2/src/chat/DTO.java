package chat;

public class DTO {
	private String userId, userPw;
	
	public DTO() {
		// TODO Auto-generated constructor stub
	}

	public DTO(String userId, String userPw) {

		this.userId = userId;
		this.userPw = userPw;
	}


	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	
}
