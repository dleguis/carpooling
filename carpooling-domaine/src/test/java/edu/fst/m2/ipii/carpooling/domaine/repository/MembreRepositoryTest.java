package edu.fst.m2.ipii.carpooling.domaine.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Dimitri on 20/10/14.
 */
@ContextConfiguration("classpath*:config/carpooling-domaine-datasource-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MembreRepositoryTest {

    /**
     * The user repository.
     */
    @Autowired
    private MembreRepository membreRepository;

    /**
     * Find one test.
     */
    @Test
    public void findOneTest() {
	assertNotNull(membreRepository.findOne(1));
    }
}
