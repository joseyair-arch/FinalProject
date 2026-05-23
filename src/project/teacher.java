package project;

public class teacher extends user  {
	
	public teacher(String id,String name){

        super(id,name);

    }

    @Override
    public int loanLimit(){

        return 5;

    }

    @Override
    public String toString(){

        return getName()
                +" - Teacher";

    }

	@Override
	public int limitePrestamos() {
		// TODO Auto-generated method stub
		return 0;
	}


}
