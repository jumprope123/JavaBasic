package lab.movies;

public class Actor {
    //멤버변수
    private String name;
    private String birth;
    private String[] joinMovie;
    private String[] casting;

    //생성자
    public Actor() {
    }

    public Actor(String name, String birth, String[] joinMovie, String[] casting) {
        this.name = name;
        this.birth = birth;
        this.joinMovie = joinMovie;
        this.casting = casting;
    }

    //setter/getter


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String[] getJoinMovie() {
        return joinMovie;
    }

    public void setJoinMovie(String[] joinMovie) {
        this.joinMovie = joinMovie;
    }

    public String[] getCasting() {
        return casting;
    }

    public void setCasting(String[] casting) {
        this.casting = casting;
    }
}
