import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class assignment1 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.print("Please input two or more letters without spaces: ");
    String letters = scan.next();
    int lettersLength = letters.length();
    Tree mainTree = new Tree();

    while (lettersLength < 2) {
      System.out.println("INVALID AMOUNT OF LETTERS. Please input two or more.");
      letters = scan.next();
      lettersLength = letters.length();
    }

    Stack<String> letterStack = new Stack<String>();
    for (int i = 0; i < lettersLength; i++)
      letterStack.push(Character.toString(letters.charAt(i)));
    Node currentNode = mainTree.getRoot();

    while (!letterStack.empty()) {
      if (letterStack.size() > 2) {
        Node newNode = new Node();
        newNode.data = letterStack.pop();
        currentNode.rightChild = newNode;
        Node plusNode = new Node();
        plusNode.data = "+";
        currentNode.leftChild = plusNode;
        currentNode = currentNode.leftChild;
      } else if (letterStack.size() == 2) {
        Node rightNode = new Node();
        Node leftNode = new Node();
        rightNode.data = letterStack.pop();
        leftNode.data = letterStack.pop();
        currentNode.rightChild = rightNode;
        currentNode.leftChild = leftNode;
        currentNode = currentNode.leftChild;
      } else {
        currentNode.data = letterStack.pop();
      }
    }

    mainTree.displayTree();
    scan.close();
  }
}