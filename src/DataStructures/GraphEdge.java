package DataStructures;

/**
 * Adapted from: Implementation of an Edge class by Tushar Roy uploaded to GitHub on Dec 13, 2015
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/Graph.java
 * A class representing a graph edge
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 * @param <V> Generic type declaration for the Graph Edge class
 */
public class GraphEdge<V> {
        private final GraphVertex<V> firstVertex;
        private final GraphVertex<V> secondVertex;
        private boolean isDirected = false;

        /**
         * Public constructor for the GraphEdge class
         * @param u the source vertex of the edge
         * @param v the destination vertex of the edge
         */
        public GraphEdge(GraphVertex<V> u, GraphVertex<V> v){
            firstVertex = u;
            secondVertex = v;
        }
        
        /**
         * Additional constructor for the GraphEdge class
         * @param u the source vertex of the edge
         * @param v the destination vertex of the edge
         * @param isDirected boolean value indicating whether the graph is directed
         */
        public GraphEdge(GraphVertex<V> u, GraphVertex<V> v, boolean isDirected){
            firstVertex = u;
            secondVertex = v;
            this.isDirected = isDirected;
        }
        
        /**
         * Gets the source vertex of the edge
         * @return the source vertex of the edge
         */
        public GraphVertex<V> getFirstVertex() {return firstVertex;}
        /**
         * Returns the destination vertex of the edge
         * @return the destination vertex of the edge
         */
        public GraphVertex<V> getSecondVertex() {return secondVertex;}
        /**
         * Returns whether the graph is directed
         * @return The boolean value indicating whether a graph is directed
         */
        public boolean isDirected() {return isDirected;}
    }
