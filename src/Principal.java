import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import br.com.fluxocaixa.model.ClienteFisicoEmail;
import br.com.fluxocaixa.model.ClienteJuridico;
import br.com.fluxocaixa.model.ClienteJuridicoEmail;
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
	
	
	public static void main(String[] args) throws ParseException 
	{
		scanner = new Scanner(System.in);
		
		System.out.println("Oi, bem vindo ao sistema do G5");
		
		opcoesSistema();
		
	}
	
	
	private static void opcoesSistema() throws ParseException {
		// TODO Auto-generated method stub
		switch(painelDoSistema())
		{
		case 0:
			
			break;
		/*case 1:
			cadastrarCentrosDeCustos();
			break;
		*/
		case 1:
			cadastrarFornecedores(idMetodoOpcoesSistema);
			break;
		case 2:
			cadastrarCliente();
			break;
		case 3:
			cadastrarUnidadeOrganizacional();
			break;
		case 4:
			cadastrarCarteiraContaBancaria();
			break;
		case 5:
			cadastrarCategoriaDeDespesa();
			break;
		case 6:
			cadastrarCategoriaDeReceita();
			break;
		case 7:
			cadastrarUsuario();
			break;
		case 8:
			cadastrarDespesa();
			break;
		case 9:
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
		NegocioDAO dao = new NegocioDAO();
		
	}


	private static void cadastrarDespesa() {
		// TODO Auto-generated method stub
		NegocioDAO negocio = new NegocioDAO(); 
		
		Despesa despesa = new Despesa();
		System.out.println("Lista de Categorias de Débito:");
		List<CategoriaDebito> listaCategoria = negocio.listarCategoriaDespesas();
		int i = 0;
		for(CategoriaDebito c : listaCategoria)
		{
			System.out.println(i + " : " + c.getNome());
			i++;
		}
		System.out.println("Selecione a categoria de despesa:");
		String s = scanner.nextLine();
		i = Integer.parseInt(s);
		despesa.setCategoria(listaCategoria.get(i));
				
		System.out.println("Lista de Centros de Custos:");
		List<CategoriaCredito> listaCentroCusto = negocio.listarCentroCustoDespesas();
		i = 0;
		for(CategoriaCredito c : listaCentroCusto)
		{
			System.out.println(i + " : " + c.getNome());
			i++;
		}
		System.out.println("Selecione o Centro de Custo:");
		s = scanner.nextLine();
		i = Integer.parseInt(s);
		
		
		List<CentroCusto> custos = new ArrayList<CentroCusto>(1);
		//custos.add(listaCentroCusto.get(i));
		despesa.setCentrosCusto(custos);
		
		System.out.println("Insira uma data:");
		despesa.setData(new Date());
		System.out.println("Insira a quantidade de parcelas:");
		despesa.setNumeroParcela(1);
		System.out.println("Insira o valor:");
		despesa.setValor(new Float(65.90));
		System.out.println("Insira uma observação:");
		despesa.setObservacao("Pagamento refernte ao fluxo geral");
		System.out.println("Lista de estados:");
		Realizado estado = new Realizado();
		estado.setMovimentacao(despesa);
		estado.setData(new Date());
		
		negocio.inserirDespesas(despesa, estado);
	}


	private static void cadastrarUsuario() {
		// TODO Auto-generated method stub
		
	}


	private static void cadastrarCarteiraContaBancaria() throws ParseException {

		Carteira carteira = new Carteira();
		
		System.out.println("Tipo de conta:");
		System.out.println("1 - cartão de crédito");
		System.out.println("2 - conta corrente");
		System.out.println("3 - conta poupança");
		System.out.println("4 - carteira");
		String tipoConta = scanner.nextLine();
		
		carteira.setTipoConta(tipoConta);
		
		System.out.println("Entre com o banco: ");
		String banco = scanner.nextLine();
		
		carteira.setBanco(banco);
		
		System.out.println("Entre com o número da conta");
		String numeroDaConta = scanner.nextLine();
		
		carteira.setNumeroDaConta(numeroDaConta);
		
		System.out.println("Entre com a agência:");
		String nomeDaAgencia = scanner.nextLine();
		
		carteira.setNomeDaAgencia(nomeDaAgencia);
		
		System.out.println("Entre com o gerente:");
		String gerente = scanner.nextLine();
		
		carteira.setGerente(gerente);
		
		System.out.println("Entre com o telefone:");
		String telefone = scanner.nextLine();
		
		carteira.setTelefone(telefone);
		
		System.out.println("Entre com o saldo inicial:");
		String saldoInicial = scanner.nextLine();
		float saldoInicialF = Float.parseFloat(saldoInicial);
		
		carteira.setSaldo(saldoInicialF);
		
		System.out.println("Entre com a dataDeVencimento:");
		String dataDeVencimentoString = scanner.nextLine();
		DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
		Date dataDeVencimentoDate = dateFormat.parse(dataDeVencimentoString);
		
		carteira.setDataDeVencimento(dataDeVencimentoDate);
		
		NegocioDAO dao = new NegocioDAO();	
		dao.salvarGenerico(carteira);
	}


	private static void cadastrarCategoriaDeDespesa()
	{
		
		System.out.println("Lista de categorias de despeza atual:");
		System.out.println("");
		NegocioDAO dao = new NegocioDAO();
		List<CategoriaDebito> list = dao.listarCategoriaDespesas();
		CategoriaDebito categoria = null;
		int i = 0;
		for(CategoriaDebito cd : list)
		{
			System.out.println(" " + i + " : " + cd.getNome());
			i++;
		}
		System.out.println("-1 : Para uma categoria nova, sem pai");
		System.out.println("");
		System.out.println("Escolha uma das opções acima para ser pai da nova categoria a ser criada.");		
		
		String s = scanner.nextLine();
		i = Integer.parseInt(s);
		
		if(i != -1 && i < list.size())
			categoria = list.get(i);
		
		cadastrarCategoriaDebito(categoria);
	}
	

	private static void cadastrarCategoriaDeReceita()
	{
		
		System.out.println("Lista de categorias de receita atual:");
		System.out.println("");
		NegocioDAO dao = new NegocioDAO();
		List<CategoriaCredito> list = dao.listarCategoriaReceitas();
		CategoriaCredito categoria = null;
		int i = 0;
		for(CategoriaCredito cd : list)
		{
			System.out.println(" " + i + " : " + cd.getNome());
			i++;
		}
		System.out.println("-1 : Para uma categoria nova, sem pai");
		System.out.println("");
		System.out.println("Escolha uma das opções acima para ser pai da nova categoria a ser criada.");		
		
		String s = scanner.nextLine();
		i = Integer.parseInt(s);
		
		if(i != -1 && i < list.size())
			categoria = list.get(i);
		
		cadastrarCategoriaCredito(categoria);		
	}


	private static void cadastrarUnidadeOrganizacional()
	{
		
		UnidadeOrganizacional unidadeOrganizacional = new UnidadeOrganizacional();
		
		System.out.println("Entre com o nome da Unidade Organizacional:");
		String nome = scanner.nextLine();
		unidadeOrganizacional.setNome(nome);
		
		System.out.println("Entre com o número externo:");
		String numeroExterno = scanner.nextLine();
		unidadeOrganizacional.setNumeroExterno(numeroExterno);
		
		System.out.println("Entre com o tipo de unidade:");
		String tipoUnidade = scanner.nextLine();
		unidadeOrganizacional.setTipoUnidade(tipoUnidade);
		
		
		System.out.println("Existe unidade pai? (S/N)");
		String existePai = scanner.nextLine().toUpperCase();
		
		
		if(existePai == "S")
		{
			unidadeOrganizacional.setUnidadePai(null);
		}
		else
		{
			unidadeOrganizacional.setUnidadePai(null);
		}
		
		
		NegocioDAO dao = new NegocioDAO();	
		dao.salvarGenerico(unidadeOrganizacional);
		
	}


	private static void cadastrarCliente()
	{
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
			ClienteJuridicoEmail clienteJuridico = new ClienteJuridicoEmail();
			System.out.println("Nome:");
			clienteJuridico.setNome(scanner.nextLine());
			System.out.println("CNPJ:");
			clienteJuridico.setCnpj(scanner.nextLine());
			System.out.println("Descrição:");
			clienteJuridico.setDescricao(scanner.nextLine());
			System.out.println("Telefone:");
			clienteJuridico.setTelefone(scanner.nextLine());
			System.out.println("Email:");
			clienteJuridico.setEmail(scanner.nextLine());
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
			ClienteFisicoEmail clienteFisico = new ClienteFisicoEmail();
			System.out.println("Nome:");
			clienteFisico.setNome(scanner.nextLine());
			System.out.println("CPF:");
			clienteFisico.setCpf(scanner.nextLine());
			System.out.println("Descrição:");
			clienteFisico.setDescricao(scanner.nextLine());
			System.out.println("Telefone:");
			clienteFisico.setTelefone(scanner.nextLine());
			System.out.println("Email:");
			clienteFisico.setEmail(scanner.nextLine());
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


	private static void cadastrarFornecedores(int idMetodo) throws ParseException {
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
			/*else if(idMetodo == idMetodoCadastrarCentrosDeCustos)
				cadastrarCentrosDeCustos();*/
			else 
				System.exit(0);
			break;
		default:
			System.out.println("Insira uma opção válida.");
			cadastrarFornecedores(idMetodo);
			break;
		}
		
	}


	/*
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
	*/

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
		/*case 5:
			cadastrarCentrosDeCustos();
			break;*/
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
		
		//System.out.println("01 - Cadastrar Centro de Custo");
		
		System.out.println("01 - Cadastrar Fornecedores");
		System.out.println("02 - Cadastrar Cliente");
		System.out.println("03 - Cadastrar Unidade Organizacional");
		System.out.println("04 - Cadastrar Carteira/Conta Bancaria");
		System.out.println("05 - Cadastrar Categorias de Despesa");
		System.out.println("06 - Cadastrar Categorias de Receita");
		System.out.println("07 - Cadastrar Usuário");
		System.out.println("08 - Cadastrar Despesa");
		System.out.println("09 - Cadastrar Receita");
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

	static void cadastrarCategoriaDebito(CategoriaDebito categoriaPai){
		NegocioDAO negocio = new NegocioDAO(); 
		
		CategoriaDebito categoria = new CategoriaDebito();
		System.out.println("Digite o nome da categoria de débito:");
		categoria.setNome(scanner.nextLine());
		System.out.println("Digite a descrição da categoria de débito:");		
		categoria.setDescricao(scanner.nextLine()); 
		categoria.setPai(categoriaPai);

		negocio.salvarGenerico(categoria);
	}
	

	static void cadastrarCategoriaCredito(CategoriaCredito categoriaPai){
		NegocioDAO negocio = new NegocioDAO(); 
		
		CategoriaCredito categoria = new CategoriaCredito();
		System.out.println("Digite o nome da categoria de crédito:");
		categoria.setNome(scanner.nextLine());
		System.out.println("Digite a descrição da categoria de crédito:");		
		categoria.setDescricao(scanner.nextLine()); 
		categoria.setPai(categoriaPai);

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
