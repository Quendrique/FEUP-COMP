/* Generated By:JJTree: Do not edit this line. ASTIdentifier.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package parser;public


class ASTIdentifier extends SimpleNode {

  protected String identifier;

  public ASTIdentifier(int id) {
    super(id);
  }

  public ASTIdentifier(Jmm p, int id) {
    super(p, id);
  }

  public String getIdentifier() {
    return this.identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }
  
  @Override
  public String getSymbolReturn() {
    return this.symbolTable.doesSymbolExist(this.identifier, this.scope).getType();
  }

  @Override
  public void checkNodeSemantic() {
    //If symbol doesn't exist in the symbol table and it's not a function call, there is a variable not declared
    if (this.symbolTable.doesSymbolExist(this.identifier, this.scope) == null && this.jjtGetNumChildren() > 0) {
     
        if(!this.jjtGetChild(0).getClass().getSimpleName().equals("ASTCall")){
         super.printSemanticError("Variable " + this.identifier + " was not declared");
        }
      
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
