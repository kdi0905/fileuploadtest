package gd.fintech.fileuploadtest.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import gd.fintech.fileuploadtest.vo.Board;
@Mapper
public interface BoardMapper {
	int insertBoard(Board board);
	List<Board> selectBoardListByPage(Map<String,Object> Pagemap);
	int selectBoardListTotalCount();
}
