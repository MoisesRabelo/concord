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
@Table(name = "adventure")
public class Adventure 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private User users_id;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "my_adventures",
			joinColumns = @JoinColumn(
		            name = "adventure_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
				            name = "users_id", referencedColumnName = "id"))
    private Collection<User> myAdventures;
    
    
    public Adventure(){    	
    }
    
    public Adventure(String name, Collection<User> myAdventures)
    {
    	super();
    	this.name = name;
    	this.myAdventures = myAdventures;
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

	public Collection<User> getMyAdventures() {
		return myAdventures;
	}

	public void setMyAdventures(Collection<User> myAdventures) {
		this.myAdventures = myAdventures;
	}    
}
