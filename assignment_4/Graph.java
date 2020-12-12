package assignment_4;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Graph {
    private boolean isDirected;
    private ArrayList<int[][]> adjacencyList;

    public Graph() {
    }

    public Graph(boolean isDirected, ArrayList<int[][]> adjacencyList) {

    public Graph(ArrayList<int[][]> adjacencyList) {
        this.isDirected = true;
        this.adjacencyList = adjacencyList;
    }

    public Graph(File file) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new FileReader(file));
        this.isDirected = Integer.parseInt(bf.readLine()) == 1;

        StringBuilder str = new StringBuilder();
        String textLine;
        while ((textLine = bf.readLine()) != null)
            str.append(textLine).append(" ");

        String[] numbs = str.toString().split(" ");
        this.adjacencyList = new int[numbs.length / 3][3];
        System.out.println("The numbers array is:");
        for (int i = 0; i < numbs.length; i++) {
            for (int j = 0; j < numbs.length / 3; j++) {
                adjacencyList[j][0] = Integer.parseInt(numbs[i++]);
                adjacencyList[j][1] = Integer.parseInt(numbs[i++]);
                adjacencyList[j][2] = Integer.parseInt(numbs[i++]);
                System.out.println(Arrays.toString(adjacencyList[j]) + ", ");
            }
        }

        // System.out.println("");
        bf.close();
        // System.out.println("Original:" + Arrays.toString(this.adjacencyList));
    }

    public static ArrayList<int[][]> readGraphFile(String strFile) throws IOException {
        return adjacencyList;
    }

    /**
     * Extend the size of the adjacency list to the index of the vertex, equivalent
     * with adding this node
     * 
     * @param vertex the index of the vertex
     * @return if the node already exists, return false, else return true
     */
    public boolean addVertex(int vertex) {
        if (!this.existsVertex(vertex))
            return false;
        while (!this.existsVertex(vertex))
            this.adjacencyList.add(new ArrayList<int[]>());
        return true;
    }

    /**
     * Add an edge with start vertex, end vertex and weight given, will not override
     * edge exist.
     * 
     * @param startVertex
     * @param endVertex
     * @param weight
     */
    public void addEdge(int startVertex, int endVertex, int weight) {
        this.addVertex(startVertex);
        this.addVertex(endVertex);
        this.adjacencyList.get(startVertex).add(new int[] { endVertex, weight });
    }

    /**
     * To get whether a vertex exists in the adjacency list or not.
     * 
     * @param vertex
     * @return If the vertex exists in the adjacency list, return true, else return
     *         false
     */
    public boolean existsVertex(int vertex) {
        return this.adjacencyList.size() - 1 >= vertex;
    }

    public boolean isDirected() {
        return isDirected;
    }

    /**
     * Print each vertex in a line with other vertices and their weight in ascending
     * order according to vertices number.
     * 
     * @return Each line prints the start vertex and other vertices numbers and
     *         weights of edges ascending.
     */
    public String printAdjacencyList() {
        String strList = "";
        return strList;
    }

    /**
     * Print each weight in matrix with vertices number as row and col in ascending
     * order according to vertices number.
     * 
     * @return Each row and each line print the vertex numbers and weights
     *         ascending.
     */
    public String printAdjacencyMatrix() {
        String strMatrix = "";
        return strMatrix;
    }

    /**
     * Print the shortest path from startVertex to other vertices, except itself.
     * 
     * @param startVertex
     * @return [shortestPathLength]v1, v2, ..., vn. If no path from v1 to vn, print
     *         [0]null
     */
    public String ShortestPath(int startVertex) {
        String strPath = "";
        return strPath;
    }

    public String ShortestPath(int startVertex, int endVertex) {
        String strPath = "";
        return strPath;
    }
}
