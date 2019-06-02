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
	public void senderLetter(@SessionAttribute("MEMBER") Member member,
			Model model) {
		List<Letter> letters = letterDao
				.senderLetter(member.getMemberId());
       model.addAttribute("letters", letters);
	}
	
	/**
	 * 받은 목록
	 */
	
	@GetMapping("/letter/receivelist")
	public void receiverLetter(@SessionAttribute("MEMBER") Member member,
			Model model) {
		List<Letter> letters = letterDao
				.receiveLetter(member.getMemberId());
       model.addAttribute("letters", letters);
	}
	
	/**
	 * 상세 보기
	 */
	
	@GetMapping("/letter/view")
	public void view(@RequestParam("letterId") String letterId,
			@SessionAttribute("MEMBER") Member member, Model model) {
		Letter letter = letterDao.detailLetter(letterId, member.getMemberId());
		model.addAttribute("letter", letter);
}
	
	/**
	 * 편지 쓰기
	 */
	
	@PostMapping("/letter/addForm")
	public String add(Letter letter,
			@SessionAttribute("MEMBER") Member member) {
		letter.setSenderId(member.getMemberId());
		letter.setSenderName(member.getName());
		letterDao.insertLetter(letter);
		return "redirect:/app/letter/sendlist";
}
	
	/**
	 * 편지 삭제
	 */
	@GetMapping("/letter/delete")
	public String delete(@RequestParam("letterId") String letterId,
			@SessionAttribute("MEMBER") Member member) {
		int updatedRows = letterDao.deleteLetter(letterId,
				member.getMemberId());
		if (updatedRows == 0)
			throw new RuntimeException("No Authority!");
		return "redirect:/receivelist";
}
	
	
	
	
	

}
