package world.cup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import world.cup.models.Equipe;
import world.cup.models.Joueur;
import world.cup.payload.response.MessageResponse;
import world.cup.repositories.EquipeRepository;
import world.cup.repositories.JoueurRepository;

@Service
public class JoueurServiceImpl implements IJoueurService {
	
@Autowired
JoueurRepository joueurRepository;
@Autowired
EquipeRepository equipeRepository;

@Transactional
@Override
public MessageResponse<Joueur> save(Joueur joueur,Long equipeid) {
	 boolean existe = joueurRepository.existsByfifajoueurid(joueur.getFifajoueurid());
	    if (existe){
	        return new MessageResponse<Joueur>(false,"Echec !","Ce joueur existe déja !",null);
	    }
	    Equipe equipe = equipeRepository.findById(equipeid).orElse(null);
	    joueur.setEquipe(equipe);
	    return new MessageResponse<Joueur>(true,"Succès","Joueur ajouté avec succès.",joueurRepository.save(joueur));

}

@Transactional
@Override
public MessageResponse<Joueur> update(Joueur joueur, Long equipeid) {
		 boolean existe = joueurRepository.existsByfifajoueurid(joueur.getFifajoueurid());
	     if (!existe){
	         return new MessageResponse<Joueur>(false,"Echec !","Opération non réalisée !",null);
	         }
	     Equipe equipe = equipeRepository.findById(equipeid).orElse(null);
		 joueur.setEquipe(equipe);
	     return new MessageResponse<Joueur>(true,"Succès","Opération réalisée avec succès.",joueurRepository.save(joueur));
}

@Transactional
@Override
public MessageResponse<Joueur> delete(Long joueurid) {
	Joueur joueur = findById(joueurid);
    if (joueur==null){
        return new MessageResponse<Joueur>(false,"Echec","Ce joueur n'existe pas !",null);
    }
    joueurRepository.delete(joueur);
    return new MessageResponse<Joueur>(true,"Succès", "Le joueur a été supprimé avec succès.",null);
}

@Override
public List<Joueur> findAll() {
	return joueurRepository.findAll();
}

@Override
public Joueur findById(Long joueurid) {
	Joueur joueur = joueurRepository.findById(joueurid).orElse(null);
	return joueur;
}



}
