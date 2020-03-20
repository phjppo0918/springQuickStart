package polymorphism;

public class SamsungTV implements TV {
	
	private Speaker speaker;
	private int price;
	
	public SamsungTV() {
		
		System.out.println("===> SamsungTV 객체 생성");
	
	}
	
	public SamsungTV(Speaker speaker) {
		System.out.println("===> Samsung TV(2) 객체 생성");
		this.speaker = speaker;
	}
	
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("===> Samsung TV(2) 객체 생성");
		this.speaker = speaker;
		this.price = price;
	}
	
	public void initMethod() {
		System.out.println("객체 초기화 작업 처리..");
	}
	
	public void destroyMethod() {
		System.out.println("객체 삭제 전에 처리한 로직 처리...");
	}
	
	
	public void powerOn() {
		System.out.println("SamsungTV---전원 켠다.(가격 : "+price+")");
	}

	public void powerOff() {
		System.out.println("SamsungTV---전원 끈다.");
	}

	public void volumeUp() {
		speaker.volumeUp();
	}

	public void volumeDown() {
		speaker.volumeDown();
	}
}
