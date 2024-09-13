import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.Queue; //hint: might be useful for BFS - https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html
import java.util.LinkedList; //hint: might be useful for BFS - https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html
import java.util.Stack; //hint: might be useful for DFS - https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html

/**
This class will be a driver class that demonstrates graph traversal algorithms
TODO - You must implement the breadthFirstSearch and depthFirstSearch methods contained in this class
*/
public class Graph1
{
   public static void main(String[] args) throws IOException
   {
      //An ArrayList of Nodes, where each node contains an adjacency list of all nodes adjacent to it
      ArrayList<Node> graph = createGraph();
           
      //you can call displayGraph to have it print out the information in the graph
      //this is just provided to help you visualize each node in the graph, along with it's adjacent nodes
      displayGraph(graph);
      
      //call BFS and DFS here to have them print out their traversals
      //YOU MUST IMPLEMENT THESE METHODS!!!!
      //the definitions are already done for you towards the end of this file, you just need to add the code to the body
      breadthFirstSearch(graph);
      depthFirstSearch(graph);
      
   }
   
   /*
   Creates an ArrayList of Node objects that represent a graph
   
   Graph information is read from a GraphInfo.txt file contained in the same directory as this code
   Each line of the text file will contain information about a specific node and the nodes that are adjacent to it
   The nodes are delimited by a comma
   Example line of GraphInfo.txt:
   A,B,D
      A - the starting Node
      B D - nodes that are adjacent to A 
      This means that there is an edge from A to B and an edge from A to D
   This is an unweighted graph, so no need to worry about weights on the edges  
   
   @return graph The graph 
   */
   public static ArrayList<Node> createGraph() throws IOException {
      ArrayList<Node> graph = new ArrayList<>();
   
      File file = new File("GraphInfo.txt");
      Scanner inputFile = new Scanner(file);
   
      while (inputFile.hasNext()) {
         String line = inputFile.nextLine();
         String[] tokens = line.split(",");
      
         if (tokens.length > 0) {
            Node n = new Node(tokens[0]);
            int nodeIndex = graph.indexOf(n);
            if (nodeIndex != -1) {
               n = graph.get(nodeIndex);
            } else {
               graph.add(n);
            }
         
            // Add the adjacent nodes in the order they appear in the input file
            for (int i = 1; i < tokens.length; i++) {
               Node adj = new Node(tokens[i]);
               int adjNodeIndex = graph.indexOf(adj);
               if (adjNodeIndex != -1) {
                  adj = graph.get(adjNodeIndex);
               } else {
                  graph.add(adj);
               }
               n.addAdjacentNode(adj);
            }
         }
      }
   
      return graph;
   }      
   /**
   Displays all Node information for each Node in the graph
   @param graph The graph
   */
   public static void displayGraph(ArrayList<Node> graph)
   {
      for(Node n : graph)
      {
         System.out.println(n);
      }
   }
   
   /**
   TODO - Implement this method
   This method will perform a Breadth First Search traversal starting with the first Node contained in the graph
   Follow the algorithm described in 13.5.5 of your zyBook
   At the end of the method, you should display the contents of discoveredSet, which will be the traversal of the graph
   @param graph An ArrayList of Node objects representing a graph
   */
   public static void breadthFirstSearch(ArrayList<Node> graph)
   {
      //perform a breadth first traversal from the first Node in the graph (graph.get(0))
      //Follow the algorithm described in 13.5.5 of your zyBook
      //It lays out the entire algorithm in psuedocode - you just need to convert it into java code
      //WRITE YOUR CODE HERE
      Queue<Node> queue = new LinkedList<>();
      boolean[] visited = new boolean [graph.size()];
      
      queue.offer(graph.get(0));
      visited[0] = true;
      
      System.out.println("BFS:");
      
      while (!queue.isEmpty())
      {
         Node currentNode = queue.poll();
         System.out.print(currentNode.getName() + " ");
         
         for(Node value : currentNode.getAdjacencyList())
         {
            int index = graph.indexOf(value);
            if(!visited[index])
            {
               queue.offer(value);
               visited[index] = true;
            }
         }
      }
               
      
      //print out the contents of discoveredSet - meaning the name of each node (don't use the toString() method since it includes the adjacency list)
      System.out.println();
   }
  /**
 * TODO - Implement this method
 * This method will perform a Depth First Search traversal starting with the first Node contained in the graph
 * Follow the algorithm described in 13.6.3 of your zyBook
 * At the end of the method, you should display the contents of visitedSet, which will be the traversal of the graph
 * @param graph An ArrayList of Node objects representing a graph
 */
   public static void depthFirstSearch(ArrayList<Node> graph) {
      boolean[] visited = new boolean[graph.size()];
      System.out.println("DFS:");
      depthFirstSearchRecursive(graph, 0, visited);
      System.out.println();
   }

   private static void depthFirstSearchRecursive(ArrayList<Node> graph, int currentIndex, boolean[] visited) {
      visited[currentIndex] = true;
      Node currentNode = graph.get(currentIndex);
      System.out.print(currentNode.getName() + " ");
   
    // Traverse the adjacency list in the expected order
      for (Node neighbor : currentNode.getAdjacencyList()) {
         int neighborIndex = graph.indexOf(neighbor);
         if (!visited[neighborIndex]) {
            depthFirstSearchRecursive(graph, neighborIndex, visited);
         }
      }
   }    
   
}

/*
while(!stackList.isEmpty())
      {
         Node currentNode = stackList.pop();
         System.out.print(currentNode.getName() + " ");
         
         for(Node value : currentNode.getAdjacencyList())
         {
            int index =  graph.indexOf(value);
            if(!visited[index])
            {
               stackList.push(value);
               visited[index] =  true;
            }
         }
      }


*/