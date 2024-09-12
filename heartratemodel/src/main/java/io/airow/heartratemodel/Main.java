package io.airow.heartratemodel;

import org.apache.commons.math3.analysis.polynomials.PolynomialFunctionLagrangeForm;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        double[] x = {3,7,12,17,22,27,32};
        double[] y = {120,126,122,140,142,155,145};


        double[] lagrange = new double[35];
        double[] modelResult = new double[35];
        for (int i = 0; i < y.length*5; i++) {
            var modelValue = HeartRateInterpolation.execute(y, i);
            modelResult[i] = modelValue;
            lagrange[i] = PolynomialFunctionLagrangeForm.evaluate(x,y,i);
        }

        System.out.println(Arrays.toString(lagrange));
        System.out.println(Arrays.toString(modelResult));
        System.out.println("Lost: " + lost(lagrange, modelResult, 2) + "%");
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
