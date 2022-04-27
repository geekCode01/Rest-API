package com.api.book.bootapibook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.api.book.bootapibook.entities.Book;
import org.springframework.stereotype.Component;

@Component
public class BookService 
{
    private static List<Book> list=new ArrayList<>();

    static
    {
        list.add(new Book(2,"Python","XYZ"));
        list.add(new Book(3,"C++","MNO"));
        list.add(new Book(4,"JS","QRS"));
    }

    public List<Book> getAllBooks()
    {
        return list;
    }

    public Book getBookById(int id)
    {
        Book book=null;
        book=list.stream().filter(e->e.getId()==id).findFirst().get();
        return book;
    }

    public Book addBook(Book b)
    {
        list.add(b);
        return b;
    }

    //we want to delete that book with given id
    //in that code we are printing that books where book id != id 
    //it automatically remove that book with given id
    public void deleteBook(int id)
    {
        list=list.stream().filter(book->book.getId()!=id).collect(Collectors.toList());
    }

    public void updateBook(Book book,int id)
    {
        list=list.stream().map(b->{
            if(b.getId()==id)
            {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());
    }
}
