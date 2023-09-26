package com.example;

import com.github.loki4j.slf4j.marker.LabelMarker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;
import java.util.UUID;

public class Demo {

    private static final Logger log = LoggerFactory.getLogger(Demo.class);

    public static void main(String[] args) throws InterruptedException {
        log.info("Hello !");
        Thread.sleep(5000);

        // custom contextual marker
        UUID uuid = UUID.randomUUID();
        LabelMarker marker = LabelMarker.of("personId", uuid::toString);
        log.debug(marker, "Log with additional marker !");

        int randInt = new SecureRandom().nextInt(1, 4);
        if (randInt % 3 == 0) {
            log.warn("Random alert");
        }

        log.info("Bye !");
        Thread.sleep(1500);
    }

}
