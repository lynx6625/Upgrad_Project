public class isPrime {

  static void isPrime(int n) {
    if (n < 2) {
      System.out.println("There are no prime numbers less than " + n);
      return;
    }
    boolean prime[] = new boolean[n + 1]; //boolean array of size n+1
    for (int i = 0; i <= n; i++) { //iterating from 0 to n
      prime[i] = true;
    }
    for (int p = 2; p * p <= n; p++) { //if p is 2, it is prime, else increment, also the root n method
      if (prime[p] == true) {
        for (int i = p * p; i <= n; i += p) { //p+p=2p(multiple); if it is prime, all multiples>= square of n marked as false
          prime[i] = false;
        }
      }
    }
    boolean found = false;
    for (int i = 2; i <= n; i++) {
      if (prime[i] == true) {
        System.out.print(i + " ");
        found = true;
      }
    }
    if (!found) {
      System.out.println("There are no prime numbers less than " + n);
      return;
    }
  }

  public static void main(String args[]) {
    isPrime(-5);
  }
}
