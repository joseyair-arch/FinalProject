package project;

public class Loan {

    private User user;

    private Material material;

    public Loan(
            User user,
            Material material
    ) {

        this.user = user;

        this.material = material;

    }

    public User getUser() {

        return user;

    }

    public void setUser(User user) {

        this.user = user;

    }

    public Material getMaterial() {

        return material;

    }

    public void setMaterial(Material material) {

        this.material = material;

    }

    @Override
    public String toString() {

        return user.getName()
                + " borrowed "
                + material.getTitle();

    }

}