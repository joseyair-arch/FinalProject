package project;

public abstract class Material {

    private String code;

    private String title;

    private boolean available;

    public Material(
            String code,
            String title
    ) {

        this.code = code;

        this.title = title;

        this.available = true;

    }

    public String getCode() {

        return code;

    }

    public void setCode(String code) {

        this.code = code;

    }

    public String getTitle() {

        return title;

    }

    public void setTitle(String title) {

        this.title = title;

    }

    public boolean isAvailable() {

        return available;

    }

    public void setAvailable(boolean available) {

        this.available = available;

    }

    public abstract int loanDays();

}