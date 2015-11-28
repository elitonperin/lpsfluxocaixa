package br.com.fluxocaixa.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.mysql.fabric.xmlrpc.base.Data;

import br.com.fluxocaixa.model.Categoria;
import br.com.fluxocaixa.model.CategoriaCredito;
import br.com.fluxocaixa.model.CategoriaDebito;
import br.com.fluxocaixa.model.CentroCusto;
import br.com.fluxocaixa.model.Despesa;
import br.com.fluxocaixa.model.FluxoCaixa;
import br.com.fluxocaixa.model.Realizado;
import br.com.fluxocaixa.model.Receita;
import br.com.fluxocaixa.model.Status;
import br.com.fluxocaixa.util.Conexao;

public class NegocioDAO {

	private Session session = Conexao.getInstance();;
	private Transaction tx = null;
	
	public void salvarGenerico(Object object) {

		try {
			tx = session.beginTransaction();
			session.save(object);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
	}
	
	public void excluirGenerico(Object object) {
		try {
			tx = session.beginTransaction();
			session.delete(object);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
	}
	
	public void inserirReceitas(Receita receita, Status estado) {
		
		if(estado == null){
			System.out.println("Estado da receita inválido");
			return;
		}
		
		if(receita.getCentrosCusto().isEmpty()){
			System.out.println("Nenhum centro de custo foi selecionado");
			return;
		}
		
		if(receita.getCategoria() == null){
			System.out.println("Categoria da receita precisa ser selecionada");
			return;
		}
		
		if(estado instanceof Realizado &&  estado.getData().compareTo(new Date()) > 0){
			System.out.println("Data de pagamento inválida");
			return;
		}
		
		if(receita.getValor() <= 0){
			System.out.println("Valor inválido");
			return;
		}
		
		if(receita.getNumeroParcela() <= 0){
			System.out.println("Número de parcelas inválido");
			return;
		}
		receita.setStatus(estado);
		salvarGenerico(receita);
	}
	
	public void inserirDespesas(Despesa despesa, Status estado) {
		
		if(estado == null){
			System.out.println("Estado da despesa inválido");
			return;
		}
		
		if(despesa.getCentrosCusto().isEmpty()){
			System.out.println("Nenhum centro de custo foi selecionado");
			return;
		}
		
		if(despesa.getCategoria() == null){
			System.out.println("Categoria da despesa precisa ser selecionada");
			return;
		}
		
		if(estado instanceof Realizado &&  estado.getData().compareTo(new Date()) > 0){
			System.out.println("Data de pagamento inválida");
			return;
		}
		
		if(despesa.getValor() <= 0){
			System.out.println("Valor inválido");
			return;
		}
		
		if(despesa.getNumeroParcela() <= 0){
			System.out.println("Número de parcelas inválido");
			return;
		}
		
		if(despesa.getNumeroParcela() == null ||
		   despesa.getData() == null ||
		   despesa.getValor() == null){
			System.out.println("Há um ou mais campo(s) obrigatório(s) não preenchido(s)");
			return;
		}
		
		salvarGenerico(despesa);
		System.out.println("Nova despesa salva com sucesso");
	}

	public void alterarDespesas(Despesa despesa, Status novoEstado){
    	despesa.setStatus(novoEstado);
    	salvarGenerico(despesa);
    	System.out.println("Despesa editada com sucesso");
    }
    
    public void excluirDespesas(Despesa despesa){
    	excluirGenerico(despesa);
    	System.out.println("Despesa excluída com sucesso");
    }
    
    public void alterarReceitas(Receita receita, Status novoEstado){
    	receita.setStatus(novoEstado);
    	salvarGenerico(receita);
    	System.out.println("Receita editada com sucesso");
    }
    
    public void excluirReceitas(Receita receita){
    	excluirGenerico(receita);
    	System.out.println("Receita excluída com sucesso");
    }
    
	public List<CategoriaCredito> listarCategoriaReceitas(){
        return session.createCriteria(CategoriaCredito.class).list();
	}
	
	public List<CategoriaDebito> listarCategoriaDespesas(){
        return session.createCriteria(CategoriaDebito.class).list();
	}
	
	/*
	 * Aqui deverá ser estanciado conforme a necessidade do cliente
	 * Exemplo: se só faz credito de uma conta p/ um fornecedor a lista deve 
	 * retornar uma lista de contas e uma lista de fornecedores
	 */
	public List<CentroCusto> listaCentroCustoReceitas(){		
        return session.createCriteria(CentroCusto.class).list();
	}
	
	
	public List<CentroCusto> listarCentroCustoDespesas(){		
        return session.createCriteria(CentroCusto.class).list();
	}
	
	public List<Despesa> listarDespesas(Date data1, Date data2, String texto){
		return session.createCriteria(Despesa.class)
				.add(Restrictions.like("observacao", "%" + texto + "%"))
				.add(Restrictions.between("data", data1, data2))
				.addOrder(Order.asc("data"))
				.list();
	}
	
	public List<Receita> listarReceitas(){
		return session.createCriteria(Receita.class).list();
	}
	
	public Object getById(Class Object, Integer id){
		return session.get(Object, id);
	}
	
	public void close(){
		session.close();
	}
    
}
