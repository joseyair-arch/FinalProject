package service;

import project.*;

import java.util.ArrayList;

public class Library {

    private ArrayList<Material> materials;
    private ArrayList<user> users;
    private ArrayList<Loan> loans;

    public Library(){

        materials = new ArrayList<>();
        users = new ArrayList<>();
        loans = new ArrayList<>();

    }


    // ADD MATERIAL
    public boolean addMaterial(
            Material material
    ){

        for(Material m : materials){

            if(
                    m.getCode()
                    .equalsIgnoreCase(
                            material.getCode()
                    )
            ){

                return false;
            }

        }

        materials.add(material);

        return true;

    }


    // ADD USER
    public boolean addUser(
            user user
    ){

        for(user u : users){

            if(
                    u.getId()
                    .equalsIgnoreCase(
                            user.getId()
                    )
            ){

                return false;
            }

        }

        users.add(user);

        return true;

    }



    // SEARCH MATERIAL
    public Material searchMaterial(
            String code
    ){

        for(
                Material m:materials
        ){

            if(
                    m.getCode()
                    .equalsIgnoreCase(
                            code
                    )
            ){

                return m;

            }

        }

        return null;

    }


    // SEARCH USER
    public user searchUser(
            String id
    ){

        for(
                user u:users
        ){

            if(
                    u.getId()
                    .equalsIgnoreCase(
                            id
                    )
            ){

                return u;

            }

        }

        return null;

    }



    // LOAN
    public String loanMaterial(
            String id,
            String code
    ){

        user user =
                searchUser(id);

        if(user==null){

            return "User not found";

        }


        Material material=
                searchMaterial(
                        code
                );

        if(material==null){

            return "Material not found";

        }


        if(
                !material.isAvailable()
        ){

            return "Not available";

        }



        int count=0;

        for(
                Loan l:loans
        ){

            if(
                    l.getUser()
                    .getId()
                    .equals(
                            id
                    )
            ){

                count++;

            }

        }



        if(
                count>=
                user.loanLimit()
        ){

            return "Loan limit exceeded";

        }



        material.setAvailable(
                false
        );


        loans.add(
                new Loan(
                        user,
                        material
                )
        );


        return "Loan completed";

    }



    // RETURN
    public String returnMaterial(
            String code
    ){

        Loan remove=null;


        for(
                Loan l:loans
        ){

            if(
                    l.getMaterial()
                    .getCode()
                    .equalsIgnoreCase(
                            code
                    )
            ){

                remove=l;

                break;

            }

        }


        if(remove==null){

            return "Loan not found";

        }


        remove
        .getMaterial()
        .setAvailable(
                true
        );


        loans.remove(
                remove
        );

        return "Returned";

    }


    public ArrayList<Material>
    getMaterials(){

        return materials;

    }


    public ArrayList<user>
    getUsers(){

        return users;

    }


    public ArrayList<Loan>
    getLoans(){

        return loans;

    }
    
}
