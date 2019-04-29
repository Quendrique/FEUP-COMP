.class public TestExamples
.super java/lang/Object
.field static t I 
.field static b Z 
.field static p [I 


.method public static testIntReturn(II)I
  .limit stack 20
  .limit locals 0
  ireturn
.end method



.method public static main([Ljava/lang/String;)V
  .limit stack 20
  .limit locals 2
  iconst_1
  istore_2
  iload_2
  iconst_1
  iadd
  iconst_2
  iconst_1
  iadd
  iload_2
  iload_2
  iadd
  iconst_1
  iconst_1
  iadd
  iconst_2
  iconst_3
  iadd
  iadd
  istore_2
  astore_1
  iload_2
  iload_2
  invokevirtual TestExternal/test(II)V
  iconst_0
  return
.end method


