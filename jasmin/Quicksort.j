.class public Quicksort
.super java/lang/Object


.method public <init>()V
  aload_0
  invokespecial java/lang/Object/<init>()V
  return
.end method


.method public static main([Ljava/lang/String;)V
  .limit stack 4
  .limit locals 4
  bipush 10
  newarray int
  astore_1
  aload_1
  iconst_0
  iconst_3
  iastore
  aload_1
  iconst_1
  bipush 6
  iastore
  aload_1
  iconst_2
  iconst_1
  iastore
  aload_1
  iconst_3
  iconst_2
  iastore
  aload_1
  iconst_4
  bipush 9
  iastore
  aload_1
  iconst_5
  bipush 10
  iastore
  aload_1
  bipush 6
  iconst_4
  iastore
  aload_1
  bipush 7
  bipush 7
  iastore
  aload_1
  bipush 8
  iconst_5
  iastore
  aload_1
  bipush 9
  bipush 8
  iastore
  new Quicksort
  dup
  invokespecial Quicksort/<init>()V
  astore_3
  aload_3
  aload_1
  invokevirtual Quicksort/quicksort([I)Z
  pop
  aload_3
  aload_1
  invokevirtual Quicksort/printL([I)Z
  pop
  return
.end method



.method public printL([I)Z
  .limit stack 4
  .limit locals 3
  iconst_0
  istore_2
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
  invokestatic io/println(I)V
  iload_2
  iconst_1
  iadd
  istore_2
  goto WHILE_0
  WHILE_NEXT_0:
  iconst_1
  ireturn
.end method



.method public quicksort([I)Z
  .limit stack 5
  .limit locals 2
  aload_0
  aload_1
  iconst_0
  aload_1
  arraylength
  iconst_1
  isub
  invokevirtual Quicksort/quicksort([III)Z
  ireturn
.end method



.method public quicksort([III)Z
  .limit stack 7
  .limit locals 5
  iload_2
  iload_3
  isub
  ifge LT_ELSE_1
  iconst_1
  goto LT_NEXT_1
  LT_ELSE_1:
  iconst_0
  LT_NEXT_1:
  ifeq ELSE_0
  aload_0
  aload_1
  iload_2
  iload_3
  invokevirtual Quicksort/partition([III)I
  istore 4
  aload_0
  aload_1
  iload_2
  iload 4
  iconst_1
  isub
  invokevirtual Quicksort/quicksort([III)Z
  pop
  aload_0
  aload_1
  iload 4
  iconst_1
  iadd
  iload_3
  invokevirtual Quicksort/quicksort([III)Z
  pop
  goto NEXT_0
  ELSE_0:
  NEXT_0:
  iconst_1
  ireturn
.end method



.method public partition([III)I
  .limit stack 10
  .limit locals 8
  aload_1
  iload_3
  iaload
  istore 4
  iload_2
  istore 5
  iload_2
  istore 6
  iload 6
  iload_3
  isub
  ifge LT_ELSE_2
  iconst_1
  goto LT_NEXT_2
  LT_ELSE_2:
  iconst_0
  LT_NEXT_2:
  ifeq WHILE_NEXT_1
  WHILE_1:
  aload_1
  iload 6
  iaload
  iload 4
  isub
  ifge LT_ELSE_3
  iconst_1
  goto LT_NEXT_3
  LT_ELSE_3:
  iconst_0
  LT_NEXT_3:
  ifeq ELSE_1
  aload_1
  iload 5
  iaload
  istore 7
  aload_1
  iload 5
  aload_1
  iload 6
  iaload
  iastore
  aload_1
  iload 6
  iload 7
  iastore
  iload 5
  iconst_1
  iadd
  istore 5
  goto NEXT_1
  ELSE_1:
  NEXT_1:
  iload 6
  iconst_1
  iadd
  istore 6
  iload 6
  iload_3
  isub
  ifge LT_ELSE_2
  iconst_1
  goto LT_NEXT_2
  LT_ELSE_2:
  iconst_0
  LT_NEXT_2:
  ifne WHILE_1
  WHILE_NEXT_1:
  aload_1
  iload 5
  iaload
  istore 7
  aload_1
  iload 5
  aload_1
  iload_3
  iaload
  iastore
  aload_1
  iload_3
  iload 7
  iastore
  iload 5
  ireturn
.end method


