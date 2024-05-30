package lab5.controllers;

import lab5.album.Album;
import lab5.repositories.albumRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class albumController {
    private final albumRepository repository;

    albumController(albumRepository repository){
        this.repository = repository;
    }

    @GetMapping("/get")
    List<Album> all(){
        return (List<Album>) repository.findAll();
    }

    @PostMapping("/post")
    Album newLanguage(@RequestBody Album newAlbum){
        return repository.save(newAlbum);
    }

    @PutMapping("/put/{id}")
    Album replaceAlbum(@RequestBody Album newAlbum, @PathVariable int id){
        return repository.findById(id)
                .map(album -> {
                    album.setAlbum_title(newAlbum.getAlbum_title());
                    album.setArtist(newAlbum.getArtist());
                    album.setRelease_year(newAlbum.getRelease_year());
                    album.setNumber_of_songs(newAlbum.getNumber_of_songs());
                    album.setRelease_image(newAlbum.getRelease_image());
                    return repository.save(album);
                }).orElseGet(() -> {
                    newAlbum.setId(id);
                    return repository.save(newAlbum);
                });
    }
    @DeleteMapping("/delete/{id}")
    void deleteLanguage(@PathVariable int id){
        repository.deleteById(id);
    }
}