package br.bucker.bits.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.bucker.bits.data.vo.v2.PersonVO2;
import br.bucker.bits.model.Person;

@Service
public class PersonMapper {
	
	public PersonVO2 convertEntityToVO (Person person) {
		PersonVO2 vo = new PersonVO2();
		vo.setId(person.getId());
		vo.setAtivo(person.getAtivo());
		vo.setFirstName(person.getFirstName());
		vo.setLastName(person.getLastName());
		vo.setAddress(person.getAddress());
		vo.setGender(person.getGender());
		vo.setBirthDay(new Date());
		
		return vo;
	}
	
	public Person convertVOtoEntity (PersonVO2 vo) {
		Person entity = new Person();
		entity.setId(vo.getId());
		entity.setAtivo(vo.getAtivo());
		entity.setFirstName(vo.getFirstName());
		entity.setLastName(vo.getLastName());
		entity.setAddress(vo.getAddress());
		entity.setGender(vo.getGender());
		
		return entity;
	}
}
