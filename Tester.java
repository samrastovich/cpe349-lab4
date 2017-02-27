/* Authors: Matt Bryan and Sam Rastovich
 * IDs: mpbryan & srastovi
 * Date: 2/24
 * Assignment: Project 4 */

public class Tester {
   public static void main(String args[]) {
      int[] set1 = {100, 50, 25, 10, 5, 1};
      int[] set2 = {100, 50, 20, 15, 10, 5, 3, 2, 1};
      int[] set3 = {64, 32, 16, 8, 4, 2, 1};
      int[] set4 = {100, 50, 25, 10, 1};
      int[] set5 = {66, 35, 27, 18, 10, 1};
      int[][] sets = {set1, set2, set3, set4, set5};
      int[] resDP, resGreedy;
      int matchCount = 0, setCount = 1, countDP = 0, countGreedy = 0;

      System.out.println("Testing change_DP and change_greedy algorithms");


      for (int[] curSet : sets) {

         System.out.print("Testing set" + setCount++ + ": ");
         for (int i = 1; i <= 200; i++) {
            //set tests
            resDP = ChangeMaker.change_DP(i, curSet);
            resGreedy = ChangeMaker.change_greedy(i, curSet);

            //Optimal Coin Counts
            for (int j = 0; j < resDP.length; j++) {
               countDP += resDP[j];
            }
            for (int j = 0; j < resGreedy.length; j++) {
               countGreedy += resGreedy[j];
            }
            if (countDP == countGreedy) {
               matchCount++;
            }

         	countDP = 0;
         	countGreedy = 0;
         }
         System.out.println(matchCount + " matches in 200 tests");
   		matchCount = 0;
      }
   }
}
