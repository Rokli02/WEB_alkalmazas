package hu.me.iit.webalk.individual;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BoardGameMemoryRepository implements BoardGameRepository {
	List<BoardGameDto> boardGames = new ArrayList<>();
	
	private int findBoardGameById(int id) {
		int found = -1;
		for (int i = 0; i < boardGames.size(); i++) {
			if(boardGames.get(i).getId() == id) {
				found = i;
				break;
			}
		}
		return found;
	}
	
	@Override
	public List<BoardGameDto> findAll() {
		return boardGames;
	}

	@Override
	public BoardGameDto getById(int id) {
		return boardGames.get(findBoardGameById(id));
	}

	@Override
	public int save(BoardGameDto boardGameDto) {
		int found = findBoardGameById(boardGameDto.getId());
		
		if(found != -1) {
			BoardGameDto foundGame = boardGames.get(found);
			foundGame.setManufacturer(boardGameDto.getManufacturer());
			foundGame.setPlayerNumber(boardGameDto.getPlayerNumber());
		} else {
			boardGames.add(boardGameDto);
		}
		
		return 0;
	}

	@Override
	public void deleteById(int id) {
		int found = findBoardGameById(id);
		
		if(found != -1) {
			boardGames.remove(found);
		}
	}

}
