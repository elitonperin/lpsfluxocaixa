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
import br.com.fluxocaixa.model.ClienteFisico;
import br.com.fluxocaixa.model.ClienteJuridico;
import br.com.fluxocaixa.model.ContaCorrente;
import br.com.fluxocaixa.model.Despesa;
import br.com.fluxocaixa.model.FluxoCaixa;
import br.com.fluxocaixa.model.FornecedorFisico;
import br.com.fluxocaixa.model.FornecedorJuridico;
import br.com.fluxocaixa.model.NaoRealizado;
import br.com.fluxocaixa.model.Realizado;
import br.com.fluxocaixa.model.Receita;
import br.com.fluxocaixa.model.UnidadeOrganizacional;

public class Principal 
{
	private static Scanner scanner;
	static int idMetodoOpcoesSistema = 0;
	static int idMetodoCadastrarCentrosDeCustos = 1;
	
	public static void main(String[] args) 
	{
		scanner = new Scanner(System.in);
		
		System.out.println("Oi, bem vindo ao sistema do G5");
		
		opcoesSistema();
		
	}
	
	
	private static void opcoesSistema() {
		// TODO Auto-generated method stub
		switch(painelDoSistema())
		{
		case 0:
			
			break;
		case 1:
			cadastrarCentrosDeCustos();
			break;
		case 2:
			cadastrarFornecedores(idMetodoOpcoesSistema);
			break;
		case 3:
			cadastrarCliente();
			break;
		case 4:
			cadastrarUnidadeOrganizacional();
			break;
		case 5:
			cadastrarCarteiraContaBancaria();
			break;
		case 6:
			cadastrarCategoriasDeDespesa();
			break;
		case 7:
			cadastrarCategoriaDeReceita();
			break;
		case 8:
			cadastrarUsuario();
			break;
		case 9:
			cadastrarDespesa();
			break;
		case 10:
			cadastrarReceita();
			break;
			
		default:
			System.out.println("Opção inválida.");
			opcoesSistema();
			break;
		}
	}


	private static void cadastrarReceita() {
		// TODO Auto-generated method stub
		
	}


	private static void cadastrarDespesa() {
		// TODO Auto-generated method stub
		
	}


	private static void cadastrarUsuario() {
		// TODO Auto-generated method stub
		
	}


	private static void cadastrarCategoriaDeReceita() {
		// TODO Auto-generated method stub
		
	}


	private static void cadastrarCarteiraContaBancaria() {
		// TODO Auto-generated method stub
		
	}


	private static void cadastrarCategoriasDeDespesa() {
		// TODO Auto-generated method stub
		
	}


	private static void cadastrarUnidadeOrganizacional() {
		// TODO Auto-generated method stub
		
	}


