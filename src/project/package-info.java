package project;

 class book extends Material {

     private String author;
    

    public book(String author) {

        

        this.author=author;
       
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String toString() {

        return getTitulo()+" - "+author;
    }

	private String getTitulo() {
		// TODO Auto-generated method stub
		return null;
	}

}