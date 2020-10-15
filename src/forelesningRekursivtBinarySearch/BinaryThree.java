package forelesningRekursivtBinarySearch;


import java.util.ArrayDeque;
import java.util.Queue;

class BinaryTree {
    static class BinaryTreeNode {
        char value;
        BinaryTreeNode left_child;
        BinaryTreeNode right_child;

        BinaryTreeNode(char value) {
            this.value = value;
            this.left_child = null;
            this.right_child = null;
        }

        BinaryTreeNode addLeftChild(char value) {
            this.left_child = new BinaryTreeNode(value);
            return this.left_child;
        }

         BinaryTreeNode addRightChild(char value) {
            this.right_child = new BinaryTreeNode(value);
            return this.right_child;
        }
    }

    static void printLevelOrder(BinaryTreeNode root){
        ArrayDeque<BinaryTreeNode> queue = new ArrayDeque<BinaryTreeNode>();

        // Legger til rot noden
        queue.addLast(root);

        while(!queue.isEmpty()){
            // 1. Ta ut første fra køen
            BinaryTreeNode current = queue.removeFirst();

            //  2. Legg til current sine to barn til køen
            if(current.left_child != null){
                queue.addLast(current.left_child);
            }
            if(current.right_child != null){
                queue.addLast(current.right_child);
            }

            // skriv ut
            System.out.println(current.value + " ");
        }
    }

    public static void main(String[] args) {

        // lager rot-noden niva 0
        BinaryTreeNode root = new BinaryTreeNode('A');


        // Legger inn resterende noder på nivå 1
        BinaryTreeNode b = root.addLeftChild('B');
        BinaryTreeNode c = root.addRightChild('C');


        // legger inn noder på nivå 2
        BinaryTreeNode d = b.addLeftChild('D');
        BinaryTreeNode e = b.addRightChild('E');

        BinaryTreeNode f = c.addLeftChild('F');
        BinaryTreeNode g = c.addRightChild('G');

        // Kalle funksjomnen vår

        printLevelOrder(root);
    }
}
