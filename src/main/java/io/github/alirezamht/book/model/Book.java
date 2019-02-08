package io.github.alirezamht.book.model;


import org.json.simple.JSONObject;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long bookId;
    @Column(nullable = false,updatable = false, name = "name")
    private String name;
    @Column(nullable = false, name = "writer")
    private String writer;
    @Column(nullable = false, name = "year")
    private Long year;
    @Column(nullable = false, name = "print_num")
    private Long printNum;
    @Column(nullable = false, name = "isbn_num")
    private Long isbnNum;
    @Column(nullable = false,name = "inventory")
    private Long inventory;
    @Column(nullable = false, name = "photo")
    private String photo;
    @Column(nullable = false,name = "cutsomer_id")
    private Long customerID;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long iD) {
        this.bookId = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Long getPrintNum() {
        return printNum;
    }

    public void setPrintNum(Long printNum) {
        this.printNum = printNum;
    }

    public Long getIsbnNum() {
        return isbnNum;
    }

    public void setIsbnNum(Long isbnNum) {
        this.isbnNum = isbnNum;
    }

    public Long getInventory() {
        return inventory;
    }

    public void setInventory(Long inventory) {
        this.inventory = inventory;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public Book() {
    }


  public JSONObject getJson(){
      JSONObject object=new JSONObject();
      object.put("ID:" , bookId );
      object.put("name:" , name);
      object.put("writer:" , writer);
      object.put("year:" , year);
      object.put("print number:" , printNum);
      object.put("isbn number:" , isbnNum);
      object.put("inventory:" , inventory);
      object.put("photo:" , photo);
      object.put("customer ID:", customerID);
      return object;
  }

    public void update(@Valid Book book) {
        try {
            if (book.getName()!=null)
                this.name = book.getName();
            if(book.getWriter()!=null)
                this.writer = book.getWriter();
            if(book.getYear()!=null)
                this.year = book.getYear();
            if(book.getPrintNum()!=null)
                this.printNum = book.getPrintNum();
            if(book.getIsbnNum()!=null)
                this.isbnNum = book.getIsbnNum();
            if(book.getInventory()!=null)
                this.inventory = book.getInventory();
            if(book.getPhoto()!=null)
                this.photo = book.getPhoto();
            if(book.getCustomerID()!=null)
                this.customerID = book.getCustomerID();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
