package lab.movies;

public class MovieMain {
    public static void main(String[] args) {
        String[] genre = {"드라마"};
        String[] director = {"이종필"};
        String[] actors = {"고아성","이솜","박혜수"};
        String summary = "마이드림이즈커리어우먼";
        String desc = "회사랑 맞짱";
        Movie toiecClass = new Movie("삼진그룹 영어토익반","2020",110,"몰라",genre,director,actors,summary,desc);

        System.out.println(toiecClass.getTitle());
        System.out.println(toiecClass.getYear());
        System.out.println(toiecClass.getRuntime());
        System.out.println(toiecClass.getPrdtin());
        System.out.println(toiecClass.getGenre());
        System.out.println(toiecClass.getDirtor());
        System.out.println(toiecClass.getActor());
        System.out.println(toiecClass.getSummary());
        System.out.println(toiecClass.getDesc());
        //참조형 변수이므로 배열의 내용 대신 내용이 저장된 위치가 출력 : 반복문으로 뽑아냄
        for (int i = 0; i<genre.length; i++){
            System.out.println(toiecClass.getGenre()[i]);
        }
    }

}
