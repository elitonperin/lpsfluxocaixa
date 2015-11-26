import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import br.com.fluxocaixa.dao.NegocioDAO;
import br.com.fluxocaixa.model.Carteira;
import br.com.fluxocaixa.model.Categoria;
import br.com.fluxocaixa.model.CategoriaCredito;
import br.com.fluxocaixa.model.CategoriaDebito;
import br.com.fluxocaixa.model.CentroCusto;
import br.com.fluxocaixa.model.ContaCorrente;
import br.com.fluxocaixa.model.Despesa;
import br.com.fluxocaixa.model.FluxoCaixa;
import br.com.fluxocaixa.model.NaoRealizado;
import br.com.fluxocaixa.model.Realizado;
import br.com.fluxocaixa.model.Receita;
import br.com.fluxocaixa.model.UnidadeOrganizacional;

public class Principal 
{
	private static Scanner scanner;
	
	public static void main(String[] args) 
	{
		scanner = new Scanner(System.in);
		
		System.out.println("Oi, bem vindo ao sistema do G5");
		System.out.println("Escolha uma opção abaixo:");
		
		switch(panelSystem())
		{
		case 1:
			break;
		}
		
	}
	
	
	private static int panelSystem() 
	{
		// TODO Auto-generated method stub
		System.out.println("01 - Cadastrar Centros de Custos");
		System.out.println("02 - Cadastrar Fornecedores");
		System.out.println("03 - Cadastrar Cliente");
		System.out.println("04 - Cadastrar Unidades Organizacionais");
		System.out.println("05 - Cadastrar Carteiras/Contas Bancarias");
		System.out.println("06 - Cadastrar Categorias de Despesas");
		System.out.println("07 - Cadastrar Categorias de Receitas");
		System.out.println("08 - Cadastrar Usuário");
		System.out.println("09 - Cadastrar Despesa");
		System.out.println("10 - Cadastrar Receita");
		
		String s = scanner.nextLine();
		int i = Integer.parseInt(s);
		
		return i;
				
	}


	void exemploListarMovimentos(){
		NegocioDAO negocio = new NegocioDAO();  
		List<Despesa> lista = negocio.listarDespesas(new Date(), new Date(), "");
		for(Despesa d: lista){
			System.out.println(d);
		}
		
		List<Receita> ls = negocio.listarReceitas();
		for(Receita r: ls){
			System.out.println(r);
		}
	}
	
	static void exemploCategoriaCredito(){
		NegocioDAO negocio = new NegocioDAO(); 
		
		Categoria categoria = new CategoriaCredito();
		categoria.setNome("Salário");
	    categoria.setDescricao("Salário mensal"); 
		categoria.setPai(null);

		negocio.salvarGenerico(categoria);
	}
	
	static void exemploCategoriaDebito(){
		NegocioDAO negocio = new NegocioDAO(); 
		
		Categoria categoria = new CategoriaDebito();
		categoria.setNome("Conta de água");
	    categoria.setDescricao("Conta mensal de águal (Sanesul)"); 
		categoria.setPai(null);

		negocio.salvarGenerico(categoria);
	}
	
	static void exemploReceita(){
		NegocioDAO negocio = new NegocioDAO(); 
		
		//aqui tem que negar quando for categoria debito
		Receita receita = new Receita();
		receita.setCategoria(new CategoriaCredito());
		receita.getCategoria().setNome("Vendas");
		receita.getCategoria().setDescricao("Vendas gerais");
		
		receita.setData(new Date());
		receita.setNumeroParcela(1);
		receita.setValor(new Float(250));
		receita.setObservacao("venda para cliente prazo de 1 mês");
		
		NaoRealizado estado = new NaoRealizado();
		estado.setMovimentacao(receita);
		estado.setData(new Date());
		
		Carteira conta = new Carteira();
		conta.setNome("Carteira Jean");
		conta.setDescricao("Carteira local");
		
		List<CentroCusto> custos = new ArrayList<CentroCusto>(1);
		custos.add(conta);
		receita.setCentrosCusto(custos);
		
		negocio.inserirReceitas(receita, estado);
	}
	
	static void exemploDespesa(){
		NegocioDAO negocio = new NegocioDAO(); 
		
		Despesa despesa = new Despesa();
		CategoriaDebito categoria = (CategoriaDebito) negocio.getById(CategoriaDebito.class, 1);
		ContaCorrente cc = (ContaCorrente) negocio.getById(ContaCorrente.class, 1);
		
		despesa.setCategoria(categoria);
		
		despesa.setData(new Date());
		despesa.setNumeroParcela(1);
		despesa.setValor(new Float(65.90));
		despesa.setObservacao("Pagamento refernte ao fluxo geral");
		
		Realizado estado = new Realizado();
		estado.setMovimentacao(despesa);
		estado.setData(new Date());
		
		List<CentroCusto> custos = new ArrayList<CentroCusto>(1);
		custos.add(cc);
		despesa.setCentrosCusto(custos);
		
		negocio.inserirDespesas(despesa, estado);
	}
	
	static void exemploCentrosDeCusto(){
		NegocioDAO dao = new NegocioDAO();
		
		CentroCustoG5 centroCustoG5 = new CentroCustoG5();
	}

}
