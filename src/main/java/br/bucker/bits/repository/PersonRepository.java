package br.bucker.bits.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.bucker.bits.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}