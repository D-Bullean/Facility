package digitalsignaturesolution;

/**
 *
 * @author Brandon Davenport
 */


import java.math.BigInteger;
import java.util.Random;

public class RSA // My own RSA to use for the Digital Signature in addition to the Hashing
{
    private BigInteger p, q, n, z, e, d;

    RSA() 
    {}   
    
    public void generateKeys() // Generates the keys randomly using the prime number 17.
    {
        Random r = new Random();
        
        int bitlength = 17;

        p = BigInteger.probablePrime(bitlength, r);
        q = BigInteger.probablePrime(bitlength, r);
        n = p.multiply(q);
        z = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        setE(BigInteger.probablePrime(bitlength / 2, r));

        while (z.gcd(getE()).compareTo(BigInteger.ONE) > 0 && getE().compareTo(z) < 0) {
            getE().add(BigInteger.ONE);
        }
        setD(getE().modInverse(z));
        }

    public BigInteger processWPrivateKey(BigInteger m) // Sets number to the private key. 
    {
    return m.modPow(d, n);
    }
   
    public BigInteger processWPublicKey(BigInteger c) // Sets number to the public key. 
    {
         return c.modPow(e, n);
    }
    //Returns variables with the number. 
    public BigInteger getN() 
    {
        return n;
    }
  
    public BigInteger getE()
    {
        return e;
    }
    
    public void setE(BigInteger e) 
    {
        this.e = e;
    }

    
    public BigInteger getD() 
    {
        return d;
    }

    public void setD(BigInteger d) 
    {
        this.d = d;
    }

}
