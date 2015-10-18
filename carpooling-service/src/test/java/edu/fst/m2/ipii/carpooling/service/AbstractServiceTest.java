package edu.fst.m2.ipii.carpooling.service;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.AddressComponent;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.Geometry;
import com.google.maps.model.LatLng;
import edu.fst.m2.ipii.carpooling.domaine.bo.Voiture;
import edu.fst.m2.ipii.carpooling.domaine.repository.FactureRepository;
import edu.fst.m2.ipii.carpooling.domaine.repository.PaiementRepository;
import edu.fst.m2.ipii.carpooling.domaine.repository.VoitureRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;

/**
 * Created by Dimitri on 14/01/2015.
 */
@ContextConfiguration({ "classpath*:config/carpooling-service-test-context.xml", "classpath:config/carpooling-domaine-datasource.xml" })
//@RunWith(PowerMockRunner.class)
// @PowerMockRunnerDelegate(SpringJUnit4ClassRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
//@PrepareForTest({ GeocodingApi.class })
public abstract class AbstractServiceTest {

    /**
     * The user repository.
     */
    @Autowired
    protected MembreService membreService;

    @Autowired
    protected TrajetService trajetService;

    @Autowired
    protected MoyenPaiementService moyenPaiementService;

    @Autowired
    protected PaiementRepository paiementRepository;

    @Autowired
    protected FactureRepository factureRepository;

    @Autowired
    protected ReservationService reservationService;

    @Autowired
    protected VoitureService voitureService;

    @Autowired
    protected VoitureRepository voitureRepository;

    // @Before
    public void setUp() throws Exception {

        /*
        GeocodingResult fakeResult = new GeocodingResult();


        fakeResult.geometry = new Geometry();
        fakeResult.geometry.location = new LatLng(1, 1);

        // fakeResult.addressComponents = new AddressComponent[]{};

        AddressComponent numero = new AddressComponent();
        numero.longName = "1337";

        AddressComponent rue = new AddressComponent();
        rue.longName = " rue test";

        AddressComponent ville = new AddressComponent();
        ville.longName = " ville test";

        AddressComponent codePostal = new AddressComponent();
        codePostal.longName = " codePostal test";

        AddressComponent pays = new AddressComponent();
        pays.longName = " pays test";



        fakeResult.addressComponents[0] = numero;
        fakeResult.addressComponents[1] = rue;
        fakeResult.addressComponents[2] = ville;
        fakeResult.addressComponents[6] = codePostal;
        fakeResult.addressComponents[5] = pays;
        // Remplissage fake
        fakeResult.addressComponents[3] = null;
        fakeResult.addressComponents[4] = null;

        GeocodingResult[] fakeResults = new GeocodingResult[] { fakeResult };

        PowerMockito.mockStatic(GeocodingApi.class);
        PowerMockito.when(GeocodingApi.geocode(any(GeoApiContext.class), anyString()).await()).thenReturn(fakeResults);
        */
    }

    //@After
    public void tearDown() {
        // PowerMockito.verifyStatic();
    }

}
