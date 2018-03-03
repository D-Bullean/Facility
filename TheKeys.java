package digitalsignaturesolution;

/**
 *
 * @author Brandon Davenport
 */
public class TheKeys  //Begins the RSA algorithm for the Sender and Receiver. 
{

	RSA sender = new RSA();
	RSA receiver = new RSA();
	
	
	public TheKeys(){
		sender.generateKeys();
		System.out.println("Sender's public key: John(n, e) = (" + sender.getN() + "," + sender.getE() + ")"); // Gives the Sender's Public Key 
		System.out.println("Sender's private key: John(n, d) = (" + sender.getN() + "," + sender.getD() + ")"); // Gives the Sender's Private Key
		receiver.generateKeys();
		System.out.println("Receiver's public key:Jane(n, e) = (" + receiver.getN() + "," + receiver.getE() +")");//Gives Reciever Private Key.
		System.out.println("Receiver's private key:Jane(n, d) = (" + receiver.getN() + "," + receiver.getD() +")" + "\n" ); //Gives Receiever's Private Key

		
		
		
	}
	
	
}
    
