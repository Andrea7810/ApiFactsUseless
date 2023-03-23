package it.softwareInside.ApiFacts.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.softwareInside.ApiFacts.models.FattoInutile;
import it.softwareInside.ApiFacts.service.FattoService;

@RequestMapping("/api")
@org.springframework.web.bind.annotation.RestController
public class RestController {

	
	@Autowired
	FattoService fattoService;
	
	
	@GetMapping("/")
	public FattoInutile fattoInutile () {
		
		return fattoService.generaFattoInutile();
	}
	
	
	
	@GetMapping("/add-random-fact")
	public boolean addFact () {
		
		return fattoService.addFattoInutile();
	}
	
	
	
	
	@DeleteMapping("/delete-fact-by-id")
	public FattoInutile deleteFactById (@RequestParam (name="id") String id) {
		
		return fattoService.rimuoviById(id);
	}
	
	
	
	@GetMapping("/all-facts")
	public Iterable<FattoInutile> allFacts () {
		
		return fattoService.allFacts();
	}
	
	
	
	
	@DeleteMapping("/delete-all-facts")
	public boolean deleteAllFacts (@RequestParam (name="pass") String password) {
		
		return fattoService.removeAllFacts(password);
	}
	
	
	
	@PostMapping("/update-fact")
	public boolean updateFact (@RequestBody FattoInutile fattoInutile) {
		
		return fattoService.updateFact(fattoInutile);
	}
	
	
	
	
	
	@GetMapping("/get-fact-by-id")
	public FattoInutile getFactById (@RequestParam (name="id") String id) {
		
		return fattoService.getFactById(id);
	}
	
	
	
	
}
