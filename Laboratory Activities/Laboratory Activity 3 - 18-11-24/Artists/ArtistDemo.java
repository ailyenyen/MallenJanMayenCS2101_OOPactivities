
public class ArtistDemo {
    public static void main(String[] args) {
        Artist artist = new Artist("Chappell Roan", 26, "Music");
        System.out.println("\nArtist's Info:");
        artist.displayInfo();
        System.out.println();

        Singer singer = new Singer("Ariane Grande", 31, Genre.POP);
        System.out.println("\nSinger's Info:");
        singer.displayInfo();
        System.out.println();

        Painter painter = new Painter("Claude Monet", 86, Medium.OIL);
        System.out.println("\nPainter's Info:");
        painter.displayInfo();
        System.out.println();

        Writer writer = new Writer("Brandon Sanderson", 48, WritingStyle.FICTION);
        System.out.println("\nWriter's Info:");
        writer.displayInfo();
        System.out.println();

        Dancer dancer = new Dancer("Martha Graham", 96, DanceStyle.CONTEMPORARY);
        System.out.println("\nDancer's Info:");
        dancer.displayInfo();
    }
}