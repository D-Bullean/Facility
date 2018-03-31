
/**
*<p>Cryptography - Receiver
*Receiver class of a network that will take a packet and gather information out of it to decipher the given message
*It will also authorize if the packet is valid or not
*@author Dylan Bull
*@date 03/30/2018
*/
import java.math.BigInteger;

public class Receiver {
	Package pack;

	public Receiver() {
		System.out.println("\nReceiver created");
		pack = new Package();
		RSA key;

	}

	public void receive(Network network, RSA_Keys key, int methodType) {

		ShiftCipher _shift = new ShiftCipher();
		blockCipher _block = new blockCipher();

		// Asks the network to receive whatever packet is currently stored in there
		System.out.println("\n___Receive packet from internet___");
		pack = network.getPacketFromSender();

		// Gathers each segement of the packet and isolates them to be processed
		System.out.print("\n___Split Packet___");
		BigInteger message = pack.getMessage();
		BigInteger sessionKey = pack.getSessionKey();
		BigInteger signature = pack.getSignature();
		System.out.println(pack.toString());

		System.out.println("\n___Decrypting the session key with Receivers Private___");
		BigInteger decryptSession = key.receiver.privDecrypt(sessionKey);
		System.out.println("E-Session Key:" + sessionKey);
		System.out.println("D-Session Key:" + decryptSession);

		// Decrypts using symmetric keys
		// Applied to Message and signature parts of the Packet
		System.out.println("\n___Decrypt message using decrypted session key___");
		BigInteger decryptMessage = BigInteger.ZERO;

		// If statement determines what symmetric algoirthm will be used
		if (methodType == 0) {

			decryptMessage = _shift.decrypt(message, decryptSession);
		} else if (methodType == 1) {

			decryptMessage = new BigInteger(_block.decrypt(Integer.toBinaryString(message.intValue()), 3));
		}
		System.out.println("Decrypted message:" + decryptMessage);

		// Applies same if statement as above but with the Signature instead
		System.out.println("\n___Decrypt Signature with session___");
		BigInteger decryptSignature = BigInteger.ZERO;
		if (methodType == 0) {
			decryptSignature = _shift.decrypt(signature, decryptSession);
		} else if (methodType == 1) {
			decryptSignature = new BigInteger(_block.decrypt(Integer.toBinaryString(signature.intValue()), 3));
		}
		System.out.println("Signature:" + decryptSignature);

		// Hashes the Decrypted Signature to get a Hash
		System.out.println("\n___Hash Message___");
		DigitalSignature digSignature = new DigitalSignature();
		BigInteger hashedMessage = digSignature.hash(decryptMessage);
		System.out.println("Hashed Message:" + hashedMessage);
		
		// Decrypts the Signature using the Senders public key because it was encrypted
		// using the private key
		System.out.println("\n___Decrypt Signature with Senders Public___");
		BigInteger decryptPubSign = key.sender.pubEncrypt(decryptSignature);
		System.out.println("Decrypted Signature:" + decryptPubSign);

		// Compares Hash to see if message has lost integrity
		System.out.println("\n___Comparing Hash___");
		System.out.println(hashedMessage);
		System.out.println(decryptPubSign);
		if (hashedMessage.equals(decryptPubSign)) {
			System.out.println("No errors");
		} else
			System.out.println("Error in Packet!");
	}

}
