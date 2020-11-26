package semiProject;

import java.util.Scanner;

public class EmployeeV1Main {
    public static void main(String[] args) {
        EmployeeV1Service esvs = new EmployeeV1Service();
        Scanner scan = new Scanner(System.in);
        String menuNum;

        while (true) {
            esvs.displayMenu();
            menuNum = scan.nextLine();

            switch (menuNum){
                case "1" : esvs.newPInfo(); break;
                case "2" : esvs.readPInfo(); break;
                case "3" : esvs.readOnePInfo(); break;
                case "4" : esvs.modifyPInfo(); break;
                case "5" : esvs.removePInfo(); break;
                case "0" : System.exit(0); break;
                default:
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
            }
        }
    }
}
