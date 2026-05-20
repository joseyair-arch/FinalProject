package project;

public abstract class Material {



private String code;
private String title;


public Material(String code,String title) {
    this.code = code;
    this.title = title;
    
  }
public String getCode() {
    return code;
 }

public void setCode(String code) {

    if(code.isEmpty()){
        throw new IllegalArgumentException("Códe empty");
    }

    this.code = code;
  }

public String getTitle() {
    return title;
}

public void setTitle(String title) {

    if(title.isEmpty()){
        throw new IllegalArgumentException("Título vacío");
    }

    this.title = title;
}
public int diasPrestamo() {
	// TODO Auto-generated method stub
	return 0;
}

 }