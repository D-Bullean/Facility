
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
}
