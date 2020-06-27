package com.interview.list;

import java.util.HashMap;
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

        NodeNextWithRandom origCurr = head;
        NodeNextWithRandom cloneCurr = null;
        Map<NodeNextWithRandom, NodeNextWithRandom> map = new HashMap<>();

        while (origCurr != null) {
            cloneCurr = new NodeNextWithRandom(origCurr.data);
            map.put(origCurr, cloneCurr);
            origCurr = origCurr.next;
        }

        origCurr = head;
        while (origCurr != null){
            cloneCurr = map.get(origCurr);
            cloneCurr.next = map.get(origCurr.next);
            cloneCurr.random = map.get(origCurr.random);
            origCurr = origCurr.next;
        }
        return map.get(head);
    }

}
