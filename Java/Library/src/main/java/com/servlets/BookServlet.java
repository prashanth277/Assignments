package com.servlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.model.Book;
import com.service.BookService;
import com.service.InMemoryBookService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends HttpServlet {
    private static final Gson GSON = new GsonBuilder().create();
    private static BookService bookService = new InMemoryBookService();

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        if(req.getPathInfo() == null){
            List<Book> bookList = bookService.getBooks();
            res.setStatus(200);
            res.setHeader("Content-Type","application/json");
            res.getOutputStream().println(GSON.toJson(bookList));
        } else{
            int bookId = Integer.parseInt(req.getPathInfo().replace("/" ,""));
            Book book = bookService.getBookById(bookId);
            if(book != null){
                res.setStatus(200);
                res.setHeader("Content-Type","application/json");
                res.getOutputStream().println(GSON.toJson(book));
            }else{
                res.setStatus(404);
            }
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Book book =GSON.fromJson(req.getReader(),Book.class);
        bookService.createBook(book);

        res.setStatus(201);
        res.setHeader("Content-Type","application/json");
        res.getOutputStream().println(GSON.toJson(book));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        Book book =GSON.fromJson(req.getReader(),Book.class);
        bookService.updateBook(book);

        res.setStatus(201);
        res.setHeader("Content-Type","application/json");
        res.getOutputStream().println(GSON.toJson(book));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Book book =GSON.fromJson(req.getReader(),Book.class);
        bookService.deleteBook(book);

        res.setStatus(200);
        res.setHeader("Content-Type","application/json");
        res.getOutputStream().println(GSON.toJson(book));

    }
}
