package library;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean exit = true;
        Library library = new Library();

        System.out.println("""
                Добро пожаловать в Удивительную Цифровую Библиотеку
                Введите ключевое слово для одного из следующих действий:
                Add - Добавить книгу в систему
                GetAll - Получить каталог книг
                GetById - Получить книгу по уникальному идентификатору
                Delete - Удалить книгу по уникальному идентификатору
                Exit - Выйти из системы""");
        String keyword =  input.nextLine();

        while (
                !keyword.equals("Add") &&
                !keyword.equals("GetAll") &&
                !keyword.equals("GetById") &&
                !keyword.equals("Delete") &&
                !keyword.equals("Exit")
        ) {
            System.out.println("""
                    Введено неверное ключевое слово:
                    Введите ключевое слово для одного из следующих действий:
                    Add - Добавить книгу в систему
                    GetAll - Получить каталог книг
                    GetById - Получить книгу по уникальному идентификатору
                    Delete - Удалить книгу по уникальному идентификатору
                    Exit - Выйти из системы""");
            keyword =  input.nextLine();
        }

        String title;
        String author;
        int id;

        while (exit) {
            switch (keyword) {
                case "Add":
                    System.out.print("Введите название книги: ");
                    title = input.nextLine();
                    System.out.print("Введите автора книги: ");
                    author = input.nextLine();

                    library.addBook(title, author);
                    System.out.print("Введите любую клавишу чтобы продолжить:");
                    input.nextLine();
                    break;
                case "GetById":
                    System.out.print("Введите уникальный идентификатор (id) книги: ");
                    id = Integer.parseInt(input.nextLine());

                    if (library.getBookById(id) == null){
                        System.out.println("Книги по указанному уникальному идентификатору не существует: ");
                    }else{
                        System.out.printf("""
                                Информация по вашей книге:
                                Id - %d
                                Автор - %s
                                Название - %s\n""", id, library.getBookById(id).getAuthor(), library.getBookById(id).getTitle());
                    }

                    System.out.print("Введите любую клавишу чтобы продолжить:");
                    input.nextLine();
                    break;
                case "GetAll":
                    System.out.println("Каталог всех книг: ");
                    for (Book book : library.getAllBooks()) {
                        System.out.printf("""
                                Информация по вашей книге:
                                Id - %d
                                Автор - %s
                                Название - %s\n""", book.getId(), book.getAuthor(), book.getTitle());
                    }
                    System.out.println("Конец каталога.");

                    System.out.print("Введите любую клавишу чтобы продолжить:");
                    input.nextLine();
                    break;
                case "Delete":
                    System.out.print("Введите уникальный идентификатор (id) книги: ");
                    id = Integer.parseInt(input.nextLine());

                    if (!library.deleteBook(id)){
                        System.out.println("Книги по указанному уникальному идентификатору не существует: ");
                    }else{
                        System.out.println("Книга по указанному уникальному идентификатору была успешно удалена: ");
                    }
                    System.out.print("Введите любую клавишу чтобы продолжить:");
                    input.nextLine();
                    break;
                case "Exit":
                    System.out.println("Спасибо что воспользовались Удивительной Цифровой Библиотекой");
                    exit = false;
                    System.out.print("Введите любую клавишу чтобы продолжить:");
                    input.nextLine();
                    break;
                default:
                    continue;
            }

            if(exit){
                continue;
            }else {
                System.out.println("""
                        Введите ключевое слово для одного из следующих действий:
                        Add - Добавить книгу в систему
                        GetAll - Получить каталог книг
                        GetById - Получить книгу по уникальному идентификатору
                        Delete - Удалить книгу по уникальному идентификатору
                        Exit - Выйти из системы""");
                keyword = input.nextLine();
            }
        }
    }
}