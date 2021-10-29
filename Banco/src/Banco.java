import java.net.MalformedURLException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Banco extends Remote {

	public Conta abrirConta(double saldo, String Titular) throws RemoteException, MalformedURLException;
	
	public void manutencaoConta(Conta conta) throws RemoteException;

	public double saque(Conta conta, double valor) throws RemoteException;

	public double deposito(Conta conta, double valor) throws RemoteException;

	public void extrato(Conta conta) throws RemoteException;


}
