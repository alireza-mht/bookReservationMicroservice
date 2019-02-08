package io.github.alirezamht.book.controller;


import io.github.alirezamht.book.model.Book;
import io.github.alirezamht.book.model.User;
import io.github.alirezamht.book.service.BookService;
import io.github.alirezamht.book.util.ResponseFactory;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@ControllerAdvice
@RestController
@RequestMapping("/book")
public class BookController {
    protected RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private BookService bookService;

    @GetMapping(value ="show" , params = {} )
    public @ResponseBody JSONObject showBook(
           HttpServletResponse response) {
       // response.addHeader("Access-Control-Allow-Origin","*");
        try {response.setStatus(HttpStatus.OK.value());
                JSONObject result = new JSONObject();
                ArrayList<Book> books  = bookService.getAllBook();
                for (int i = 0 ; i < books.size();i++){
                    result.put(i,books.get(i).getJson());
                }
               return ResponseFactory.getSuccessResponse(HttpStatus.OK.value()
                       ,result);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value ="deleteBook" )
    public @ResponseBody JSONObject deleteBook( @RequestParam ("bookId") int bookId,
                                                @RequestParam("username") String username ,
                                                @RequestParam("session") String session,HttpServletResponse response){

          //  response.addHeader("Access-Control-Allow-Origin","*");
        String url = "http://localhost:8081/authenticate?" +"username="+username+"&session="+session;
        JSONObject authenticate  = restTemplate.getForObject(url,JSONObject.class);
        if(200 == (Integer) authenticate.get("status")){
            response.setStatus(HttpStatus.OK.value());
            bookService.delete((long) bookId);
        }
        JSONObject result = new JSONObject();
        return ResponseFactory.getSuccessResponse(HttpStatus.OK.value()
                ,result);
    }

    @RequestMapping(value ="addBook" )
    public @ResponseBody JSONObject addBook( @Valid Book book, @RequestParam("username") String username ,
                                             @RequestParam("session") String session,
                                             HttpServletResponse response){

      //  response.addHeader("Access-Control-Allow-Origin","*");
        String url = "http://localhost:8081/authenticate?" +"username="+username+"&session="+session;
        JSONObject authenticate  = restTemplate.getForObject(url,JSONObject.class);
        if(200 == (Integer) authenticate.get("status")){
            response.setStatus(HttpStatus.OK.value());
            bookService.insert(book);
        }
        JSONObject result = new JSONObject();
        return ResponseFactory.getSuccessResponse(HttpStatus.OK.value()
                ,result);
    }

    @RequestMapping(value ="update")
    public @ResponseBody JSONObject updateBook( @Valid Book book,@RequestParam("username") String username ,
                                                @RequestParam("session") String session,
                                                  HttpServletResponse response){

        //response.addHeader("Access-Control-Allow-Origin","*");
        String url = "http://localhost:8081/authenticate?" +"username="+username+"&session="+session;
        JSONObject authenticate  = restTemplate.getForObject(url,JSONObject.class);
        if(200 == (Integer) authenticate.get("status")){
            response.setStatus(HttpStatus.OK.value());
            Book myBook = bookService.getBook(book.getBookId());


           if (myBook!=null) {
               myBook.update(book);
               bookService.update(myBook);
           }
        }
        JSONObject result = new JSONObject();
        return ResponseFactory.getSuccessResponse(HttpStatus.OK.value()
                ,result);
    }


}

