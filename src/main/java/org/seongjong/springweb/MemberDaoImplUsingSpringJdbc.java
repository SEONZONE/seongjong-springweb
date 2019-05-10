package org.seongjong.springweb;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository("articleDao")
public class articleDaoImplUsingSpringJdbc implements articleDao {

	static final String INSERT = "INSERT article(email, password, name) VALUES(?, sha2(?,256), ?)";

	static final String SELECT_ALL = "SELECT articleId, email, name, left(cdate,19) cdate FROM article ORDER BY articleId desc LIMIT ?,?";

	static final String COUNT_ALL = "SELECT count(articleId) count FROM article";

	@Autowired
	JdbcTemplate jdbcTemplate;

	final RowMapper<article> articleRowMapper = new BeanPropertyRowMapper<>(
										article.class);

	@Override
	public article selectByEmail(String email) {
		// TODO selectByEmail() 메서드 구현
		return null;
	}

	/**
	 * p.201 [리스트 8.12]의 insert() 메서드 수정
	 */
	@Override
	public void insert(article article) {
		jdbcTemplate.update(INSERT, article.getEmail(), article.getPassword(),
											article.getName());
	}

	@Override
	public void update(article article) {
		// TODO update() 메서드 구현
	}

	/**
	 * p.195 [리스트 8.9] selectAll() 메서드 수정
	 */
	@Override
	public List<article> selectAll(int offset, int count) {
		return jdbcTemplate.query(SELECT_ALL, articleRowMapper, offset, count);
	}

	@Override
	public int countAll() {
		return jdbcTemplate.queryForObject(COUNT_ALL, Integer.class);
	}
}