package bancoDigital;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Solicitar o nome do cliente
		System.out.println("Digite o nome do cliente: ");
		String nomeCliente = sc.nextLine(); //Lê o nome digitado pelo usuário
		
		//Criar cliente com o nome informado
		Cliente cliente = new Cliente(nomeCliente);
		System.out.println("Cliente " + cliente.getNome());
		
		//Criando contas para o cliente
		Conta cc = new ContaCorrente(cliente);
		Conta cp = new ContaPoupanca(cliente);
		
		//Deposito
		System.out.println();
		System.out.println("Digite o valor para depositar na Conta Corrente: R$ ");
		double valorDeposito = sc.nextDouble();
		cc.depositar(valorDeposito);
		
		//Saque
		System.out.println("Digite o valor para sacar da Conta Corrente: R$ ");
		double valorSaque = sc.nextDouble();
		cc.sacar(valorSaque);
		
		//transferencia
		System.out.println("Digite o valor para transferir da Conta Corrente para Conta Poupança");
		double valorTransferencia = sc.nextDouble();
		cc.transferir(valorTransferencia, cp);
		
		System.out.println();
		
		cc.imprimiExtrato();
		cp.imprimiExtrato();
	}

}
