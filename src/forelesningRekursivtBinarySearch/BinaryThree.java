package forelesningRekursivtBinarySearch;


import java.util.ArrayDeque;


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

    static void printLevelOrder(BinaryTreeNode root) {
        ArrayDeque<BinaryTreeNode> queue = new ArrayDeque<BinaryTreeNode>();

        // Legger til rot noden
        queue.addLast(root);

        while (!queue.isEmpty()) {
            // 1. Ta ut første fra køen
            BinaryTreeNode current = queue.removeFirst();

            //  2. Legg til current sine to barn til køen
            if (current.left_child != null) {
                queue.addLast(current.left_child);
            }
            if (current.right_child != null) {
                queue.addLast(current.right_child);
            }

            // skriv ut
            System.out.println(current.value + " ");
        }
    }

    static void printPreorder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        printPreorder(node.left_child);
        printPreorder(node.right_child);
    }

    static void printInorder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        printInorder(node.left_child);
        System.out.print(node.value + " ");
        printInorder(node.right_child);
    }

    static void printPostorder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        printPostorder(node.left_child);
        printPostorder(node.right_child);
        System.out.print(node.value + " ");
    }

    static void printPreorderNonRecursiv(BinaryTreeNode root) {
        ArrayDeque<BinaryTreeNode> stack = new ArrayDeque<BinaryTreeNode>();

        stack.addLast(root);

        while (!stack.isEmpty()) {
            BinaryTreeNode current = stack.removeLast();
            if (current.right_child != null) {
                stack.add(current.right_child);
            }
            if (current.left_child != null) {
                stack.add(current.left_child);

            }
            System.out.print(current.value + " ");


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

        //printLevelOrder(root);
        System.out.println("Pre order:");
        printPreorder(root);
        System.out.println();
        System.out.println("In order");
        printInorder(root);
        System.out.println();
        System.out.println("Post order:");
        printPostorder(root);
        System.out.println();
        System.out.println("Pre order ikke rekursivt");
        printPreorderNonRecursiv(root);
    }
}
