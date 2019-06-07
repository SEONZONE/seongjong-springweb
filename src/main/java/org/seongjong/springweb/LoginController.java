package org.seongjong.springweb;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.seongjong.springweb.Member;
import org.seongjong.springweb.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

	@Autowired
	MemberDao memberDao;

	static final Logger logger = LogManager.getLogger();

	/**
	 * 로그인 화면
	 */
	@GetMapping("/loginForm")
	public String form() {
		return "login/loginForm";
	}

	/**
	 * 로그인을 실행
	 */
	@PostMapping("/login")
	public String submit(@RequestParam("email") String email,
			@RequestParam("password") String password, 
			@RequestParam("returnUrl")String returnUrl,HttpSession session) {
		try {
			Member member = memberDao.selectByLogin(email, password);
			session.setAttribute("MEMBER", member);
			logger.debug("로그인 성공. {}", member);
			return "redirect:" + returnUrl;
		} catch (EmptyResultDataAccessException e) {
			logger.debug("로그인 실패. email={}", email);
			return "redirect:/app/loginForm?mode=FAILURE&email=" + email
					+"&returnUrl=" + returnUrl; // redirect 했는데 email 을 남기고 싶을때 parameter email 을 써주면 로그인이 실패해도 남아있다.
			                                                                      
		}
	}

	/**
	 * p.362 [리스트 13.3] LogoutController의 logout() 메서드 로그 아웃
	 */
	@RequestMapping("/logout") // logout 은 원래 페이지로 다시 redirect 한다. 제일 먼저 로그인하면 session 상태 부터 본다. gradle dist 하면 세션이 초기화 된다. 
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}