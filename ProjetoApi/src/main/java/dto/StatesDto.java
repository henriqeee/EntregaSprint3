package dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.ProjetoApi.repository.StatesRepository;

public class StatesDto {
	@Entity
	public class States {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column(nullable = false)
		private String nome;
		
		
		private String regiao;
		
		private int populacao;
		
		private String capital;
		
		private float area;
		
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getRegiao() {
			return regiao;
		}
		public void setRegiao(String regiao) {
			this.regiao = regiao;
		}
		public int getPopulacao() {
			return populacao;
		}
		public void setPopulacao(int populacao) {
			this.populacao = populacao;
		}
		public String getCapital() {
			return capital;
		}
		public void setCapital(String capital) {
			this.capital = capital;
		}
		public float getArea() {
			return area;
		}
		public void setArea(float area) {
			this.area = area;
		}
		public States converter(StatesRepository statesRepository) {
			// TODO Auto-generated method stub
			return null;
		}
	}
}
