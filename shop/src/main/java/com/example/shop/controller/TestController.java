package com.example.shop.controller;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile(value = "test")
public class TestController {
    Flyway flyway = Flyway.configure().dataSource("jdbc:h2:mem:~/testdb", "sa", "").load();

    @GetMapping("/la")
    public String send()
    {
        return "ssss2";
    }


    @GetMapping("/t/loaddata")
    public void populate() {
        flyway.migrate();
    }

    @GetMapping("/t/clear")
    public void clear() {
        flyway.clean();
    }
}