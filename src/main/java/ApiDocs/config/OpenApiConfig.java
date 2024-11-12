package ApiDocs.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "User API",
                version = "1.0",
                description = "Documentation for User API testing open API documentation",
                contact = @Contact(
                        name = "Rehan Ashraf",
                        email = "rehan@test.com"
                )
        ),
        servers = {
                @Server(
                        url = "http://localhost:8080",
                        description = "Local server"
                ),
                @Server(
                        url = "http://test.com",
                        description = "Test server"
                )
        }
)
public class OpenApiConfig {
}
