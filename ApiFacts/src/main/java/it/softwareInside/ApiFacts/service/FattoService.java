package it.softwareInside.ApiFacts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import it.softwareInside.ApiFacts.models.FattoInutile;
import it.softwareInside.ApiFacts.repository.FattoRepository;

@Service
public class FattoService {

	
	@Autowired
	FattoRepository fattoRepository;
	
	/**
	 * Genera con chimatata Https un fatto random.
	 * @return
	 */
	public FattoInutile generaFattoInutile () {
		
		RestTemplate restTem = new RestTemplate();
		
		FattoInutile fI = restTem.getForObject("https://uselessfacts.jsph.pl/api/v2/facts/random", FattoInutile.class);
		
		return fI;
	}
	
	
	
	/**
	 * Aggiunge un fatto random al database, tornando vero se l'ha aggiunto, altrimenti falso.
	 * @return
	 */
	public boolean addFattoInutile () {
		
		try {
			
			fattoRepository.save(generaFattoInutile());
			return true;
			
		} catch (Exception e) {
			return false;
		
		}
	}
	
	
	
	/**
	 * Prende in input un id e rimuove il fatto con quell'id, se non è presente torna null.
	 * @param id
	 * @return
	 */
	public FattoInutile rimuoviById (String id) {
		
		try {
			FattoInutile fattoInutile = fattoRepository.findById(id).get();
			fattoRepository.deleteById(id);
			return fattoInutile;
		
		} catch (Exception e) {
			return null;
		
		}
	}
	
	
	
	
	/**
	 * Torna tutti i fatti presenti nel database.
	 * @return
	 */
	public Iterable<FattoInutile> allFacts () {
		
		Iterable<FattoInutile> fatti = fattoRepository.findAll();
		
		return fatti;
	}
	
	
	
	
	/**
	 * Prende in input una password String e se risulta corretta
	 * elimina tutti gli elementi dal database tornando true, altrimenti false.
	 * @param password
	 * @return
	 */
	public boolean removeAllFacts (String password) {
		
		String myPass = "12345";
		
		try {
			
			if (password.equals(myPass)) {
				fattoRepository.deleteAll();
				return true;
			} else
				return false;
		} catch (Exception e) {
			return false;
		}
			
	}
	
	
	/**
	 * Prende in input tutti i parametri di un Fatto
	 * e se l'id è già presente aggiorna gli altri parametri nel database.
	 * @param fattoInutile
	 * @return
	 */
	public boolean updateFact (FattoInutile fattoInutile) {
		
		try {
			fattoRepository.save(fattoInutile);
			return true;	
		} catch (Exception e) {
			return false;		
		}
	}
	
	
	
	/**
	 * Attraverso un id torna il fatto nel database
	 * con lo stesso id. Se l'id non è presente torna null.
	 * @param id
	 * @return
	 */
	public FattoInutile getFactById (String id) {
		
		try {
			
			return fattoRepository.findById(id).get();
			
		} catch (Exception e) {
			
			return null;
		}
	}
	
	
	
	
	
	
}
