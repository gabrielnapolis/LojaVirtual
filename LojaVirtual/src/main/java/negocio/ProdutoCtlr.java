package negocio;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import beans.Produto;
import persistencia.ProdutoDAO;

@ManagedBean (name = "viewProduto")
@SessionScoped
public class ProdutoCtlr implements Serializable {

	private static final long serialVersionUID = 1L;

	private Produto produto = new Produto();

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto ;
	}

	public List<Produto> getListagem() { 
		String filtro = "";
		return ProdutoDAO.listagem(filtro);
	}

	public String actionGravar() {
		if (produto.getId() == 0) {
			ProdutoDAO.inserir(produto);
			return "lista_produto";
		} else {
			ProdutoDAO.alterar(produto);
		}
		return "lista_produto";
	}

	public String actionInserir(){
		produto = new Produto();
		return "/admin/lista_produto";
	}
	
	public String actionExcluir(){
		ProdutoDAO.excluir(produto);
		return "/admin/lista_produto";
	}
	
}

