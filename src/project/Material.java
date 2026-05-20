package project;

public abstract class Material {



private String code;
public Material(String code) {
    this.code = code;
    
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

 }