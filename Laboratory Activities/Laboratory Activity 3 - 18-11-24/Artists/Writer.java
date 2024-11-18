enum WritingStyle {
    FICTION,
    NONFICTION,
    POETRY,
    DRAMA
}

class Writer extends Artist {
    private WritingStyle writingstyle;

    public Writer(String name, String nationality, int age, String specialty, WritingStyle writingstyle) {
        super(name, nationality, age, specialty);
        this.writingstyle = writingstyle;
    }

    public WritingStyle getWritingStyle() {
        return writingstyle;
    }

    public void setWritingStyle(WritingStyle writingstyle) {
        this.writingstyle = writingstyle;
    }

    @Override
    public void displayInfo() {
        System.out.println("Writer Info's: ");
        super.displayInfo();
        System.out.println("Writing Style: " + writingstyle);
    }
}