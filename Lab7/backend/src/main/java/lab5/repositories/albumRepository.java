package lab5.repositories;

import lab5.album.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource//(path = "favourite", collectionResourceRel = "favourite")
@CrossOrigin(origins = "*")
public interface albumRepository extends JpaRepository<Album, Integer> {
    List<Album> findByArtist(@Param("artist") String artist);
}
