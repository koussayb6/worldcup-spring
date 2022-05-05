package world.cup.models;

import java.io.Serializable;
import java.util.Date;

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
public class Joueur implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="joueurid")
	private Long joueurid;
	@Column(unique = true,nullable = false)
	private Long fifajoueurid;
	private String prenom;
	private String nom;
	private Date datenaissance;
	private int age;
	private float taille;
	private float poids;
	private float valeur;
	private float salaire;
	@Enumerated(EnumType.STRING)
	private Poste poste;
	private int nummaillot;
//@JsonIgnore to ignore equipe in json postman
	
	@JsonIgnore
	@ManyToOne
	private Equipe equipe;
	
}

