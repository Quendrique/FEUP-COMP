/* Generated By:JJTree: Do not edit this line. ASTAddSub.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package parser;

public class ASTAddSub extends SimpleNode {

  protected String op;

  public ASTAddSub(int id) {
    super(id);
    this.actualReturnType = "int";
  }

  public ASTAddSub(Jmm p, int id) {
    super(p, id);
    this.actualReturnType = "int";
  }

  public String getOp() {
    return this.op;
  } 

  public void setOp(String op) {
    this.op = op;
  } 

  public String toString() {
    return "";
  }

  @Override  
  public void checkNodeSemantic() {
    SimpleNode lhs, rhs;
    lhs = (SimpleNode) this.jjtGetChild(0); rhs = (SimpleNode) this.jjtGetChild(1);
    if (lhs.getReturnType() != "int" || rhs.getReturnType() != "int") {
      System.out.println("Both sides of a " + this.op + " operation should be of type int");
    }
  }

  public void dump(String prefix) {
    System.out.println(toString(prefix) + "(" + this.op + ")");
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
/* JavaCC - OriginalChecksum=e7c2b6d4927322836149a8181e857e01 (do not edit this line) */
