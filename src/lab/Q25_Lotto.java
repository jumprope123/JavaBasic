package lab;

import java.util.Scanner;

/*25. 다음 조건을 만족하는 복권 발행 프로그램을 작성하세요. (Lotto)

        가. 사용자로부터 복권 숫자 3자리를 입력 받으세요 (yourkey)

        나. 변수에 임의의 복권 숫자 3자리를 초기화합니다 (lottokey)

        다. 사용자가 입력한 복권 숫자가 모두 일치 : 상금 1백만 지급

        라. 일치하지 않는 경우 : “아쉽지만, 다음 기회를!” 라고 출력*/
public class Q25_Lotto {
    public static void main(String[] args) {
        int yourkey, lottokey;

        Scanner scan = new Scanner(System.in);
        System.out.println("3자리 숫자를 입력하세요");
        yourkey = scan.nextInt();

        int key_100 = ((int)(Math.random()*9) + 1)*100; // (1~9)*100
        int key_10 = ((int)(Math.random()*10))*10; // (0~9)*10
        int key_1 = ((int)(Math.random()*10)); // (0~9)*1
        lottokey = key_100 + key_10 + key_1; //(100~999)
        System.out.println("당첨넘버는 다음과 같습니다" + lottokey);

        if (yourkey == lottokey){
            System.out.println("축하합니다 상금은 1백만원입니다.");
        }else {
            System.out.println("아쉽지만 다음 기회를!");
        }

    }
}
