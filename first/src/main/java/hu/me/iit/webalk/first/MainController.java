package hu.me.iit.webalk.first;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="article")
public class MainController {
	private final ArticleService articleService;
	
	public MainController(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	@GetMapping(path="", produces= MediaType.APPLICATION_JSON_VALUE)
	List<ArticleDto> allArticles() {
		return articleService.findAll();
	}
	
	@PostMapping(path="")
	void newArticle(@RequestBody @Valid ArticleDto articleDto) {
		articleService.save(articleDto);
	}
	
	@PutMapping(path="/")
	void replaceArticle(@RequestBody @Valid ArticleDto articleDto) {
		articleService.save(articleDto);
	}
	
	@DeleteMapping(path="/{id}")
	void deleteArticle(@PathVariable("id") Long id) {
		articleService.deleteById(id);
	}
}
