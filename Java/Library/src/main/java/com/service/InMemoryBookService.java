package com.service;

import com.model.Book;

import java.util.ArrayList;
import java.util.List;

public class InMemoryBookService implements BookService{
    private  List<Book> booksList = new ArrayList<>();
    @Override
    public List<Book> getBooks() {

        return  booksList;
    }

    @Override
    public Book getBookById(int bookId) {
        for(int i = 0; i<booksList.size();i++){
            if(bookId == booksList.get(i).getBookId() ){
                return booksList.get(i);
            }
        }
        return null;
    }

    @Override
    public Book createBook(Book book) {

        booksList.add(book);
        return book;
    }

    @Override
    public Book deleteBook(Book book) {
        for(Book i: booksList){
            if(i.getBookId() == book.getBookId()){
                booksList.remove(i);
            }
        }
        return book;
    }

    @Override
    public Book updateBook(Book book) {
        int n = 0;
        int x = book.getBookId();
        String name = book.getBookName();
        for(int j = 0;j<booksList.size();j++){
            if(x == booksList.get(j).getBookId()){
                 n = j;
            }
        }
        for(int i =0; i<booksList.size(); i++) {
            if(i == n){
                booksList.get(i).setBookId(x);
                booksList.get(i).setBookName(name);
            }
        }
        //
        booksList.set(n,book);
        return book;
    }

}
