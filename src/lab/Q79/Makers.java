package lab.Q79;

public class Makers {
    private String name;
    private String location;
    private String[] makeFilms;

    //default constructor
    public Makers() {
    }

    //constructor
    public Makers(String name, String location, String[] makeFilms) {
        setName(name);
        setLocation(location);
        setMakeFilms(makeFilms);
    }

    //setter
    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setMakeFilms(String[] makeFilms) {
        this.makeFilms = makeFilms;
    }

    //getter
    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String[] getMakeFilms() {
        return makeFilms;
    }
}
