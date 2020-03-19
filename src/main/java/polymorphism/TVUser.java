package polymorphism;

public class TVUser {
	public static void main(String [] args) {
		
//		SamsungTV tv = new SamsungTV();
//		
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
//		
//		System.out.println();
//		
//		LgTV tv2 = new LgTV();
//		
//		tv2.powerOn();
//		tv2.volumeUp();
//		tv2.volumeDown();
//		tv2.powerOff();
		
		BeanFactory factory = new BeanFactory();
		TV tv = (TV)factory.getBean(args[0]);
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}
}
