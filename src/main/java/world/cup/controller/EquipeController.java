package world.cup.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

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
    public MessageResponse<Equipe> save(@RequestParam("e") String e, @RequestParam(required=false) MultipartFile file1, @RequestParam(required=false) MultipartFile file2) throws IOException {
		Equipe equipe= new ObjectMapper().readValue(e, Equipe.class);
		if(file1!=null)
    	equipe.setMaillotdomicile(file1.getBytes());
		if(file2!=null)
    	equipe.setMaillotexterieur(file2.getBytes());

        return equipeService.save(equipe);
    }

    @PutMapping
    public MessageResponse<Equipe> update(@RequestParam("e") String e, @RequestParam(required=false) MultipartFile file1, @RequestParam(required=false) MultipartFile file2) throws IOException {
		Equipe equipe= new ObjectMapper().readValue(e, Equipe.class);
		if(file1!=null)
    	equipe.setMaillotdomicile(file1.getBytes());
		if(file2!=null)
    	equipe.setMaillotexterieur(file2.getBytes());

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
