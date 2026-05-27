package project;

public class Student extends User {

    public Student(
            String id,
            String name
    ) {

        super(id, name);

    }

    @Override
    public int loanLimit() {

        return 3;

    }

    @Override
    public String toString() {

        return getName()
                + " - Student";

    }

}