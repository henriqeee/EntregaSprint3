package StatesController;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.ProjetoApi.repository.StatesRepository;

import dto.StatesDto;
import states.States;

@RestController
@RequestMapping("/api/states")
public class statesController {
	
	
	@Autowired
	private StatesRepository statesRepository;
	@PostMapping
	@Transactional
	public ResponseEntity<StatesDto> cadastrar(@RequestBody @Validated States form, UriComponentsBuilder uriBuilder) {
		States states = form.converter(statesRepository);
		statesRepository.save(states);
		
		URI uri = uriBuilder.path("/states/{id}").buildAndExpand(states.getId()).toUri();
		return ResponseEntity.created(uri).body(new StatesDto(states));
	}
	
	
	@GetMapping()
	public ResponseEntity<DetalhesStates> detalhar(@PathVariable Long id) {
		Optional<States> states = statesRepository.findById(id);
		if (states.isPresent()) {
			return ResponseEntity.ok();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesStates> detalhar(@PathVariable Long id) {
		Optional<States> states = statesRepository.findById(id);
		if (states.isPresent()) {
			return ResponseEntity.ok(new DetalhesDoTopicoDto(states.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<States> atualizar(@PathVariable Long id, @RequestBody @Validated AtualizacaoStates form) {
		Optional<States> optional = statesRepository.findById(id);
		if (optional.isPresent()) {
			States states = form.atualizar(id, statesRepository);
			return ResponseEntity.ok(new States(states));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<States> optional = statesRepository.findById(id);
		if (optional.isPresent()) {
			Repository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}


}



