import java.util.List;
import java.util.Objects;

class MusicCollection {
    public static void main(String[] args) {
        List<Song> songs = List.of(
                new Song("Nothing Else Matters", 386, "Metallica", Song.Genre.METAL),
                new Song("No One", 248, "Alicia Keys", Song.Genre.POP),
                new Song("Nothing Else Matters", 386, "Metallica", Song.Genre.METAL),
                new Song("Believer", 216, "Imagine Dragons", Song.Genre.ROCK),
                new Song("Fear of The Dark", 438, "Iron Maiden", Song.Genre.METAL),
                new Song("Enter Sandman", 346, "Metallica", Song.Genre.METAL),
                new Song("The Unforgiven", 348, "Metallica", Song.Genre.METAL),
                new Song("Girl on Fire", 404, "Alicia Keys", Song.Genre.POP)
        );
        Song.Genre inputGenre = Song.Genre.METAL;
        String authorName = "Metallica";
        System.out.println("Łączny czas piosenek "+ inputGenre +" na playliscie (w sekundach) "+ totalTimeLenght(songs, inputGenre) );
        System.out.println("Łączna liczba piosenek "+authorName+" na playliscie : " +allTracksByAutor(songs, authorName));
        System.out.println("Piosenki bez " +inputGenre);
        filtereOut(songs, inputGenre).forEach(System.out::println);
    }
    public static List<Song> filtereOut (List<Song> songss, Song.Genre genreInput){
        return songss.stream().filter(song -> song.getGenre()!=genreInput)
                .distinct()
                .toList();
    }
    public static long allTracksByAutor(List<Song> songss,String name){
        return songss.stream().filter(authorList -> Objects.equals(authorList.getArtist(), name))
                .count();
    }
    public static int totalTimeLenght (List<Song> time, Song.Genre genreinput){

               return time.stream().filter(genrelist -> genrelist.getGenre() == genreinput)
                       .map(Song::getLength)
                       .reduce(0, Integer::sum);

    }
}