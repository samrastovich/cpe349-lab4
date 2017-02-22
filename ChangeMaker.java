public class ChangeMaker {
   public static int[] change_DP(int n, int[] d) {
      int[] A = new int[n];
      int[] C = new int[n];
      int[] res = new int[d.length];
 
      for (int j = 0; j < C.length; j++) {
         if (j == 0)
            C[j] = 0;
         else if (j > 0) 
            C[j] = 1 + min(C, j, d);
         
      } 
      for (int i = 0; i < A.length; i++) {
         res[A[i]]++;
      }

      return res;
   }

   private static int min(int[] C, int j, int[] d, in[] A) {
      int res = -99999;
      int minCoin = 0;
      
      for (int i = 0; i < d.length; i++) {
         int tmp = C[j - d[i]];
         if (tmp < res) { 
            res = tmp; 
            minCoin = i;
         }
      }   
      A[j] = minCoin;                        
      return res;
   }
   public static void main(String[] args) [
      Scanner in = new Scanner(System.in);
      System.out.println("Input number of coins:");
      int k = in.nextInt();

      int[] d = new int[k];
      System.out.println("Enter list of coins separated by spaces");
      for (int i = 0; i < k; i++) {
         d[i] = in.nextInt();
      }
      System.out.println("Input amount for which to make change");
      
      int n = in.nextInt();
      while (n > 0) {
         int[] arr = change_DP(n, d);
         System.out.println("DP algorithm results");
         System.out.println("Amount: " + n);
         System.out.println("Optimal distribution: ");
         for (int i = 0; i < arr.length; i++) {
            if (i > 0) 
               System.out.print(" + ");
            System.out.println(arr[i] + "*" + d[i] + "c");
         }
         System.out.println("Optimal coin count: ");
         int sum = 0;
         for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
         }
         System.out.print(sum);
         System.out.println("Input amount for which to make change");
         n = in.nextInt();
      }
   }
}
