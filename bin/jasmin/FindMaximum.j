.class public FindMaximum
.super java/lang/Object
.field private test_arr [I
.field private global_int I


.method public <init>()V
  aload_0
  invokespecial java/lang/Object/<init>()V
  return
.end method


.method public find_maximum([I)I
  .limit stack 6
  .limit locals 5
  iconst_0
  istore_2
  aload_1
  iconst_0
  iaload
  istore_3
  WHILE_0:
  iload_2
  aload_1
  arraylength
  isub
  ifge LT_ELSE_0
  iconst_1
  goto LT_NEXT_0
  LT_ELSE_0:
  iconst_0
  LT_NEXT_0:
  ifeq WHILE_NEXT_0
  aload_1
  iload_2
  iaload
  istore 4
  iload_3
  iload 4
  isub
  ifge LT_ELSE_1
  iconst_1
  goto LT_NEXT_1
  LT_ELSE_1:
  iconst_0
  LT_NEXT_1:
  ifeq ELSE_0
  iload 4
  istore_3
  goto NEXT_0
  ELSE_0:
  NEXT_0:
  iload_2
  iconst_1
  iadd
  istore_2
  goto WHILE_0
  WHILE_NEXT_0:
  iload_3
  ireturn
.end method



.method public build_test_arr()I
  .limit stack 7
  .limit locals 2
  iconst_1
  iconst_2
  iconst_3
  iconst_4
  iconst_5
  bipush 6
  bipush 7
  iadd
  iadd
  iadd
  iadd
  iadd
  iadd
  istore_1
  iconst_5
  newarray int
  aload_0
  swap
  putfield FindMaximum/test_arr [I
  aload_0
  getfield FindMaximum/test_arr [I
  iconst_0
  iconst_0
  bipush 14
  isub
  iastore
  aload_0
  getfield FindMaximum/test_arr [I
  iconst_1
  iconst_0
  bipush 28
  isub
  iastore
  aload_0
  getfield FindMaximum/test_arr [I
  iconst_2
  iconst_1
  iastore
  aload_0
  getfield FindMaximum/test_arr [I
  iconst_3
  iconst_0
  iconst_5
  isub
  iastore
  aload_0
  getfield FindMaximum/test_arr [I
  iconst_4
  iconst_0
  bipush 12
  isub
  iastore
  iconst_0
  ireturn
.end method



.method public get_array()[I
  .limit stack 0
  .limit locals 1
  aload_0
  getfield FindMaximum/test_arr [I
  areturn
.end method



.method public static main([Ljava/lang/String;)V
  .limit stack 7
  .limit locals 2
  new FindMaximum
  dup
  invokespecial FindMaximum/<init>()V
  astore_1
  aload_1
  invokevirtual FindMaximum/build_test_arr()I
  aload_1
  aload_1
  invokevirtual FindMaximum/get_array()[I
  invokevirtual FindMaximum/find_maximum([I)I
  invokestatic ioPlus/printResult(I)V
  return
.end method


