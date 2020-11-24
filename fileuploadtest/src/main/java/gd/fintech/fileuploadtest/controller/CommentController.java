package gd.fintech.fileuploadtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import gd.fintech.fileuploadtest.service.CommentService;
import gd.fintech.fileuploadtest.vo.Comment;

@Controller
public class CommentController {
	@Autowired CommentService commentService;
	
	
	@PostMapping("/addComment")
	public String addComment(Comment comment) {
		commentService.addComment(comment);
		return "redirect:/boardOne?boardId="+comment.getBoardId();
	}
}
