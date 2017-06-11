class Some {
    Some() {
        System.out.println("Some()");
    }
}

class Other extends Some {
    Other() {
        System.out.println("Other()");
    }

    public static void main (String[] args) {
        Other o = new Other();
    }
}
