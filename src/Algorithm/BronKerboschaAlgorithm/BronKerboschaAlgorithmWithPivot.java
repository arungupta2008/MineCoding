package Algorithm.BronKerboschaAlgorithm;

import Helper.Graph;
import Helper.Vertex;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by arun.gupta on 17/04/16.
 */
public class BronKerboschaAlgorithmWithPivot {
    public static Graph graph = null;

    public static void main(String[] args) {
        graph = new Graph();
        createGraph(graph);

        Set<Vertex> P = new HashSet<Vertex>();
        Set<Vertex> X = new HashSet<Vertex>();
        Set<Vertex> R = new HashSet<Vertex>();

        for (Vertex v : graph.getVertices()) {
            P.add(v);
        }
        BronKerboschaAlgorithmWithPivot bronKerboschaAlgorithmWithPivot = new BronKerboschaAlgorithmWithPivot();
        bronKerboschaAlgorithmWithPivot.BronKerbosch(R, P, X);
    }

    public Set<Vertex> interSection(Set<Vertex> A, Set<Vertex> B) {
        Set<Vertex> A1 = new HashSet<>(A);
        Set<Vertex> B1 = new HashSet<>(B);
        A1.retainAll(B1);
        Set<Vertex> intersection = new HashSet<Vertex>(A1); // use the copy constructor
        intersection.retainAll(B1);
        return intersection;
    }

    public Set<Vertex> union(Set<Vertex> vertexSet, Vertex vertex) {
        Set<Vertex> vertexSet1 = new HashSet<>(vertexSet);
        vertexSet1.add(vertex);
        return vertexSet1;
    }

    public Set<Vertex> union(Set<Vertex> vertexSet, Set<Vertex> vertexSet1) {
        Set<Vertex> newvertexSet = new HashSet<>(vertexSet);
        newvertexSet.addAll(vertexSet);
        newvertexSet.addAll(vertexSet1);
        return newvertexSet;
    }

    private void BronKerbosch(Set<Vertex> R, Set<Vertex> P, Set<Vertex> X) {
        if (P.size() == 0 && X.size() == 0) {
            System.out.println("Maximal Set Found : " + R);
        } else {

            //choose a pivot vertex u in P ⋃ X
            Vertex u = graph.highestDegreeVertex(union(P, X));
            System.out.println("Pivot Node  : "+u.name);

            //P -  N(u) set
            Set<Vertex> removedSet = new HashSet<>(P);
            removedSet.removeAll(graph.NeighborOfVertex(u.name));
            Set<Vertex> iterRatorSet = new HashSet<>(removedSet);
            for (Vertex v : iterRatorSet) {
                BronKerbosch(union(R, v), interSection(P, graph.NeighborOfVertex(v.name)), interSection(X, graph.NeighborOfVertex(v.name)));
                P.remove(v);
                X = union(X,v);
            }
        }
    }

    private void printVertex(String vertexSetName, Set<Vertex> vertexSet) {
        System.out.println(vertexSetName + " : " + vertexSet);
    }

    private static void createGraph(Graph G) {
        G.addEdge("1", "5");
        G.addEdge("1", "2");
        G.addEdge("5", "2");
        G.addEdge("2", "3");
        G.addEdge("3", "4");
        G.addEdge("5", "4");
        G.addEdge("6", "4");

//        G.addEdge("1", "2");
//        G.addEdge("1", "3");
//        G.addEdge("2", "3");
//        G.addEdge("2", "4");
    }
}
