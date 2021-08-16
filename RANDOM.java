/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package random;

import java.util.Random;

/**
 *
 * @author Eliezer Klu
 */
public class RANDOM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] Array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
RemoveElement(Array);
}

static void RemoveElement(int[] Array) {
Random rand = new Random();
while (Array.length > 0) {
  int index = rand.nextInt(Array.length);
  System.out.println("Element " + Array[index] + " removed at  Index "   + index);
  int[] Array1 = new int[Array.length - 1];
  for (int i = 0; i < index; i++)
   Array1[i] = Array[i];
 for (int i = index; i < Array.length - 1; i++)
   Array1[i] = Array[i + 1];
 Array = Array1;
    }
    
}
}
