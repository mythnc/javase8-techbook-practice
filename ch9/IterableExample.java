import java.util.*;

class IterableExample {
    public static void main (String[] args) {
        List names = Arrays.asList("123", "abc");
        forEach1(names);
        forEach2(names);
        names.forEach(name -> System.out.println(name));
    }

    static void forEach1(Iterable iterable) {
        for (Object o: iterable) {
            System.out.println(o);
        }
    }

    static void forEach2(Iterable iterable) {
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
