package world.cup.service;

import java.util.List;

import world.cup.models.Fonction;
import world.cup.payload.response.MessageResponse;

public interface IFonctionService {
	public MessageResponse<Fonction> save(Fonction equipe);
    public MessageResponse<Fonction> update(Fonction equipe);
    public MessageResponse<Fonction> delete(Long fonctionid);
    public List<Fonction> findAll();
    public Fonction findById(Long fonctionid);

}
