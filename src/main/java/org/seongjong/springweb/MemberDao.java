package org.seongjong.springweb;
import java.util.List;


public interface articleDao {

	/**
	 * 이메일로 회원 정보 가져옴
	 */
	article selectByEmail(String email);

	/**
	 * 회원정보 저장
	 */
	void insert(article article);

	/**
	 * 회원정보 수정
	 */
	void update(article article);

	/**
	 * 회원 목록
	 */
	List<article> selectAll(int offset, int count);
	
	/**
	 * 회원 수
	 */
	int countAll();
}