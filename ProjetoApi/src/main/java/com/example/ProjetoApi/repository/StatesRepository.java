package com.example.ProjetoApi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import states.States;

public interface StatesRepository extends JpaRepository <States, Long> {

	<S> S save(States states);

	Optional<States> findById(Long id);



}
