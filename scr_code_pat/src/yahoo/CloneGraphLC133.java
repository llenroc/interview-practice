package yahoo;

import java.util.*;

public class CloneGraphLC133 {
    Map<Integer, UndirectedGraphNode> map = new HashMap<>();


    // DFS
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        return cloning(node);
    }

    private UndirectedGraphNode cloning(UndirectedGraphNode node){
        if(node == null) return null;

        // already exists
        if(map.containsKey(node.label)){
            return map.get(node.label);
        }
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label, clone);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            UndirectedGraphNode clonedNB =  cloning(neighbor);
            clone.neighbors.add(clonedNB);
        }
        return clone;
    }



    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    };

}
