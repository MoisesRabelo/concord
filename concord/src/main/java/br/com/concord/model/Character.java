package br.com.concord.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "character")
public class Character
{	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String classe;
    
    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private User users_id;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "my_characters",
			joinColumns = @JoinColumn(
		            name = "character_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
				            name = "users_id", referencedColumnName = "id"))
    private Collection<User> myCharacters;
    
    public Character() {
    }
    
    public Character(String name, String classe, Collection<User> myCharacters) {
    	super();
    	this.name = name;
    	this.classe = classe;
    	this.myCharacters = myCharacters;
    }
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public Collection<User> getMyCharacters() {
		return myCharacters;
	}

	public void setMyCharacters(Collection<User> myCharacters) {
		this.myCharacters = myCharacters;
	}    
}
