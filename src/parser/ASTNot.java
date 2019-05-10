/* Generated By:JJTree: Do not edit this line. ASTNot.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package parser;

public
class ASTNot extends SimpleNode {
  public ASTNot(int id) {
    super(id);
    this.actualReturnType = "boolean";
  }

  public ASTNot(Jmm p, int id) {
    super(p, id);
    this.actualReturnType = "boolean";
  }

  @Override
  public String getActualReturnType() {
    return this.actualReturnType;
  }

  @Override
  public String getReturnType() {
    return this.actualReturnType;
  }

  @Override
  public void checkNodeSemantic() {
    if(!((SimpleNode) this.jjtGetChild(0)).getReturnType().equals("boolean")) {
      super.flagError();
      super.printSemanticError("The ! operation can only be performed on boolean values");
    }

  }

}
/* JavaCC - OriginalChecksum=d51a67fdf278ac3b7a3840f9efffb2dc (do not edit this line) */
