package gd.fintech.fileuploadtest.vo;

import java.util.List;


public class Board {
	private int boardId;
	private String boardTitle;
	private String boardContent;
	private List<Boardfile> boardfiles;
	
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
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
	public List<Boardfile> getBoardfiles() {
		return boardfiles;
	}
	public void setBoardfiles(List<Boardfile> boardfiles) {
		this.boardfiles = boardfiles;
	}
	@Override
	public String toString() {
		return "Board [boardId=" + boardId + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardfiles=" + boardfiles + "]";
	}
	
}
