/* JmmTokenManager.java */
/* Generated By:JJTree&JavaCC: Do not edit this line. JmmTokenManager.java */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/** Token Manager. */
@SuppressWarnings("unused")public class JmmTokenManager implements JmmConstants {

  /** Debug output. */
  public static  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public static  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private static final int jjStopStringLiteralDfa_0(int pos, long active0){
   switch (pos)
   {
      case 0:
         if ((active0 & 0xff00007fe0L) != 0L)
         {
            jjmatchedKind = 40;
            return 1;
         }
         return -1;
      case 1:
         if ((active0 & 0xff000077e0L) != 0L)
         {
            jjmatchedKind = 40;
            jjmatchedPos = 1;
            return 1;
         }
         if ((active0 & 0x800L) != 0L)
            return 1;
         return -1;
      case 2:
         if ((active0 & 0xbe000077e0L) != 0L)
         {
            jjmatchedKind = 40;
            jjmatchedPos = 2;
            return 1;
         }
         if ((active0 & 0x4100000000L) != 0L)
            return 1;
         return -1;
      case 3:
         if ((active0 & 0x96000061e0L) != 0L)
         {
            jjmatchedKind = 40;
            jjmatchedPos = 3;
            return 1;
         }
         if ((active0 & 0x2800001600L) != 0L)
            return 1;
         return -1;
      case 4:
         if ((active0 & 0x86000041c0L) != 0L)
         {
            jjmatchedKind = 40;
            jjmatchedPos = 4;
            return 1;
         }
         if ((active0 & 0x1000002020L) != 0L)
            return 1;
         return -1;
      case 5:
         if ((active0 & 0x200000040L) != 0L)
         {
            jjmatchedKind = 40;
            jjmatchedPos = 5;
            return 1;
         }
         if ((active0 & 0x8400004180L) != 0L)
            return 1;
         return -1;
      default :
         return -1;
   }
}
private static final int jjStartNfa_0(int pos, long active0){
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
static private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
static private int jjMoveStringLiteralDfa0_0(){
   switch(curChar)
   {
      case 33:
         return jjStopAtPos(0, 25);
      case 38:
         return jjMoveStringLiteralDfa1_0(0x4000000L);
      case 40:
         return jjStopAtPos(0, 19);
      case 41:
         return jjStopAtPos(0, 20);
      case 42:
         return jjStopAtPos(0, 31);
      case 43:
         return jjStopAtPos(0, 28);
      case 44:
         return jjStopAtPos(0, 21);
      case 45:
         return jjStopAtPos(0, 29);
      case 46:
         return jjStopAtPos(0, 22);
      case 47:
         return jjStopAtPos(0, 30);
      case 59:
         return jjStopAtPos(0, 23);
      case 60:
         return jjStopAtPos(0, 27);
      case 61:
         return jjStopAtPos(0, 24);
      case 83:
         return jjMoveStringLiteralDfa1_0(0x400000000L);
      case 91:
         return jjStopAtPos(0, 17);
      case 93:
         return jjStopAtPos(0, 18);
      case 98:
         return jjMoveStringLiteralDfa1_0(0x200000000L);
      case 99:
         return jjMoveStringLiteralDfa1_0(0x20L);
      case 101:
         return jjMoveStringLiteralDfa1_0(0x1040L);
      case 102:
         return jjMoveStringLiteralDfa1_0(0x1000000000L);
      case 105:
         return jjMoveStringLiteralDfa1_0(0x100000800L);
      case 108:
         return jjMoveStringLiteralDfa1_0(0x8000000000L);
      case 109:
         return jjMoveStringLiteralDfa1_0(0x400L);
      case 110:
         return jjMoveStringLiteralDfa1_0(0x4000000000L);
      case 112:
         return jjMoveStringLiteralDfa1_0(0x80L);
      case 114:
         return jjMoveStringLiteralDfa1_0(0x4000L);
      case 115:
         return jjMoveStringLiteralDfa1_0(0x100L);
      case 116:
         return jjMoveStringLiteralDfa1_0(0x2800000000L);
      case 118:
         return jjMoveStringLiteralDfa1_0(0x200L);
      case 119:
         return jjMoveStringLiteralDfa1_0(0x2000L);
      case 123:
         return jjStopAtPos(0, 15);
      case 125:
         return jjStopAtPos(0, 16);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
static private int jjMoveStringLiteralDfa1_0(long active0){
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 38:
         if ((active0 & 0x4000000L) != 0L)
            return jjStopAtPos(1, 26);
         break;
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x400L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0xc000004000L);
      case 102:
         if ((active0 & 0x800L) != 0L)
            return jjStartNfaWithStates_0(1, 11, 1);
         break;
      case 104:
         return jjMoveStringLiteralDfa2_0(active0, 0x2000002000L);
      case 108:
         return jjMoveStringLiteralDfa2_0(active0, 0x1000001020L);
      case 110:
         return jjMoveStringLiteralDfa2_0(active0, 0x100000000L);
      case 111:
         return jjMoveStringLiteralDfa2_0(active0, 0x200000200L);
      case 114:
         return jjMoveStringLiteralDfa2_0(active0, 0x800000000L);
      case 116:
         return jjMoveStringLiteralDfa2_0(active0, 0x400000100L);
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0x80L);
      case 120:
         return jjMoveStringLiteralDfa2_0(active0, 0x40L);
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
static private int jjMoveStringLiteralDfa2_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x1000000120L);
      case 98:
         return jjMoveStringLiteralDfa3_0(active0, 0x80L);
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0x2000002600L);
      case 110:
         return jjMoveStringLiteralDfa3_0(active0, 0x8000000000L);
      case 111:
         return jjMoveStringLiteralDfa3_0(active0, 0x200000000L);
      case 114:
         return jjMoveStringLiteralDfa3_0(active0, 0x400000000L);
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x1000L);
      case 116:
         if ((active0 & 0x100000000L) != 0L)
            return jjStartNfaWithStates_0(2, 32, 1);
         return jjMoveStringLiteralDfa3_0(active0, 0x4040L);
      case 117:
         return jjMoveStringLiteralDfa3_0(active0, 0x800000000L);
      case 119:
         if ((active0 & 0x4000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 38, 1);
         break;
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
static private int jjMoveStringLiteralDfa3_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 100:
         if ((active0 & 0x200L) != 0L)
            return jjStartNfaWithStates_0(3, 9, 1);
         break;
      case 101:
         if ((active0 & 0x1000L) != 0L)
            return jjStartNfaWithStates_0(3, 12, 1);
         else if ((active0 & 0x800000000L) != 0L)
            return jjStartNfaWithStates_0(3, 35, 1);
         return jjMoveStringLiteralDfa4_0(active0, 0x40L);
      case 103:
         return jjMoveStringLiteralDfa4_0(active0, 0x8000000000L);
      case 105:
         return jjMoveStringLiteralDfa4_0(active0, 0x400000000L);
      case 108:
         return jjMoveStringLiteralDfa4_0(active0, 0x200002080L);
      case 110:
         if ((active0 & 0x400L) != 0L)
            return jjStartNfaWithStates_0(3, 10, 1);
         break;
      case 115:
         if ((active0 & 0x2000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 37, 1);
         return jjMoveStringLiteralDfa4_0(active0, 0x1000000020L);
      case 116:
         return jjMoveStringLiteralDfa4_0(active0, 0x100L);
      case 117:
         return jjMoveStringLiteralDfa4_0(active0, 0x4000L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
static private int jjMoveStringLiteralDfa4_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x2000L) != 0L)
            return jjStartNfaWithStates_0(4, 13, 1);
         else if ((active0 & 0x1000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 36, 1);
         return jjMoveStringLiteralDfa5_0(active0, 0x200000000L);
      case 105:
         return jjMoveStringLiteralDfa5_0(active0, 0x180L);
      case 110:
         return jjMoveStringLiteralDfa5_0(active0, 0x400000040L);
      case 114:
         return jjMoveStringLiteralDfa5_0(active0, 0x4000L);
      case 115:
         if ((active0 & 0x20L) != 0L)
            return jjStartNfaWithStates_0(4, 5, 1);
         break;
      case 116:
         return jjMoveStringLiteralDfa5_0(active0, 0x8000000000L);
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
static private int jjMoveStringLiteralDfa5_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa6_0(active0, 0x200000000L);
      case 99:
         if ((active0 & 0x80L) != 0L)
            return jjStartNfaWithStates_0(5, 7, 1);
         else if ((active0 & 0x100L) != 0L)
            return jjStartNfaWithStates_0(5, 8, 1);
         break;
      case 100:
         return jjMoveStringLiteralDfa6_0(active0, 0x40L);
      case 103:
         if ((active0 & 0x400000000L) != 0L)
            return jjStartNfaWithStates_0(5, 34, 1);
         break;
      case 104:
         if ((active0 & 0x8000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 39, 1);
         break;
      case 110:
         if ((active0 & 0x4000L) != 0L)
            return jjStartNfaWithStates_0(5, 14, 1);
         break;
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
static private int jjMoveStringLiteralDfa6_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0);
      return 6;
   }
   switch(curChar)
   {
      case 110:
         if ((active0 & 0x200000000L) != 0L)
            return jjStartNfaWithStates_0(6, 33, 1);
         break;
      case 115:
         if ((active0 & 0x40L) != 0L)
            return jjStartNfaWithStates_0(6, 6, 1);
         break;
      default :
         break;
   }
   return jjStartNfa_0(5, active0);
}
static private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 3;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
               case 2:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 41)
                     kind = 41;
                  { jjCheckNAdd(2); }
                  break;
               case 1:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 40)
                     kind = 40;
                  jjstateSet[jjnewStateCnt++] = 1;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
               case 1:
                  if ((0x7fffffe07fffffeL & l) == 0L)
                     break;
                  if (kind > 40)
                     kind = 40;
                  { jjCheckNAdd(1); }
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 3 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
};

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, "\143\154\141\163\163", 
"\145\170\164\145\156\144\163", "\160\165\142\154\151\143", "\163\164\141\164\151\143", "\166\157\151\144", 
"\155\141\151\156", "\151\146", "\145\154\163\145", "\167\150\151\154\145", 
"\162\145\164\165\162\156", "\173", "\175", "\133", "\135", "\50", "\51", "\54", "\56", "\73", "\75", 
"\41", "\46\46", "\74", "\53", "\55", "\57", "\52", "\151\156\164", 
"\142\157\157\154\145\141\156", "\123\164\162\151\156\147", "\164\162\165\145", "\146\154\141\163\145", 
"\164\150\151\163", "\156\145\167", "\154\145\156\147\164\150", null, null, };
static protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

