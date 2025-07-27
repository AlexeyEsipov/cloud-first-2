package ru.job4j.first.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.first.model.Person;
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

    @PostMapping("/person/{personId}")
    public ResponseEntity<String> createPerson(@PathVariable Long personId, @RequestBody Person person) {
        return new ResponseEntity<>(person.getName(), HttpStatus.OK);
    }

    @GetMapping("/person/exc")
    public ResponseEntity<String> exc() {
        return ResponseEntity.status(400).build();
    }

    @GetMapping("/person/head")
    public ResponseEntity<String> head(@RequestHeader(name = "X-Name-Courses", required = true) String nameCourses) {
        return ResponseEntity.ok(nameCourses);
    }
}
