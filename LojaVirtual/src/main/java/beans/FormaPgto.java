package beans;

import javax.persistence.*;

@Entity
@Table (name="forma_pgto")
public class FormaPgto {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "fgp_id")
	private int id;
	@Column(name = "fgp_descricao", length = 20, nullable= true)
	private String descricao;
	@Column(name = "fgp_num_max_parc", nullable = true)
	private int numMaxParc;
	@Column(name = "fgp_num_padrao_parc", nullable = true)
	private int numPadraoParc;
	@Column(name = "fgp_intervalo_dias", nullable = true)
	private int intervaloDias;
	@Column(name = "fgp_percentual_acres", nullable = true)
	private float percentualAcres;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getNumMaxParc() {
		return numMaxParc;
	}
	public void setNumMaxParc(int numMaxParc) {
		this.numMaxParc = numMaxParc;
	}
	public int getNumPadraoParc() {
		return numPadraoParc;
	}
	public void setNumPadraoParc(int numPadraoParc) {
		this.numPadraoParc = numPadraoParc;
	}
	public int getIntervaloDias() {
		return intervaloDias;
	}
	public void setIntervaloDias(int intervaloDias) {
		this.intervaloDias = intervaloDias;
	}
	public float getPercentualAcres() {
		return percentualAcres;
	}
	public void setPercentualAcres(float percentualAcres) {
		this.percentualAcres = percentualAcres;
	}
	
	
}
