package project;

public abstract class user {
	
	private String id;
    private String name;

    public  user(String id,String name) {

        this.id=id;
        this.name=name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract int limitePrestamos();

	public int loanLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

}


