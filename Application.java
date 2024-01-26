public class Application {
    public static void main(String[] args) {
        String[] tests = new String[]{
                "{([])}",
                "{([)]}",
                "{([({})])}",
                "({{{[()]}}})",
        };

        Analyser analyser = new Analyser();
        for (String test : tests) {
            System.out.printf("%s is %s\n", test, analyser.isValid(test) ? "valid" : "invalid");
        }
    }
}