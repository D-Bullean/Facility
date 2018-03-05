/**
*<p>Cryptography - RSA
*Takes in message as a BigInteger
*Generates 2 large primes and calculates private and public keys
*Uses the public key to encrypt and the private key to decrypt the message
*
*@author Tyler Connors
*@date 03/02/2018
*/

import java.math.BigInteger;
import java.util.Scanner;
import java.util.Random;

public class RSA {
	private BigInteger n;
	private BigInteger p;
	private BigInteger q;
	private BigInteger z;
	private BigInteger e;
	private BigInteger d;

	public void init() //Initializes RSA variables
	{
		Random rand = new Random();
		p = BigInteger.probablePrime(10, rand); //Generates first prime
		q = BigInteger.probablePrime(10, rand); //Generates second prime
		n = q.multiply(p);
		z = (q.subtract(BigInteger.ONE)).multiply(p.subtract(BigInteger.ONE));
		e = BigInteger.probablePrime(5, rand);
		while (z.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(z) < 0) //Ensures e is coprime to z
		{
			e.add(BigInteger.ONE);
		}		
		d = e.modInverse(z); //Calculates d as the modular inverse of e mod z
	}
	
	public BigInteger encrypt(BigInteger m) //Encrypts message using public key K(e,n)
	{
		return m.modPow(e, n);
	}
	
	public BigInteger decrypt(BigInteger c) //Decrypts message using private key K(d,n)
	{
		return c.modPow(d, n);
	}

	public static void main(String args[]) //Tests methods
	{
		Scanner scan = new Scanner(System.in);
		RSA Obj = new RSA();
		Obj.init();
		System.out.println("Enter test message");
		BigInteger m = scan.nextBigInteger(); //Generates test m value
		System.out.println("Original message " + m);
		m = Obj.encrypt(m);
		System.out.println("Encrypted " + m);
		m = Obj.decrypt(m);
		System.out.println("Decrypted " + m);
	}
}