package world.cup.service;

import java.util.List;

import world.cup.models.Joueur;
import world.cup.payload.response.MessageResponse;

public interface IJoueurService {
	
	public MessageResponse<Joueur> save(Joueur joueur, Long equipeid);
    public MessageResponse<Joueur> update(Joueur joueur, Long equipeid); 
    public MessageResponse<Joueur> delete(Long joueurid);
    public List<Joueur> findAll();
    public Joueur findById(Long joueurid);
}
