import java.math.BigInteger;

public class RSA {
	private BigInteger n;
	private BigInteger p;
	private BigInteger q;
	private BigInteger z;
	private BigInteger e;
	private BigInteger d;

	public void init() {
		p = BigInteger.probablePrime(1024, null);
		q = BigInteger.probablePrime(1024, null);
		n = q.multiply(p);
		z = (q.subtract(BigInteger.ONE)).multiply(p.subtract(BigInteger.ONE));
		e = BigInteger.TEN;
		while (e.gcd(z) != BigInteger.ONE) {
			e.add(BigInteger.ONE);
		}
		d = e.modInverse(z);
	}

	public BigInteger encrypt(BigInteger m) {
		return m.modPow(e, n);
	}

	public BigInteger decrypt(BigInteger c) {
		return c.modPow(d, n);
	}
}
