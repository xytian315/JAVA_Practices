/*
4.2 Given a directed graph, design an algorithm to find out whether ther is a route 
between two nodes
*/


/*
Trade off: Bread first traversal could find the shortest path,using queue to implement
equals tree level traversal
But depth-first can use less space in finding a path, using statck to implement
*/
public class Solution{
	
	public boolean breadFristTraversal( Graph g, Node start, Node end){

		//use queue to implement bfs

		LinkedList<Node> q = new LinkedList<Node>();

		//set all nodes to the state unvisited;

		for(Node u: g.getNodes()){
			u.State = State.Unvisted;
		}

		//put the start node into queue

		Start.State = State.Visted;
		q.add(start);
		Node u;

		while(!q.isEmpty()){
			u = q.remove();
			if(u!= null){
				for(Node v: u.getAjacent()){
					if(v.State == State.Unvisted){
						if(v == end)
							return true;
						else{
							v.State = State.Visited;
							q.add(v);
						}

					}
				}
			}
		}

		return false;

	}

	public enum State{
		Visited, Unvisted;
	}

}
