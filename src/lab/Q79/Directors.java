package lab.Q79;

public class Directors {

    private String name;
    private String birth;
    private String[] DircFilms;
    private String[] movies;

    //default constructor
    public Directors() {
    }

    // constructor


    public Directors(String name, String birth, String[] dircFilms, String[] movies) {
        setName(name);
        setBirth(birth);
        setDircFilms(dircFilms);
        setMovies(movies);
    }

    //setter
    public void setName(String name) {
        this.name = name;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setDircFilms(String[] dircFilms) {
        DircFilms = dircFilms;
    }

    public void setMovies(String[] movies) {
        this.movies = movies;
    }

    //getter
    public String getName() {
        return name;
    }

    public String getBirth() {
        return birth;
    }

    public String[] getDircFilms() {
        return DircFilms;
    }

    public String[] getMovies() {
        return movies;
    }
}
