import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BancoImpl extends UnicastRemoteObject implements Banco {

	private int ultimaConta;

	public BancoImpl() throws RemoteException {
		super();
		ultimaConta = 1;
	}

	public Conta abrirConta(double saldo, String Titular) throws RemoteException, MalformedURLException {

		Conta c = new ContaImpl(saldo, Titular, ultimaConta);

		Naming.rebind("Conta" + ultimaConta, c); // registra o banco no servidor de nomes
		System.out.println("Conta " + ultimaConta + " foi criado com sucesso!");
		System.out.println("Titular: " + c.obterTitular());
		System.out.println("Saldo: " + c.obterSaldo());

		ultimaConta++;
		return c;
	}

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		Banco b = new BancoImpl();
		Naming.rebind("Inter", b); // registra o banco no servidor de nomes
		System.out.println("Banco ativo!");
	}

	@Override
	public void manutencaoConta(Conta conta) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double saque(Conta conta, double valor) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double deposito(Conta conta, double valor) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void extrato(Conta conta) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}