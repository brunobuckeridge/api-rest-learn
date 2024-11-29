package br.bucker.bits.data.vo.v1;

import java.io.Serializable;
import java.util.Objects;

public class PersonVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Boolean ativo;
	private String firstName;
	private String lastName;
	private String address;
	private String gender;

	public PersonVO() {
		ativo = true;
	}

	public PersonVO(Long id, String firstName, String lastName, String address, String gender) {
		super();
		this.id = id;
		this.ativo = true;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.gender = gender;
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

	@Override
	public int hashCode() {
		return Objects.hash(address, ativo, firstName, gender, id, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonVO other = (PersonVO) obj;
		return Objects.equals(address, other.address) && Objects.equals(ativo, other.ativo)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(gender, other.gender)
				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName);
	}
}
