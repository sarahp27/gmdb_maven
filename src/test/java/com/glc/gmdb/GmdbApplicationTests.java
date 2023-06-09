package com.glc.gmdb;

import static org.mockito.Mockito.when;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;

// import org.apache.tomcat.util.http.parser.MediaType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.glc.gmdb.Controller.MovieController;
import com.glc.gmdb.Controller.ReviewerController;
import com.glc.gmdb.Model.Movies;
import com.glc.gmdb.Model.Reviews;
import com.glc.gmdb.Model.User;
import com.glc.gmdb.Repository.IMovieRepository;
import com.glc.gmdb.Repository.IReviewRepo;
import com.glc.gmdb.Repository.IUserRepo;

@AutoConfigureMockMvc
@WebAppConfiguration
@SpringBootTest
class GmdbApplicationTests {

    private MockMvc mvc;
    private MockMvc mvc2;

    @Mock
    private IMovieRepository movieRepository;

    @Mock
    private IUserRepo reviewerRepository;

    @Mock
    private IReviewRepo reviewsRepository;

    @InjectMocks
    private ReviewerController reviewerController;

    @InjectMocks
    private MovieController movieController;
    // @Autowired
    private JacksonTester<Movies> jsonMovie;
    // @Autowired
    private JacksonTester<List<Movies>> jsonMovies;
    // @Autowired
    private JacksonTester<Reviews> jsonReview;
    // @Autowired
    private JacksonTester<List<Reviews>> jsonReviews;
    // @Autowired
    private JacksonTester<User> jsonReviewer;
    // @Autowired
    private JacksonTester<List<User>> jsonReviewers;

    @BeforeEach
    public void setUp() {
        JacksonTester.initFields(this, new ObjectMapper());
        mvc = MockMvcBuilders.standaloneSetup(movieController).build();
        mvc2 = MockMvcBuilders.standaloneSetup(reviewerController).build();
    }

    @Test
    void contextLoads() {
    }
    // Stories for this project are shown below in order of value, with the highest
    // value listed first.
    // This microservice will contain the CRUD operations required to interact with
    // the GMDB movie database.
    // Other functionality (e.g. user authentication) is hosted in other
    // microservices.
    //
    // 1. As a user
    // I can GET a list of movies from GMDB that includes Movie ID | Movie Title |
    // Year Released | Genre | Runtime
    // so that I can see the list of available movies.

    // so that I can see the list of available movies.

    // testing getAllMovies
    // @Test
    // public void getAllMovies() throws Exception {
    // Movies movies1 = new Movies("Your name",1999, "Comedy", 150);
    // Movies movies2 = new Movies("Your name",1999, "Comedy", 150);

    // List<Movies> addMovies = new ArrayList<>();
    // addMovies.add(movies1);
    // addMovies.add(movies2);
    // when(movieRepository.findAll()).thenReturn( addMovies );

    // mvc.perform(MockMvcRequestBuilders.get("/movies/all"))
    // .andExpect(content().json(jsonMovies.write(addMovies).getJson()))
    // .andExpect(status().isOk());
    // }

