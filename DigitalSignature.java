/**
*<p>Cryptography - Digital Signature
*The digital signature hashes the message
*Then signs it with the sender's private key
*
*@author Tyler Connors
*@date 03/26/2018
*/

import java.math.BigInteger;
import java.util.Scanner;

public class DigitalSignature
{
	//Hashes the message
	public BigInteger hash(BigInteger m)
	{
		return m.mod(BigInteger.valueOf(13));
	}
	
	//Uses private RSA key of sender to to encrypt hashed message
	public BigInteger generateDigSig(BigInteger m)
	{
		BigInteger result;
		RSA senderKeys = new RSA();
		senderKeys.init();
		BigInteger hashed = hash(m);
		result = senderKeys.privEncrypt(hashed);
		return result;
	}
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		DigitalSignature dig = new DigitalSignature();
		System.out.println("Enter test message");
		BigInteger m = scan.nextBigInteger(); //Generates test m value
		System.out.println("Original message " + m);
		System.out.println("Signed " + dig.generateDigSig(m));
	}
}
