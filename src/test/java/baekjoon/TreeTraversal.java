package baekjoon;

import java.util.Scanner;

/**
 이진 트리를 입력받아 전위 순회(preorder traversal), 중위 순회(inorder traversal), 후위 순회(postorder traversal)한 결과를 출력하는 프로그램을 작성하시오.

 예를 들어 위와 같은 이진 트리가 입력되면,

 전위 순회한 결과 : ABDCEFG // (루트) (왼쪽 자식) (오른쪽 자식)
 중위 순회한 결과 : DBAECFG // (왼쪽 자식) (루트) (오른쪽 자식)
 후위 순회한 결과 : DBEGFCA // (왼쪽 자식) (오른쪽 자식) (루트)
 가 된다.

 입력
 첫째 줄에는 이진 트리의 노드의 개수 N(1≤N≤26)이 주어진다. 둘째 줄부터 N개의 줄에 걸쳐 각 노드와 그의 왼쪽 자식 노드, 오른쪽 자식 노드가 주어진다. 노드의 이름은 A부터 차례대로 영문자 대문자로 매겨지며, 항상 A가 루트 노드가 된다. 자식 노드가 없는 경우에는 .으로 표현된다.

 출력
 첫째 줄에 전위 순회, 둘째 줄에 중위 순회, 셋째 줄에 후위 순회한 결과를 출력한다. 각 줄에 N개의 알파벳을 공백 없이 출력하면 된다.

 https://www.acmicpc.net/problem/1991
 */
public class TreeTraversal {

    public static void main(String... args) {
        new TreeTraversal().solution();
    }

    private class TreeNode {
        private char data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(char data) {
            this.data = data;
            left = null;
            right = null;
        }

        public void addLeft(char parent, char data) {
            TreeNode node = getNode(this, parent);

            if (node != null) {
                node.left = new TreeNode(data);
            }
        }

        public void addRight(char parent, char data) {
            TreeNode node = getNode(this, parent);

            if (node != null) {
                node.right = new TreeNode(data);
            }
        }

        private TreeNode getNode(TreeNode node, char data) {
            if(node == null) {
                return null;
            }

            if(node.data == data) {
                return node;
            }

            TreeNode findNode = getNode(node.left, data);

            if(findNode != null) {
                return  findNode;
            }

            return getNode(node.right, data);
        }
    }

    public void solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        sc.nextLine();

        TreeNode root = null;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            char node1 = line.charAt(0);
            char node2 = line.charAt(2);
            char node3 = line.charAt(4);

            if (node1 == 'A') {
                root = new TreeNode(node1);
            }

            if (node2 != '.') {
                root.addLeft(node1, node2);
            }

            if (node3 != '.') {
                root.addRight(node1, node3);
            }
        }

        preorder(root);
        System.out.println();

        inorder(root);
        System.out.println();

        postorder(root);
    }

    public void preorder(TreeNode node) {
        if(node == null) {
            return;
        }

        System.out.print(node.data);

        preorder(node.left);
        preorder(node.right);
    }

    public void inorder(TreeNode node) {
        if(node == null) {
            return;
        }

        inorder(node.left);
        System.out.print(node.data);
        inorder(node.right);
    }

    public void postorder(TreeNode node) {
        if(node == null) {
            return;
        }

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data);
    }

}