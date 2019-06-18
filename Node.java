import java.io.*;

public class Node {
  String data;
  Node leftChild;
  Node rightChild;

  public void displayNode() {
    System.out.print("{" + data + "}");
  }
}