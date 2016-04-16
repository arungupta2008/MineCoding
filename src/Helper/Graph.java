package Helper; /**
 * Created by arun.gupta on 16/04/16.
 */
/**
 * Undirected, unweighted simple graph data type
 * <p>
 *  Notes:
 *  <ul>
 *   <li> Parallel edges are not allowed
 *   <li> Self loops are allowed
 *  </ul>
 *  <p>
 *  This Helper.Graph class was adapted from
 *  <a href="http://www.cs.princeton.edu/introcs/45graph/Graph.java">Helper.Graph.java</a>
 *
 *  http://homepage.cs.uiowa.edu/~hzhang/c31/code/Vertex.java
 *  http://homepage.cs.uiowa.edu/~hzhang/c31/code/
 */

/*
* /******************************************************************************
 *  Compilation:  javac Helper.Graph.java
 *  Execution:    java Helper.Graph
 *  Dependencies: ST.java SET.java In.java StdOut.java
 *
 *  Undirected graph data type implemented using a symbol table
 *  whose keys are vertices (String) and whose values are sets
 *  of neighbors (SET of Strings).
 *
 *  Remarks
 *  -------
 *   - Parallel edges are not allowed
 *   - Self-loop are allowed
 *   - Adjacency lists store many different copies of the same
 *     String. You can use less memory by interning the strings.
 *
 ******************************************************************************/

