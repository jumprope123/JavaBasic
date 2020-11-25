package shin;

import java.util.Scanner;

// 문자열 처리시 유용한 기능을 제공하는 메서드
//
public class Strings2 {
    public static void main(String[] args) {
        String str = "Hello, World!!";
        // 문자열 검색
        // indexOf : 지정한 문자 찾기
        // 문자열 길이 : length
        int idx = str.indexOf('W');
        System.out.println(idx);
        idx = str.indexOf('?');
        System.out.println(idx);
        idx = str.indexOf("World");
        System.out.println(idx);
        System.out.println(str.length());
        // lastIndexOf(문자) : 지정한 문자 찾기 , 위치값 출력
        str = "Hello, Hi, Noon";
        idx = str.lastIndexOf("Noon");
        System.out.println(idx);

        // 문자 바꾸기 : replace
        // replace (찾을 문자열, 바꿀문자열)
        str = "A*B*C*D";
        String idxx = str.replace("*","-");
        System.out.println(idxx);

        // 문자열 분리 : split
        // 지정한 문자를 기준으로 문자열을 나눠 배열에 저장
        //split(구분자)
        str = "201350050,김태희,경기도,1985.3.22,컴퓨터,504";
        String[] result = str.split(",");
        /*for (int i = 0; i<result.length; i++){
            System.out.println(result[i]);
        }*/

        // 향상된 for문을 사용하면 배열을 쉽게 다룰 수 있음
        for(String data : result) {
           System.out.println(data);
       }

        // 문자열 추출 : substring
        // substring(시작위치, 끝위치-1)
        str = "Hello, World!!";
        String word = str.substring(7,12);
        System.out.println(word);

        // ex) 주민번호에서 성별 체크하는 코드 작성
        //123456-7891235 , 987456-4567890
        // 1,2 : 2000 년 이전 남녀
        // 3,4 : 2000 년 이후 남녀

        while (true){
        System.out.println("주민등록번호를 입력하세요 ex)987456-4567890 , 99를 입력하면 종료");
        Scanner scan = new Scanner(System.in);
        String PeopleNum = scan.nextLine();
        if (PeopleNum.equals("99")) break;
        String genderNumString;
       try{genderNumString = PeopleNum.substring(7,8);}
       catch (Exception e){
           System.out.println("잘못 입력했습니다 다시 입력하세요");
           genderNumString = "5";
       }

        if(genderNumString.equals("1") ){
            System.out.println("2000년 이전 남자입니다");
        }else if(genderNumString.equals("2")) {
            System.out.println("2000년 이전 여자입니다");
        }else if(genderNumString.equals("3")){
            System.out.println("2000년 이후 남자입니다");
        }else if(genderNumString.equals("4")) {
            System.out.println("2000년 이후 여자입니다");
        }else {
            System.out.println("잘못 입력했습니다 다시 입력하세요");
        }
        }

    // 지정한 위치의 문자 추출 : charAt(인트값)
        str = "123456-1234567";
        System.out.println(str.charAt(7));

        // 정규표현식에 따라 일치여부 확인 : matches
        // 정규식 사용가능 메서드 : split, replaceAll
        int num = 1234567;
        String str1 = String.format("%d",num);
        String str2 = "1234567";
        System.out.println(str1.matches(str2));

        str1 = String.format("%,d",num);
        System.out.println(str1.matches(str2));
        System.out.println(str1);

        System.out.println(str1.matches("[a-z].+"));
        System.out.println(str1.matches("[0-9].*"));

        //정규 표현식
        // 특정한 규칙을 가진 문자열의 집합을 표현하기 위해 사용하는 형식언어
//        [] : 문자집합이나 두 문자 사이의 범위를 나타냄 , -는 두 문자 사이 범위 표현
//        [0-9] : 숫자집합 = ([0123456789])
//        [a-zA-Z] : 영문자 집합
//        [가-힣] : 한글 집합
//        * : 0개 무한개의 임의의 문자 반복
//        ab* : ab, aba, ab1, abaa...
//        + : 1개 이상 무한개의 임의의 문자 반복
//        ab+ : aba, ab1, abA , abaa...
//        ? : 0개 또는 1개의 임의의 문자 반복
//        ab? : ab, aba , abb ... ab0, abZ , abz
//        {n,m} : 최소 n개 이상 최대 m개 이하 반복
//        [0-9]{3,4} : 0~9까지중의 숫자가 3번또는 4번반복
//        ^ : 문자열 시작
//        ^123 : 123으로 시작하는 문자열
//        $ : 문자열 끝
//        123$ : 123으로 끝나는 문자열
//        . : 임의의 문자를 의미
//        .{3,} : 문자의 최소길이는 3이상
//        1234567890
//        abcdefghijklmnopqrstuvwxyz
//        가나다라마바사아자차카타파하

//        다음 문자열이 전화번호형식에 맞게 작성되었는지
//        알아보는 정규식을 작성하세요
//        010-123-4567, 011-1234-5678
        String phone1 ="010-123-4567";
        String phone2 = "011-1234-5678";
        String pattern = "[0-9]{3}-[0-9]{3,4}-[0-9]{4}";
        System.out.println(phone1.matches(pattern));
        System.out.println(phone2.matches(pattern));


//        ex) 사용자 아이디가 다음 규칙에 적합하게 작성되었는지 확인
//        영문자 소문자 하나, 대문자 하나, 숫자 , 특수기호
//        abc123!XYZ, 123jkl
        String pattern2 = "[a-zA-Z0-9!]+";

        String uid ="abc123!XYZ";
        System.out.println(uid.matches(pattern2));
        uid = "123jkl";
        System.out.println(uid.matches(pattern2));

//        첫글자는 영 소/대문자
//        두번째는 영문자,숫자,특수기호 등이 포함
//        최소 길이는 6 ~ 18자
        String pattern3 = "^[a-zA-Z]{1}[a-zA-Z0-9!@#$%^&*]{5,17}";
        uid = "Adsl!23";
        System.out.println(uid.matches(pattern3));


    }
}
