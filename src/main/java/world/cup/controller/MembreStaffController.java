package world.cup.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import world.cup.models.MembreStaff;
import world.cup.payload.response.MessageResponse;
import world.cup.service.MembreStaffServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/membrestaff")
public class MembreStaffController {
	@Autowired
    @Resource
    private MembreStaffServiceImpl membrestaffService;

    @GetMapping
    public List<MembreStaff> findAll() {
        return membrestaffService.findAll();
    }

    @PostMapping("/{equipeid}/{fonctionid}")
 
    public MessageResponse<MembreStaff> save(@RequestBody MembreStaff membrestaff,@PathVariable("equipeid") Long equipeid, @PathVariable("fonctionid") Long fonctionid) {
        return membrestaffService.save(membrestaff, equipeid,fonctionid);
    }

    @PutMapping("/{equipeid}/{fonctionid}")
    public MessageResponse<MembreStaff> update(@RequestBody MembreStaff membrestaff,@PathVariable("equipeid") Long equipeid, @PathVariable("fonctionid") Long fonctionid) {
        return membrestaffService.update(membrestaff, equipeid,fonctionid);
    }

   @GetMapping("/{code}")
    public MembreStaff findById(@PathVariable("code") Long id) {
        return membrestaffService.findById(id);
    }

    @DeleteMapping("/{id}")
    public MessageResponse<MembreStaff> delete(@PathVariable Long id) {
        return membrestaffService.delete(id);
    }


}
