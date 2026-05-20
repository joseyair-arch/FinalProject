package project;

 class book extends Material {

     private String author;
     private int anio;

    public book(String author,int anio) {

        

        this.author=author;
        this.anio=anio;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {

        if(anio<1900){

            throw new IllegalArgumentException("year inválid");
        }

        this.anio=anio;
    }
    

    public String toString() {

        return getTitulo()+" - "+author;
    }

	private String getTitulo() {
		// TODO Auto-generated method stub
		return null;
	}

}