/**
*<p>Cryptography - Digital Signature
*This calls the function generating RSA as well as the java file that holds most of the equations encrypting and decrypting.
*on XOR with previous block.
*
*@author Brandon Davenport
*@date 03/02/2018
*/

package digitalsignaturesolution;

public class DigitalSignatureSolution {

    public static void main(String[] args)
    {          
    	TheKeys en = new TheKeys();
    	Equations a = new Equations(en);
    }
}
