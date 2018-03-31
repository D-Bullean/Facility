/*
 * This makes it so we can reference two separate set of keys for both the sender and the receiver
 * Makes encrypting with the receiver and senders private and public keys easier to disguinish.
 * Thinking of adding all of the encryption methods in here for easy reference as well
 * 
 */
public class RSA_Keys {
	RSA sender = new RSA();
	RSA receiver = new RSA();

	public RSA_Keys() {
		sender.init();
		receiver.init();
	}
}
