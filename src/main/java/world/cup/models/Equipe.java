package world.cup.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Equipe implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="equipeid")
	private Long equipeid;
	@Column(unique = true,nullable = false)
	private String nom;
	private String surnom;
	private int classementmondial;
	private String confederation;
	private String couleurs;
	private String stadeprincipal;
	@Column(nullable = true, length = 64)
	private String maillotdomicile;
	@Column(nullable = true, length = 64)
	private String maillotexterieur;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="equipe")
	private List<MembreStaff> MembresStaff;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="equipe")
	private List<Joueur> joueurs;
	
	
}
