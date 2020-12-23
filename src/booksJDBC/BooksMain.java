package booksJDBC;

import java.util.Scanner;

public class BooksMain {
    public static void main(String[] args) {
        BooksServices bsv = new BooksServices();
        while (true) {
            Scanner scan = new Scanner(System.in);
            bsv.showMenu();
            String input = scan.nextLine();
            switch (input){
                case "1" : bsv.newBook();break;
                case "2" : bsv.selectBook();break;
                case "3" : bsv.selectOneBook();break;
                case "4" : bsv.modifyBook();break;
                case "5" : bsv.removeBook();break;
                case "0" : System.exit(0);
                default:
                    System.out.println("잘못 입력하셨습니다");
            }

        }
    }
}
