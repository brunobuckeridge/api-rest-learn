package br.bucker.bits.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.bucker.bits.data.vo.v1.PersonVO;
import br.bucker.bits.exceptions.ResourceNotFoundException;
import br.bucker.bits.mapper.DozerMapper;
import br.bucker.bits.model.Person;
import br.bucker.bits.repository.PersonRepository;

@Service
public class PersonServices {

	private static final boolean PERSISTIDO = true;

	// Mock
	private static final boolean DEBUG = false;
	private final AtomicLong counter = new AtomicLong();
	private static final int NUM_LIST_MOCK = 5;

	private Logger logger = Logger.getLogger(this.getClass().getName());

	@Autowired
	private PersonRepository repository;

	public List<PersonVO> findAll() {
		logger.info("Procurando por todos.");

		if (DEBUG) {
			List<PersonVO> persons = new ArrayList<>();
			populaMockList(persons, NUM_LIST_MOCK);
			return persons;
		}

		return DozerMapper.parseListObjects(repository.findAll().stream().filter(p -> p.getAtivo() == true).toList(), PersonVO.class);
	}

	public PersonVO findById(Long id) {
		logger.info("Procurando por ID: " + id);

		if (DEBUG) {
			PersonVO person = new PersonVO();
			populaMock(person, Integer.parseInt(id.toString()));
			return person;
		}

		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Sem registro para o ID: " + id));	
		
		if (PERSISTIDO) {
			return DozerMapper.parseObject(entity, PersonVO.class);			
		} else {
			if (entity.getAtivo()) {
	            return DozerMapper.parseObject(entity, PersonVO.class);
	        } else {
	            throw new ResourceNotFoundException("Sem registro para o ID: " + id);
	        }
		}
	}

	public PersonVO create(PersonVO person) {
		logger.info("Criando pessoa com ID: " + person.getId());
		
		if (DEBUG) {
			return person;
		}
		
		Person entity = DozerMapper.parseObject(person, Person.class);
		
		return DozerMapper.parseObject(repository.save(entity), PersonVO.class);
	}

	public PersonVO update(PersonVO person) {
		logger.info("Update de pessoa com ID: " + person.getId());

		if (DEBUG) {
			return person;
		}
		
		Person entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Sem registro para o ID: " + person.getId()));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		return DozerMapper.parseObject(repository.save(entity), PersonVO.class);
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

	//Para DEBUG
	private void populaMockList(List<PersonVO> persons, int numeroDeLista) {
		for (int i = 1; i <= numeroDeLista; i++) {
			PersonVO person = new PersonVO();
			populaMock(person, i);
			persons.add(person);
		}
	}

	//Para DEBUG
	private void populaMock(PersonVO person, int i) {
		person.setId(counter.incrementAndGet());
		person.setFirstName("Aplicação " + i);
		person.setLastName("Cursando Teste");
		person.setAddress("Rua Teste, " + i + " - Curitiba, PR");
		person.setGender("Male");
	}
}
