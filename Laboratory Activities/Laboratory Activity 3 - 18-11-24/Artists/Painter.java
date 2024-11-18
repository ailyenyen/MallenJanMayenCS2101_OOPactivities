class Painter extends Artist {
    private Medium medium;

    public Painter(String name, int age, Medium medium) {
        super(name, age, "Painting");
        this.medium = medium;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Medium: " + medium);
    }
}

enum Medium {
    OIL, WATERCOLOR, ACRYLIC, PENCIL, CHARCOAL
}