package DailyQuestion;
import java.util.*;

//Time Complexity : O(Elogv)

//Making the class Pair for storing the solution
class Pair{
 int node;
 double probability;
 Pair(int node,double probability){
     this.node = node;
     this.probability = probability;
 }
}
class PathWithMaximumProbability_1514 {
public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        
        // Making the adjaceny list where we are storing the Pair of neighbor and their probability reaching their for every node 
        List<List<Pair>> list = new ArrayList<>();

        for(int i=0;i<n;i++) list.add(new ArrayList<>());

        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            list.get(u).add(new Pair(v,prob));
            list.get(v).add(new Pair(u,prob));
        }

        // Here we are going to store the best probability for every node
        double[] distance = new double[n];
        Arrays.fill(distance,0.0);
        distance[start] = 1;

        // Starting with the start node
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()){
            int curr_node = queue.poll();
            List<Pair> neighbor_list = list.get(curr_node);
            // getting all the pairs of neighbor nodes and their probabilities respectively 
            for(Pair pair:neighbor_list){
                int neighbor = pair.node;
                double prob = pair.probability;
                double new_prob = distance[curr_node]*prob;
                // if the new probability is greater than the existing one
                if(new_prob>distance[neighbor]){
                    distance[neighbor] = new_prob;
                    queue.add(neighbor);
                }

            }
        }

        // returning the end node 
        return distance[end];
    }
}

/*
Example 1:
Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
Output: 0.25000
Explanation: There are two paths from start to end, one having a probability of success = 0.2 and the other has 0.5 * 0.5 = 0.25.

Example 2:
Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.3], start = 0, end = 2
Output: 0.30000

Example 3:
Input: n = 3, edges = [[0,1]], succProb = [0.5], start = 0, end = 2
Output: 0.00000
Explanation: There is no path between 0 and 2.
*/ 