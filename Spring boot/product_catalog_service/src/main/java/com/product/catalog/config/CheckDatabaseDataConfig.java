package com.product.catalog.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class CheckDatabaseDataConfig {

    private final DatabaseDataChecker databaseDataChecker;

    public CheckDatabaseDataConfig(DatabaseDataChecker databaseDataChecker) {
        this.databaseDataChecker = databaseDataChecker;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void checkDbDataPresentOrNot() {
        databaseDataChecker.executeStart();
    }
}
