package com.sanfoundry.hardgraph;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
 
public class BranchandBound
{
    static int[][]         wt;                             // Matrix of edge
                                                            // weights
    static String[]        city;                           // Vector of city
                                                            // names
  
  static int             n;                              // Dimension for wt
                                                            // and city
    static ArrayList<Tour> soln    = new ArrayList<Tour>();
    static int             bestTour;                       // Initialized in
                                                            // init()
    static int             blocked;                        // Ditto
    static boolean         DEBUG   = true;                 // Show
                                                            // accept/reject
                                                            // decisions
    static boolean         VERBOSE = true;                 // Show all tours
                                                            // discovered
 
    @SuppressWarnings("rawtypes")
    private static class Tour implements Comparable
    {
        int[]          soln;
        int            index;        // In branch-and-bound, start of variable
        int            dist;
        static int     nTours = 0;
        // Best-first based on dist, or DFS based on maxheap of index
        static boolean DFS    = true;
        static boolean DBG    = true;
 
        /*
         * Presumable edges up to [index-1] have been verified before
         * this constructor has been called. So compute the fixed
         * distance from [0] up to [index-1] as dist.
         */
        private Tour(int[] vect, int index, int[][] wt)
        {
            dist = 0;
            for (int k = 1; k < index; k++)
                // Add edges
                dist += wt[vect[k - 1]][vect[k]];
            if (index == n)
                dist += wt[vect[n - 1]][vect[0]]; // Return edge
            soln = new int[n]; // Deep copy
            System.arraycopy(vect, 0, soln, 0, n);
            this.index = index; // Index to permute
            nTours++; // Count up # of tours
            if (DBG)
                System.out.printf("Idx %d: %s\n", index, toString());
        }
 
        public int compareTo(Object o)
        {
            Tour rt = (Tour) o;
            int c1 = rt.index - this.index, c2 = this.dist - rt.dist;
            if (DFS)
                return c1 == 0 ? c2 : c1;
            else
                return c2;
        }
