package dev.cristovantamayo.quarkus.microservices.number;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.logging.Logger;

import java.time.Instant;
import java.util.Random;

@Path("/api/numbers")
@Tag(name = "Number REST Endpoint")
public class NumberResource {

    private static final Logger LOG = Logger.getLogger(NumberResource.class);

    @Inject
    Logger logger;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Generate ISBN numbers",
            description = "ISBN 13 and ISBN 10 numbers are generated")
    public IsbnNumbers generateIsbnNumbers() {
        IsbnNumbers numbers = new IsbnNumbers();
        numbers.setIsbn13("13-"+new Random().nextInt(100000000));
        numbers.setIsbn10("10-"+new Random().nextInt(100000));
        numbers.setGenerationDate(Instant.now());
        logger.info("Generated ISBN numbers: "+numbers);
        return numbers;
    }
}