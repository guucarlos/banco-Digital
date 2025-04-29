package bancoDigital;

public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	
	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	
	public Conta(Cliente cliente) {
		this.agencia = AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}
	
	@Override
	public void sacar(double valor) {
		if(valor <= 0) {
			System.out.println("Valor inválido para saque, O valor deve ser maior que zero.");
			return;
		}
		if(saldo >=valor) {
			saldo -= valor;
			System.out.println(String.format("Saque de R$%.2f realizado com sucesso. Saldo atual: R$%.2f", valor, saldo));
		}else {
			System.out.println("Saldo insuficiente para saque");
		}
	}

	@Override
	public void depositar(double valor) {
		if(valor  <= 0) {
			System.out.println("Valor invalido para depósito. O valor deve ser maior que zero.");
			return;
		}
		saldo += valor;
	    System.out.println(String.format("Depósito de R$%.2f realizado com sucesso. Saldo atual: R$%.2f", valor, saldo));
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		if(valor <= 0) {
			System.out.println("Valor inválido para transferência, O valor deve ser maior que zero.");
			return;
		} if (saldo >= valor){
			sacar(valor); // Chama o método sacar para reduzir o saldo da conta de origem
			contaDestino.depositar(valor); // Chama o método depositar para adicionar o valor à conta destino
	        System.out.println(String.format("Transferência de R$%.2f realizada para a conta de %s.", valor, contaDestino.cliente.getNome()));
		}else {
			System.out.println("Saldo insuficiente pararealizar a transferência.");
		}
		
		
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}
	
	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Conta: %d", this.numero));	
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}


}
