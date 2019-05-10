package org.seongjong.springweb;
public class article {
	String articleId; // 아이디
	String email; // 이메일
	String password; // 비밀번호
	String name; // 이름
	String cdate; // 가입일

	/**
	 * Default Constructor
	 */
	public article() {
	}

	/**
	 * email, password, name 으로 초기화하는 컨스트럭터
	 * 
	 * @param email    이메일
	 * @param password 비밀번호
	 * @param name     이름
	 */
	public article(String email, String password, String name) {
		this.email = email;
		this.password = password;
		this.name = name;
	}

	public String getarticleId() {
		return articleId;
	}

	public void setarticleId(String articleId) {
		this.articleId = articleId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getCdate() {
		return cdate;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}

	@Override
	public String toString() {
		return "article [articleId=" + articleId + ", email=" + email + ", name="
				+ name + ", cdate=" + cdate + "]";
	}
}