package library;

import java.util.*;

public class Library {
    private List<Book> books = new ArrayList<>(); // Для хранения книг мне Лист использовать удобнее всего
    private int nextId = 1;

    public void addBook(String title, String author) {
        books.add(new Book(nextId++, title, author));
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book getBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public boolean deleteBook(int id) {
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getId() == id) {
                books.remove(i);
                return true;
            }
        }
        return false;
    }
}
