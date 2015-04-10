package edu.fst.m2.ipii.carpooling.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import edu.fst.m2.ipii.carpooling.transverse.dto.VoitureDto;
import edu.fst.m2.ipii.carpooling.transverse.exception.CarpoolingFonctionnelleException;
import edu.fst.m2.ipii.carpooling.transverse.exception.code.CarpoolingFonctionnelleExceptionCode;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import edu.fst.m2.ipii.carpooling.domaine.bo.Membre;
import edu.fst.m2.ipii.carpooling.domaine.bo.Voiture;
import edu.fst.m2.ipii.carpooling.service.MembreService;
import edu.fst.m2.ipii.carpooling.transverse.dto.MembreDto;
import edu.fst.m2.ipii.carpooling.transverse.utils.mapper.MapperUtils;

/**
 * Created by Dimitri on 02/04/15.
 */
@Service
public class MembreServiceImpl extends AbstractServiceImpl implements MembreService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(MembreServiceImpl.class);

	@Override
	public List<MembreDto> rechercher() {
		List<Membre> membres = membreRepository.findAll();
		for (Membre membre : membres) {
			LOGGER.debug("profils : {}", membre.getProfils());
		}
		return MapperUtils.map(mapperService, membres, MembreDto.class);
	}

	@Override
	public MembreDto rechercher(int id) {
		Membre membre = membreRepository.findOne(id);

		LOGGER.debug("profils : {}", membre.getProfils());
		LOGGER.debug("voitures : {}", membre.getVoitures());

		return MapperUtils.map(mapperService, membre, MembreDto.class);
	}

	@Override
	public MembreDto rechercher(String login) {
		Membre membre = membreRepository.findByLogin(login);

		LOGGER.debug("profils : {}", membre.getProfils());
		LOGGER.debug("voitures : {}", membre.getVoitures());

		return MapperUtils.map(mapperService, membre, MembreDto.class);
	}

	@Override
	public MembreDto rechercher(String login, String password) {
		return MapperUtils.map(mapperService, membreRepository.findByLoginAndPassword(login, password), MembreDto.class);
	}

	@Override
	public void save(MembreDto membre) {
		Membre m = membreRepository.findOne(membre.getID());

		m.setNomMembre(membre.getNomMembre());
		m.setPrenomMembre(membre.getPrenomMembre());
		m.setEmail(membre.getEmail());
		m.setPassword(membre.getPassword());

		membreRepository.save(m);
	}

	@Override
	public void update(MembreDto membreDto) {
		Membre m = membreRepository.findOne(membreDto.getID());
		m.setNomMembre(membreDto.getNomMembre());
		m.setPrenomMembre(membreDto.getPrenomMembre());
	   // m.getVoitures().addAll((Collection<? extends Voiture>) MapperUtils.map(mapperService, membreDto.getVoitures(), ArrayList.class));
		 membreRepository.save(m);

	}

	@Override
	public void nouveau(MembreDto membreDto) {

		List<Membre> membres = membreRepository.findByLoginAndEmail(membreDto.getLogin(), membreDto.getEmail());

		if (CollectionUtils.isNotEmpty(membres)) {
			throw new CarpoolingFonctionnelleException(CarpoolingFonctionnelleExceptionCode.ERR_USER_005);
		}

		Membre m = new Membre();
		m.setNomMembre(membreDto.getNomMembre());
		m.setPrenomMembre(membreDto.getPrenomMembre());
		m.setLogin(membreDto.getLogin());
		m.setEmail(membreDto.getEmail());
		m.setPassword(membreDto.getPassword());

		m.getProfils().add(profilRepository.findOne(1));

		membreRepository.save(m);
	}

	@Override
	public List<VoitureDto> rechercherVoitures(int membreId) {
		return MapperUtils.map(mapperService, voitureRepository.findByConducteur(membreId), VoitureDto.class);
	}
}