package digitalsignaturesolution;

/**
 *
 * @author Brandon Davenport
 */


import java.math.BigInteger;
import java.util.Random;

public class Sender 
{ 

    private DigitalSignature pk; // Private Keys for the Sender
    TheKeys en;
  
    public Sender(TheKeys en) {
        
        BigInteger message = new BigInteger("10"); //This is the message that the Sender generates. 
        System.out.println("Message = "+ message);
        
        
        Hash hash = new Hash(); // Creates the Hash Message
        BigInteger hashMessage =hash.Hashing(message);
        System.out.println("Hash Message = " + hashMessage);
                
        BigInteger digSig = en.sender.processWPrivateKey(hashMessage);// Encrypts the message with Sender's Private Key.
        System.out.println("Digital Signature = " + digSig);
        
                Random x = new Random(); //Generates the session key (named S Key). 
        int keyLength = 16;
        BigInteger symmetricKey = BigInteger.probablePrime(keyLength, x);
        System.out.println("Session key = " + symmetricKey + "\n");
                
        BigInteger encryptSymmetric = en.receiver.processWPublicKey(symmetricKey); //Encrypts session key with Receiver's Public Key with RSA. 
        System.out.println("Receiver's N: " + en.receiver.getN());
        System.out.println("Receiver's E: " + en.receiver.getE());
        System.out.println("The encrypted session key w/ receiver's public key = " + encryptSymmetric + "\n");
       
  
        BigInteger encryptMessage =message.add(symmetricKey); // Symmetric Key is used to Encrypt the message  using new add with a.
        System.out.println("Encrypted Message = " + encryptMessage);
        
        
        BigInteger encryptDigSig =digSig.add(symmetricKey); // Encrypts Digital Signature with Symmetic Key. 
        System.out.println("Encrypted Digital Signature = " + encryptDigSig);
       
         
        pk = new DigitalSignature(encryptSymmetric, encryptMessage,encryptDigSig);// Final Encrypted Symmetric, Message, and Signature
        System.out.println("Packet sent to network: " + pk.toString() + "\n"); // Grabs the Message, Siggnature, and Key from Digital Signature
    } 
 	public DigitalSignature getPacket()
        {     
           return pk;
        }
   }
