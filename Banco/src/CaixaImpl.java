import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.NotBoundException;

public class CaixaImpl {

	public static void main(String[] args) throws NotBoundException, NumberFormatException, IOException {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

		int menuSwitch = -1;

		double valor;
		double indice;
		double vd = 0;
		String conta;

		
		while (menuSwitch != 7) {
			System.out.println("+++++ CAIXA BANCO INTER +++++");
			System.out.println("Digite 1 para Retornar Saldo");
			System.out.println("Digite 2 para Retornar o nome do Titular");
			System.out.println("Digite 3 para Credita o valor informado ao saldo da conta");
			System.out.println("Digite 4 para Debita o valor no saldo da conta");
			System.out.println(
					"Digite 5 para Creditar ao saldo da conta o valor \ncorrespondente ao índice de correção informado");
			System.out.println("Digite 6 para Transferência de valor.");
			System.out.println("Digite 7 para SAIR");
			menuSwitch = Integer.parseInt(teclado.readLine());

			switch (menuSwitch) {

			case 1:
				System.out.println("Informe o número da conta:");
				conta = teclado.readLine();
				Conta c = (Conta) Naming.lookup("//localhost/Conta" + conta);
				System.out.println("Saldo: R$" + c.obterSaldo()+ "\n");
				break;

			case 2:
				System.out.println("Informe o número da conta:");
				conta = teclado.readLine();
				c = (Conta) Naming.lookup("//localhost/Conta" + conta);
				System.out.println("Titular: " + c.obterTitular()+ "\n");
				break;

			case 3:
				System.out.println("Informe o número da conta:");
				conta = teclado.readLine();
				c = (Conta) Naming.lookup("//localhost/Conta" + conta);
				System.out.println("Titular: " + c.obterTitular());
				System.out.println("Saldo: R$" + c.obterSaldo());
				System.out.println("Informe o valor:");
			valor = Double.parseDouble(teclado.readLine());
				c.creditarValor(valor);
				System.out.println("O saldo atualizado de "+c.obterTitular()+" é R$"+c.obterSaldo()+ "\n");
				break;

			case 4:
				System.out.println("Informe o número da conta:");
				conta = teclado.readLine();
				c = (Conta) Naming.lookup("//localhost/Conta" + conta);
				System.out.println("Titular: " + c.obterTitular());
				System.out.println("Saldo: R$" + c.obterSaldo());
				System.out.println("Informe o valor:");
				valor = Double.parseDouble(teclado.readLine());
				if (valor > c.obterSaldo()) {
					System.out.println("Valor insuficiente para transação");
				} else
					c.debitarValor(valor);
				System.out.println("O saldo atualizado de "+c.obterTitular()+" é R$"+c.obterSaldo()+ "\n");
				
				break;

			case 5:
				System.out.println("Informe o número da conta:");
				conta = teclado.readLine();
				c = (Conta) Naming.lookup("//localhost/Conta" + conta);
				System.out.println("Titular: " + c.obterTitular());
				System.out.println("Saldo: R$" + c.obterSaldo());
				System.out.println("Informe o índice:");
				indice = Double.parseDouble(teclado.readLine());
				c.aplicarCorrecao(indice);
				System.out.println("O saldo atualizado de "+c.obterTitular()+" é R$"+c.obterSaldo()+ "\n");
				
				break;

			case 6:
				System.out.println("Informe o número da conta de retirada:");
				conta = teclado.readLine();
				c = (Conta) Naming.lookup("//localhost/Conta" + conta);
				System.out.println("Titular: " + c.obterTitular());
				System.out.println("Saldo: R$" + c.obterSaldo());
				System.out.println("Informe o valor de transferencia:");
				valor = Double.parseDouble(teclado.readLine());

				if (valor > c.obterSaldo()) {
					System.out.println("Valor insuficiente para transação");
				} else {
					c.debitarValor(valor);
					System.out.println("O Saldo Atual do " + c.obterTitular() + " é R$" + c.obterSaldo());
					vd = valor;
					System.out.println("Informe o número da conta recebedora:");
					conta = teclado.readLine();
					c = (Conta) Naming.lookup("//localhost/Conta" + conta);
					c.creditarValor(vd);
					System.out.println("Titular: " + c.obterTitular());
					System.out.println("Valor transferido: R$" + vd);
					System.out.println("Saldo Atualizado: R$" + c.obterSaldo()+ "\n");
				
				}

				break;
			case 7:

				break;

			default:
				System.out.println("Opção Incorreta");
			}
		}
	}
}