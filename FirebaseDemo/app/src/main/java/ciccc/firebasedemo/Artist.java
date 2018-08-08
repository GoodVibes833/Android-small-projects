package ciccc.firebasedemo;

public class Artist {
    private String id;
    private String name;
    private String genres;


    public Artist() {
    }

    public Artist(String id, String name, String genres) {
        this.id = id;
        this.name = name;
        this.genres = genres;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }
}
