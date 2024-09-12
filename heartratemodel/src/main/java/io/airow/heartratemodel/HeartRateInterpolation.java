package io.airow.heartratemodel;

public class HeartRateInterpolation {

    public static double execute(double[] y, int n) {
        var numberOfElements = 5;
        int[] result = new int[y.length * numberOfElements];

        for (int i = 0; i < y.length; i++) {
            var n0 = y[i];
            var nextIndex = i + 1;
            var n1 = y[nextIndex < y.length ? nextIndex : y.length - 2];

            var abs = Math.abs(n1 - n0);

            for (int k = 0; k < numberOfElements; k++) {
                result[i*numberOfElements + k % numberOfElements] = getRandomNumber(n0 - abs, n0 + abs);
            }
        }

        return result[n];
    }

    private static int getRandomNumber(double min, double max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
