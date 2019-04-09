import java.util.HashMap;

public class ST extends Object {

  HashMap<String, HashMap<String, STO>> functionTables;
  Node[] AST;

  public ST(Node[] AST) {
    this.functionTables = new HashMap<String, HashMap<String, STO>>();
    this.AST = AST;
    //insert global scope entry in hashmap
  }

  public void analyzeAST() {
    //go through ast
    //for each function create a new entry in the function table
    //maybe new method to deal with functions, called recursively
    String nodeType;
    for(Node node : AST) {
      if(((SimpleNode) node).children != null) {
        nodeType = ((SimpleNode) node).getClass().getSimpleName();
        switch(nodeType) {
          case "ASTAssign":
            break;
          case "ASTAssignStatement":
            break;
          case "ASTArrayAssign":
            break;
          case "ASTArrayAssignStatement":
            break;
          default:

        }
      }
    }
  } 



}