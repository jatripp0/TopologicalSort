package edu.frostburg.COSC310.TrippJohnathan;

import DataStructures.AdjListGraph;
import DataStructures.GraphVertex;
import DataStructures.TopologicalSort;
import java.util.Deque;


/**
 * Main class for the Topological Sort project, used to test the sorting algorithm
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 */
public class TopologicalSortProject {

    /**
     * Main method for the project. Initializes and sets up a graph, then
     * topologically sorts the graph and prints the sorted order.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AdjListGraph<String> graph = new AdjListGraph<>(true);
        
        //Example graph for ordering that clothes should be put on
//        graph.addEdge("Underwear", "Shoes");
//        graph.addEdge("Pants", "Belt");
//        graph.addEdge("Underwear", "Pants");
//        graph.addEdge("Belt", "Jacket");
//        graph.addEdge("Tie", "Jacket");
//        graph.addEdge("Shirt", "Tie");
//        graph.addEdge("Shirt", "Belt");
//        graph.addEdge("Pants", "Belt");
//        graph.addEdge("Socks", "Shoes");
        
        //Example graph for course order for the Computer Science major, including some math courses
        graph.addEdge("COSC 101", "COSC 240");
        graph.addEdge("MATH 119", "COSC 240");
        graph.addEdge("MATH 119", "COSC 102");
        graph.addEdge("MATH 236", "COSC 310");
        graph.addEdge("COSC 241", "COSC 310");
        graph.addEdge("COSC 240", "COSC 241");
        graph.addEdge("COSC 102", "COSC 310");
        graph.addEdge("COSC 365", "COSC 460");
        graph.addEdge("COSC 241", "COSC 325");
        graph.addEdge("COSC 240", "COSC 350");
        graph.addEdge("COSC 241", "COSC 331");
        graph.addEdge("COSC 241", "COSC 365");
        //The following edge introduces a cycle to the graph, causing an error.
        //graph.addEdge("COSC 325", "COSC 240"); 
        
        //Runs the topological sort algorithm on the graph
        try{
            TopologicalSort<String> sort = new TopologicalSort<>();
            Deque<GraphVertex<String>> sorted = sort.TopSort(graph);
            while(!sorted.isEmpty()){
                System.out.println(sorted.poll().getElement());
            }
        } catch (IllegalStateException e){
            System.out.println(e.getMessage()); //Prints an error message if a cycle is detected by topological sort
        }
    }
    
}
