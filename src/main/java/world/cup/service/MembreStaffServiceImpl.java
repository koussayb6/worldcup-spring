package world.cup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import world.cup.models.Equipe;
import world.cup.models.Fonction;
import world.cup.models.MembreStaff;
import world.cup.payload.response.MessageResponse;
import world.cup.repositories.EquipeRepository;
import world.cup.repositories.FonctionRepository;
import world.cup.repositories.MembreStaffRepository;

@Service
public class MembreStaffServiceImpl implements IMembreStaffService {
	
	@Autowired
	MembreStaffRepository membreStaffRepository;
	@Autowired
	EquipeRepository equipeRepository;
	@Autowired
	FonctionRepository fonctionRepository;
	
	@Transactional
	@Override
	public MessageResponse<MembreStaff> save(MembreStaff membrestaff, Long equipeid, Long fonctionid) {
		boolean existe = membreStaffRepository.existsBynom(membrestaff.getNom());
	    if (existe){
	        return new MessageResponse<MembreStaff>(false,"Echec !","Ce joueur existe déja !",null);
	    }
	    Equipe equipe = equipeRepository.findById(equipeid).orElse(null);
	    membrestaff.setEquipe(equipe);
	    Fonction fonction = fonctionRepository.findById(fonctionid).orElse(null);
	    membrestaff.setFonction(fonction);
	    return new MessageResponse<MembreStaff>(true,"Succès","Joueur ajouté avec succès.",membreStaffRepository.save(membrestaff));
	}
	
	@Transactional
	@Override
	public MessageResponse<MembreStaff> update(MembreStaff membrestaff, Long equipeid, Long fonctionid) {
		boolean existe = membreStaffRepository.existsBynom(membrestaff.getNom());
	    if (!existe){
	        return new MessageResponse<MembreStaff>(false,"Echec !","Ce joueur existe déja !",null);
	    }
	    Equipe equipe = equipeRepository.findById(equipeid).orElse(null);
	    membrestaff.setEquipe(equipe);
	    Fonction fonction = fonctionRepository.findById(fonctionid).orElse(null);
	    membrestaff.setFonction(fonction);
	    return new MessageResponse<MembreStaff>(true,"Succès","Joueur ajouté avec succès.",membreStaffRepository.save(membrestaff));
	}
	
	@Transactional
	@Override
	public MessageResponse<MembreStaff> delete(Long membrestaffid) {
		MembreStaff membreStaff = findById(membrestaffid);
	    if (membreStaff==null){
	        return new MessageResponse<MembreStaff>(false,"Echec","Ce joueur n'existe pas !",null);
	    }
	    membreStaffRepository.delete(membreStaff);
	    return new MessageResponse<MembreStaff>(true,"Succès", "Le joueur a été supprimé avec succès.",null);
	}
	@Override
	public List<MembreStaff> findAll() {
		return membreStaffRepository.findAll();
	}
	@Override
	public MembreStaff findById(Long membrestaffid) {
		MembreStaff membreStaff = membreStaffRepository.findById(membrestaffid).orElse(null);
		return membreStaff;
	}
}
