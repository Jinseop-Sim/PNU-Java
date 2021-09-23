public class TestTV {

	public static void main(String[] args) {
		TV samsung = new TV();
		samsung.turnOn();
		samsung.setChannel(30);
		samsung.setVolume(4);
		
		TV lg = new TV();
		lg.turnOn();
		lg.channelUp();
		lg.channelUp();
		lg.volumeUp();
		
		System.out.println("Samsung's Channel is " + samsung.channel + " and volume is " + samsung.volumeLevel);
		System.out.println("LG's Channel is " + lg.channel + " and volume is " + lg.volumeLevel);
	}
}
