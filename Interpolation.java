package com.ganzory
import java.util.Scanner;


public class Interpolation {

  //  Newton's 'divided-difference' interpolation method

  public static void newton_general() {

    Scanner sc = new Scanner(System.in);

    System.out.print("No. of points: ");
    int ptsNum = sc.nextInt();
    float[] xs = new float[ptsNum];
    float[] ys = new float[ptsNum];

    System.out.println("Enter points in pairs:  (x, y)");

    for (int i = 0; i < ptsNum; i++) {
      xs[i] = sc.nextFloat();
      ys[i] = sc.nextFloat();
    }

    short play = 1;

    while (play == 1) {
      System.out.print("Enter an X to find its Y: ");
      float x = sc.nextFloat();

      float res = ys[0], coef = 1;
      for (int i = 1; i < ptsNum; i++) {
        coef *= (x - xs[i - 1]);
        for (int j = ptsNum - 1; j >= i; j--) {
          ys[j] = (ys[j] - ys[j - 1]) / (xs[j] - xs[j - i]);
        }
        res += coef * ys[i];
      }

      System.out.println(res);
      System.out.print("Another X? press 1 for yes, else 0:  ");
      play = sc.nextShort();
    }

    sc.close();

  }



  //  Lagrange's interpolation method

  public static void lagrange() {

    Scanner sc = new Scanner(System.in);

    System.out.print("No. of points: ");
    int ptsNum = sc.nextInt();
    float[] xs = new float[ptsNum];
    float[] ys = new float[ptsNum];

    System.out.println("Enter points in pairs:  (x, y)");

    for (int i = 0; i < ptsNum; i++) {
      xs[i] = sc.nextFloat();
      ys[i] = sc.nextFloat();
    }

    short play = 1;

    while (play == 1) {
      System.out.print("Enter an X to find its Y: ");
      float x = sc.nextFloat();

      float res = 0;
      for (int i = 0; i < ptsNum; i++) {
        float num = 1, den = 1;
        for (int j = 0; j < ptsNum; j++) {
          if (j == i)  continue;
          num *= (x - xs[j]);
          den *= (xs[i] - xs[j]);
        }
        res += (num / den) * ys[i];
      }

      System.out.println(res);
      System.out.print("Another X? press 1 for yes, else 0:  ");
      play = sc.nextShort();
    }

    sc.close();

  }

}
