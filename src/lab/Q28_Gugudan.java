package lab;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
28. 사용자로부터 숫자(1 - 9)를 하나 입력 받아, 구구단을 출력하는 프로그램을
        작성해보세요. 단, 1 - 9 이외의 숫자나 문자를 입력 받으면 “잘못 입력하셨습니다!!”라는 메시지를 출력하도록 합니다. (GuGuDan)
*/
public class Q28_Gugudan {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = 0;

        System.out.println("1에서 9까지 숫자중 하나를 입력하세요");
        try{
        input = scan.nextInt();
        }catch (InputMismatchException e){
        }

        if (input>0 && input <10) {
            for (int i = 1; i <= 9; i++) {
                System.out.printf("%d * %d = %d\n", input, i, input * i);
            }
        }else {
            System.out.println("잘못 입력하셨습니다.");
        }

    }
}
