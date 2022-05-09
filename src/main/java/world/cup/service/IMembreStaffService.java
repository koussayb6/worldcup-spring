package world.cup.service;

import java.util.List;

import world.cup.models.MembreStaff;
import world.cup.payload.response.MessageResponse;

public interface IMembreStaffService {
	public MessageResponse<MembreStaff> save(MembreStaff membrestaff, Long equipeid, Long fonctionid);
    public MessageResponse<MembreStaff> update(MembreStaff membrestaff, Long equipeid, Long fonctionid);
    public MessageResponse<MembreStaff> delete(Long membrestaffid);
    public List<MembreStaff> findAll();
    public MembreStaff findById(Long membrestaffid);
}
