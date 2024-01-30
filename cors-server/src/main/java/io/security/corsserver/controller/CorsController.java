package io.security.corsserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CorsController {

    @GetMapping("/users")
    public User user() {
        return new User("taetae", 33);
    }
}
