package world.cup.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import world.cup.models.Equipe;
import world.cup.payload.response.MessageResponse;
import world.cup.service.EquipeServiceImpl;


@RestController
@CrossOrigin("*")
@RequestMapping("/equipe")
public class EquipeController {
	@Autowired
    @Resource
    private EquipeServiceImpl equipeService;

    @GetMapping
    public List<Equipe> findAll() {
        return equipeService.findAll();
    }

    @PostMapping
    public MessageResponse<Equipe> save(@RequestBody Equipe equipe) {
        return equipeService.save(equipe);
    }

    @PutMapping
    public MessageResponse<Equipe> update(@RequestBody Equipe equipe) {
        return equipeService.update(equipe);
    }

   @GetMapping("/{code}")
    public Equipe findById(@PathVariable("code") Long id) {
        return equipeService.findById(id);
    }

    @DeleteMapping("/{id}")
    public MessageResponse<Equipe> delete(@PathVariable Long id) {
        return equipeService.delete(id);
    }


}
