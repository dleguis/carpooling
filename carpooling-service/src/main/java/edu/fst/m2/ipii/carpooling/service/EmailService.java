package edu.fst.m2.ipii.carpooling.service;

/**
 * Created by Dimitri on 14/04/2015.
 */
public interface EmailService {

    void envoyer(String from, String to, String subject, String msg);
}
