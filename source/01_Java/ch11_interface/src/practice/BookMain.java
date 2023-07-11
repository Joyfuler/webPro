package practice;

import java.awt.print.Book;
import java.util.Scanner;

public class BookMain {
    public static void main(String[] args) {
        BookLib[] books = {new BookLib("890?-101-1?±", "java", "?κΈΈλ"),
                new BookLib("110?±-111-1?±", "dbms", "? κΈΈλ"),
                new BookLib("110?-123-2?", "web", "? κΈΈλ"),
                new BookLib("770?-123-2?", "jsp", "κ³ κΈΈ?"),
                new BookLib("110?-123-2?", "spring", "κΉ?κΈΈλ")};

        int inputNum;
        int idx;
        String bookTitle, borrower, checkOutDate;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("?€??κ³? ?Ά?? κΈ°λ₯? ? ??΄μ£ΌμΈ?. 1 - ??μΆ? | 2 - λ°λ© | 3 - μ±? listμ‘°ν | 0 - μ’λ£");
            inputNum = scanner.nextInt();
            switch (inputNum) {
                case 1: // ??μΆ?
                    System.out.println("??μΆνκ³? ?Ά?? μ±? ?΄λ¦μ ?? ₯?΄μ£ΌμΈ?.");
                    bookTitle = scanner.next();
                    for (idx = 0; idx <= books.length; idx++) {
                        if (bookTitle.equals(books[idx].getBookTitle())) {
                            break;
                        }
                    }
                    if (idx == books.length) {
                        System.out.println("??¬ λ³΄μ ?μ§? ??? ?????€.");

                    } else {
                        if (books[idx].getState() == BookLib.STATE_BORROWED) {
                            System.out.println("?΄λ―? ??μΆμ€?Έ ?????€.");
                        } else {
                            System.out.println("??μΆν?? λΆμ ?±?¨? ?? ₯?΄μ£ΌμΈ?.");
                            borrower = scanner.next();
                            System.out.println("??μΆν? ?Ό?λ₯? ? ?΄μ£ΌμΈ?.");
                            checkOutDate = scanner.next();
                            books[idx].checkOut(borrower, checkOutDate);

                        }
                    }
                    break;
                case 2:
                    System.out.println("λ°λ©?? €? ?? ?΄λ¦μ ?? ₯?΄μ£ΌμΈ?.");
                    bookTitle = scanner.next();
                    for (idx = 0; idx < books.length; idx++) {
                        if (bookTitle.equals(books[idx].getBookTitle())) {
                            break;
                        }
                    }
                    if (idx == books.length) {
                        System.out.println("?μ²???  ??? ? λ³΄κ? ??΅??€.");
                    } else {
                        books[idx].checkIn();
                    }
                    break;
                case 3:
                    System.out.println("??κ΄?? μ±? λ¦¬μ€?Έ? ???? κ°μ΅??€.");
                    for (int i = 0; i < books.length; i++) {
                        books[i].printState();
                    }
                    break;
            }
        } while (inputNum != 0) ;
        System.out.println("?΄?©?΄ μ£Όμ? κ°μ¬?©??€.");
        scanner.close();
        }

    }



