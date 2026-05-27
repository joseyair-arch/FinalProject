package project;

public class Teacher extends User {

    public Teacher(
            String id,
            String name
    ) {

        super(id, name);

    }

    @Override
    public int loanLimit() {

        return 5;

    }

    @Override
    public String toString() {

        return getName()
                + " - Teacher";

    }

}