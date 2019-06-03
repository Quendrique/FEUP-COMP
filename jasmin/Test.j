.class public Test
.super java/lang/Object
.field private t I
.field private b Z
.field private p [I


.method public <init>()V
  aload_0
  invokespecial java/lang/Object/<init>()V
  return
.end method


.method public static main([Ljava/lang/String;)V
  .limit stack 1
  .limit locals 2
  iconst_0
  istore_1
  return
.end method



.method public getArray()[I
  .limit stack 1
  .limit locals 2
  iconst_3
  newarray int
  astore_1
  aload_1
  areturn
.end method


