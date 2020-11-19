package lab.Q79;

public class Actors {
    private String name;
    private String birth;
    private String[] movies;
    private String part;


    //defalt constuctor
    public Actors() {
    }

    // constructor
    public Actors(String name, String birth, String[] movies, String part) {
        setName(name);
        setBirth(birth);
        setMovies(movies);
        setPart(part);
    }

    //setter
    public void setName(String name) {
        this.name = name;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setMovies(String[] movies) {
        this.movies = movies;
    }

    public void setPart(String part) {
        this.part = part;
    }

    //getter


    public String getName() {
        return name;
    }

    public String getBirth() {
        return birth;
    }

    public String[] getMovies() {
        return movies;
    }

    public String getPart() {
        return part;
    }
}
