package world.cup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import world.cup.models.Equipe;
import world.cup.payload.response.MessageResponse;
import world.cup.repositories.EquipeRepository;

@Service
public class EquipeServiceImpl implements IEquipeService  {
	@Autowired
	EquipeRepository equipeRepository;
	
	@Transactional
	@Override
	public MessageResponse<Equipe> save(Equipe equipe) {
		boolean existe = equipeRepository.existsByEquipeid(equipe.getEquipeid());
	    if (existe){
	        return new MessageResponse<Equipe>(false,"Echec !","Cette équipe existe déja !",null);
	    }
	    
	    return new MessageResponse<Equipe>(true,"Succès","Equipe ajouté avec succès.",equipeRepository.save(equipe));
	}
	@Transactional
	@Override
	public MessageResponse<Equipe> update(Equipe equipe) {
		boolean existe = equipeRepository.existsByEquipeid(equipe.getEquipeid());
		 if (!existe){
	         return new MessageResponse<Equipe>(false,"Echec !","Opération non réalisée !",null);
	         }
	     
	     return new MessageResponse<Equipe>(true,"Succès","Opération réalisée avec succès.",equipeRepository.save(equipe));
	}
	@Transactional
	@Override
	public MessageResponse<Equipe> delete(Long equipeid) {
		Equipe equipe = findById(equipeid);
	    if (equipe==null){
	        return new MessageResponse<Equipe>(false,"Echec","Cette équipe n'existe pas !",null);
	    }
	    equipeRepository.delete(equipe);
	    return new MessageResponse<Equipe>(true,"Succès", "L'équipe a été supprimée avec succès.",null);
	}

	@Override
	public List<Equipe> findAll() {
		return equipeRepository.findAll(Sort.by("equipeid").descending());
	}

	@Override
	public Equipe findById(Long equipeid) {
		Equipe equipe = equipeRepository.findById(equipeid).orElse(null);
		return equipe;
	}

}
