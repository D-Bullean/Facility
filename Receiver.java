import java.math.BigInteger;

public class Receiver {
	Package pack;

	public Receiver() {
		System.out.println("Receiver created");
		pack = new Package();
	}

	public void receive(Network network, RSA receiver) {

		System.out.println("Receive packet from internet");
		pack = network.getPacketFromSender();

		System.out.println("Split Packet");
		BigInteger message = pack.getMessage();
		BigInteger sessionKey = pack.getSessionKey();
		BigInteger signature = pack.getSignature();

		System.out.println("Decrypting the session key with Receivers Private");
		BigInteger decryptSession = receiver.privDecrypt(sessionKey);
		System.out.println("E-Session Key:" + sessionKey);
		System.out.println("D-Session Key:" + decryptSession);

		System.out.println("Decrypt message using decrypted session key");

	}

}
