package br.com.mentoria.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * 
 * @author jmc
 *	
 *	check list para implementar uma entity:
 *	1) precisa implementar Serializable
 *	2) precisa ter construtor vazio
 *	3) precisar ter todos os get e sets
 *	4) add anotacoes apropriadas
 *	5) sobreescrever os methods equals e hashcode
 */

@Entity
@Table(name = "PERSON")
@SecondaryTable(name = "PERSON_DETAILS")
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@NotNull(message = "Name is required")
	@Column(name = "NAME", length = 50, nullable = false)
	private String name;
	
	@NotBlank(message = "Last Name is required")
	@Column(name = "LASTNAME", length = 50, nullable = false)
	private String lastName;
	
	@Column(table = "PERSON_DETAILS")
	private String address;
	
	@Column(table = "PERSON_DETAILS")
	private String addressComp;
	
	@ElementCollection
	@CollectionTable(name = "PERSON_PHONES")
	private Set<String> phones = new HashSet<>();

	public Person() {
	}
	
	

	public Person(Long id, String name,
			String lastName) {
		this.id= id;
		this.name = name;
		this.lastName = lastName;
	}


	

	public String getAddressComp() {
		return addressComp;
	}



	public void setAddressComp(String addressComp) {
		this.addressComp = addressComp;
	}



	public Set<String> getPhones() {
		return phones;
	}



	public void setPhones(Set<String> phones) {
		this.phones = phones;
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
