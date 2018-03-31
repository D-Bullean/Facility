import java.math.BigInteger;

public class Sender {
	private Package pack;
	RSA_Keys key;
	ShiftCipher _shift = new ShiftCipher();
	blockCipher _block = new blockCipher();

	public Sender(RSA_Keys key, int methodType) {
		System.out.println("\n___Sender created___");
		System.out.println("Generate Message");
		BigInteger message = new BigInteger("89");
		System.out.println("Message:" + message);

		System.out.println("\n___Hashing Message___");
		DigitalSignature hasher = new DigitalSignature();
		BigInteger hashMessage = hasher.hash(message);
		System.out.println("Hashed Message:" + hashMessage);

		System.out.println("\n___Sign H(m) with Senders Private Key___");
		BigInteger digSignature = key.sender.privEncrypt(hashMessage);
		System.out.println("Digital Signature:" + digSignature);

		System.out.println("\n___Generate Session Key___");
		BigInteger symmetricKey = new BigInteger("5");
		System.out.println("Session Key:" + symmetricKey);

		System.out.println("\n___Encrypt Session with Receivers Public Key___");
		BigInteger encryptedSymmetric = key.receiver.pubEncrypt(symmetricKey);
		System.out.println("Encrypted Session Key:" + encryptedSymmetric);

		System.out.println("\n____Encrypt message with symmetric key___");
		System.out.println("___Encrypt Digital Signature with Symmetric Key___");
		BigInteger encryptedMessage = BigInteger.ZERO;
		BigInteger encryptedSig = BigInteger.ZERO;
		if (methodType == 0) {

			encryptedMessage = _shift.encrypt(message, symmetricKey);
			encryptedSig = _shift.encrypt(digSignature, symmetricKey);

		} else if (methodType == 1) {

			encryptedMessage = new BigInteger(_block.encrypt(message.toString(), 3));
			encryptedSig = new BigInteger(_block.encrypt(digSignature.toString(), 3));
		}
		System.out.println("Encrypted Message:" + encryptedMessage);
		System.out.println("Encrypted Signature:" + encryptedSig);

		System.out.print("\n___Creating Packet___");
		pack = new Package(encryptedSymmetric, encryptedMessage, encryptedSig);
		System.out.println(pack.toString());

	}

	public Package getPacket() {
		return pack;
	}
}
