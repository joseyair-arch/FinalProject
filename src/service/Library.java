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

    // ADD MATERIAL
    public boolean addMaterial(Material material) {

        for (Material m : materials) {

            if (m.getCode().equalsIgnoreCase(material.getCode())) {

                return false;

            }

        }

        materials.add(material);

        return true;

    }

    // ADD USER
    public boolean addUser(User user) {

        for (User u : users) {

            if (u.getId().equalsIgnoreCase(user.getId())) {

                return false;

            }

        }

        users.add(user);

        return true;

    }

    // SEARCH MATERIAL
    public Material searchMaterial(String code) {

        for (Material m : materials) {

            if (m.getCode().equalsIgnoreCase(code)) {

                return m;

            }

        }

        return null;

    }

    // SEARCH USER
    public User searchUser(String id) {

        for (User u : users) {

            if (u.getId().equalsIgnoreCase(id)) {

                return u;

            }

        }

        return null;

    }

    // MAKE LOAN
    public boolean makeLoan(String userId, String materialCode) {

        User user = searchUser(userId);

        Material material = searchMaterial(materialCode);

        if (user == null || material == null) {

            return false;

        }

        if (!material.isAvailable()) {

            return false;

        }

        int count = 0;

        for (Loan l : loans) {

            if (l.getUser().getId().equalsIgnoreCase(userId)) {

                count++;

            }

        }

        if (count >= user.loanLimit()) {

            return false;

        }

        material.setAvailable(false);

        Loan loan = new Loan(user, material);

        loans.add(loan);

        return true;

    }

    // RETURN MATERIAL
    public boolean returnMaterial(String code) {

        for (Loan l : loans) {

            if (l.getMaterial().getCode().equalsIgnoreCase(code)) {

                l.getMaterial().setAvailable(true);

                loans.remove(l);

                return true;

            }

        }

        return false;

    }

    // VIEW MATERIALS
    public ArrayList<Material> getMaterials() {

        return materials;

    }

    // VIEW LOANS
    public ArrayList<Loan> getLoans() {

        return loans;

    }

}