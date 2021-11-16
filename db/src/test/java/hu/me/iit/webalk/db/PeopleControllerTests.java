package hu.me.iit.webalk.db;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import hu.me.iit.webalk.db.repository.PeopleRepository;
import hu.me.iit.webalk.db.repository.People;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
//@Transactional
class PeopleControllerTests {

	@Autowired
	private PeopleRepository peopleRepository;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void shouldNoMainPage() throws Exception {
		this.mockMvc.perform(get("/"))
		.andDo(print())
		.andExpect(status().is4xxClientError());
	}
	
	@Test
	public void shouldReturnPeoples() throws Exception {
		//GIVEN
		People people = new People(1L, 12, "1");
		peopleRepository.save(people);
		
		//WHEN	//THEN
		this.mockMvc.perform(get("/people"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.[0].name", is("1")))
		.andExpect(jsonPath("$.[0].age", is(12)))
		.andExpect(jsonPath("$.[0].id", is(1)));
	}
	
	@Test
	public void shouldReturnPeoples2() throws Exception {
		//GIVEN
		People people = new People(1L, 22, "2");
		peopleRepository.save(people);
		
		//WHEN	//THEN
		this.mockMvc.perform(get("/people"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.[0].name", is("2")))
		.andExpect(jsonPath("$.[0].age", is(22)))
		.andExpect(jsonPath("$.[0].id", is(1)));
	}
	
	/*
	  @Test
		public void shouldReturnPeoples2() throws Exception {
			//GIVEN
			People people = new People(1L, 22, "2");
			peopleRepository.save(people);
			//WHEN
			
			//THEN
			this.mockMvc.perform(get("/people"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string("[{\"id\":1,\"name\":\"2\",\"age\":22}]"));
	}
	  */
}
