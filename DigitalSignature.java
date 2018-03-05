/**
*<p>Cryptography - Digital Signature
*This is the methodology behind Digital Signature. Using the session key, message, and the signature, each returns
* something to be placed with the changing variables with different inputs.
*
*@author Brandon Davenport
*@date 03/02/2018
*/
package digitalsignaturesolution;
import java.math.BigInteger;

public class DigitalSignature //Method for Session Key, Message, and the signature.
{

    private BigInteger SKey;
    private BigInteger message;
    private BigInteger signature;

    DigitalSignature()  // Sets all to BigInteger
    {

        SKey = BigInteger.ZERO;
        message = BigInteger.ZERO;
        signature = BigInteger.ZERO;

    }

    public DigitalSignature(BigInteger SKey, BigInteger message, BigInteger signature) 
    {
        this.SKey = SKey;
        this.message = message;
        this.signature = signature;
    }

    
    public BigInteger getSessionKey() //Gets the Session Key
    {
        return SKey;
    }
   
  
    public void setSessionKey(BigInteger sessionKey) 
    {
        this.SKey = sessionKey;
    }

   
    public BigInteger getMessage() //Grabs the message.
    {
        return message;
    }

    public void setMessage(BigInteger message) 
    {
        this.message = message;
    }

    public void setErrorInMessage(BigInteger error)
    {
        this.message = this.message.add(error);
    }

    
    public BigInteger getSignature() //Grabs the signature 
    {
        return signature;
    }

    
    public void setSignature(BigInteger signature) 
    {
        this.signature = signature;
    }

    @Override
	public String toString() //Shows the Message, Signature and Session Key. 
        {

        String result = " ";

        result = "Message = " + this.message.toString() + "\n"
                + "Signature = " + this.signature.toString() + "\n"
                + "SessionKey = " + this.SKey.toString() + "\n";

        return result;
    }

}

