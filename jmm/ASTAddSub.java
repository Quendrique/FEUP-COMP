/* Generated By:JJTree: Do not edit this line. ASTAddSub.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTAddSub extends SimpleNode {

  protected String op;

  public ASTAddSub(int id) {
    super(id);
  }

  public ASTAddSub(JmmNew p, int id) {
    super(p, id);
  }

  public String getOp() {
    return this.op;
  } 

  public void setOp(String op) {
    this.op = op;
  } 

  public void dump(String prefix) {
    System.out.println(toString(prefix) + ": " + this.op);
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
