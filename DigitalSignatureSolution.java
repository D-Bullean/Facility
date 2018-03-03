package digitalsignaturesolution;
/**
 *
 * @author Bkd12
 */
public class DigitalSignatureSolution {

    public static void main(String[] args)
    {          
    	TheKeys en = new TheKeys();
    	Sender a = new Sender(en);
        Reciever b = new Reciever();
        Network net = new Network();      

        System.out.println("\n Here you go, Jane." + "\n" + "-Gives the Packet-");
        
        net.sendToReceiver(a.getPacket());
        
       
        
        net.setInternetCondition(0);
        
        

        
       System.out.println("Thanks, John!" + "\n");
        
       b.receive(net, en);


    }

}
