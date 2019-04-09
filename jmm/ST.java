import java.util.HashMap;

public class ST extends Object {

  HashMap<String, HashMap<String, STO>> functionTables;
  SimpleNode[] AST;

  public ST(SimpleNode[] AST) {
    this.functionTables = new HashMap<String, HashMap<String, STO>>();
    this.AST = AST;
    //insert global scope entry in hashmap
  }

  public void analyzeAST() {
    //go through ast
    //for each function create a new entry in the function table
    //maybe new method to deal with functions, called recursively
  }



}