package negocio;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import beans.Pessoa;
import persistencia.PessoaDAO;

@ManagedBean(name = "viewPessoa")
@SessionScoped
public class PessoaCtlr implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa = new Pessoa();
	private String filtro = "";
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	
	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public List<Pessoa> getListagem() {
		return PessoaDAO.listagem(filtro);
	}

	public String actionGravar() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		if (pessoa.getId() == 0) {
			PessoaDAO.inserir(pessoa);
			context.addMessage(null, new FacesMessage("Sucesso", "Inserido com sucesso!"));
		} else {
			PessoaDAO.alterar(pessoa);
			context.addMessage(null, new FacesMessage("Sucesso", "Alterado com sucesso!"));

		}
		return "/publico/lista_pessoa";
	}

	public String actionInserir() {
		pessoa = new Pessoa();
		return "/publico/lista_pessoa";
	}

	public String actionExcluir() {
		PessoaDAO.excluir(pessoa);
		return "/publico/lista_pessoa";
	}
	
	

}
