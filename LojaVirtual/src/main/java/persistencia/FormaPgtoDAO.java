package persistencia;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.FormaPgto;

public class FormaPgtoDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	public static void inserir(FormaPgto formaPgto) {
		Session sessao = HibernateUtil.getSessionfactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.save(formaPgto);
		t.commit();
		sessao.close();
	}

	public static void alterar(FormaPgto formaPgto) {
		Session sessao = HibernateUtil.getSessionfactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.update(formaPgto);
		t.commit();
		sessao.close();
	}

	public static void excluir(FormaPgto formaPgto) {
		Session sessao = HibernateUtil.getSessionfactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.delete(formaPgto);
		t.commit();
		sessao.close();
	}

	
	@SuppressWarnings("unchecked")
	public static List<FormaPgto> listagem(String filtro) {
		Session sessao = HibernateUtil.getSessionfactory().openSession();
		Query consulta;
		List<FormaPgto> lista = null;

		if (filtro.trim().length() == 0) {
			consulta = sessao.createQuery("from FormaPgto order by fgp_descricao");
		} else {
			consulta = sessao.createQuery("from FormaPgto where fgp_descricao like :parametro");
			consulta.setString("parametro", "%" + filtro + "%");
		}
		lista = consulta.list();
		sessao.close();
		return lista;
	}

	public static FormaPgto pesqId(int valor){
		Session sessao = HibernateUtil.getSessionfactory().openSession();
		Query consulta = sessao.createQuery("from FormaPgto where fgp_id = :parametro");
		consulta.setInteger("parametro", valor);
		sessao.close();
		return (FormaPgto) consulta.uniqueResult();
	}
}
