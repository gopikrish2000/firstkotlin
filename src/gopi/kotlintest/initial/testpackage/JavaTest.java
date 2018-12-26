package gopi.kotlintest.initial.testpackage;

class JavaTest {

    private static boolean abc() {
        System.out.println("JavaTest.abc");
        return true;
    }

    public static void main(String[] args) {

        boolean a = false;
        boolean abcVal = abc();
        a = a && abcVal;
        System.out.println("a is " + a);

    }
}
