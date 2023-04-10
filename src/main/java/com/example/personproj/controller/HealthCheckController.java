package com.example.personproj.controller;


import com.example.personproj.model.DetailedHealthCheck;
import com.example.personproj.model.HealthCheck;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/v1")
public class HealthCheckController {


    @GetMapping(value = "/healthcheck", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getHealthCheck(@RequestParam(value = "format", defaultValue = "short") String format) {
        if (!format.equals("short") && !format.equals("full")) {
            return ResponseEntity.badRequest().body("Invalid format parameter value");
        }

        if (!format.equals("full")) {
            HealthCheck healthCheck = new HealthCheck("OK");
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(healthCheck);
        } else {

            LocalDateTime currentTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
            String formattedTime = formatter.format(currentTime);
            DetailedHealthCheck detailedHealthCheck = new DetailedHealthCheck(formattedTime, "OK");
            System.out.println("detailedHealthCheck: "+detailedHealthCheck);
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(detailedHealthCheck);
        }
    }

    @GetMapping(value = "/badrequest", produces = MediaType.APPLICATION_JSON_VALUE, params = "format")
    public ResponseEntity<?> getBadRequest() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or missing format parameter");
    }

    @GetMapping(value = "/onlygetmethod", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getMethodNotAllowed() {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("Only GET method is allowed");
    }
}
