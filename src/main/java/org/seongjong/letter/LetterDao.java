package org.seongjong.letter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class LetterDao {

	static final String INSERT_LETTER = "insert letter(title,content,senderId,senderName,receiverId,receiverName) values(?,?,?,?,?,?)";
	static final String SEND_LIST = "selet letterId,title,receiverId,receiverName,cdate where senderId=?";	
	static final String RECEIVE_LIST = "selet letterId,title,senderId,senderName,cdate from letter where receiveId=?";
	static final String DETAIL_LETTER = "select letterId,title,content,senderId,senderName,receiverId,receiverName,cdate from letter where letterId=? and (senderId = ? or receiverId=?)";
	static final String DELETE_LETTER = "delete from letter where letterId=? and(senderId = ? or receiverId=?)";


	@Autowired
	JdbcTemplate jdbcTemplate;

	RowMapper<Letter> letterRowMapper = new BeanPropertyRowMapper<>(Letter.class);

	

	/**
	 * 편지 저장 
	 */
    
	/**
	 * 받은 목록
	 */
	public Letter receiveLetter(String receiverId) {
		return jdbcTemplate.queryForObject(RECEIVE_LIST,letterRowMapper,receiverId);
	}
	
	/**
	 * 보낸 목록
	 */
	
	public Letter senderLetter(String senderId) {
		return jdbcTemplate.queryForObject(SEND_LIST, letterRowMapper,senderId);
	}

	/**
	 * 편지 쓰기 
	 */
	public int wirteLetter(Letter letter) {
		return jdbcTemplate.update(INSERT_LETTER,letter.getTitle(),letter.getContent(),letter.getSenderId(),letter.getSenderName(),letter.getReceiverId(),letter.getReceiverName());
	}



	/**
	 * 편지 삭제 
	 */
	public int deleteLetter(String receiverId, String senderId) {
		return jdbcTemplate.update(DELETE_LETTER, receiverId, senderId);
	}
}