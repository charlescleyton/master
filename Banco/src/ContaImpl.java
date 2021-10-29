import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ContaImpl extends UnicastRemoteObject implements Conta {

	private double saldo;
	private int number;
	private String Titular;

	public ContaImpl(double s, String t, int number) throws RemoteException {
		super();
		saldo = s;
		setTitular(t);
		setNumber(number);
	}

	public double obterSaldo() throws RemoteException {
		// System.out.println("Metodo remoto em execucao: Retornar Saldo");
		return saldo;
	}

	public String obterTitular() throws RemoteException {
		// System.out.println("Metodo remoto em execucao: Nome Tirtular: ");
		return Titular;
	}

	public void creditarValor(double valor) throws RemoteException {
//		System.out.println("Metodo remoto em execucao: Debitar Valor: ");
		saldo = saldo + valor;

		System.out.println("Conta: " + number);
		System.out.println("Titular: " + obterTitular());
		System.out.println("Saldo: " + obterSaldo());
		System.out.println("Crédito de: " + valor);
	}

	public void debitarValor(double valor) throws RemoteException {
		if (valor > saldo)
			System.out.println("O saldo é insuficiente!");
		else {
			saldo = saldo - valor;
			System.out.println("Conta: " + number);
			System.out.println("Titular: " + obterTitular());
			System.out.println("Saldo: " + obterSaldo());
			System.out.println("Crédito de: " + valor);

		}
	}

	public void aplicarCorrecao(double indice) throws RemoteException {
		saldo = saldo + (saldo * (indice / 100));
	}

	public void transferirValor(double valor, Conta c) throws RemoteException {
		this.debitarValor(valor);
		c.creditarValor(valor);
	}

	public void encerrarConta() throws RemoteException, MalformedURLException, NotBoundException {
		Naming.unbind("Conta" + number);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTitular() {
		return Titular;
	}

	public void setTitular(String Titular) {
		this.Titular = Titular;
	}

	
	@Override
	public String toString() {
		return "ContaImpl [saldo=" + saldo + ", number=" + number + ", Titular=" + Titular + "]";
	}

	@Override
	public void transferirValor(double valor, String conta) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
}