	private static void cadastrarCliente() {
		// TODO Auto-generated method stub
		System.out.println("Selecione o tipo de cliente:");
		System.out.println("");
		System.out.println("01-Cliente Juridico");
		System.out.println("02-Cliente Físico");
		System.out.println("03-Voltar");
		System.out.println("0-Sair");
		
		String s = scanner.nextLine();
		int i = Integer.parseInt(s);
		
		switch(i)
		{
		case 0:
			System.exit(0);
			break;
		case 1:
			ClienteJuridico clienteJuridico = new ClienteJuridico();
			System.out.println("Nome:");
			clienteJuridico.setNome(scanner.nextLine());
			System.out.println("CNPJ:");
			clienteJuridico.setCnpj(scanner.nextLine());
			System.out.println("Descrição:");
			clienteJuridico.setDescricao(scanner.nextLine());
			System.out.println("Telefone:");
			clienteJuridico.setTelefone(scanner.nextLine());
			System.out.println("Cidade:");
			clienteJuridico.setCidade(scanner.nextLine());
			System.out.println("Bairro:");
			clienteJuridico.setBairro(scanner.nextLine());
			System.out.println("CEP:");
			clienteJuridico.setCep(scanner.nextLine());
			System.out.println("Rua:");
			clienteJuridico.setRua(scanner.nextLine());
			System.out.println("Número:");
			clienteJuridico.setNumero(scanner.nextLine());
			
			NegocioDAO dao = new NegocioDAO();
			dao.salvarGenerico(clienteJuridico);			
			
			break;
		case 2:
			System.out.println("Forneça os dados para cadastro:");
			ClienteFisico clienteFisico = new ClienteFisico();
			System.out.println("Nome:");
			clienteFisico.setNome(scanner.nextLine());
			System.out.println("CPF:");
			clienteFisico.setCpf(scanner.nextLine());
			System.out.println("Descrição:");
			clienteFisico.setDescricao(scanner.nextLine());
			System.out.println("Telefone:");
			clienteFisico.setTelefone(scanner.nextLine());
			System.out.println("Cidade:");
			clienteFisico.setCidade(scanner.nextLine());
			System.out.println("Bairro:");
			clienteFisico.setBairro(scanner.nextLine());
			System.out.println("CEP:");
			clienteFisico.setCep(scanner.nextLine());
			System.out.println("Rua:");
			clienteFisico.setRua(scanner.nextLine());
			System.out.println("Número:");
			clienteFisico.setNumero(scanner.nextLine());
			
			NegocioDAO dao1 = new NegocioDAO();	
			dao1.salvarGenerico(clienteFisico);
			break;
		case 3:
			break;
		default:
			break;
		}
		
		
	}


	private static void cadastrarFornecedores(int idMetodo) {
		// TODO Auto-generated method stub
		System.out.println("Selecione o tipo de fornecedor:");
		System.out.println("");
		System.out.println("01-Fornecedor Juridico");
		System.out.println("02-Fornecedor Físico");
		System.out.println("03-Voltar");
		System.out.println("0-Sair");
		
		String s = scanner.nextLine();
		int i = Integer.parseInt(s);
		
		switch(i)
		{
		case 0:
			System.exit(0);
			break;
		case 1:
			System.out.println("Forneça os dados para cadastro:");
			FornecedorJuridico fornecedorJuridico = new FornecedorJuridico();
			System.out.println("Nome:");
			fornecedorJuridico.setNome(scanner.nextLine());
			System.out.println("CNPJ:");
			fornecedorJuridico.setCnpj(scanner.nextLine());
			System.out.println("Descrição:");
			fornecedorJuridico.setDescricao(scanner.nextLine());
			System.out.println("Telefone:");
			fornecedorJuridico.setTelefone(scanner.nextLine());
			System.out.println("Cidade:");
			fornecedorJuridico.setCidade(scanner.nextLine());
			System.out.println("Bairro:");
			fornecedorJuridico.setBairro(scanner.nextLine());
			System.out.println("CEP:");
			fornecedorJuridico.setCep(scanner.nextLine());
			System.out.println("Rua:");
			fornecedorJuridico.setRua(scanner.nextLine());
			System.out.println("Número:");
			fornecedorJuridico.setNumero(scanner.nextLine());

			NegocioDAO dao = new NegocioDAO();	
			dao.salvarGenerico(fornecedorJuridico);
			
			break;
		case 2:
			System.out.println("Forneça os dados para cadastro:");
			FornecedorFisico fornecedorFisico = new FornecedorFisico();
			System.out.println("Nome:");
			fornecedorFisico.setNome(scanner.nextLine());
			System.out.println("CPF:");
			fornecedorFisico.setCpf(scanner.nextLine());
			System.out.println("Descrição:");
			fornecedorFisico.setDescricao(scanner.nextLine());
			System.out.println("Telefone:");
			fornecedorFisico.setTelefone(scanner.nextLine());
			System.out.println("Cidade:");
			fornecedorFisico.setCidade(scanner.nextLine());
			System.out.println("Bairro:");
			fornecedorFisico.setBairro(scanner.nextLine());
			System.out.println("CEP:");
			fornecedorFisico.setCep(scanner.nextLine());
			System.out.println("Rua:");
			fornecedorFisico.setRua(scanner.nextLine());
			System.out.println("Número:");
			fornecedorFisico.setNumero(scanner.nextLine());
			
			NegocioDAO dao1 = new NegocioDAO();	
			dao1.salvarGenerico(fornecedorFisico);
			
			break;
		case 3:
			if(idMetodo == idMetodoOpcoesSistema)
				opcoesSistema();
			else if(idMetodo == idMetodoCadastrarCentrosDeCustos)
				cadastrarCentrosDeCustos();
			else 
				System.exit(0);
			break;
		default:
			System.out.println("Insira uma opção válida.");
			cadastrarFornecedores(idMetodo);
			break;
		}
		
	}


