package io.airow.heartratemodel;

import org.apache.commons.math3.analysis.polynomials.PolynomialFunctionLagrangeForm;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        double[] y = {120,126,122,140,142,155,145};

        double[] modelResult = new double[35];
        for (int i = 0; i < y.length*5; i++) {
            var modelValue = HeartRateInterpolation.execute(y, i);
            modelResult[i] = modelValue;
        }

        double[] avg = new double[7];
        for (int i = 0; i < modelResult.length/5; i++) {
            double sum = 0;
            for (int j = 0; j < 5; j++) {
                sum += modelResult[i * 5 +j];
            }
            avg[i] = sum / 5;
        }

        System.out.println(Arrays.toString(y));
        System.out.println(Arrays.toString(avg));
        System.out.println("Lost: " + lost(y, avg, 2) + "%");
    }

    private static double lost(double[] expected, double[] predicted, double threshold) {
        var countValid = 0;
        for (int i = 0; i < predicted.length; i++) {
            if (similarity(expected[i], predicted[i], threshold)) {
                countValid++;
            }
        }


        return 100 - 100*countValid/expected.length;
    }

    private static boolean similarity(double expected, double actual, double threshold) {
        return Math.abs(expected - actual) <= threshold;
    }
}
