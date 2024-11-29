package br.bucker.bits.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.bucker.bits.model.Person;

@Service
public class PersonServices {
	
	private static final int NUM_LIST_MOCK = 8;
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(this.getClass().getName());

	public Person findById(String id) {
		logger.info("Procurando por ID: "+ id);
		
		Person person = new Person();		
		populaMock(person, Integer.parseInt(id));
		
		return person;		
	}
	
	public List<Person> findAll() {
		logger.info("Procurando por todos.");
		
		List<Person> persons = new ArrayList<>();
		populaMockList(persons, NUM_LIST_MOCK);
		
		return persons;		
	}
	
	public Person create(Person person) {
		logger.info("Criando pessoa com ID: "+ person.getId());
				
		return person;		
	}
	
	public Person update(Person person) {
		logger.info("Update de pessoa com ID: "+ person.getId());
				
		return person;		
	}
	
	public void delete(String id) {
		logger.info("Deletando pessoa com ID: "+ id);
	}

	private void populaMockList(List<Person> persons, int numeroDeLista) {
		for (int i = 0; i < numeroDeLista; i++) {
			Person person = new Person();
			populaMock(person, i);
			persons.add(person);
		}
	}

	private void populaMock(Person person, int i) {
		person.setId(counter.incrementAndGet());
		person.setFirstName("Aplicação " + i);
		person.setLastName("Cursando Teste");
		person.setAdress("Rua Teste, " + i + " - Curitiba, PR");
		person.setGender("Male");
	}
}
