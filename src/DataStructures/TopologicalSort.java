package DataStructures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * Adapted from: Implementation of the Topological Sort algorithm by Tushar Roy uploaded to GitHub on Aug 2, 2015
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/TopologicalSort.java
 * A class that implements the Topological Sort algorithm
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 * @param <V> Generic type declaration for the TopologicalSort class
 */
public class TopologicalSort<V> {
    
    /**
     * Primary method for performing topological sort
     * @param graph an adjacency list graph to be sorted topographically
     * @return a stack containing the topographically sorted order of the graph
     */
    public Deque<GraphVertex<V>> TopSort(AdjListGraph<V> graph){
        Deque<GraphVertex<V>> sorted = new ArrayDeque<>();
        Set<GraphVertex<V>> visited = new HashSet<>();
        for(GraphVertex<V> v : graph.getVertices()){
            Deque<GraphVertex<V>> recurStack = new ArrayDeque<>(); //for each new call to the recursive helper method, initialize a new recursion stack
            if(visited.contains(v)){
                continue;
            }
            //Calls the recursive helper method
            TopSortDFS(v, sorted, visited, recurStack);
        }
        return sorted; //return the stack containing the sorted order of vertices for the graph
    }

    /**
     * Recursive helper method for the Topological Sort method. Implements the
     * depth-first search algorithm to visit all the adjacent vertices and their
     * adjacent vertices from a given origin vertex
     * @param v the vertex to begin a depth-first search from
     * @param stack a stack that is passed along with each recursive call to keep
     * track of the topologically sorted order of vertices
     * @param visited a set containing all the vertices of the graph that have already been visited
     * @param recurStack Stack of vertices of the previous recursive calls. Used to detect cycles in the graph.
     * @throws IllegalStateException if a cycle is detected
     */
    private void TopSortDFS(GraphVertex<V> v, Deque<GraphVertex<V>> stack, Set<GraphVertex<V>> visited,
            Deque<GraphVertex<V>> recurStack) throws IllegalStateException{
        visited.add(v); //add the current vertex to the visited set
        recurStack.offerFirst(v); //add the current vertex to the recursive stack
        for(GraphVertex<V> child : v.getAdjacentVertices()){
            if(recurStack.contains(child)){ //if the recursion stack contains an adjacent vertex of the current vertex, a cycle is detected
                throw new IllegalStateException("Error: Graph contains a cycle."
                        + " Topological Sort can only be performed on a directed"
                        + " acyclic graph.\nCycle from: " + v.getElement() 
                        + " --> " + child.getElement());
            }
            if(visited.contains(child)){
                continue;
            }
            TopSortDFS(child, stack, visited, recurStack);
        }
        stack.offerFirst(v); //add the vertex to the sorted stack when there are no more adjacent vertices to visit
    }
}
