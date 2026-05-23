package project;

public class Loan {
	
	private user user;
    private Material material;

    public Loan(
            user user,
            Material material
    ){

        this.user = user;
        this.material = material;

    }

    public user getUser() {
        return user;
    }

    public void setUser(
            user user
    ) {
        this.user = user;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(
            Material material
    ) {
        this.material = material;
    }

    @Override
    public String toString(){

        return user.getName()
                + " borrowed "
                + material.getTitle();

    }


}
