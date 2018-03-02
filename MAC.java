/**
 * Created by Kage on 01-Mar-18.
 */

import java.math.BigInteger;

public class MAC {
    //Returns a MAC_package containing the message and the MAC tag.
    public MAC_package encrypt(BigInteger k, BigInteger m) {
        int mac = k.multiply(m).mod(BigInteger.TEN).intValue();
        MAC_package pack = new MAC_package();
        pack.message = m;
        pack.mac = mac;
        return pack;
    }

    //Returns true if integrity was maintained, else false.
    public static boolean verify (BigInteger k, MAC_package m) {
        int mac = k.multiply(m.message).mod(BigInteger.TEN).intValue();
        if(mac == m.mac) return true;
        return false;
    }
}
