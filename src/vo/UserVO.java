package vo;

public class UserVO {
	private int userIDX;
	private String userID;
	private String password;
	private String userName;
	private String phoneNumber;
	private String joinDate;

	public int getUserIDX() {
		return userIDX;
	}

	public void setUserIDX(int userIDX) {
		this.userIDX = userIDX;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "UserVO [userIDX=" + userIDX + ", userID=" + userID + ", password=" + password + ", userName=" + userName
				+ ", phoneNumber=" + phoneNumber + ", joinDate=" + joinDate + "]";
	}

}
