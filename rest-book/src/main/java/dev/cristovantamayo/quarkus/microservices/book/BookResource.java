package dev.cristovantamayo.quarkus.microservices.book;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.logging.Logger;

@Path("/api/books")
@Tag(name = "Book REST Endpoint", description = "Create Books")
public class BookResource {

    @Inject
    Logger logger;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Operation(
            summary = "Create a new book",
            description = "Create a new book with the given title, author, year of publication, and genre"
    )
    public Response createBook(
            @FormParam("title") String title,
            @FormParam("author") String author,
            @FormParam("year") int yearOfPublication,
            @FormParam("genre") String genre) {
        Book book = new Book();
        book.isbn13 = "13-123456789";
        book.title = title;
        book.author = author;
        book.yearOfPublication = yearOfPublication;
        book.genre = genre;
        book.creationDate = java.time.Instant.now();

        logger.info("Created book: "+book);
        return Response.status(201).entity(book).build();
    }
}
