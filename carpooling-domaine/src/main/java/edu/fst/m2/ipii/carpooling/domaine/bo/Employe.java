package edu.fst.m2.ipii.carpooling.domaine.bo;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Dimitri on 20/03/2015.
 */
@Entity
public class Employe {
    private int id;
    private String login;
    private String password;
    private Collection<Profil> profils;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "Password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employe employe = (Employe) o;

        if (id != employe.id) return false;
        if (login != null ? !login.equals(employe.login) : employe.login != null) return false;
        if (password != null ? !password.equals(employe.password) : employe.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "employe")
    public Collection<Profil> getProfils() {
        return profils;
    }

    public void setProfils(Collection<Profil> profils) {
        this.profils = profils;
    }
}
