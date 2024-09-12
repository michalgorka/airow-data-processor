package io.airow.heartratemodel;

public class HeartRateInterpolation {

    public static double execute(double[] y, int n) {
        var numberOfElements = 5;
        double[] result = new double[y.length * numberOfElements];

        for (int i = 0; i < y.length; i++) {
            if (i == 0) {
                result[2] = y[i];
                for (int j = 0; j < 2; j++) {
                    result[j] = getRandomNumber(y[i] - 10, y[i]);
                }
            } else {
                var previous = result[i * numberOfElements - 3];
                result[i * numberOfElements + 2] = y[i];
                for (int j = i * numberOfElements - 2; j < i * numberOfElements + 2; j++) {
                    result[j] = getRandomNumber(previous, y[i]);
                }
            }
        }

        return result[n];
    }

    private static int getRandomNumber(double min, double max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
