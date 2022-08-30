package com.some.demo.controller;

import com.some.demo.model.SomeRequest;
import com.some.demo.service.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1")
public class SomeController {
    @Autowired
    SomeService service;


    @PostMapping("/some")
    public ResponseEntity<String> doSome(final @RequestBody @Valid SomeRequest request) {
        service.register(request);
        return ResponseEntity.ok("OK");
    }
}
