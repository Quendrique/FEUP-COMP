/* Generated By:JJTree: Do not edit this line. ASTMethodArgument.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTMethodArgument extends SimpleNode {

  protected String identifier;

  public ASTMethodArgument(int id) {
    super(id);
  }

  public ASTMethodArgument(JmmNew p, int id) {
    super(p, id);
  }

  public String getIdentifier() {
    return this.identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

}
/* JavaCC - OriginalChecksum=2a4ad6cdde0349a884c22866cd0718b4 (do not edit this line) */
