package com.interview.list;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class NodeNextWithRandom {
    int data;
    NodeNextWithRandom next,random;
    NodeNextWithRandom(int x){
        data = x;
        next = random = null;
    }
}

public class LinkedListCloneWithNextAndRandomPointer {

    public NodeNextWithRandom linkedListCloneWithNextAndRandomPointer(NodeNextWithRandom head){

        NodeNextWithRandom origCurr = head, cloneCurr = null;
        // Hash map which contains node to node mapping of original and clone linked list.
        Map<NodeNextWithRandom, NodeNextWithRandom> map = new HashMap<>();

        // Traverse the original list and make a copy of that in the clone linked list.
        while (origCurr != null) {
            cloneCurr = new NodeNextWithRandom(origCurr.data);
            map.put(origCurr, cloneCurr);
            origCurr = origCurr.next;
        }

        // Adjusting the original list reference again.
        origCurr = head;

        // Traversal of original list again to adjust the next and random references of clone list using hash map.
        while (origCurr != null){
            cloneCurr = map.get(origCurr);
            cloneCurr.next = map.get(origCurr.next);
            cloneCurr.random = map.get(origCurr.random);
            origCurr = origCurr.next;
        }

        //return the head reference of the clone list.
        return map.get(head);
    }

}
