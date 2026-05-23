package project;

public class student extends user {

	 public student(String id,String name){

	        super(id,name);
	        

	    }

	    @Override
	    public int loanLimit(){

	        return 3;

	    }

	    @Override
	    public String toString(){

	        return getName()
	                +" - Student";

	    }

		@Override
		public int loanlimit() {
			// TODO Auto-generated method stub
			return 0;
		}


}
