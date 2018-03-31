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
		System.out.println("\n___Receive packet from internet___");
		pack = network.getPacketFromSender();

		System.out.print("\n___Split Packet___");
		BigInteger message = pack.getMessage();
		BigInteger sessionKey = pack.getSessionKey();
		BigInteger signature = pack.getSignature();
		System.out.println(pack.toString());

		System.out.println("\n___Decrypting the session key with Receivers Private___");
		BigInteger decryptSession = key.receiver.privDecrypt(sessionKey);
		System.out.println("E-Session Key:" + sessionKey);
		System.out.println("D-Session Key:" + decryptSession);

		System.out.println("\n___Decrypt message using decrypted session key___");
		BigInteger decryptMessage = BigInteger.ZERO;
		BigInteger decryptSignature = BigInteger.ZERO;
		if (methodType == 0) {

			decryptMessage = _shift.decrypt(message, decryptSession);
		} else if (methodType == 1) {

			decryptMessage = new BigInteger(_block.decrypt(message.toString(), 3));
		}
		System.out.println("Decrypted message:" + decryptMessage);

		System.out.println("\n___Decrypt Signature with session___");
		if (methodType == 0) {
			decryptSignature = _shift.decrypt(signature, decryptSession);
		} else if (methodType == 1) {
			decryptSignature = new BigInteger(_block.decrypt(signature.toString(), 3));
		}

		System.out.println("Signature:" + decryptSignature);

		System.out.println("\n___Hash Message___");
		DigitalSignature digSignature = new DigitalSignature();
		BigInteger hashedMessage = digSignature.hash(decryptMessage);
		System.out.println("Hashed Message:" + hashedMessage);

		System.out.println("\n___Decrypt Signature with Senders Public___");
		BigInteger decryptPubSign = key.sender.pubEncrypt(decryptSignature);
		System.out.println("Decrypted Signature:" + decryptPubSign);

		System.out.println("\n___Comparing Hash___");
		System.out.println(hashedMessage);
		System.out.println(decryptPubSign);
		if (hashedMessage.equals(decryptPubSign)) {
			System.out.println("No errors");
		} else
			System.out.println("Error in Packet!");
	}

}
