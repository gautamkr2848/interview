package com.interview.list;

import java.util.HashMap;
import java.util.Map;

class NodeRandom {
    int data;
    NodeRandom next,random;
    NodeRandom(int x){
        data = x;
        next = random = null;
    }
}


public class LinkedListCloneWithNextAndRandomPointer {

    public NodeRandom linkedListCloneWithNextAndRandomPointer(NodeRandom head){

        NodeRandom curr1 = head;
        NodeRandom curr2 = null;
        Map<NodeRandom, NodeRandom> map = new HashMap<>();

        while (curr1 != null) {
            curr2 = new NodeRandom(curr1.data);
            map.put(curr1, curr2);
            curr1 = curr1.next;
        }

        curr1 = head;
        while (curr1 != null){
            curr2 = map.get(curr1);
            curr2.next = map.get(curr1.next);
            curr2.random = map.get(curr1.random);
            curr1 = curr1.next;
        }
        return map.get(head);
    }

}
