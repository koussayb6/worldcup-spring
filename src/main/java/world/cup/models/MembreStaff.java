package world.cup.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MembreStaff implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="membrestaffid")
	private Long membrestaffid;
	@Column(unique = true,nullable = false)
	private String prenom;
	private String nom;
	@Enumerated(EnumType.STRING)
	private Categorie categorie;
	
	
	@ManyToOne
	private Fonction fonction;
	@JsonIgnore
	@ManyToOne
	private Equipe equipe;
	

}
