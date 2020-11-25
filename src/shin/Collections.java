package shin;

// 제네릭 Generic
// 데이터 유형을 일반화(통일)한다는 것을 의미
// 여러 유형의 데이터를 사용하는 클래스의 경우
// 매개변수의 유형을 object로 선언하는 경우
// 경우에 따라 원래의 유형으로 변환해야하는
// 번거로움이 존재하고 오류가 발생할 수 있는 가능성 존재

import java.util.ArrayList;

public class Collections {
    public static void main(String[] args) {
        // 동물들을 동물원 우리에 가둠
        // 일반적으로 배열은 동일한 유형의
        // 자료들을 저장하는 자료구조
        // 하지만, 배열의 유형을 object로 선언하면
        // 온갖 종류의 데이터들을 저장할 수 있음
        Object[] zoo = new Object[10];
        zoo[0] = new Tiger(); // upcasting적용
        zoo[1] = new Lion();
        zoo[2] = new Zebra();

        // 우리에서 동물을 하나씩 빼냄
        // 하지만, 배열에 저장된 데이터를 빼낼때는
        // 적절한 형 변환이 필요함!

//        Tiger t1 = zoo[0]; // 오류! 타입 불일치
        Tiger t1 = (Tiger)zoo[0]; // downcasting적용
        Lion l1 = (Lion)zoo[1]; // downcasting적용
        Zebra z1 = (Zebra)zoo[2]; // downcasting적용

        // 컬렉션 프레임워크
        // 다수의 데이터를 쉽고 효과적으로
        // 처리할 수 있도록 표준화 방법을 제공하는 클래스
        // 데이터를 저장하는 자료구조와 처리하는
        // 각종 알고리즘을 구조화하여 클래스로 구현한 것
        // 동적배열, 집합, 해시맵, 트리, 큐
        ArrayList zoo2 = new ArrayList();
        // 컬렉션 프레임 워크에서 제공하는 동적 배열
        // 동적 배열의 자료형은 기본적으로 object
        zoo2.add(new Tiger());
        zoo2.add(new Lion());
        zoo2.add(new Zebra());

        /*t1 = zoo.get(0);
        l1 = zoo.get(1);
        z1 = zoo.get(2);*/
        // 동적 배열을 사용했지만
        // 앞의 경우와 동일하게 형 변환시 오류 발생!

        // 제네릭을 이용하면 데이터의 타입을 통일시켜
        // 컴파일시 타입체크 오류 방지와
        // 불필요한 형변환을 없앨수 있음
        // type-parameter (<>)를 이용해서 자료구조의
        // 데이터 유형을 미리 설정해 둠

        ArrayList<Tiger> zoo3 = new ArrayList<>();
        zoo3.add(new Tiger());
        zoo3.add(new Tiger());
        //zoo3.add(new Lion()); //오류 발생

        t1 = zoo3.get(0);
        // 자동으로 형 변환 되기 때문에 오류없이 처리가능

        ArrayList<Lion> zoo4 = new ArrayList<>();

        zoo4.add(new Lion());
        zoo4.add(new Lion());
        zoo4.add(new Lion());

        zoo4.get(0);
        System.out.println(zoo4);
    }
}

class Tiger {}
class Lion {}
class Zebra {}