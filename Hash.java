package digitalsignaturesolution;

/**
 *
 * Brandon Davenport
 */
import java.math.BigInteger;

public class Hash {
	
	public BigInteger Hashing(BigInteger message)
        {
    	BigInteger modulus = new BigInteger("8");
    	BigInteger hVal = message.mod(modulus);
    	return hVal;
    	}
    

}