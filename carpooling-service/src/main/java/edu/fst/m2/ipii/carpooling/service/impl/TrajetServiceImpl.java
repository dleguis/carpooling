package edu.fst.m2.ipii.carpooling.service.impl;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import edu.fst.m2.ipii.carpooling.domaine.bo.Trajet;
import edu.fst.m2.ipii.carpooling.service.TrajetService;
import edu.fst.m2.ipii.carpooling.transverse.criteria.TrajetCriteria;
import edu.fst.m2.ipii.carpooling.transverse.dto.TrajetDto;
import edu.fst.m2.ipii.carpooling.transverse.utils.mapper.MapperUtils;
import org.dozer.Mapper;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dimitri on 05/04/15.
 */
@Service
public class TrajetServiceImpl extends AbstractServiceImpl implements TrajetService {

    @Override
    public List<TrajetDto> rechercher(TrajetCriteria trajetCriteria) throws Exception {

        // Replace the API key below with a valid API key.
        GeoApiContext context = new GeoApiContext().setApiKey("***REMOVED***");
        GeocodingResult[] results =  GeocodingApi.geocode(context, trajetCriteria.getVilleDepart()).await();

        double latDepart = results[0].geometry.location.lat;
        double lngDepart = results[0].geometry.location.lng;

        results =  GeocodingApi.geocode(context, trajetCriteria.getVilleArrivee()).await();

        double latArrivee = results[0].geometry.location.lat;
        double lngArrivee = results[0].geometry.location.lng;


        List<Trajet> trajets = trajetRepository.findTrajetByCriteria(latDepart,
                lngDepart,
                latArrivee,
                lngArrivee,
                new DateTime(trajetCriteria.getDateDepart()).withTimeAtStartOfDay().toDate(),
                new DateTime(trajetCriteria.getDateDepart()).withTime(23, 59, 59, 0).toDate());

        return MapperUtils.map(mapperService, trajets, TrajetDto.class);
    }

    @Override
    public TrajetDto getTrajet(int id) {
        return MapperUtils.map(mapperService, trajetRepository.findOneFetch(id), TrajetDto.class);
    }
}