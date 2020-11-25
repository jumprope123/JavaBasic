package shin;

import java.util.Scanner;

/**
 * 로그인 확인 프로그램
 * 0. 인증용 아이디와 비밀번호를 하나 생성해둠
 * => abc123, 987xyz
 * 1. Scanner로 아이디,비밀번호를 입력받음
 * 2a. 아이디와 비밀번호가 틀리면 "가입되지 않은 아이디!"
 * 2b. 아이디만 맞으면 "비밀번호가 틀렸음!"
 * 2c. 아이디와 비밀번호가 맞으면 "로그인 성공!"
*/
public class LogInMe {
    public static void main(String[] args) {

        String id = "abc123";
        String pw = "987xyz";
        String inputId;
        String inputPw;

        while(true){
            Scanner scan = new Scanner(System.in);
            System.out.print("아이디를 입력하세요");
            inputId = scan.nextLine();
            System.out.print("비밀번호를 입력하세요");
            inputPw = scan.nextLine();

        if (inputId.equals(id) && inputPw.equals(pw)){
            System.out.println("로그인 성공!");
            break;
        }else if(inputId.equals(id)){
            System.out.println("비밀번호가 틀렸음!");
        }else {
            System.out.println("가입되지 않은 아이디!");
            }
        }
    }
}