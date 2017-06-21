interface SpamIF {
    void foo();
}

class Spam {
    public void foo() {}
}

class LambdaExample {
    public static void main (String[] args) {
        SpamIF t1 = new SpamIF() {
            @Override
            public void foo() {
                System.out.println("t1");
            }
        };
        t1.foo();

        SpamIF t2 = () -> System.out.println("t2");
        t2.foo();

        Spam t3 = new Spam() {
            public void foo() {
                System.out.println("t3");
            }
        };
        t3.foo();

        new Spam() {
            public void newFoo() {
                System.out.println("t4");
            }
        }.newFoo();
    }
}
