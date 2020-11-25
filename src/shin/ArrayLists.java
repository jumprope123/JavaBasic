package shin;

//ArrayLists
//동적 배열의 한 종류
// List 인터페이스를 구현해서 만든 컬렉션 프레임 워크
// 요소의 저장순서가 유지
// 중복으로 데이터를 저장할 수 있음
// 크기가 늘어나면 새로운 배열을 생성하고
// 기존의 요소들을 옮겨야 하는 복잡한 과정이 동반됨

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayLists {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();

        names.add("혜교"); // 데이터 추가
        names.add("지현");
        names.add("수지");

        System.out.println(names);
        //특정 위치에 데이터 추가 : add(위치,대상)
        names.add(1,"한팀장");

        // 요소 수정 : set(위치, 대상)
        names.set(0,"남산");


        // 요소 추출 : get(위치)
        System.out.println(names.get(1));

        //요소 삭제 : remove(위치)
        names.remove(2);

        // 컬렉션 자료구조에 저장된 데이터를
        // 출력하려면 foreach 구문 사용
        for (String name : names) {
            System.out.println(name);
        }
        //요소 모두 삭제 : clear()

        // 데이터 검색하기
        // 배열에서 원하는 데이터를 찾는 방법은 두가지
        // 위치로 찾음 : get(위치)
        // 실제값으로 찾음 : contains, indexOf
        String[] game = {"바람의나라","리그오브레전드","스타크래프트"};
//        ArrayList<String> games = (ArrayList<String>) Arrays.asList(game);
//         ↑ 문법적으로는 문제가 없지만 실행하면 다운캐스팅 오류 발생.
        List<String> games = Arrays.asList(game); //리스트가 부모, 어레이리스트가 자식
        //일반 배열을 동적 배열로 변환하려면 Arrays 클래스의 asList메서드를 사용함
        System.out.println(games);

        // games 동적 배열에서 '스타크래프트'를 찾아봄
        // 전체를 훑어가며 대상을 찾기 때문에 성능이 나쁨
        for (int i = 0 ; i <games.size(); i++){
            if (games.get(i).equals("리그오브레전드")) {
                System.out.println((i+1)+"번 째에서 찾음");
                break;
            }
        }
        int cnt = 1;
        for (String g : games) {
            if (g.equals("스타크래프트")){
                System.out.println("데이터 찾음"+cnt);
            }
            cnt++;
        }

        if(games.contains("리그오브레전드")){
            System.out.println("있음");
        }

        System.out.println(games.indexOf("리그오브레전드"));

    // 게임정보에 대한 객체 생성
        GameInfo g1 = new GameInfo("디아블로",35000);
        GameInfo g2 = new GameInfo("스타크래프트",35000);
        GameInfo g3 = new GameInfo("워크래프트",35000);

        //동적 배열에 객체들 저장
        List<GameInfo> gameinfo = new ArrayList<>();
        gameinfo.add(g1);
        gameinfo.add(g2);
        gameinfo.add(g3);

        //"스타크래프트" 요소를 출력
        // ArrayList의 타입은 gameInfo의 객체이므로 .name으로 뽑아내야함
        // 따라서, 대상.변수명 또는 대상.getter를 이용해야함
        System.out.println(gameinfo.get(1).name);

        //특정 요소를 검색하는 코드를 4가지 버전으로 작성
        // for문, forech , contains, indexOf

        //for문
        for(int i = 0; i<gameinfo.size(); i++){
            if (gameinfo.get(i).name.equals("스타크래프트")){
                System.out.println((i+1)+"번째에서 스타크래프트 발견");
            }
        }
        //향상된 for문
        for(GameInfo game1 : gameinfo) {
            if (game1.name.equals("스타크래프트")){
                System.out.println("스타크래프트가 있습니다");
            }
        }
        //contains
        for(int i = 0; i<gameinfo.size(); i++) {
            if(gameinfo.get(i).name.contains("스타크래프트")){
                System.out.println("스타크래프트가 있습니다");
            }
        }
        //indexOf
        for(int i = 0; i<gameinfo.size(); i++) {
           if (gameinfo.get(i).name.indexOf("스타크래프트")==0) {
               System.out.println(gameinfo.get(i).name.indexOf("스타크래프트") + (i + 1) + "번째 객체에 스타크래프트가 있습니다");
           }
        }


    }
}

class GameInfo {
    String name;
    int price;

    public GameInfo(String name, int price) {
        this.name = name;
        this.price = price;
    }


}
