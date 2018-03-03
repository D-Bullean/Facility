package digitalsignaturesolution;

/**
 *
 * @author Brandon Davenport
 */
import java.math.BigInteger;

public class Network 
{

    DigitalSignature inFromSender, outToReceiver; // Connects the Sender to the Receiver. 
    
    Network()
    {
        System.out.println("Connecting ..." + "\n" + "Connected");
        inFromSender = new DigitalSignature(); //
        outToReceiver =  new DigitalSignature();
    }
   
    public void sendToReceiver(DigitalSignature pk) 
    {
        inFromSender = pk;
    }
   
    public void setInternetCondition( int error)
        {
    	if (error == 0) {
            outToReceiver = inFromSender;
        } 
                else 
                {
                inFromSender.setErrorInMessage(new BigInteger(Integer.toString(error)));
            outToReceiver = inFromSender;
                }

    }

    public DigitalSignature receiveFromSender() // 
    {
        return outToReceiver;
    }

}
