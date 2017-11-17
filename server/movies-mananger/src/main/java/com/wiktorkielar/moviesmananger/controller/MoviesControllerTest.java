package com.wiktorkielar.moviesmananger.controller;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.wiktorkielar.moviesmananger.MoviesManangerApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = MoviesManangerApplication.class)
public class MoviesControllerTest {
	
//	@Autowired
//	private RestTemplate restTemplate;
//
//	@Test
//	public void testGetMovies() {
//		String url = "/api/movies";
//		ResponseEntity<List<Movie>> response = this.restTemplate
//				.exchange(url, HttpMethod.GET, requestEntity, responseType)
//	}
//
//	@Test
//	public void testCreateMovie() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDeleteMovie() {
//		fail("Not yet implemented");
//	}

}
