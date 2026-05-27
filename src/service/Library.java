package service;

import project.*;

import java.util.ArrayList;

public class Library {

    private ArrayList<Material> materials;

    private ArrayList<User> users;

    private ArrayList<Loan> loans;

    public Library() {

        materials = new ArrayList<>();

        users = new ArrayList<>();

        loans = new ArrayList<>();

    }

    public boolean addMaterial(Material material) {

        for (Material m : materials) {

            if (
                    m.getCode()
                    .equalsIgnoreCase(
                            material.getCode()
                    )
            ) {

                return false;

            }

        }

        materials.add(material);

        return true;

    }

}