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

import world.cup.models.Fonction;
import world.cup.payload.response.MessageResponse;
import world.cup.service.FonctionServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/fonction")
public class FonctionController {
	@Autowired
    @Resource
    private FonctionServiceImpl fonctionService;

    @GetMapping
    public List<Fonction> findAll() {
        return fonctionService.findAll();
    }

    @PostMapping
 
    public MessageResponse<Fonction> save(@RequestBody Fonction fonction) {
        return fonctionService.save(fonction);
    }

    @PutMapping
    public MessageResponse<Fonction> update(@RequestBody Fonction fonction) {
        return fonctionService.update(fonction);
    }

   @GetMapping("/{code}")
    public Fonction findById(@PathVariable("code") Long id) {
        return fonctionService.findById(id);
    }

    @DeleteMapping("/{id}")
    public MessageResponse<Fonction> delete(@PathVariable Long id) {
        return fonctionService.delete(id);
    }


}
