.class public TestNoErrors
.super java/lang/Object
.field private global_int I
.field private global_boolean Z
.field private global_array [I
.field private global_external LTest;
.field private global_internal LTestNoErrors;


.method public <init>()V
  aload_0
  invokespecial java/lang/Object/<init>()V
  return
.end method


.method public getArray()[I
  .limit stack 1
  .limit locals 2
  iconst_5
  newarray int
  astore_1
  aload_1
  areturn
.end method



.method public static main([Ljava/lang/String;)V
  .limit stack 12
  .limit locals 3
  iconst_0
  istore_1
  iconst_1
  istore_2
  iconst_2
  aload_0
  swap
  putfield TestNoErrors/global_int I
  iconst_5
  newarray int
  aload_0
  swap
  putfield TestNoErrors/global_array [I
  new TestNoErrors
  dup
  invokespecial TestNoErrors/<init>()V
  aload_0
  swap
  putfield TestNoErrors/global_internal LTestNoErrors;
  aload_0
  getfield TestNoErrors/global_internal LTestNoErrors;
  invokestatic TestNoErrors/getArray()[I
  pop
  new Test
  dup
  invokespecial Test/<init>()V
  aload_0
  swap
  putfield TestNoErrors/global_external LTest;
  aload_0
  getfield TestNoErrors/global_external LTest;
  invokestatic Test/getArray()[I
  pop
  iconst_1
  iconst_2
  isub
  ifge LT_ELSE_0
  iconst_1
  goto LT_NEXT_0
  LT_ELSE_0:
  iconst_0
  LT_NEXT_0:
  ifeq ELSE_0
  iconst_1
  istore_1
  goto NEXT_0
  ELSE_0:
  iconst_2
  istore_1
  NEXT_0:
  iconst_0
  istore_1
  WHILE_0:
  iload_1
  bipush 6
  isub
  ifge LT_ELSE_1
  iconst_1
  goto LT_NEXT_1
  LT_ELSE_1:
  iconst_0
  LT_NEXT_1:
  ifeq WHILE_NEXT_0
  iload_1
  iconst_1
  iadd
  istore_1
  aload_0
  getfield TestNoErrors/global_array [I
  bipush 9
  iaload
  aload_0
  swap
  putfield TestNoErrors/global_int I
  goto WHILE_0
  WHILE_NEXT_0:
  return
.end method


