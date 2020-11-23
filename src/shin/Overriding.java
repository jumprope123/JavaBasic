package shin;

// 메서드 재 정의 override
// 객체지향 중요 3대 개념중 다형성에 해당
// 상속관계에 있는 상위 클래스의 메서드를
// 하위클래스에서 같은 이름의 메서드로 다시 작성하는 것을 의미
// 즉, 상속받은 메서드를 새로 정의해서 사용하는 것을 말함
public class Overriding {
    public static void main(String[] args) {
        Animal am = new Animal();
        System.out.println(am.cry());
        Cat cat = new Cat();
        System.out.println(cat.cry());
        Dog dog = new Dog();
        System.out.println(dog.cry());
    }

}

//상속관계에 있는 클래스의 멤버변수는 특별하지 않으면 protected로 선언
class Animal {
    protected String cry(){return "동물이 웁니다";}
}

class Cat extends Animal {
    @Override
    protected String cry() {return "야옹~야옹~";}
}

class Dog extends Animal{
    @Override
    protected String cry() {return "멍~멍~";}
}