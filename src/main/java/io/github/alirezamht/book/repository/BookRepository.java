package io.github.alirezamht.book.repository;

import io.github.alirezamht.book.model.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.ArrayList;


@Repository
public interface BookRepository extends CrudRepository<Book, Long>  {

    // Book getBookByID(Long c);
     //Book getBookByID
     ArrayList<Book> getAllBy();

     Book getBooksByBookId(Long bookID);

    @Modifying
    @Query(value ="INSERT INTO book (name, writer, year, print_num, isbn_num, inventory, photo) " +
            "VALUES (:setName, :setWriter , :setYear , :setPrint_num, :setIsbn_num, :setInventory, :setPhoto)"
            , nativeQuery = true)
    @Transactional
    void insert(@Param("setName") String name  ,
                 @Param("setWriter") String writer ,@Param("setYear") Long year,
                 @Param("setPrint_num") Long printNum ,@Param("setIsbn_num") Long isbnNum,
                 @Param("setInventory") Long inventory ,@Param("setPhoto") String photo);


    @Modifying
    @Query("UPDATE Book c SET" +
            " c.name = :name, c.writer = :writer, c.year = :year, " +
            "c.printNum = :print_num, c.isbnNum = :isbn_num, c.inventory = :inventory, c.photo = :photo " +
            "WHERE c.bookId = :book_id")
    void update(@Param("name") String name , @Param("book_id") Long bookId ,
                @Param("writer") String writer ,@Param("year") Long year,
                @Param("print_num") Long printNum ,@Param("isbn_num") Long isbnNum,
                @Param("inventory") Long inventory ,@Param("photo") String photo);




    void deleteByBookId(Long id);

}
