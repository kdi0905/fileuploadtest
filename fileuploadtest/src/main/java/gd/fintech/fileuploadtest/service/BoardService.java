package gd.fintech.fileuploadtest.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import gd.fintech.fileuploadtest.mapper.BoardMapper;
import gd.fintech.fileuploadtest.mapper.BoardfileMapper;
import gd.fintech.fileuploadtest.vo.Board;
import gd.fintech.fileuploadtest.vo.BoardForm;
import gd.fintech.fileuploadtest.vo.Boardfile;

@Service
@Transactional
public class BoardService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired BoardMapper boardMapper;
	@Autowired BoardfileMapper boardfileMapper;
	
	public int getBoardListTotalCount() {
		return boardMapper.selectBoardListTotalCount(); 
	}
	
	public List<Board> getBoardListByPage(int currentPage, int rowPerPage){
		//페이징 작업
		int beginRow = (currentPage-1)*rowPerPage;
		Map<String,Object> Pagemap =new HashMap<>();
		Pagemap.put("beginRow", beginRow);
		Pagemap.put("rowPerPage", rowPerPage);
		List<Board> boardList = boardMapper.selectBoardListByPage(Pagemap);
		return boardList;
	}
	
	
	public void addBoard(BoardForm boardForm) {
		Board board = new Board();
		board.setBoardTitle(boardForm.getBoardTitle());
		board.setBoardContent(boardForm.getBoardContent());
		//1 board db 입력 => key값 받음
		boardMapper.insertBoard(board); 
		List<Boardfile> boardfile = null;
		if(boardForm.getBoardfile()!=null) {
			boardfile = new ArrayList<Boardfile>();
			for(MultipartFile mf : boardForm.getBoardfile()) {
				Boardfile bf= new Boardfile();
				bf.setBoardId(board.getBoardId());
				
				
				int p =mf.getOriginalFilename().lastIndexOf(".");//마지막부터 마지막.까지 자른다
				String ext =  mf.getOriginalFilename().substring(p).toLowerCase();//확장자 설정 // tolowerCase()소문자로 바꾸기
				String filename=UUID.randomUUID().toString().replace("-", ""); // 중복되지 않는 문자열이름을 만들기 -는 공백으로 바꾸기
				
				bf.setBoardfileName(filename+ext);//중복되지 않는 문자열이름을 만들어야한다.
				bf.setBoardfileSize(mf.getSize());
				bf.setBoardfileType(mf.getContentType());
				
				boardfile.add(bf);
				logger.debug("for문"+bf);
				try {
				mf.transferTo(new File("D:\\자바\\sts-git-work\\fileuploadtest\\maven.1606091111218\\fileuploadtest\\src\\main\\webapp\\upload\\"+filename+ext));
				}catch(Exception e) {
					e.printStackTrace();
					throw new RuntimeException();
				}
			}
		}
		

		//2. board db 입력
		//3. boardfile.size()횟수만큼 입력
		//4. 입력시 boardId 1번에서 받은 key값 사용
		if(boardfile != null) {
			for(Boardfile bf : boardfile) {
				boardfileMapper.insertBoardfile(bf);
			}
			
		}
	}
}
