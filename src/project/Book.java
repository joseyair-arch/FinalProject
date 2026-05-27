package project;

public class Book extends Material {

    private String author;

    private int year;

    public Book(
            String code,
            String title,
            String author,
            int year
    ) {

        super(code, title);

        this.author = author;

        this.year = year;

    }

    public String getAuthor() {

        return author;

    }

    public void setAuthor(String author) {

        this.author = author;

    }

    public int getYear() {

        return year;

    }

    public void setYear(int year) {

        this.year = year;

    }

    @Override
    public int loanDays() {

        return 7;

    }

    @Override
    public String toString() {

        return getTitle()
                + " - "
                + author;

    }

}