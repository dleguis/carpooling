package edu.fst.m2.ipii.carpooling.domaine.repository;

import edu.fst.m2.ipii.carpooling.domaine.bo.Membre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MembreRepository extends JpaRepository<Membre, Integer> {

    Membre findByLogin(String login);

    List<Membre> findByLoginLike(String login);

    Membre findByLoginAndPassword(String login, String password);

    @Query("SELECT m FROM Membre m WHERE m.login = :login OR m.email = :email")
    List<Membre> findByLoginAndEmail(@Param("login") String login, @Param("email") String email);
}