package lab5.album;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="favourite")
public class Album {
    @Id
    @GeneratedValue
    int id;
    String album_title;
    String artist;
    int release_year;
    int number_of_songs;
    String release_image;
    protected Album() {}
    public Album(int id, String album_title, String artist, int release_year, int number_of_songs, String release_image) {
        this.id = id;
        this.album_title = album_title;
        this.artist = artist;
        this.release_year = release_year;
        this.number_of_songs = number_of_songs;
        this.release_image = release_image;
    }
}
