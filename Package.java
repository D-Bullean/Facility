import java.math.BigInteger;
import java.util.BitSet;

public class Package {
	private BigInteger message;
	private BigInteger sessionKey;
	private BigInteger signature;

	Package() {
		message = BigInteger.ZERO;
		sessionKey = BigInteger.ZERO;
		signature = BigInteger.ZERO;

	}

	public Package(BigInteger sessionKey, BigInteger message, BigInteger signature) {
		this.sessionKey = sessionKey;
		this.message = message;
		this.signature = signature;
	}

	public void setSessionKey(BigInteger sessionKey) {
		this.sessionKey = sessionKey;
	}

	public BigInteger getSessionKey() {
		return this.sessionKey;
	}

	public void setMessage(BigInteger message) {
		this.message = message;
	}

	public void setErrorMessage(BigInteger shift) {
		this.message.add(shift);
	}

	public BigInteger getMessage() {
		return this.message;
	}

	public void setSignatre(BigInteger signature) {
		this.signature = signature;
	}

	public BigInteger getSignature() {
		return this.signature;
	}

	public String toString() {
		return "\nMessage:" + this.message.toString() + "\nSignature:" + this.signature.toString() + "\nSessionKey:"
				+ this.sessionKey.toString();
	}

}
