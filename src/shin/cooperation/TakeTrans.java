package shin.cooperation;

public class TakeTrans {
    public static void main(String[] args) {
        Student james = new Student("james",5000);
        Student tomas = new Student("tomas",10000);
        Student edward = new Student("Edward",10000);

        Bus bus = new Bus(100);
        james.takeBus(bus);
        james.showInfo();
        bus.showInfo();

        Subway subway = new Subway("2호선");
        tomas.takeSubway(subway);
        tomas.showInfo();
        subway.showInfo();

        Taxi taxi = new Taxi(1234);
        edward.takeTaxi(taxi);
        edward.showInfo();
        taxi.showInfo();

    }
}
