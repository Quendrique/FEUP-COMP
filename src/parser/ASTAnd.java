/* Generated By:JJTree: Do not edit this line. ASTAnd.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package parser;

public class ASTAnd extends SimpleNode {

  public ASTAnd(int id) {
    super(id);
    this.returnType = "boolean";
  }

  public ASTAnd(Jmm p, int id) {
    super(p, id);
  }

  public String toString() {
    return "(&&)";
  }

}
/* JavaCC - OriginalChecksum=5b49cdc56b18d489e3596312bd0c07e0 (do not edit this line) */
