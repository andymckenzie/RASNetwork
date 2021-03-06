package org.sage.kda.giny;

import giny.model.GraphPerspective;
import giny.model.Node;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DirectedNetworkTest2 {

	private ImportExport.Network _network;
	
	@Before
	public void setup() throws Exception {
		_network = ImportExport.loadNetwork("./data/directedNetwork2.txt",true);
	}
	
	@Test
	public void knn1(){
		
		Set<Node> module = makeSet(new String[]{"node0","node1"});
		
		Set<Node> neighbors = NetworkFncs.findNLayerNeighbors(_network.graph, module, new HashSet<Node>(), 1, true);
		assertEquals(5, neighbors.size());
		GraphPerspective subgraph = NetworkFncs.findNLayerNeighbors_GraphPerspective(
				_network.graph, module, 1, true);
		assertEquals(5, subgraph.getNodeCount());
		List<Node> nodes = subgraph.nodesList();
		neighbors.containsAll(nodes);
		
		assertEquals(5, subgraph.getEdgeCount());
	}
	
	@Test
	public void knn2(){
		
		Set<Node> module = makeSet(new String[]{"node4","node5"});
		
		Set<Node> neighbors = NetworkFncs.findNLayerNeighbors(_network.graph, module, new HashSet<Node>(), 1, true);
		assertEquals(4, neighbors.size());
		GraphPerspective subgraph = NetworkFncs.findNLayerNeighbors_GraphPerspective(
				_network.graph, module, 1, true);
		assertEquals(4, subgraph.getNodeCount());
		List<Node> nodes = subgraph.nodesList();
		neighbors.containsAll(nodes);
		
		assertEquals(2, subgraph.getEdgeCount());
	}
	
	@Test
	public void knn3(){
		
		Set<Node> module = makeSet(new String[]{"node6","node9"});
		
		Set<Node> neighbors = NetworkFncs.findNLayerNeighbors(_network.graph, module, new HashSet<Node>(), 1, true);
		assertEquals(2, neighbors.size());
		GraphPerspective subgraph = NetworkFncs.findNLayerNeighbors_GraphPerspective(
				_network.graph, module, 1, true);
		assertEquals(2, subgraph.getNodeCount());
		List<Node> nodes = subgraph.nodesList();
		neighbors.containsAll(nodes);
		
		assertEquals(0, subgraph.getEdgeCount());
	}
	
	@Test
	public void knn4(){
		
		Set<Node> module = makeSet(new String[]{"node2","node7"});
		
		Set<Node> neighbors = NetworkFncs.findNLayerNeighbors(_network.graph, module, new HashSet<Node>(), 1, true);
		assertEquals(3, neighbors.size());
		GraphPerspective subgraph = NetworkFncs.findNLayerNeighbors_GraphPerspective(
				_network.graph, module, 1, true);
		assertEquals(3, subgraph.getNodeCount());
		List<Node> nodes = subgraph.nodesList();
		neighbors.containsAll(nodes);
		
		assertEquals(2, subgraph.getEdgeCount());
	}
	
	private Set<Node> makeSet(String[] nodes){
		HashSet<Node> nodeSet = new HashSet<Node>();
		for(int i = 0 ;i < nodes.length; ++i){
			nodeSet.add(_network.nodeMap.get(nodes[i]));
		}
		return nodeSet;
	}
}
