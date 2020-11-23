package gd.fintech.fileuploadtest.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;


public class BoardForm {
	private String boardTitle;
	private String boardContent;
	private List<MultipartFile> boardfile;
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public List<MultipartFile> getBoardfile() {
		return boardfile;
	}
	public void setBoardfile(List<MultipartFile> boardfile) {
		this.boardfile = boardfile;
	}
	@Override
	public String toString() {
		return "BoardForm [boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", boardfile=" + boardfile
				+ "]";
	}
	
}
