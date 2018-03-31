import java.math.BigInteger;

public class Network {
	Package in, out;

	Network() {
		System.out.println("Network formed...");
		in = new Package();
		out = new Package();
	}

	public Package getPacketFromSender() {
		return out;
	}

	public void deliverPacketToReceiver(Package pack) {
		in = pack;
	}

	public void hackedPacket(int shift) {
		if (shift == 0)
			out = in;
		else {
			in.setErrorMessage(new BigInteger(Integer.toString(shift)));
			out = in;
		}

	}
}
