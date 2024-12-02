package br.bucker.bits.data.vo.v2;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class PersonVO2 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Boolean ativo;
	private String firstName;
	private String lastName;
	private String address;
	private String gender;
	
	//Adicionado ao V2
	private Date birthDay;
	
	public PersonVO2() {
		ativo = true;
	}

	public Long getId() {
		return id;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getGender() {
		return gender;
	}
	
	public Date getBirthDay() {
		return birthDay;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, ativo, birthDay, firstName, gender, id, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonVO2 other = (PersonVO2) obj;
		return Objects.equals(address, other.address) && Objects.equals(ativo, other.ativo)
				&& Objects.equals(birthDay, other.birthDay) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(gender, other.gender) && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName);
	}
}
