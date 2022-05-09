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

import world.cup.models.Joueur;
import world.cup.payload.response.MessageResponse;
import world.cup.service.JoueurServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/joueur")
public class JoueurController {
	
	@Autowired
    @Resource
    private JoueurServiceImpl joueurService;

    @GetMapping
    public List<Joueur> findAll() {
        return joueurService.findAll();
    }

    @PostMapping("/{equipeid}")
 
    public MessageResponse<Joueur> save(@RequestBody Joueur joueur,@PathVariable("equipeid") Long equipeid) {
        return joueurService.save(joueur, equipeid);
    }

    @PutMapping("/{equipeid}")
    public MessageResponse<Joueur> update(@RequestBody Joueur joueur,@PathVariable("equipeid") Long equipeid) {
        return joueurService.update(joueur, equipeid);
    }

   @GetMapping("/{code}")
    public Joueur findById(@PathVariable("code") Long id) {
        return joueurService.findById(id);
    }

    @DeleteMapping("/{id}")
    public MessageResponse<Joueur> delete(@PathVariable Long id) {
        return joueurService.delete(id);
    }


}
