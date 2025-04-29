package bancoDigital;

public class ContaPoupanca extends Conta{

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimiExtrato() {
		System.out.println("=== Extrato Conta Poupanca ===");
		super.imprimirInfosComuns();
	}

}
