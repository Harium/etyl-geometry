package com.harium.etyl.geometry.math;

public class EtylMath {

    public static double diffMod(double a, double b) {
        double result = a - b;
        return mod(result);
    }

    public static int diffMod(int a, int b) {
        int result = a - b;
        return mod(result);
    }

    public static float diffMod(float a, float b) {
        float result = a - b;
        return mod(result);
    }

    public static double divMod(double a, double b) {
        double result = a / b;
        return mod(result);
    }

    public static double sqr(double a) {
        return a * a;
    }

    public static int mod(int a) {
        if (a < 0) {
            return -a;
        }
        return a;
    }

    public static float mod(float a) {
        if (a < 0) {
            return -a;
        }
        return a;
    }

    public static double mod(double a) {
        if (a < 0) {
            return -a;
        }
        return a;
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static int max(int a, int b, int c) {
        return max(a, max(b, c));
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }

    public static int min(int a, int b, int c) {
        return min(a, min(b, c));
    }

    public static float max(float a, float b) {
        return a > b ? a : b;
    }

    public static float max(float a, float b, float c) {
        return max(a, max(b, c));
    }

    public static float min(float a, float b) {
        return a < b ? a : b;
    }

    public static float min(float a, float b, float c) {
        return min(a, min(b, c));
    }

    public static double max(double a, double b) {
        return a > b ? a : b;
    }

    public static double max(double a, double b, double c) {
        return max(a, max(b, c));
    }

    public static double min(double a, double b) {
        return a < b ? a : b;
    }

    public static double min(double a, double b, double c) {
        return min(a, min(b, c));
    }

}
