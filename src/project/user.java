package project;

public abstract class user {
	
	private String license;
    private String name;

    public void User(String license,String name) {

        this.license=license;
        this.name=name;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract int limitePrestamos();

}


