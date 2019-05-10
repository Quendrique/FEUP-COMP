.class public TestExamples
.super java/lang/Object
.field static t I 
.field static b Z 
.field static p [I 


.method public static testIntReturn(II)I
  .limit stack 20
  .limit locals 2
  iconst_1
  ireturn
.end method



.method public static testIntReturn2(II)I
  .limit stack 20
  .limit locals 2
  iload_2
  iconst_1
  iadd
  istore_1
  iload_1
  ireturn
.end method



.method public static main([Ljava/lang/String;)V
  .limit stack 20
  .limit locals 5
  iconst_1
  istore 3
  iconst_4
  newarray
  astore 4
  iconst_1
  iastore
  new TestExamples
  dup
  invokespecial TestExamples<init>()V
  astore_2
  iload 3
  iconst_1
  iand
  putfield TestExamples/b Z
  iconst_1
  aload_0
  getfield TestExamples/p [I
  iand
  putfield TestExamples/b Z
  iconst_1
  iconst_1
  iand
  putfield TestExamples/b Z
  aload_0
  getfield TestExamples/p [I
  arraylength
  putfield TestExamples/t I
  aload_0
  getfield TestExamples/b Z
  arraylength
  putfield TestExamples/t I
  aload 4
  arraylength
  putfield TestExamples/t I
  iconst_0
  invokevirtual TestExternal/call()V
  iconst_1
  iconst_1
  ixor
  putfield TestExamples/b Z
  iconst_1
  iconst_1
  ixor
  putfield TestExamples/b Z
  iconst_5
  iload 3
  iconst_1
  iadd
  iconst_2
  iconst_1
  iadd
  iload 3
  iload 3
  iadd
  iload 3
  aload_0
  getfield TestExamples/p [I
  iadd
  istore 3
  iconst_1
  iconst_0
  iand
  istore 5
  iconst_1
  iconst_1
  isub
  istore 5
  iconst_1
  iconst_1
  iadd
  iconst_2
  iconst_3
  iadd
  iadd
  istore 3
  new TestExamples
  dup
  invokespecial TestExamples<init>()V
  astore_1
  iload 3
  iload 3
  invokevirtual TestExternal/test(II)V
  iconst_0
  aload 4
  iconst_1
  iaload
  istore 3
  aload 4
  istore 3
  aload 4
  iconst_1
  iaload
  istore 3
  istore 3
  return
.end method


