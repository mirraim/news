package ru.mirraim.news.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class AuthController {

    @GetMapping("/login")
    public Flux<String> login() {
        return Flux.just("Hello");
    }
}
