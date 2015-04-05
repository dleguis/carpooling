package edu.fst.m2.ipii.carpooling.service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Dimitri on 14/01/2015.
 */
@ContextConfiguration({ "classpath*:config/carpooling-service-test-context.xml", "classpath:config/carpooling-domaine-datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class AbstractServiceTest {

    /**
     * The user repository.
     */
    @Autowired
    protected MembreService membreService;

    @Autowired
    protected TrajetService trajetService;


}
