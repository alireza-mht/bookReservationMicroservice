package io.github.alirezamht.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication

public class UserBook {

    public static void main(String[] args){
        SpringApplication.run(UserBook.class, args);


    }

    @GetMapping("/")

    public String root(){
        return "hello";
    }

}
