package com.xiaor.common_use_class.homework;

import java.util.*;

public class ListExercise {

    public static void main(String[] args) {

        List array = new ArrayList();
        array.add(new Book("红楼梦", "曹雪芹", 100));
        array.add(new Book("西游记", "吴承恩", 90));
        array.add(new Book("水浒传", "施耐庵", 120));
        array.add(new Book("三国演义", "罗贯中", 150));

        // 按照价格从低到高排序
        Collections.sort(array, new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                if (book1.getPrice() > book2.getPrice()) {
                    return 1;
                }
                return -1;
            }
        });

        for (Object o : array) {
            System.out.println(o);
        }
    }
}

class Book {
    private String title;
    private double price;
    private String author;

    Book(String title,  String author, double price) {
        this.title = title;
        this.price = price;
        this.author = author;
    }


    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                '}';
    }
}
