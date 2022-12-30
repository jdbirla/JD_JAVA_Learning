package designpattern.jd;

class SingletonEager {

	private static SingletonEager instance = new SingletonEager();

	private SingletonEager() {
	}

	public static SingletonEager getInstance() {
		return instance;
	}

}

class SingletonLazy {

	private static SingletonLazy instance = null;

	private SingletonLazy() {
	}

	public static SingletonLazy getInstance() {
		if (instance == null) {
			instance = new SingletonLazy();
		}
		return instance;
	}

}

class SingletonSynchronizedMethod {

	private static SingletonSynchronizedMethod instance = null;

	private SingletonSynchronizedMethod() {
	}

	public static synchronized SingletonSynchronizedMethod getInstance() {
		if (instance == null) {
			instance = new SingletonSynchronizedMethod();
		}
		return instance;
	}

}

class SingletonSynchronizedBlock {

	private static SingletonSynchronizedBlock instance = null;

	private SingletonSynchronizedBlock() {
	}

	public static SingletonSynchronizedBlock getInstance() {
		if (instance == null) {
			synchronized (SingletonSynchronizedBlock.class) {
				instance = new SingletonSynchronizedBlock();

			}
		}
		return instance;
	}

}

public class SingletonExample {

	public static void main(String[] args) {
		SingletonEager eagerinstance = SingletonEager.getInstance();

		System.out.println(eagerinstance);

		SingletonLazy singletonLazy = SingletonLazy.getInstance();

		System.out.println(singletonLazy);

		SingletonSynchronizedMethod singletonSynchronizedMethod = SingletonSynchronizedMethod.getInstance();

		System.out.println(singletonSynchronizedMethod);
		
		SingletonSynchronizedBlock singletonSynchronizedBlock = SingletonSynchronizedBlock.getInstance();

		System.out.println(singletonSynchronizedBlock);


	}

}
