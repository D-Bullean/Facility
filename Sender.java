import java.math.BigInteger;

public class Sender {
	private Package pack;
	RSA_Keys key;

	public Sender(RSA_Keys key, int methodType) {
		System.out.println("Sender created...");
		System.out.println("Generate Message");
		BigInteger message = new BigInteger("70");
		System.out.println("Message:" + message);

		System.out.println("Hashing Message");
		DigitalSignature hasher = new DigitalSignature();
		BigInteger hashMessage = hasher.hash(message);
		System.out.println("Hashed Message:" + hashMessage);

		System.out.println("Sign H(m) with Senders Private Key");
		BigInteger digSignature = hasher.generateDigSig(message, key.sender);
		System.out.println("Digital Signature:" + digSignature);

		System.out.println("Generate Session Key");
		BigInteger symmetricKey = new BigInteger("5");
		System.out.println("Session Key:" + symmetricKey);

		System.out.println("Encrypt Session with Receivers Public Key");
		BigInteger encryptedSymmetric = key.receiver.pubEncrypt(symmetricKey);
		System.out.println("Encrypted Session Key:" + encryptedSymmetric);

		System.out.println("Encrypt message with symmetric key");
		System.out.println("Encrypt Digital Signature with Symmetric Key");
		BigInteger encryptedMessage = BigInteger.ZERO;
		BigInteger encryptedSig = BigInteger.ZERO;
		if (methodType == 0) {
			ShiftCipher _shift = new ShiftCipher();
			encryptedMessage = new BigInteger(_shift.encrypt(message.toString(), symmetricKey.intValue()));
			encryptedSig = new BigInteger(_shift.encrypt(digSignature.toString(), symmetricKey.intValue()));

		} else if (methodType == 1) {
			blockCipher _block = new blockCipher();
			encryptedMessage = new BigInteger(_block.encrypt(message.toString(), 3));
			encryptedSig = new BigInteger(_block.encrypt(digSignature.toString(), 3));
		}
		System.out.println("Encrypted Message:" + encryptedMessage);
		System.out.println("Encrypted Signature:" + encryptedSig);

		System.out.println("Creating Packet");
		pack = new Package(encryptedSymmetric, encryptedMessage, encryptedSig);
		System.out.println("Packet info:" + pack.toString());

	}
}
