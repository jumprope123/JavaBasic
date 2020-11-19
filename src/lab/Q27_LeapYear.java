package lab;

import java.util.Scanner;

/*27. 다음 조건을 이용해서 현재 연도를 입력하면 윤년 여부를
        출력하는 프로그램을 작성하세요. (LeapYear)

        가. 현재 연도가 4로 나눠 떨어지지만, 100으로는 나눠 떨어지지 않음

        나. 현재 연도가 400으로 나눠 떨어짐

        4로 나눠떨어지면 윤년, 100으로 나눠떨어지면 윤년아님, 그러나 400으로 나눠떨어지면 윤년
        */
public class Q27_LeapYear {
    public static void main(String[] args) {
        boolean LeapYear;
        int thisYear;

        Scanner scan = new Scanner(System.in);
        System.out.println("윤년을 확인하고자 하는 년도를 숫자로 입력하시오. 예) 2020");
        thisYear = scan.nextInt();

        if (thisYear % 4 == 0 && thisYear %100 != 0) {
            LeapYear = true;
        }
        else {
            LeapYear = false;
            if (thisYear %400 == 0){
            LeapYear = true;
            }
        }
        if(LeapYear == true)
        System.out.printf("입력한 %d년은 윤년입니다",thisYear);
        else {
            System.out.printf("입력한 %d년은 윤년이 아닙니다.",thisYear);
        }

    }
}
