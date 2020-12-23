package booksJDBC;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class BooksServices extends BooksGeneric{
    Scanner scan = new Scanner(System.in);
    public void showMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("-------------------\n")
                .append("도서관리 프로그램 v3\n")
                .append("-------------------\n")
                .append("1. 도서 정보 입력\n")
                .append("2. 도서 정보 조회\n")
                .append("3. 도서 정보 상세조회\n")
                .append("4. 도서 정보 수정\n")
                .append("5. 도서 정보 삭제\n")
                .append("0. 프로그램 종료\n")
                .append("-------------------\n")
                .append("원하시는 작업은 ? ");
        System.out.print(sb);
    }


    public void newBook() {
        System.out.println("도서 번호를 입력하세요");
        int bookid = Integer.parseInt(scan.nextLine());
        System.out.println("도서 이름을 입력하세요");
        String bookname = scan.nextLine();
        System.out.println("출판사 이름을 입력하세요");
        String publisher = scan.nextLine();
        System.out.println("도서 가격을 입력하세요");
        int price = Integer.parseInt(scan.nextLine());
        BooksVO bv = new BooksVO(bookid,bookname,publisher,price);
        String result = BooksDAO.newBook(bv);
        System.out.println(result);
    }

    public void selectBook() {
        StringBuilder sb = new StringBuilder();
        String fmt = "%15s %15s %15s %15s\n";
        ArrayList<BooksVO> bvs = BooksDAO.selectBook();
        Iterator<BooksVO> iter = bvs.iterator();
        while (iter.hasNext()){
            BooksVO bv = iter.next();
            String result = String.format(fmt, bv.bookid, bv.bookname, bv.publisher, bv.price);
            sb.append(result);
        }
        System.out.print(sb);
    }

    public void selectOneBook() {
        System.out.println("조회하실 bookid를 입력해주세요");
        int bookid = Integer.parseInt(scan.nextLine());
        String fmt = "%15s %15s %15s %15s";
        BooksVO bv = null;
        bv = BooksDAO.selectOneBook(bookid);
        String result = String.format(fmt,bv.bookid,bv.bookname,bv.publisher,bv.price);
        System.out.println(result);
    }

    public void modifyBook() {
        System.out.println("수정하실 도서 번호를 입력하세요");
        int bookid = Integer.parseInt(scan.nextLine());
        System.out.println("도서 이름을 입력하세요");
        String bookname = scan.nextLine();
        System.out.println("출판사 이름을 입력하세요");
        String publisher = scan.nextLine();
        System.out.println("도서 가격을 입력하세요");
        int price = Integer.parseInt(scan.nextLine());
        BooksVO bv = new BooksVO(bookid,bookname,publisher,price);
        String result = BooksDAO.modifyBook(bv);
        System.out.println(result);
    }

    public void removeBook() {
        System.out.print("삭제할 북아이디를 입력하세요");
        int inputid = Integer.parseInt(scan.nextLine());
        String result = BooksDAO.removeBook(inputid);
        System.out.println(result);
    }
}
