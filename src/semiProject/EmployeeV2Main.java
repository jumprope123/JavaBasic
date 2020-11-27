package semiProject;

import java.io.IOException;
import java.util.Scanner;

/**
 * EmployeeV2Main
 * 파일에 실제로 저장하는
 * 인사정보 관리 프로그램 시작점
 */
public class EmployeeV2Main {
    public static void main(String[] args) throws IOException {
        EmployeeV2Service empsrv = new EmployeeV2Service();
        Scanner sc = new Scanner(System.in);
        String menu;

        while (true) {
            empsrv.displayMenu();
            menu = sc.nextLine();

            switch (menu){
                case "1" : empsrv.newEmployee(); break;
                case "2" : empsrv.readEmployee(); break;
                case "3" : empsrv.readOneEmployee(); break;
                case "4" :  empsrv.modifyEmployee();break;
                case "5" : empsrv.removeEmployee(); break;
                case "0" : {empsrv.outWriteEmployee();System.exit(0); break;}
                default:
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
            }
        }
    }
}
