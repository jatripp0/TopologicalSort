package DataStructures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Adapted from: Implementation of a Graph class by Tushar Roy uploaded to GitHub on Dec 13, 2015
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/Graph.java
 * A class that represents a graph using an adjacency list structure
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 * @param <V> Generic type specification for the Adjacency List Graph
 */
public class AdjListGraph<V>{
    
    private boolean isDirected = false; //boolean flag to indicate whether a graph is directed
    private final List<GraphEdge<V>> edges;
    private final Map<V, GraphVertex<V>> vertices;
    
    /**
     * Public constructor for the Adjacency List Graph class
     * @param isDirected indicates whether the graph should be treated as directed
     */
    public AdjListGraph(boolean isDirected){
        edges = new ArrayList<>();
        vertices = new HashMap<>();
        this.isDirected = isDirected;
    }
    
    /**
     * Adds an edge to the graph from the source vertex u to the destination 
     * vertex v. An edge from v to u is added only if the graph is marked as
     * undirected.
     * @param source the source vertex for the edge
     * @param dest the destination vertex for the edge
     */
    public void addEdge(V source, V dest){
        GraphVertex<V> vertex1;
        if(vertices.containsKey(source)){
            vertex1 = vertices.get(source);
        }else{
            vertex1 = new GraphVertex<>(source);
            vertices.put(source, vertex1);
        }
        GraphVertex<V> vertex2;
        if(vertices.containsKey(dest)){
            vertex2 = vertices.get(dest);
        }else{
            vertex2 = new GraphVertex<>(dest);
            vertices.put(dest, vertex2);
        }

        GraphEdge<V> edge = new GraphEdge<>(vertex1,vertex2,isDirected);
        edges.add(edge);
        vertex1.addAdjVertex(edge, vertex2);
        if(!isDirected){//create a back edge if the graph is undirected
            vertex2.addAdjVertex(edge, vertex1);
        }
    }
    
    /**
     * Returns the collection of vertices of the graph
     * @return a collection of GraphVertex objects
     */
    public Collection<GraphVertex<V>> getVertices(){
        return vertices.values();
    }    
}
