.class public FindMaximum
.super java/lang/Object
.field static test_arr [I 


.method public static find_maximum([I)I
  .limit stack 20
  .limit locals 3
  iconst_1
  istore_2
  istore 3
  ireturn
.end method



.method public static build_test_arr()I
  .limit stack 20
  .limit locals 0
  ireturn
.end method



.method public static get_array()[I
  .limit stack 20
  .limit locals 0
  areturn
.end method



.method public static main([Ljava/lang/String;)V
  .limit stack 20
  .limit locals 1
  astore_1
  invokevirtual FindMaximum/build_test_arr()I
  invokevirtual FindMaximum/get_array()[I
  invokevirtual FindMaximum/find_maximum([I)I
  invokestatic ioPlus/printResult(I)V
  return
.end method


