class Writer extends Artist {
    private WritingStyle writingStyle;

    public Writer(String name, int age, WritingStyle writingStyle) {
        super(name, age, "Writing");
        this.writingStyle = writingStyle;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Writing Style: " + writingStyle);
    }
}

enum WritingStyle {
    FICTION, NONFICTION, POETRY, DRAMA
}