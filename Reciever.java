package digitalsignaturesolution;
/**
 *
 * @author Brandon Davenport
 */
import java.math.BigInteger;
 
public class Reciever {

    
    private DigitalSignature rPacket;  
     
    public Reciever() // Here is what Jane recieves
    {
       rPacket = new DigitalSignature();       
    }

    public void receive(Network net, TheKeys en) 
     {
       
      
        rPacket = net.receiveFromSender(); // Receiver gets packet.    
        
        
        
        System.out.println("Packet is: " + rPacket.toString() + "\n"); // Gets the strings in the Digital Signature file. 
        BigInteger message = rPacket.getMessage();
        BigInteger sessionKey = rPacket.getSessionKey();
        BigInteger signature = rPacket.getSignature();
        
        
        
        BigInteger deSession = en.receiver.processWPrivateKey(sessionKey); // Decrypts Session Key with Reciever's private key. 
        System.out.println("Encrypted Session Key = " + sessionKey);
        System.out.println("Decrypted Session Key = " + deSession + "\n");
        
       
        BigInteger deMessage = message.subtract(deSession); // Decrypts message using the session key. 
        System.out.println("Decrypted Message = " + deMessage);
        
        
        BigInteger deSignature = signature.subtract(deSession); // Decrypts signature using the session key.
        System.out.println("Decrypted Signature = " + deSignature);
        
        
        Hash hash = new Hash(); // Hashes the message. 
        BigInteger hashedMessage = hash.Hashing(deMessage);
        System.out.println("Hashed Message = " + hashedMessage);
        
        
        BigInteger publicdeSignature = en.sender.processWPublicKey(deSignature); //Decrypts the signature using the sender's public key. 
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

	


}
