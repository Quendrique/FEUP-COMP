/* Generated By:JJTree: Do not edit this line. ASTMainDeclaration.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package parser;


public class ASTMainDeclaration extends SimpleNode {

  protected String identifier;

  public ASTMainDeclaration(int id) {
    super(id);
  }

  public ASTMainDeclaration(Jmm p, int id) {
    super(p, id);
  }

  public String getIdentifier() {
    return this.identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  @Override
  public void checkNodeSemantic() {
    this.scope = "main";
  }

  public void dump(String prefix) {
    System.out.println(toString(prefix) + ": args: " + this.identifier);
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
/* JavaCC - OriginalChecksum=33abd5ea878283da98f855e1bf361ecf (do not edit this line) */
