import java.io.*;
import java.util.*;
 

class Graph {
    private int V;                              
 
    private LinkedList<Integer> adj[];             
 
    public Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
{
          adj[i] = new LinkedList();
    	}
 
    void addEdge(int v, int w)
    {
        adj[v].add(w);                              
    }
 

    void DFSUtil(int vertex, boolean nodes[])
    {

        nodes[vertex] = true;                         
        System.out.print(vertex + " ");
        int a = 0;
 
        for (int i = 0; i < adj[vertex].size(); i++)  
            {
                a = adj[vertex].get(i);
                if (!nodes[a])                    
                {
                    DFSUtil(a, nodes);
                }
            }  
    }

    void DFS(int v)
    {
        boolean already[] = new boolean[V];             
        DFSUtil(v, already);
    }
 
    public static void main(String args[])
    {
        Graph g = new Graph(6);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 0);
        g.addEdge(1, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 3);
        g.addEdge(5, 3);
 
        System.out.println(
            "Following is Depth First Traversal: ");
 
        g.DFS(0);
    }
}
 
Iterative implementation
The iterative implementation of DFS in java follows:-

import java.util.*; 
  

 class Graph 
    { 
        int V;                                          
          
        LinkedList<Integer>[] adj;                      
          
        Graph(int V) 
        { 
            this.V = V; 
            adj = new LinkedList[V]; 
              
            for (int i = 0; i < adj.length; i++) 
                adj[i] = new LinkedList<Integer>(); 
              
        } 
          
        void addEdge(int v, int w) 
        { 
            adj[v].add(w);                             
        } 
          
        void DFS(int n) 
        { 
            boolean nodes[] = new boolean[V]; 
      
            Stack<Integer> stack = new Stack<>(); 
              
            stack.push(n);                                    
            int a = 0;
              
            while(!stack.empty()) 
            { 
                n = stack.peek();                      
                stack.pop();                            
                  
                if(nodes[n] == false) 
                { 
                    System.out.print(n + " "); 
                    nodes[n] = true; 
                } 
                  
                for (int i = 0; i < adj[n].size(); i++) 
            {
                a = adj[n].get(i);
                if (!nodes[a])                   
                {
                    stack.push(a);                          
                }
            }  
                  
            } 
        } 
      
    public static void main(String[] args)  
    { 
        Graph g = new Graph(6); 
          
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 0);
        g.addEdge(1, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 3);
        g.addEdge(5, 3); 
              
        System.out.println("Following is the Depth First Traversal"); 
        g.DFS(0); 
    } 
} 
