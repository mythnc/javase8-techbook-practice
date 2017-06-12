class Resource implements AutoCloseable {
    void foo() {
        System.out.println("do something");
    }

    @Override
    public void close() throws Exception {
        System.out.println("shutdown resource");
    }
}

public class AutoCloseableDemo {
    public static void main (String[] args) {
        try (Resource res = new Resource()) {
            res.foo();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
