/* Generated By:JJTree: Do not edit this line. ASTLessThan.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package parser;

public
class ASTLessThan extends SimpleNode {

  public ASTLessThan(int id) {
    super(id);
    this.returnType = "boolean";
  }

  public ASTLessThan(Jmm p, int id) {
    super(p, id);
    this.returnType = "boolean";
  }

  @Override  
  public void checkNodeSemantic() {
    SimpleNode lhs, rhs;
    lhs = (SimpleNode) this.jjtGetChild(0); rhs = (SimpleNode) this.jjtGetChild(1);
    System.out.println(lhs.returnType + rhs.returnType);
    if (lhs.returnType != "int" || rhs.returnType != "int") {
      super.printSemanticError("Both sides of a < operation should be of type int");
    }
  }

  public String toString() {
    return "(<)";
  }

}
/* JavaCC - OriginalChecksum=2edc0177dedb372fb668d3c47c0f1750 (do not edit this line) */
