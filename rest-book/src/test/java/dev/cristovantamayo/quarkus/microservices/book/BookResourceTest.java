package dev.cristovantamayo.quarkus.microservices.book;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;

@QuarkusTest
class BookResourceTest {
    @Test
    void shouldCreateABookTest() {
        given()
                .formParam("title", "The Hobbit")
                .formParam("author", "J.R.R. Tolkien")
                .formParam("year", 1937)
                .formParam("genre", "Fantasy")
          .when().post("/api/books")
          .then()
             .statusCode(201)
             .body("isbn_13", startsWith("13-"))
             .body("title", is("The Hobbit"))
             .body("author", is("J.R.R. Tolkien"))
             .body("year-of-publication", is(1937))
             .body("genre", is("Fantasy"))
             .body("creation-date", startsWith("20"));

    }

}