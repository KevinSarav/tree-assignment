import java.io.*;
import java.util.Stack;

public class Tree {
  private static Node root = new Node();

  public Tree() {
    root.data = "+";
  }

  static Node getRoot() {
    return root;
  }

  public void traverse(int traverseType) {
    switch (traverseType) {
    case 1:
      System.out.print("\nPreorder traversal: ");
      preOrder(root);
      break;
    case 2:
      System.out.print("\nInorder traversal: ");
      inOrder(root);
      break;
    case 3:
      System.out.print("\nPostorder traversal: ");
      postOrder(root);
      break;
    }
    System.out.println();
  }

  private void preOrder(Node treeRoot) {
    if (treeRoot.rightChild != null || treeRoot.leftChild != null) {
      System.out.print(treeRoot.data + " ");
      preOrder(treeRoot.leftChild);
      preOrder(treeRoot.rightChild);
    }
  }

  private void inOrder(Node treeRoot) {
    if (treeRoot.rightChild != null || treeRoot.leftChild != null) {
      inOrder(treeRoot.leftChild);
      System.out.print(treeRoot.data + " ");
      inOrder(treeRoot.rightChild);
    }
  }

  private void postOrder(Node treeRoot) {
    if (treeRoot.rightChild != null || treeRoot.leftChild != null) {
      postOrder(treeRoot.leftChild);
      postOrder(treeRoot.rightChild);
      System.out.print(treeRoot.data + " ");
    }
  }

  public void displayTree() {
    Stack globalStack = new Stack();
    globalStack.push(root);
    int nBlanks = 32;
    boolean isRowEmpty = false;
    System.out.println("......................................................");
    while (isRowEmpty == false) {
      Stack localStack = new Stack();
      isRowEmpty = true;
      for (int j = 0; j < nBlanks; j++)
        System.out.print(" ");
      while (globalStack.isEmpty() == false) {
        Node temp = (Node) globalStack.pop();
        if (temp != null) {
          System.out.print(temp.data);
          localStack.push(temp.leftChild);
          localStack.push(temp.rightChild);
          if (temp.leftChild != null || temp.rightChild != null)
            isRowEmpty = false;
        } else {
          System.out.print("--");
          localStack.push(null);
          localStack.push(null);
        }
        for (int j = 0; j < nBlanks * 2 - 2; j++)
          System.out.print(" ");
      }
      System.out.println();
      nBlanks /= 2;
      while (localStack.isEmpty() == false)
        globalStack.push(localStack.pop());
    }
    System.out.println("......................................................");
  }
}