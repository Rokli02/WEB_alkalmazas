package hu.me.iit.webalk.individual;

import java.util.List;

public interface BoardGameRepository {
	List<BoardGameDto> findAll();
	BoardGameDto getById(int id);
	int save(BoardGameDto boardGameDto);
	void deleteById(int id);
}
