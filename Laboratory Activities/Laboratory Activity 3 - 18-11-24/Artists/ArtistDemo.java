import javax.swing.*;

public class ArtistDemo {
    public static void main(String[] args) {

        Artist artist = new Artist("Chappell Roan", "American", 26, "Music");
        artist.displayInfo();
        System.out.println();

        Dancer dancer = new Dancer("Martha Graham", "American", 96, "Dancing", DanceStyle.CONTEMPORARY);
        dancer.displayInfo();
        System.out.println();

        Singer singer = new Singer("Ariane Grande", "American", 31, "Singing", Genre.POP);
        singer.displayInfo();
        System.out.println();

        Painter painter = new Painter("Claude Monet", "French", 86, "Painting", Medium.OIL);
        painter.displayInfo();
        System.out.println();

        Writer writer = new Writer("Brandon Sanderson", "American", 48, "Writing", WritingStyle.FICTION);
        writer.displayInfo();
        System.out.println();
    }
}