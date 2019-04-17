import java.util.HashMap;

public class ST extends Object {

  HashMap<String, STFunction> functionTable;
  SimpleNode AST;

  public ST(SimpleNode AST) {
    this.functionTable = new HashMap<String, STFunction>();
    this.AST = AST;
    analyzeAST();
  }

  public void analyzeAST() {
    //go through ast
    //for each function create a new entry in the function table
    //maybe new method to deal with functions, called recursively
    String nodeType;
    Node[] children = ((SimpleNode) AST.children[0]).children;

    for(Node node : children) {
      if(((SimpleNode) node).children != null) {
        nodeType = ((SimpleNode) node).getClass().getSimpleName();
        if (nodeType.equals("ASTMethodDeclaration") || nodeType.equals("ASTMainDeclaration")) {
          analyzeMethodDeclaration(node);
        }
      }
    }
  } 

  public void analyzeMethodDeclaration(Node node) {

    STFunction stFunction = new STFunction();
    String stFunctionName = null;
    if (((SimpleNode) node).getClass().getSimpleName().equals("ASTMethodDeclaration")) {
      stFunctionName = ((ASTMethodDeclaration) node).getName();
      stFunction.returnDescriptor = new STO(((ASTMethodDeclaration) node).type);
    } else {
      stFunctionName = "main";
    }
    
    //parameters
    Node[] children = ((SimpleNode) node).children;
    if (((SimpleNode) children[0]).getClass().getSimpleName().equals("ASTMethodArguments")) {
      for(Node methodArg: ((SimpleNode) children[0]).children) {
        stFunction.params.put(((ASTMethodArgument) methodArg).getIdentifier(), new STO(((ASTMethodArgument) methodArg).type));
      }
    }

    //locals
    for(Node childNode : children) {
      if(!((SimpleNode) childNode).getClass().getSimpleName().equals("ASTVarDeclaration")) {
        break;
      } else {
        stFunction.locals.put(((ASTVarDeclaration) childNode).getIdentifier(), new STO(((ASTVarDeclaration) childNode).type));
      }
    }

    functionTable.put(stFunctionName, stFunction);
  
  }

  public void dump() {
    
    functionTable.forEach((key, value) -> {
      System.out.println("Function " + key + ":");
      value.dump();
    });
  }
 
}