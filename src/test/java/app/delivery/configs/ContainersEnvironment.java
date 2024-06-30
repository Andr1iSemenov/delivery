package app.delivery.configs;

import app.delivery.PostgresTestContainer;
import org.springframework.test.annotation.DirtiesContext;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@Testcontainers
public class ContainersEnvironment {

    @Container
    public static PostgreSQLContainer<?> postgresTestContainer = PostgresTestContainer.getInstance();
}
