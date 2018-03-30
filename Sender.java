import java.math.BigInteger;
import java.util.Random;

public class Sender {
	private Package pack;
	RSA key;

	public Sender(RSA key) {
		System.out.println("Sender created...");
		System.out.println("Generate Message");
		BigInteger message = new BigInteger("70");
		System.out.println("Message:" + message);

		System.out.println("Hashing Message");
		DigitalSignature hasher = new DigitalSignature();
		BigInteger hashMessage = hasher.hash(message);
		System.out.println("Hashed Message:" + hashMessage);

		System.out.println("Sign H(m) with Senders Private Key");
		BigInteger encryptedHash = hasher.generateDigSig(message);
		System.out.println("Signed Hash:" + encryptedHash);

		System.out.println("Generate Session Key");

		Random r = new Random();
		int keyLength = 16;
		BigInteger symmetricKey = BigInteger.probablePrime(keyLength, r);
		System.out.println("Session Key:" + symmetricKey);

		System.out.println("Encrypt Ks with Receiver's public key using RSA algorithm");
		
	}
}
