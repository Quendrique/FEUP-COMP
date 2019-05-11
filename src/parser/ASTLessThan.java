/* Generated By:JJTree: Do not edit this line. ASTLessThan.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package parser;

public
class ASTLessThan extends SimpleNode {

  static int count = 0;
  int labelId;

  public ASTLessThan(int id) {
    super(id);
    this.actualReturnType = "boolean";
    this.labelId = count;
    count++;
  }

  public ASTLessThan(Jmm p, int id) {
    super(p, id);
    this.actualReturnType = "boolean";
    this.labelId = count;
    count++;
  }

  public int getLabelId() {
    return this.labelId;
  }
  
  @Override
  public String getReturnType() {
    //logic operations can only return boolean
    return this.actualReturnType;
  }

  @Override  
  public void checkNodeSemantic() {
    SimpleNode lhs, rhs;
    lhs = (SimpleNode) this.jjtGetChild(0); rhs = (SimpleNode) this.jjtGetChild(1);
    if (lhs.getReturnType() != "int" || rhs.getReturnType() != "int") {
      super.printSemanticError("Both sides of a < operation should be of type int");
    }
  }

  public String toString() {
    return "(<)";
  }

}
/* JavaCC - OriginalChecksum=2edc0177dedb372fb668d3c47c0f1750 (do not edit this line) */
