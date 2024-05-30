export interface Albums {
    album_title: string;
    artist: string;
    release_year: number;
    number_of_songs: number;
    release_image: string;
    _links: {
        self:{
            href: string;
        },
        album:{
            href: string;
        }
    }
}
