import java.util.Scanner;

public class ChangeMaker {
   public static int[] change_DP(int n, int[] d) {
      int[] A = new int[n + 1];
      int[] C = new int[n + 1];
      int[] res = new int[d.length];
      int counter = n;

      for (int i = 0; i < res.length; i++) {
         res[i] = 0;
      }

      C[0] = 0;
 
      for (int j = 1; j < C.length; j++) {
         C[j] = 1 + min(C, j, d, A);
      } 
      while (counter > 0) {
         res[A[counter]]++;
         counter -= d[A[counter]];
      }
      /*System.out.println("A:");
      printArray(A);

      System.out.println("C:");
      printArray(C);*/

      return res;
   }

   private static void printArray(int[] arr) {
      for (int i = 0; i < arr.length; i++) {
         System.out.print(arr[i] + " ");
      }
      System.out.println();
   }

   private static int min(int[] C, int j, int[] d, int[] A) {
      int curMin = 99999;
      int tmp, minCoin = 0;
      
      for (int i = 0; i < d.length; i++) {
         if (j - d[i] > 0) {
            tmp = C[j - d[i]];
            if (tmp < curMin) { 
               curMin = tmp; 
               minCoin = i;
            }
         }
         else if (j - d[i] == 0) {
            curMin = C[j - d[i]];
            minCoin = i;
            break;
         }
      }   
      A[j] = minCoin;                        
      return curMin;
   }
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      System.out.println("Input number of coins:");
      int k = in.nextInt();
      int count = 0;

      int[] d = new int[k];
      System.out.println("Enter list of coins separated by spaces: ");
      for (int i = 0; i < k; i++) {
         d[i] = in.nextInt();
      }
      System.out.print("Input amount for which to make change: ");
      
      int n = in.nextInt();
      while (n > 0) {
         int[] arr = change_DP(n, d);
         System.out.println("\nDP algorithm results\n");
         System.out.println("Amount: " + n);
         System.out.print("Optimal distribution: ");
         for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
               if (count > 0) {
                  System.out.print(" + ");
               }
               System.out.print(arr[i] + "*" + d[i] + "c");
               count++;
            }
         }
         count = 0;
         System.out.println();
         System.out.print("Optimal coin count: ");
         int sum = 0;
         for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
         }
         System.out.println(sum + "\n");
         System.out.println("Input amount for which to make change");
         n = in.nextInt();
      }
   }
}
