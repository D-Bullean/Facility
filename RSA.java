
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
	private BigInteger privKey[];
	private BigInteger pubKey[];

	public void init() // Initializes RSA variables
	{
		Random rand = new Random();
		p = BigInteger.probablePrime(10, rand); // Generates first prime
		q = BigInteger.probablePrime(10, rand); // Generates second prime
		n = q.multiply(p);
		z = (q.subtract(BigInteger.ONE)).multiply(p.subtract(BigInteger.ONE));
		e = BigInteger.probablePrime(5, rand);
		while (z.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(z) < 0) // Ensures e is coprime to z
		{
			e.add(BigInteger.ONE);
		}
		d = e.modInverse(z); // Calculates d as the modular inverse of e mod z
		pubKey = new BigInteger[2];
		privKey = new BigInteger[2];
		pubKey[0] = n;
		pubKey[1] = e;
		privKey[0] = n;
		privKey[1] = d;
	}

	public BigInteger pubEncrypt(BigInteger m) // Encrypts message using public key K(n, e)
	{
		return m.modPow(e, n);
	}

	public BigInteger privEncrypt(BigInteger m) // Encrypts message using private key K(n, d)
	{
		System.out.println(d);
		System.out.println(n);
		return m.modPow(d, n);

	}

	public BigInteger privDecrypt(BigInteger c) // Decrypts message using private key K(n, d)
	{
		return c.modPow(d, n);
	}

	public BigInteger pubDecrypt(BigInteger c) // Decrypts message using public key K(n, d)
	{
		return c.modPow(d, n);
	}

	public BigInteger[] getPubKey() // Returns public key K(n, e)
	{
		return pubKey;
	}

	public BigInteger[] getprivKey() // Returns private key K(n, d)
	{
		return privKey;
	}
	//
	// public static void main(String args[]) //Tests methods
	// {
	// Scanner scan = new Scanner(System.in);
	// RSA Obj = new RSA();
	// Obj.init();
	// System.out.println("Enter test message");
	// BigInteger m = scan.nextBigInteger(); //Generates test m value
	// System.out.println("Original message " + m);
	// m = Obj.pubEncrypt(m);
	// System.out.println("Encrypted " + m);
	// m = Obj.privDecrypt(m);
	// System.out.println("Decrypted " + m);
	// }
}
