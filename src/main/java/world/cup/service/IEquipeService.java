package world.cup.service;

import java.util.List;

import world.cup.models.Equipe;
import world.cup.payload.response.MessageResponse;

public interface IEquipeService {
	public MessageResponse<Equipe> save(Equipe equipe);
    public MessageResponse<Equipe> update(Equipe equipe);
    public MessageResponse<Equipe> delete(Long equipeid);
    public List<Equipe> findAll();
    public Equipe findById(Long equipeid);

}