    // Test 1
    @Test
    public void getAllMovies() throws Exception {
        // Arrange
        Movies movie1 = new Movies("Your name", 1999, "Comedy", 150);
        Movies movie2 = new Movies("Your name", 1999, "Comedy", 150);
        List<Movies> expectedMovies = Arrays.asList(movie1, movie2);

        when(movieRepository.findAll()).thenReturn(expectedMovies);

        // Act and Assert
        mvc.perform(MockMvcRequestBuilders.get("/movies/all"))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonMovies.write(expectedMovies).getJson()));
    }

    private Object get(String string) {
        return null;
    }

    //
    // 2. As a user
    // I can provide a movie ID and get back the record shown in story 1, plus a
    // list of reviews that contains Review ID | Movie ID | Reviewer ID | Review
    // Text | DateTime last modified
    // so that I can read the reviews for a movie.
    //

    // @Test
    // public void getRecord() throws Exception {

    // Movies movie1 = new Movies("Your name", 1999, "Comedy", 150);
    // Optional<Movies> expected = Optional.ofNullable(movie1);
    // when(movieRepository.findById(1L)).thenReturn(expected);
    // mvc.perform(MockMvcRequestBuilders.get("/movies/1"))
    // // .contentType(MediaType.APPLICATION_JSON)

    // .andExpect(status().isOk())
    // .andExpect(content().json(jsonMovie.write(movie1).getJson()));

    // }

    // test 2

    @Test
    public void getAllRecord() throws Exception {
        // Arrange
        Movies movie1 = new Movies("Your name", 1999, "Comedy", 150);
        Optional<Movies> expected = Optional.of(movie1);
        when(movieRepository.findById(1L)).thenReturn(expected);

        // Act and Assert
        mvc.perform(MockMvcRequestBuilders.get("/movies/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonMovie.write(movie1).getJson()));
    }
    // 3. As a user
    // I can provide a Reviewer ID and get back a record that contains Reivewer ID |
    // Username | Date Joined | Number of Reviews
    // so that I can see details about a particular reviewer.

    // test 3

    // @Test
    // public void getReviewer()throws Exception{

    // Date currDate = new Date(0);
    // User reviewer = new User("Sarah", "Reviewer", currDate, 2);
    // reviewer.setReviews(new ArrayList<>());
    // when(reviewerRepository.findById(1L)).thenReturn(Optional.of(reviewer));

    // mvc2.perform(
    // MockMvcRequestBuilders.get("/Reviewers/1")
    // // (RequestBuilder) ((ContentResultMatchers)
    // get("/Reviewer/1")).contentType(MediaType.APPLICATION_JSON)
    // )
    // .andExpect(status().isOk())
    // .andExpect(content().json(jsonReviewer.write(reviewer).getJson()));
    // }

    @Test
    public void getReviewer() throws Exception {
        // Arrange
        Date currDate = new Date(0);
        User reviewer = new User("Sarah", "Reviewer", currDate, 2);
        reviewer.setReviews(new ArrayList<>());
        when(reviewerRepository.findById(1L)).thenReturn(Optional.of(reviewer));

        // Act and Assert
        mvc2.perform(MockMvcRequestBuilders.get("/Reviewers/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonReviewer.write(reviewer).getJson()));
    }

    //
    // 4. As a user
    // I can register as a reviewer by providing my Username. (Reviewer ID should be
    // autogenerated)
    // So that I can start reviewing movies.

    // @Test
    // public void registerUser() throws IOException, Exception{
    // User reviewer = new User("Sarah", "Reviewer", new Date(0), 2);
    // when(reviewerRepository.save(reviewer)).thenReturn(reviewer);
    // reviewer.setReviews(new ArrayList<>());
    // System.out.println(new Date(0));
    // mvc2.perform(MockMvcRequestBuilders.post("/Reviewers/Register"))
    // // .contentType(MediaType.APPLICATION_JSON)
    // // .andExpect(status().isOk())
    // .andExpect(content().json(jsonReviewer.write(reviewer).getJson()));

    // }

    @Test 
    public void registerUser() throws Exception{
        User reviewer = new User("Sarah", "", new Date(0), 2);
        reviewer.setReviews(new ArrayList<>());
        when(reviewerRepository.save(reviewer)).thenReturn(reviewer);
        System.out.println(new Date(0));

        mvc2.perform(MockMvcRequestBuilders.post("/Reviewers/Register")
        .contentType(MediaType.APPLICATION_JSON)
        .content(jsonReviewer.write(reviewer).getJson()))
        .andExpect(status().isOk())
        .andExpect(content().json(jsonReviewer.write(reviewer).getJson()));
    }

    // @Test
    // public void registerUser() throws IOException, Exception {
    //     User reviewer = new User("Sarah", "Reviewer", new Date(0), 2);
    //     when(reviewerRepository.save(reviewer)).thenReturn(reviewer);
    //     reviewer.setReviews(new ArrayList<>());
    //     System.out.println(new Date(0));
    //     ((MockHttpServletRequestBuilder) mvc2.perform(post("/Reviewers/Register")))
    //             .contentType(MediaType.APPLICATION_JSON))
    //             .andExpect(status().isOk())
    //             .andExpect(content().json(jsonReviewer.write(reviewer).getJson()));
    // }

    private MockHttpServletRequestBuilder post(String string) {
        return null;
    }

    //
    // 5. As a reviewer
    // I can post a review by providing my reviewer ID, a movie ID and my review
    // text. (Review ID should be autogenerated)
    // So that I can share my opinions with others.
    //
    // 6. As a reviewer
    // I can delete a review by providing my reviewer ID and a review ID
    // So that I can remove reviews I no longer wish to share.
    //
    // 7. As a reviewer
    // I can update a review by providing my reviewer ID, a movie ID and my review
    // text.
    // So that I can modify the opinion I'm sharing with others.
    //
    // 8. As an Admin
    // I can add a new movie to the database by providing the data listed in story 1
    // (Movie ID should be autogenerated)
    // so that I can share new movies with the users.
    // 9. As an Admin
    // I can add update the entry for a movie by providing the data listed in Story
    // 1.
    // so that I can correct errors in previously uploaded movie entries.
    //
    // 10. As an admin
    // I can delete a movie by providing a movie ID
    // so that I can remove movies I no longer wish to share.
    //
    // 11. As an admin
    // I can impersonate a reviewer and do any of the things they can do
    // so that I can help confused reviewers.
}