static int curLexState = 0;
static int defaultLexState = 0;
static int jjnewStateCnt;
static int jjround;
static int jjmatchedPos;
static int jjmatchedKind;

/** Get the next Token. */
public static Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      jjmatchedPos = -1;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   try { input_stream.backup(0);
      while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

static private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
static private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
static private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

    /** Constructor. */
    public JmmTokenManager(SimpleCharStream stream){

      if (input_stream != null)
        throw new TokenMgrError("ERROR: Second call to constructor of static lexer. You must use ReInit() to initialize the static variables.", TokenMgrError.STATIC_LEXER_ERROR);

    input_stream = stream;
  }

  /** Constructor. */
  public JmmTokenManager (SimpleCharStream stream, int lexState){
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Reinitialise parser. */
  static public void ReInit(SimpleCharStream stream)
  {
    jjmatchedPos = jjnewStateCnt = 0;
    curLexState = defaultLexState;
    input_stream = stream;
    ReInitRounds();
  }

  static private void ReInitRounds()
  {
    int i;
    jjround = 0x80000001;
    for (i = 3; i-- > 0;)
      jjrounds[i] = 0x80000000;
  }

  /** Reinitialise parser. */
  static public void ReInit(SimpleCharStream stream, int lexState)
  {
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Switch to specified lex state. */
  static public void SwitchTo(int lexState)
  {
    if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
    else
      curLexState = lexState;
  }

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
};
static final long[] jjtoToken = {
   0x3ffffffffe1L, 
};
static final long[] jjtoSkip = {
   0x1eL, 
};
    static protected SimpleCharStream  input_stream;

    static private final int[] jjrounds = new int[3];
    static private final int[] jjstateSet = new int[2 * 3];

    
    static protected char curChar;
}
