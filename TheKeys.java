/**
*<p>Cryptography - Digital Signature
* This assigns the RSA values to two different keys for two different individuals.  
*on XOR with previous block.
*
*@author Brandon Davenport
*@date 03/02/2018
*/
package digitalsignaturesolution;
public class TheKeys  //Begins the RSA algorithm for the Sender and Receiver. 
{

	RSA Equations = new RSA();
	RSA receiver = new RSA();
	
	
	public TheKeys(){
		Equations.generateKeys();
		System.out.println("Sender's public key: John(n, e) = (" + Equations.getN() + "," + Equations.getE() + ")"); // Gives the Sender's Public Key 
		System.out.println("Sender's private key: John(n, d) = (" + Equations.getN() + "," + Equations.getD() + ")"); // Gives the Sender's Private Key
		receiver.generateKeys();
		System.out.println("Receiver's public key:Jane(n, e) = (" + receiver.getN() + "," + receiver.getE() +")");//Gives Reciever Private Key.
		System.out.println("Receiver's private key:Jane(n, d) = (" + receiver.getN() + "," + receiver.getD() +")" + "\n" ); //Gives Receiever's Private Key
}
	
	
}
    
