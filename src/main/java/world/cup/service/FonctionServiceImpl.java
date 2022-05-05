package world.cup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import world.cup.models.Fonction;
import world.cup.payload.response.MessageResponse;
import world.cup.repositories.FonctionRepository;

@Service
public class FonctionServiceImpl implements IFonctionService {

	@Autowired
	FonctionRepository fonctionRepository;
	@Transactional
	@Override
	public MessageResponse<Fonction> save(Fonction fonction) {
		boolean existe = fonctionRepository.existsBylibelle(fonction.getLibelle());
	    if (existe){
	        return new MessageResponse<Fonction>(false,"Echec !","Cette fonction existe déja !",null);
	    }
	    
	    return new MessageResponse<Fonction>(true,"Succès","Fonction ajoutée avec succès.",fonctionRepository.save(fonction));
	}
	@Transactional
	@Override
	public MessageResponse<Fonction> update(Fonction fonction) {
		boolean existe = fonctionRepository.existsBylibelle(fonction.getLibelle());
		 if (!existe){
	         return new MessageResponse<Fonction>(false,"Echec !","Opération non réalisée !",null);
	         }
	     
	     return new MessageResponse<Fonction>(true,"Succès","Opération réalisée avec succès.",fonctionRepository.save(fonction));
	}
	@Transactional
	@Override
	public MessageResponse<Fonction> delete(Long fonctionid) {
		Fonction fonction = findById(fonctionid);
	    if (fonction==null){
	        return new MessageResponse<Fonction>(false,"Echec","Cette fonction n'existe pas !",null);
	    }
	    fonctionRepository.delete(fonction);
	    return new MessageResponse<Fonction>(true,"Succès", "La fonction a été supprimée avec succès.",null);
	}

	@Override
	public List<Fonction> findAll() {
		return fonctionRepository.findAll();
	}

	@Override
	public Fonction findById(Long fonctionid) {
		Fonction fonction = fonctionRepository.findById(fonctionid).orElse(null);
		return fonction;
	}

}
