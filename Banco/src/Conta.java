import java.net.MalformedURLException;
import java.nio.charset.MalformedInputException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Conta extends Remote {

	public double obterSaldo() throws RemoteException;

	public String obterTitular() throws RemoteException;

	public void creditarValor(double valor) throws RemoteException;

	public void debitarValor(double valor) throws RemoteException;

	public void aplicarCorrecao(double indice) throws RemoteException;

	public void transferirValor(double valor, String conta)throws RemoteException;

	public void encerrarConta() throws RemoteException, MalformedInputException, NotBoundException,
			MalformedURLException, NotBoundException;


}
