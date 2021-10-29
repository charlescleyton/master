import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.Scanner;

public class ClienteImpl {

	public static void main(String[] args) throws NotBoundException, NumberFormatException, IOException {
		Scanner sc = new Scanner (System.in);
		Banco b = (Banco) Naming.lookup ("//localhost/Inter");
		
		BufferedReader teclado = new BufferedReader (new InputStreamReader (System.in));
		
		
		System.out.println("**Cadastro de clientes**");
		int loop = 1;
		while (loop !=2) {
		//solicita um nome para o cliente
		System.out.println("Informe o nome do cliente: ");
		String nome_cliente = teclado.readLine();
		
		System.out.println("Informe o saldo inicial:");
		double saldo = Double.parseDouble(teclado.readLine());
		
		Conta c = b.abrirConta(saldo, nome_cliente);
		System.out.println("Titular: " +c.obterTitular());
		System.out.println("Saldo: " +c.obterSaldo());
		
		System.out.println("\nDigite 1 para cadastrar mais Clientes"
				+ "\nDigite 2 para Sair.");
		
		loop = sc.nextInt();
		}
	}

}