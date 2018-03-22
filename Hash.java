/**
*<p>Cryptography - Digital Signature
* This is my hash function that mods the value of message.
*
*
*@author Brandon Davenport
*@date 03/02/2018
*/
package digitalsignaturesolution;
import java.math.BigInteger;
public class Hash {

	public BigInteger Hashing(BigInteger message)
        {
    	BigInteger modulus = new BigInteger("1"); // Takes the input within sender and divides it by 1
    	BigInteger hVal = message.mod(modulus); 
    	return hVal;
    	}
}
