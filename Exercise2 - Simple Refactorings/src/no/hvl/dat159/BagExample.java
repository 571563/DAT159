package no.hvl.dat159;

public class BagExample {
	private final class BagImpl extends Bag {
		Object o;

		public Object get() {
			return o;
		}

		public void set(Object o) {
			this.o = o;
		}
	}

	void processMessage(String msg) {
		Bag bag = new BagImpl();
		bag.set(msg);
		MessagePipe pipe = new MessagePipe();
		pipe.send(bag);
	}
}
