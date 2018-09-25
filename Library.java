package library;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Library implements Runnable{

    private static Object syncObj = new Object();

    public static void main(java.lang.String[] args) {


        Book b1 = new Book("Titanic", 1000);
        Book b2 = new Book("Bible", 1300);
        Book b3 = new Book("Tom Sawyer", 300);

        List<Book> bookList = new ArrayList<>();
        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);

        Human h1 = new Human("Vanek", 2);
        Human h2 = new Human("Bugor", 8);
        Human h3 = new Human("Andrew", 9);
        Human h4 = new Human("Lenka", 8);
        Human h5 = new Human("Vika", 7);
        Human h6 = new Human("Alenka", 6);
        Human h7 = new Human("Ran", 1);

        List<Human> humanList = Stream.of(h1, h2, h3, h4, h5, h6, h7).collect(Collectors.toList());

        Thread t = new Thread(new Library());

        int h = 0;
        int b = 0;
//        for (; h < humanList.size(); h++) {
//            int finalI = h;
//
//            for (; b < bookList.size(); b++) {
//                int finalB = b;
//                t = new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        readIfNotOccupied(humanList.get(finalI), bookList.get(finalB));
//                    }
//                });
//            }
//        }


//        Thread t;
//        t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                ;
//            }
//        }).start();


    }

    public static void readIfNotOccupied(Book book, Human human) {

        if (book.isOccupied()) {
            synchronized (syncObj) {
                try {
                    if (!human.bookName.contains(book.getName())) {
                        human.bookName.add(book.getName());
                    }
                    syncObj.wait(book.getPages() * human.getReadSkill());
                    readIfNotOccupied(book, human);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            book.setOccupied(true);
        }

    }

    public static void saveReadedBook(Human human, Book book) {


    }


    @Override
    public void run() {

    }
}
