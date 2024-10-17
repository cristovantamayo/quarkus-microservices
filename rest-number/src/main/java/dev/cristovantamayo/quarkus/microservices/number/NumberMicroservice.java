package dev.cristovantamayo.quarkus.microservices.number;


import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.ExternalDocumentation;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@ApplicationPath("/")
@OpenAPIDefinition(info = @Info(
        title = "Number Microservice",
        description = "Request ISBN numbers for Books",
        contact = @Contact(
                name = "Cristovan Tamayo",
                email = "cristovan.tamayo@gmail.com",
                url = "cristovantamayo.dev"),
        version = "1.0"),
        externalDocs = @ExternalDocumentation(
                description = "Quarkus Microservices",
                url = "https://github.com/cristovantamayo/quarkus-microservices"),
        tags = {@Tag(name = "Number REST Endpoint", description = "Generate ISBN numbers")})
public class NumberMicroservice  extends Application {
    public static void main(String[] args) {
        System.out.println("Hello from Quarkus Number Microservice");
    }
}
