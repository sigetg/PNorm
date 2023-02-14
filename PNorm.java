/*
* Author George Sigety
*/

import java.util.Scanner;
import java.lang.Math;

public class PNorm {
  //instance variables
  public int n;
  public static double[] v;
  public static int p;
  public static double norm;

  //Methods
  public static double norm(double[] v, int p, int n) {
    double preNorm = 0;
    for (int i = 0; i < n; i++) {
      double y = v[i];
      double var = Math.pow(y,p);
      preNorm += var;
    }
    double j = p;
    double norm = Math.pow(preNorm, 1/j);
    return norm;
  }

  public static double euclidNorm(double[] v, int p, int n) {
    double preNorm = 0;
    p = 2;
    for (int i = 0; i < n; i++) {
      double y = v[i];
      double var = Math.pow(y,p);
      preNorm += var;
    }
    double j = p;
    double norm = Math.pow(preNorm, 1/j);
    return norm;
  }

  public static void main (String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please enter an integer number of dimentions or any letter to quit.");
    System.out.print("> ");
    while (scanner.hasNext()) {
      int dim = scanner.nextInt();
      scanner.nextLine();
      System.out.println("Please enter " + dim + " rational-number coordinates.");
      System.out.print("> ");
      String cords  = scanner.nextLine();
      String[] strArray = cords.split(" ");
      double[] doubleArray = new double[strArray.length];
      for (int i = 0; i < strArray.length; i++) {
        doubleArray[i] = Double.parseDouble(strArray[i]);
      }
      System.out.println("Please enter an integer power.");
      System.out.print("> ");
      int pow = scanner.nextInt();
      double finalNorm = PNorm.norm(doubleArray, pow, dim);
      System.out.println("The 2-norm of the coordinates is " + finalNorm);
      double finalEucNorm = PNorm.euclidNorm(doubleArray, pow, dim);
      System.out.println("The Euclidian norm is " + finalEucNorm);
      System.out.println("Please enter an integer number of dimentions or any letter to quit.");
      System.out.print("> ");
    }
  }
}
