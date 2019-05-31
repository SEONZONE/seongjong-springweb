package org.seongjong.letter;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.seongjong.article.Article;
import org.seongjong.springweb.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class LetterController {
	@Autowired
	LetterDao letterDao;
	/**
	 * 
	 * 보낸 목록
	 * 
	 */
	@GetMapping("/letter/sendlist")
	public void letterSendView(@RequestParam("senderId") String senderId,
			Model model) {
		Letter letter = LetterDao.get(senderId);
		model.addAttribute("letter", letter);
	}
	
	/**
	 * 받은 목록
	 */
	
	@GetMapping("/letter/receivelist")
	public void receiveList(
			@RequestParam(value = "page", defaultValue = "1") int page,
			Model model) {

		// 페이지당 행의 수와 페이지의 시작점
		final int COUNT = 100;
		int offset = (page - 1) * COUNT;

		List<Letter> letterList = letterDao.listLetter(offset, COUNT);
		int totalCount = LetterDao.getLetterCount();
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("letterList", letterList);
	}
	
	

}
