package hu.me.iit.webalk.individual;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

@RestController
@RequestMapping(path="boardgame")
public class MainController {
	private final BoardGameService boardGameService;
	
	public MainController(BoardGameService boardGameService) {
	this.boardGameService = boardGameService;
	}

	@GetMapping(path="", produces = MediaType.APPLICATION_JSON_VALUE)
	List<BoardGameDto> allBoardGame() {
		return boardGameService.findAll();
	}
	
	 @PostMapping(path="")
	 void newBoardGame(@RequestBody @Valid BoardGameDto boardGameDto) {
		 boardGameService.save(boardGameDto);
	 }
	 
	 @PutMapping(path="/")
	 void replaceBoardGame(@RequestBody @Valid BoardGameDto boardGameDto) {
		 boardGameService.save(boardGameDto);
	 }
	 
	 @DeleteMapping(path="/{id}")
	 void deleteBoardGame(@PathVariable("id") int id) {
		 boardGameService.deleteById(id);
	 }
	 
}
