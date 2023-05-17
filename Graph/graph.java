package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class graph{

    private LinkedList<Integer> adj[];

    public graph(int v){
        adj = new LinkedList[v];
        for(int i=0;i<v;i++){
            adj[i] =  new LinkedList<Integer>();
        }
    }

    public void addEdge(int source, int destination){
        adj[source].add(destination);
        adj[destination].add(source);
    }

    public int bfs(int s, int d){
        boolean v[] = new boolean[adj.length];
        Queue<Integer> q = new LinkedList<>();
        int[] parent = new int[adj.length];

        q.add(s);
        parent[s] = -1;
        v[s] = true;
        while(!q.isEmpty()){
            int cur = q.poll();
            if(cur == d) break;

            for(int neighbour: adj[cur]){
                if(!v[neighbour]){
                    q.add(neighbour);
                    parent[neighbour] = cur;
                    v[neighbour] = true;
                }
            }
        }
        int cur = d;
        int distance=0;
        while(parent[cur]!=-1){
            System.out.println(cur + " -> ");
            cur = parent[cur];
            distance++;
        }
        return distance;
    }

    public boolean dfs(int s, int d, boolean[] v){
        if(s == d)  return true;

        for(int neighbour:adj[s]){
            if(!v[neighbour]){
                v[neighbour] = true;
                boolean isCon = dfs(neighbour,d,v);
                if(isCon)   return true;
            }
        }
        return false;
    }

    public boolean dfsStack(int s, int d){
        boolean v[] = new boolean[adj.length];
        v[s] = true;
        Stack<Integer> stk = new Stack<>();
        stk.push(s);

        while(!stk.isEmpty()){
            int cur = stk.pop();

            if(cur == d)    return true;

            for(int neighbour:adj[cur]){
                if(!v[neighbour]){
                    v[neighbour] = true;
                    stk.push(neighbour);
                }
            }
        }

        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of vertices and edges : ");

        int v = sc.nextInt();
        int e = sc.nextInt();

        graph gph = new graph(v);
        System.out.println("Enter " + e + " edges");
        for(int i=0;i<e;i++){
            int source = sc.nextInt();
            int destination = sc.nextInt();

            gph.addEdge(source, destination);
        }

        sc.close();
    }
}