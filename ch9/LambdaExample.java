interface Spam {
    void foo();
}

class LambdaExample {
    public static void main (String[] args) {
        Spam t1 = new Spam() {
            @Override
            public void foo() {
                System.out.println("123");
            }
        };
        t1.foo();

        Spam t2 = () -> System.out.println("abc");
        t2.foo();
    }
}
