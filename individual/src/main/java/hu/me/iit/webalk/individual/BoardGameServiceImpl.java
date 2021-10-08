package hu.me.iit.webalk.individual;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BoardGameServiceImpl implements BoardGameService {
	private final int MAXIMUM_BOARDGAME_COUNT = 15;
	private final BoardGameRepository boardGameRepository;
	
	public BoardGameServiceImpl(BoardGameRepository boardGameRepository) {
		this.boardGameRepository = boardGameRepository;
	}

	@Override
	public List<BoardGameDto> findAll() {
		return boardGameRepository.findAll();
	}

	@Override
	public BoardGameDto getById(int id) {
		return boardGameRepository.getById(id);
	}

	@Override
	public int save(BoardGameDto boardGameDto) {
		if(boardGameRepository.findAll().size() >= MAXIMUM_BOARDGAME_COUNT) {
			throw new TooMuchBoardGameException();
		}
		return boardGameRepository.save(boardGameDto);
	}

	@Override
	public void deleteById(int id) {
		boardGameRepository.deleteById(id);
	}

}
