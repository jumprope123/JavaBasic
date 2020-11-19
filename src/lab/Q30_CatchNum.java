package lab;

import java.util.Scanner;

/*30. 다음 조건에 따라 숫자 맞추기 프로그램을 작성해보세요. (CatchNumber)

        가. 사용자로부터 100 - 999사이의 숫자를 입력 받으세요 (num1)

        나. 변수에 임의의 숫자 3자리를 초기화합니다 (num2)

        다.  num1이 num2보다 크면 “추측한 숫자가 큽니다”라고 출력하세요

        라.  num1이 num2보다 작으면 “추측한 숫자가 작습니다”라고 출력하세요

        마.  num1과 num2가 같으면 “빙고! 숫자를 맞췄습니다”라고 출력하고 종료*/
public class Q30_CatchNum {
    public static void main(String[] args) {
        int num1, num2;
        Scanner scan = new Scanner(System.in);

        System.out.println("100~999사이의 숫자를 입력하세요");
        num1 = scan.nextInt();

        int key_100 = ((int)(Math.random()*9) + 1)*100; // (1~9)*100
        int key_10 = ((int)(Math.random()*10))*10; // (0~9)*10
        int key_1 = ((int)(Math.random()*10)); // (0~9)*1
        num2 = key_100 + key_10 + key_1; //(100~999)

        System.out.printf("num1은 %d num2는 %d입니다\n",num1,num2);
        if (num1>num2){
            System.out.println("추측한 숫자가 큽니다");
        }else if(num1 < num2){
            System.out.println("추측한 숫자가 작습니다");
        }else{
            System.out.println("빙고! 숫자를 맞췄습니다.");
        }

    }
}
