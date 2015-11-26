package br.com.fluxocaixa.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name="tipo",
        discriminatorType=DiscriminatorType.STRING
)
public abstract class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String nome;
	
	@Column(name="descricao", unique=true)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="plano_conta_id", nullable=true)
	private Categoria pai;
	
	@OneToMany(mappedBy = "pai", targetEntity = Categoria.class
			, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Categoria> filhos;
	
	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public Categoria getPai() {
		return pai;
	}

	public List<Categoria> getFilhos() {
		return filhos;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setPai(Categoria pai) {
		this.pai = pai;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + "]";
	}	
}