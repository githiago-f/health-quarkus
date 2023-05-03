package org.acme.health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Readiness;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Readiness
public class MyReadnessCheck implements HealthCheck {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public HealthCheckResponse call() {
        logger.info("Executando health check");
        HealthCheckResponseBuilder responseBuilder = HealthCheckResponse
            .named("Database connection");
        responseBuilder.up().withData("database", "up");
        return responseBuilder.build();
    }
}
