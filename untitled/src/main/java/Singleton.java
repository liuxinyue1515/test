

public class Singleton {

    private volatile static Singleton instance = null;

    private Singleton(){}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

class Singleton2 {

    private Singleton2() {}

    private static class InnerClass {
        private static Singleton2 instance = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return InnerClass.instance;
    }

}