package com.example.BookingDemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoController {

        @RequestMapping("/welcome")
        public String welcome() {
            return " :) Welcome to Cameron's Captures";
        }
    }

