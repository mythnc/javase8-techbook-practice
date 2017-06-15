import java.util.*;

public class MapExample {
    public static void main (String[] args) {
        HashMap<String, String> messages = new HashMap<>();
        messages.put("123", "hi");
        messages.put("123", "hi");
        messages.put("123", "hi");
        messages.put("123", "hi");
        messages.put("123", "hi");
        System.out.println(messages);
        System.out.println("123".hashCode());
        System.out.println("1".hashCode());
    }
}
