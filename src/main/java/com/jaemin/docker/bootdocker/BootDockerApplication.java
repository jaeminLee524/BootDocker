package com.jaemin.docker.bootdocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@SpringBootApplication
public class BootDockerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootDockerApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void applicationReadyEventHandler() {
        System.out.println(ZonedDateTime.now() + "Server is Ready!!!");
    }

    static class ResponseMessage {
        private final String message;
        private final LocalDateTime responseDate;

        public ResponseMessage(String message, LocalDateTime responseDate) {
            this.message = message;
            this.responseDate = responseDate;
        }

        public String getMessage() {
            return message;
        }

        public LocalDateTime getResponseDate() {
            return responseDate;
        }
    }

    @RestController
    static class IndexController {

        @GetMapping("/")
        public ResponseEntity<ResponseMessage> indexEcho() {
            return ResponseEntity.ok(new ResponseMessage("index page", LocalDateTime.now()));
        }
    }


    @RestController
    static class HiController {
        @GetMapping("/{message}")
        public ResponseEntity<ResponseMessage> messageEcho(@PathVariable("message") String message) {
            return ResponseEntity.ok(new ResponseMessage(message, LocalDateTime.now()));
        }
    }
}
