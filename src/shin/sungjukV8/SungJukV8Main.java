package shin.sungjukV8;

import java.util.Scanner;

/**
 * 파일명 : SungJukV8Main
 * 작성일 : 2020.11.26
 * 성적 처리 프로그램을 체계적으로 만드려고 함
 * 객체지향 기법을 토대로 CRUD기능을 제공하도록 작성
 * 성적 데이터 입력/조회/수정/삭제 메뉴를 제공해서
 * 프로그램의 사용성을 높임
 * 즉, 입력받은 성적데이터는 동적배열에 저장하고
 * 저장된 성적데이터를 조회하거나 수정,삭제할 수 있도록 함.
 *
 * SungJukService : readSungJuk,showSungJuk,
 *                  showOneSungJuk, modifySungJuk,
 *                  removeSungJuk, computeSungJuk
 *                  displayMenu
 *
 */
public class SungJukV8Main {
    public static void main(String[] args) {
        SungJukV8Service sjsrv = new SungJukV8Service();
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
