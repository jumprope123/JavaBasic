package sungjukTest;

import java.util.Scanner;

public class SungJukMain {
    public static void main(String[] args) {
        SungJukService sjsv = new SungJukService();
        Scanner scan = new Scanner(System.in);
        while (true) {
            sjsv.displayMenu();
            String no = scan.nextLine();
            switch (no) {
                case "1" : sjsv.newSungJuk(); break;
                case "2" : sjsv.readSungJuk(); break;
                case "3" : sjsv.readOneSungJuk(); break;
                case "4" : sjsv.modifySungJuk(); break;
                case "5" : sjsv.deleteSungJuk(); break;
                case "0" : System.exit(0); break;
                default:
                    System.out.println("잘못 입력했습니다. 다시 입력하세요");
            }


        }
    }

}
