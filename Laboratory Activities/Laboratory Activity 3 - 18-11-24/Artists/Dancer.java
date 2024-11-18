class Dancer extends Artist {
    private DanceStyle danceStyle;

    public Dancer(String name, int age, DanceStyle danceStyle) {
        super(name, age, "Dancing");
        this.danceStyle = danceStyle;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Dance Style: " + danceStyle);
    }
}

enum DanceStyle {
    BALLET, HIPHOP, JAZZ, CONTEMPORARY
}

