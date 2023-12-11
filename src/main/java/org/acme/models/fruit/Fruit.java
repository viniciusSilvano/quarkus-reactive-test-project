package org.acme.models.fruit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Fruit {
	
	@Id
	@SequenceGenerator(name="fruit_seq", sequenceName="fruit_seq", allocationSize=1)
	@GeneratedValue(generator = "fruit_seq",strategy = GenerationType.SEQUENCE)
	@Column(name="id_fruit",updatable = false)
	private Long id;
	private String name;
	private String description;

    public Fruit() {
    }

    public Fruit(String name, String description) {
        this.name = name;
        this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
    
}
