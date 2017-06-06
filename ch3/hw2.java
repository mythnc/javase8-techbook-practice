class hw2 {
    public static void main (String[] args) {
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    int leftValue = i * i * i + j * j * j + k * k * k;
                    int rightValue = i * 100 + j * 10 + k;
                    if (leftValue != rightValue) {
                        continue;
                    } else {
                        System.out.printf("%d%d%d%n", i, j, k);
                    }
                }
            }
        }
    }
}
