/* Generated By:JJTree: Do not edit this line. ASTIdentifier.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package parser;

import semantic.*;

public class ASTIdentifier extends SimpleNode {

  protected String identifier;
  protected boolean isArrayAccess;

  public ASTIdentifier(int id) {
    super(id);
    this.isArrayAccess = false;
  }

  public ASTIdentifier(Jmm p, int id) {
    super(p, id);
    this.isArrayAccess = false;
  }

  public String getIdentifier() {
    return this.identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  @Override
  public String getActualReturnType() {
    if (this.actualReturnType == "") {
      STO symbol = SimpleNode.symbolTable.doesSymbolExist(this.identifier, ((SimpleNode) this.parent).scope);
      if (symbol != null) {
        this.actualReturnType = symbol.getType();
      } else {
        this.actualReturnType = this.identifier;
      }
    }
    return this.actualReturnType;
  }
  
  @Override
  public String getReturnType() {

    if (this.actualReturnType.equals("")) {
      STO symbol = SimpleNode.symbolTable.doesSymbolExist(this.identifier, ((SimpleNode) this.parent).scope);
      if (symbol != null) {
        this.actualReturnType = symbol.getType();
      }
    }

    //check if node has children
    if (this.jjtGetNumChildren() > 0) {
      SimpleNode child = (SimpleNode) this.jjtGetChild(0);
      if (child.getId() == JmmTreeConstants.JJTARRAYINDEX) {
        this.isArrayAccess = true;
      }
      return child.getReturnType();
      //if function call external to the class, return null ??
    } else {
      return this.actualReturnType;
    }
  }

  @Override
  public void checkNodeSemantic() {
    STO symbol = SimpleNode.symbolTable.doesSymbolExist(this.identifier, this.scope);
    if (symbol == null) {
      if (this.jjtGetNumChildren() > 0 && this.jjtGetChild(0).getId() != JmmTreeConstants.JJTCALL) {
        super.printSemanticError("Variable " + this.identifier + " was not declared");
      }
    } else {
      this.returnType = symbol.getType();
    }
  }

  public void dump(String prefix) {
    System.out.println(toString(prefix) + ": " + this.identifier);
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        SimpleNode n = (SimpleNode)children[i];
        if (n != null) {
          n.dump(prefix + "    ");
        }
      }
    }
  }

}
/* JavaCC - OriginalChecksum=521fa862d348d7bce1abe05050b54000 (do not edit this line) */
