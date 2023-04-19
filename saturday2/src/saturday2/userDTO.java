package saturday2;

public class userDTO {
	private String userId;
	private String userPw;
	private String nickName;
	
	
	public userDTO() {
		// TODO Auto-generated constructor stub
	}
	
	


	public userDTO(String userId, String userPw) {
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


	public String getNickName() {
		return nickName;
	}


	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	
	
	
}
