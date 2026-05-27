package project;

public class Book extends Material {

    private String author;

    public Book(String code, String title, String author, int year) {
        super(code, title, year);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public int loanDays() {
        return 14;
    }

    @Override
    public String toString() {
        return getTitle() + " - " + author;
    }
}