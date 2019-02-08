package io.github.alirezamht.book.controller;

import com.fasterxml.jackson.annotation.JsonAlias;
import io.github.alirezamht.book.model.Book;
import io.github.alirezamht.book.model.User;
import io.github.alirezamht.book.service.BookService;
import io.github.alirezamht.book.service.UserService;
import io.github.alirezamht.book.util.ResponseFactory;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class UserController {
   protected RestTemplate restTemplate = new RestTemplate();

}
