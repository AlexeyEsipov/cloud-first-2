package ru.job4j.first.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.first.service.FirstService;

@RestController
@RequestMapping("/one")
public class FirstController {
    private static final Logger log = LoggerFactory.getLogger(FirstController.class);

    private final FirstService firstService;

    public FirstController(FirstService firstService) {
        this.firstService = firstService;
    }

    @GetMapping("/test")
    public ResponseEntity<HttpStatus> test() {
        log.info("вызов метода test");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/hi")
    public ResponseEntity<String> sayHello() {
        log.info("вызов метода hi");
        return new ResponseEntity<>(firstService.getWord(), HttpStatus.OK);
    }
}
