/* Generated By:JJTree: Do not edit this line. ASTAssignStatement.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTAssignStatement extends SimpleNode {

  protected String identifier;

  public ASTAssignStatement(int id) {
    super(id);
  }

  public ASTAssignStatement(JmmNew p, int id) {
    super(p, id);
  }

  public String getIdentifier() {
    return this.identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
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
/* JavaCC - OriginalChecksum=f910517499468a690978f7b7001cd595 (do not edit this line) */
