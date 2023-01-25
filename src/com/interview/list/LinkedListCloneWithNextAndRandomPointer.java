package com.interview.list;

import com.interview.tree.Node;

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

    public void clone1(){
        NodeRandom node = new NodeRandom(1);
        node.next = new NodeRandom(2);
        node.random = new NodeRandom(21);
        node.next.next = new NodeRandom(3);
        node.next.random = new NodeRandom(31);
        node.next.next.next = new NodeRandom(4);
        node.next.next.random = new NodeRandom(41);
        NodeRandom curr = node;

        NodeRandom head = new NodeRandom(node.data);
        NodeRandom curr2 = head;

        while(curr.next != null) {
            curr2.next = curr.next;
            curr2.random = curr.random;
            curr2 = curr2.next;
            curr = curr.next;
        }

        System.out.println("########");
    }

}
