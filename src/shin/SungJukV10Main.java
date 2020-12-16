package shin;

import shin.sungjukV8.SungJukV9Service;

import java.util.Scanner;

/**
 * 파일명 : SungJukV10Main
 * 작성일 : 2020.12-16
 * 성적 처리 프로그램에 저장기능을 추가함
 * 즉, mariadb 데이터베이스에 sungjuk 테이블을 생성해서
 * 입력한 성적데이터를 여기에 저장해둠
 *
 */
public class SungJukV10Main {
    public static void main(String[] args) {
        SungJukV10Service sjsrv = new SungJukV10Service();
        Scanner scan = new Scanner(System.in);
        String menu = "";
        while (true) { // 메뉴 번호 띄우고 작업번호 입력 반복
            sjsrv.displayMenu();
            menu = scan.nextLine();
            switch (menu){
                case "1" : sjsrv.newSungJuk(); break;
                case "2" : sjsrv.readSungJuk(); break;
                case "3" : sjsrv.readOneSungJuk(); break;
                case "4" : break;
                case "5" : break;
                case "0" : System.exit(0); break;
                default:
                    System.out.println("잘못 입력함");
            }

        }
    }
}
