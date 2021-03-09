
public class Main {

  public int n;

  // recursive
  public void factorial(double n) {
    if (n == 1) {
      return n;
    }
    else {
      return n * factorial(n - 1);
    }
  }

// Traditional
  public void tFactorial(double n) {
    for(int i = n; i <= 8785856; i++) {
      tFactorial = tFactorial * i;
    }
    return tFactorial;
  }

// Traditional Fibonacci
  public void tFibonacci(double n) {
    if (n == 1 || n == 0) {
      return n;
    }
    return tFibonacci(n - 1) + tFibonacci(n - 2);
  }

// Recursive Fibonacci
  public void rFibonacci(double n) {
    if (n == 0) {
      return 0;
    }
    else if (n == 1) {
      return 1;
    }
    else {
      return rFibonacci(n - 1) + rFibonacci(n - 2);
    }
  }
}