	private static void cadastrarCentrosDeCustos() {
		// TODO Auto-generated method stub
		
		System.out.println("Selecione o tipo de Centro de Custo para ser inserido:");
		System.out.println("");
		System.out.println("01-Conta");
		System.out.println("02-Unidade Organizacional");
		System.out.println("03-Cliente");
		System.out.println("04-Fornecedor");
		System.out.println("05-Voltar");
		System.out.println("0-Sair");
		
		String s = scanner.nextLine();
		int i = Integer.parseInt(s);
		
		switch(i)
		{
		case 0:
			break;
		case 1: //Conta
			cadastrarConta();
			break;
		case 2: //Unidade Organizacional
			cadastrarUnidadeOrganizacional();
			break;
		case 3: //Cliente
			cadastrarCliente();
			break;
		case 4:
			cadastrarFornecedores(idMetodoCadastrarCentrosDeCustos);
			break;
		case 5:
			opcoesSistema();
			break;
		default:
			System.out.println("Escolha uma opção válida.");
			cadastrarCentrosDeCustos();
			break;
		}
	}


	private static void cadastrarConta() {
		// TODO Auto-generated method stub
		System.out.println("Selecione o tipo de Conta que deseja Cadastrar: ");
		System.out.println("");
		System.out.println("01-Conta Corrente");
		System.out.println("02-Caixa");
		System.out.println("03-Cartão de Crédito");
		System.out.println("04-Carteira");
		System.out.println("05-Voltar");
		System.out.println("0-Sair");
		
		String s = scanner.nextLine();
		int i = Integer.parseInt(s);
		
		switch(i)
		{
		case 0:
			break;
		case 1: //Conta Corrente
			System.out.println("Forneça os dados para cadastro:");
			System.out.println("Banco:");
			String banco = scanner.nextLine();
			System.out.println("Descrição da Conta");
			String descricao = scanner.nextLine();
			System.out.println("Nome");
			String nome = scanner.nextLine();
			System.out.println("Número");
			String numero = scanner.nextLine();

			ContaCorrente contaCorrente = new ContaCorrente();
			contaCorrente.setBanco(banco);
			contaCorrente.setDescricao(descricao);
			contaCorrente.setNome(nome);
			contaCorrente.setNumero(numero);
			
			NegocioDAO dao = new NegocioDAO();
			dao.salvarGenerico(contaCorrente);
						
			break;
		case 2: //Caixa
			break;
		case 3: //Cartão de Crédito
			break;
		case 4: //Carteira
			break;
		case 5:
			cadastrarCentrosDeCustos();
			break;
		default:
			System.out.println("Escolha uma opção válida.\n");
			cadastrarConta();
			break;
		}
	}


	private static int painelDoSistema() 
	{
		// TODO Auto-generated method stub

		System.out.println("Escolha uma opção abaixo:");
		
		System.out.println("01 - Cadastrar Centro de Custo");
		System.out.println("02 - Cadastrar Fornecedores");
		System.out.println("03 - Cadastrar Cliente");
		System.out.println("04 - Cadastrar Unidade Organizacional");
		System.out.println("05 - Cadastrar Carteira/Conta Bancaria");
		System.out.println("06 - Cadastrar Categorias de Despesa");
		System.out.println("07 - Cadastrar Categorias de Receita");
		System.out.println("08 - Cadastrar Usuário");
		System.out.println("09 - Cadastrar Despesa");
		System.out.println("10 - Cadastrar Receita");
		System.out.println("0 - Sair");
		
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
	

}
