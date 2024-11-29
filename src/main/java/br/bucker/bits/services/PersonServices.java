package br.bucker.bits.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.bucker.bits.exceptions.ResourceNotFoundException;
import br.bucker.bits.model.Person;
import br.bucker.bits.repository.PersonRepository;

@Service
public class PersonServices {

	private static final boolean DEBUG = false;
	private static final boolean PERSISTIDO = true;

	// Mock
	private final AtomicLong counter = new AtomicLong();
	private static final int NUM_LIST_MOCK = 8;

	private Logger logger = Logger.getLogger(this.getClass().getName());

	@Autowired
	private PersonRepository repository;

	public List<Person> findAll() {
		logger.info("Procurando por todos.");

		if (DEBUG) {
			List<Person> persons = new ArrayList<>();
			populaMockList(persons, NUM_LIST_MOCK);
			return persons;
		}

		return repository.findAll().stream().filter(p -> p.getAtivo() == true).toList();
	}

	public Person findById(Long id) {
		logger.info("Procurando por ID: " + id);

		if (DEBUG) {
			Person person = new Person();
			populaMock(person, Integer.parseInt(id.toString()));
			return person;
		}

		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Sem registro para o ID: " + id));	
		
		if (PERSISTIDO) {
			return entity;			
		} else {
			if (entity.getAtivo()) {
	            return entity;
	        } else {
	            throw new ResourceNotFoundException("Sem registro para o ID: " + id);
	        }
		}
	}

	public Person create(Person person) {
		logger.info("Criando pessoa com ID: " + person.getId());
		
		if (DEBUG) {
			return person;
		}

		return repository.save(person);
	}

	public Person update(Person person) {
		logger.info("Update de pessoa com ID: " + person.getId());

		if (DEBUG) {
			return person;
		}
		
		Person entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Sem registro para o ID: " + person.getId()));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAdress(person.getAdress());
		entity.setGender(person.getGender());

		return repository.save(entity);
	}
	
	// Em casos onde não é delicado a exclusão dos dados pode ser usado o delete
	// direto. No caso de persistencia de dados não permitindo delete. Usa-se o
	// campo ATIVO.
	public void delete(Long id) {
		logger.info("Deletando pessoa com ID: " + id);

		if (DEBUG) {
			return;
		}
		
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Sem registro para o ID: " + id));

		if (PERSISTIDO) {
			entity.setAtivo(false);
			repository.save(entity);
		} else {
			repository.delete(entity);
		}
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
