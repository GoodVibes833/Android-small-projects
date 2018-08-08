package ciccc.firebasedemo;

public class Track {
    private String id;
    private String track_name;
    private String artist_name;
    private String track_rating;


    public Track() {
    }

    public Track(String id, String track_name, String artist_name, String rating) {
        this.id = id;
        this.track_name = track_name;
        this.artist_name = artist_name;
        this.track_rating = rating;
    }




    @Override
    public String toString() {
        return track_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTrack_name() {
        return track_name;
    }

    public void setTrack_name(String track_name) {
        this.track_name = track_name;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public String getTrack_rating() {
        return track_rating;
    }

    public void setTrack_rating(String track_rating) {
        this.track_rating = track_rating;
    }
}
