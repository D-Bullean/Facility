/**
*<p>Cryptography -Digital Signature
* This file uses various java files in order to encrypt and decrypt a message containing a number. 
*
*
*@author Brandon Davenport
*@date 03/02/2018
*/
package digitalsignaturesolution;

/**
 *
 * @author Brandon Davenport
 */


import java.math.BigInteger;
import java.util.Random;

public class Equations
{ 

    private DigitalSignature pk; // Private Keys for the Sender
    TheKeys en;
    public Equations(TheKeys en) 
    {
        
        BigInteger message = new BigInteger("8"); //This is the message that the Sender generates. 
        System.out.println("Message = "+ message);
        
        
        Hash hash = new Hash(); // Creates the Hash Message
        BigInteger hashMessage =hash.Hashing(message);
        System.out.println("Hash Message = " + hashMessage);
                
        BigInteger digSig = en.Equations.processWPrivateKey(hashMessage);// Encrypts the message with Sender's Private Key.
        System.out.println("Digital Signature = " + digSig);
        
                Random x = new Random(); //Generates the session key (named S Key). 
        int keyLength = 16;
        BigInteger symmetricKey = BigInteger.probablePrime(keyLength, x);
        System.out.println("Session key = " + symmetricKey + "\n");
                
        BigInteger encryptSymmetric = en.Equations.processWPublicKey(symmetricKey); //Encrypts session key with Receiver's Public Key with RSA. 
        System.out.println("Receiver's N: " + en.Equations.getN());
        System.out.println("Receiver's E: " + en.Equations.getE());
        System.out.println("The encrypted session key w/ receiver's public key = " + encryptSymmetric + "\n");
       
  
        BigInteger encryptMessage =message.add(symmetricKey); // Symmetric Key is used to Encrypt the message  using new add with a.
        System.out.println("Encrypted Message = " + encryptMessage);
        
        
        BigInteger encryptDigSig =digSig.add(symmetricKey); // Encrypts Digital Signature with Symmetic Key. 
        System.out.println("Encrypted Digital Signature = " + encryptDigSig);
       
               
        System.out.println("Packet is: " + message.toString() + "\n"); // Gets the strings in the Digital Signature file. 
        
      
         
        
        BigInteger deSession = en.Equations.processWPrivateKey(encryptSymmetric); // Decrypts Session Key with Reciever's private key. 
        System.out.println("Encrypted Session Key = " + encryptSymmetric);
        System.out.println("Decrypted Session Key = " + deSession + "\n");
               
        BigInteger deMessage = message.subtract(hashMessage); // Decrypts message using the session key. 
        System.out.println("Decrypted Message = " + deMessage);
                
        BigInteger deSignature = encryptDigSig.subtract(deSession); // Decrypts signature using the session key.
        System.out.println("Decrypted Signature = " + deSignature);
                        
        BigInteger hashedMessage = hash.Hashing(deMessage);
        System.out.println("Hashed Message = " + hashedMessage);
                       
        BigInteger publicdeSignature = en.Equations.processWPublicKey(deSignature); //Decrypts the signature using the sender's public key. 
        System.out.println("Decrypted Signature = " + publicdeSignature + "\n");
        
        
        // Comparing hash messages. If not equal, there will be an error. 
        if (hashedMessage.equals(publicdeSignature))
        {
        	System.out.println("No error in the Packet!");
        }
        else{
        	System.out.println("Error in Packet!");
        }
      
    } 
 	public DigitalSignature getPacket()
        {     
           return pk;
        }
   }
