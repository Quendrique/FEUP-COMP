/* Generated By:JJTree: Do not edit this line. ASTIntegerLiteral.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package parser;

public
class ASTIntegerLiteral extends SimpleNode {

  protected int value;

  public ASTIntegerLiteral(int id) {
    super(id);
    this.returnType = "int";
  }

  public ASTIntegerLiteral(Jmm p, int id) {
    super(p, id);
    this.returnType = "int";
  }

  public int getValue() {
    return this.value;
  }
  
  @Override
  public String getReturnType() {
    return this.returnType;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public void dump(String prefix) {
    System.out.println(toString(prefix) + ": " + this.value);
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
/* JavaCC - OriginalChecksum=e434a5cb529e3bb000bda3be07de2158 (do not edit this line) */
