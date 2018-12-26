package gopi.kotlintest.javacode;

import gopi.kotlintest.initial.AdvancedKotlinKt;

public class KotlinJavaTest {
    public void display(String message, int... values) {
        System.out.println("string is " + message);
        for (int s : values) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        boolean result = AdvancedKotlinKt.isNullOrEmptyGopi("asdf");  // calling kotlin in java with fileNameKt

        System.out.println("result = " + result + " sample constant " + AdvancedKotlinKt.getSampleConstant());
    }
}
