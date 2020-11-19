package lab;

import java.util.Scanner;

/*26. 사용자가 연봉과 결혼 여부를 입력하면 다음의 세금율에 의해 납부해야
        할 세금을 계산하는 프로그램을 작성하세요 (Tax)

        가. 미혼인 경우 : 연봉 3000미만 - 10%,  연봉 3000이상 - 25%

        나. 결혼한 경우 : 연봉 6000미만 - 15%,  연봉 6000이상 - 35%*/
public class Q26_Salary {
    public static void main(String[] args) {
        int salary;
        int marriage;
        double tax;
        Scanner scan = new Scanner(System.in);
        System.out.println("당신의 연봉을 만단위로 숫자로 입력하세요. 예)연봉 3000만원 -> 3000");
        salary = scan.nextInt();
        System.out.println("당신의 결혼 여부를 입력하세요. 기혼은 1 미혼은 0");
        marriage = scan.nextInt();

        if (marriage == 0){ //미혼일 때
            if (salary < 3000){
                tax = salary * 0.1;
            }else {
                tax = salary * 0.25;
            }
        }else { //기혼일 때
            if (salary < 6000){
                tax = salary * 0.15;
            }else {
                tax = salary * 0.35;
            }
        }
        tax = tax*10000;
        System.out.printf("당신이 납부하실 세금은 %d원 입니다",(int)tax);

    }
}