/**
 *  The <tt>Helper.Graph</tt> class represents an undirected graph of vertices
 *  with string names.
 *  It supports the following operations: add an edge, add a vertex,
 *  get all of the vertices, iterate over all of the neighbors adjacent
 *  to a vertex, is there a vertex, is there an edge between two vertices.
 *  Self-loops are permitted; parallel edges are discarded.
 *
 *  http://introcs.cs.princeton.edu/java/home/
 *  <p>
 *  For additional documentation, see <a href="http://introcs.cs.princeton.edu/45graph">Section 4.5</a> of
 *  <i>Introduction to Programming in Java: An Interdisciplinary Approach</i> by Robert Sedgewick and Kevin Wayne.
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Graph {
    // from name to vertex, using HashMap
    private HashMap<String, Vertex> myVertices;

    // Adjacent list is a set of vertices represented by a search tree: TreeSet<Helper.Vertex>

    // from vertex to adjacent list, using HashMap
    private HashMap<Vertex, TreeSet<Vertex>> myAdjList;

    private int myNumVertices;
    private int myNumEdges;

    // EMPTY_SET is a constant:
    private static final TreeSet<Vertex> EMPTY_SET = new TreeSet<Vertex>();
    public static final int INFINITY = Integer.MAX_VALUE;

    // Construct an empty Helper.Graph
    public Graph() {
        myAdjList = new HashMap<Vertex, TreeSet<Vertex>>();
        myVertices = new HashMap<String, Vertex>();
        myNumVertices = myNumEdges = 0;
    }

    // Add a new vertex name with no neighbors (if vertex does not yet exist)
    public Vertex addVertex(String name) {
        Vertex v;
        v = myVertices.get(name);
        if (v == null) {
            v = new Vertex(name);
            myVertices.put(name, v);
            myAdjList.put(v, new TreeSet<Vertex>());
            myNumVertices += 1;
        }
        return v;
    }

    /**
     * Returns the Helper.Vertex matching v
     * @param name a String name of a Helper.Vertex that may be in
     * this Helper.Graph
     * @return the Helper.Vertex with a name that matches v or null
     * if no such Helper.Vertex exists in this Helper.Graph
     */
    public Vertex getVertex(String name) {
        return myVertices.get(name);
    }

    /**
     * Returns true iff v is in this Helper.Graph, false otherwise
     * @param name a String name of a Helper.Vertex that may be in
     * this Helper.Graph
     * @return true iff v is in this Helper.Graph
     */
    public boolean hasVertex(String name) {
        return myVertices.containsKey(name);
    }

    /**
     * Is from-to, an edge in this Helper.Graph. The graph is
     * undirected so the order of from and to does not
     * matter.
     * @param from the name of the first Helper.Vertex
     * @param to the name of the second Helper.Vertex
     * @return true iff from-to exists in this Helper.Graph
     */
    public boolean hasEdge(String from, String to) {
        Vertex v1 = myVertices.get(from);
        Vertex v2 = myVertices.get(to);
        if (v1 == null || v2 == null) return false;
        return myAdjList.get(v1).contains(v2);
    }

    public Set<Vertex> NeighborOfVertex(String vertexName) {
        Set<Vertex> neighborVertex = new HashSet<>();
        for (Vertex w : this.adjacentTo(vertexName)) {
            neighborVertex.add(w);
        }
        return neighborVertex;
    }

    /**
     * Add to to from's set of neighbors, and add from to to's
     * set of neighbors. Does not add an edge if another edge
     * already exists
     * @param from the name of the first Helper.Vertex
     * @param to the name of the second Helper.Vertex
     */
    public void addEdge(String from, String to) {
        Vertex v, w;
        if (hasEdge(from, to)) return;  // no duplicate edges
        myNumEdges += 1;
        if ((v = getVertex(from)) == null)
            v = addVertex(from);
        if ((w = getVertex(to)) == null)
            w = addVertex(to);
        myAdjList.get(v).add(w);
        myAdjList.get(w).add(v);  // undirected graph only
    }

    /**
     * Return an iterator over the neighbors of Helper.Vertex named v
     * @param name the String name of a Helper.Vertex
     * @return an Iterator over Vertices that are adjacent
     * to the Helper.Vertex named v, empty set if v is not in graph
     */
    public Iterable<Vertex> adjacentTo(String name) {
        Vertex v = getVertex(name);
        if (v == null) return EMPTY_SET;
        return myAdjList.get(getVertex(name));
    }

    /**
     * Return an iterator over the neighbors of Helper.Vertex v
     * @param v the Helper.Vertex
     * @return an Iterator over Vertices that are adjacent
     * to the Helper.Vertex v, empty set if v is not in graph
     */
    public Iterable<Vertex> adjacentTo(Vertex v ) {
        if (!myAdjList.containsKey(v)) return EMPTY_SET;
        return myAdjList.get(v);
    }

    /**
     * Returns an Iterator over all Vertices in this Helper.Graph
     * @return an Iterator over all Vertices in this Helper.Graph
     */
    public Iterable<Vertex> getVertices() {
        return myVertices.values();
    }

    public int numVertices() {
        return myNumVertices;
    }

    public int numEdges(){
        return myNumEdges;
    }


    /*
     * Returns adjacency-list representation of graph
     */
    public String toString() {
        String s = "";
        for (Vertex v : myVertices.values()) {
            s += v + ": ";
            for (Vertex w : myAdjList.get(v)) {
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }

    private String escapedVersion(String s) {
        return "\'"+s+"\'";

    }

    public void outputGDF(String fileName)
    {
        HashMap<Vertex, String> idToName = new HashMap<Vertex, String>();
        try {
            FileWriter out = new FileWriter(fileName);
            int count = 0;
            out.write("nodedef> name,label,distance\n");
            // write vertices
            for (Vertex v: myVertices.values())
            {
                String id = "v"+ count++;
                idToName.put(v, id);
                out.write(id + ", " + escapedVersion(v.name));
                out.write(", "+v.distance+"\n");
            }
            out.write("edgedef> node1,node2,color\n");
            // write edges
            for (Vertex v : myVertices.values())
                for (Vertex w : myAdjList.get(v))
                    if (v.compareTo(w) < 0) {
                        out.write(idToName.get(v)+", "+
                                idToName.get(w) + ", ");
                        if (v.predecessor == w ||
                                w.predecessor == v)
                            out.write("blue");
                        else
                            out.write("gray");
                        out.write("\n");
                    }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initSearch() {
        for (Vertex v : this.getVertices()) {
            v.processed = v.discovered = false;
            v.predecessor = null;
            v.distance = INFINITY;
        }
    }

    public void BFS(Vertex s) {
        this.initSearch();
        s.distance = 0;
        s.discovered = true;

        Queue<Vertex> q = new LinkedList<Vertex>();
        q.add(s);
        while (!q.isEmpty()) {
            Vertex v = q.remove();
            System.out.println("visit " + v);
            for (Vertex w : this.adjacentTo(v))
                if (!w.discovered) {
                    w.distance = v.distance+1;
                    w.discovered = true;
                    w.predecessor = v;
                    q.add(w);
                }
            v.processed = true;
        }
    }

    public void DFS(Vertex s) {
        this.initSearch();
        s.distance = 0;
        s.discovered = true;
        recDFS(s);
    }

    public void recDFS(Vertex v) {
        System.out.println("visit " + v);
        for (Vertex w : this.adjacentTo(v))
            if (!w.discovered) {
                w.distance = v.distance+1;
                w.discovered = true;
                w.predecessor = v;
                recDFS(w);
            }
        v.processed = true;
    }

    public void DFS2(Vertex s) {
        this.initSearch();
        s.distance = 0;
        s.discovered = true;

        Stack<Vertex> q = new Stack<Vertex>();
        q.push(s);
        while (!q.isEmpty()) {
            Vertex v = q.pop();
            for (Vertex w : this.adjacentTo(v)) {
                if (!w.processed) {
                    w.distance = v.distance+1;
                    w.discovered = true;
                    w.predecessor = v;
                    q.add(w);
                }
            }
            v.processed = true;
        }
    }

    public static void main(String[] args) {
        Graph G = new Graph();
        G.addEdge("A", "B");
        G.addEdge("A", "C");
        G.addEdge("B", "C");
        G.addEdge("C", "D");
        G.addEdge("D", "E");
        G.addEdge("D", "G");
        G.addEdge("E", "G");
        G.addVertex("H");

        // print out graph
        System.out.println(G);

        System.out.println("BFS :");
        G.BFS(G.getVertex("A"));
        System.out.println("DFS :");
        G.DFS(G.getVertex("A"));

        // print out graph again by iterating over vertices and edges
        for (Vertex v : G.getVertices()) {
            System.out.print(v + ": ");
            for (Vertex w : G.adjacentTo(v.name)) {
                System.out.print(w + " ");
            }
            System.out.println();
        }
//        G.outputGDF("graph.txt");
    }
}
