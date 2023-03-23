package it.softwareInside.ApiFacts.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FattoInutile {

	@Id
	private String id;
	
    private String text;
    
    private String source;
    
    private String source_url;
    
    private String language;
    
    private String permalink;
	
	
}
