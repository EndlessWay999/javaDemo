package com.endlessway.base;

/**
 * 基本数据类型
 */
public class BaseDataTypeDemo {
    public static void main(String[] args) {
        //1.整数类型
        // byte 内存占1字节(byte)=8位(bit)
        byte a1 = 127;
        System.out.println(a1);
        System.out.println("byte最小值："+Byte.MIN_VALUE);
        System.out.println("byte最大值："+Byte.MAX_VALUE);
        // short 内存占2字节(byte)=16位(bit)
        short a2 = 666;
        System.out.println(a2);
        System.out.println("short最小值："+Short.MIN_VALUE);
        System.out.println("short最大值："+Short.MAX_VALUE);
        // int 内存占4字节(byte)=32位(bit)
        int a3 = 999;
        System.out.println(a3);
        System.out.println("int最小值："+Integer.MIN_VALUE);
        System.out.println("int最大值："+Integer.MAX_VALUE);
        // long 内存占8字节(byte)=64位(bit)
        long a4 = 8888L;
        System.out.println(a4);
        System.out.println("long最小值："+Long.MIN_VALUE);
        System.out.println("long最大值："+Long.MIN_VALUE);
        //1.浮点数类型
        // double 内存占8字节(byte)=64位(bit)
        double b1 = 8888.88D;
        System.out.println(b1);
        System.out.println("double："+Double.MIN_VALUE);
        System.out.println("double："+Double.MIN_VALUE);
        // float 内存占4字节(byte)=32位(bit)
        float b2 = 8888.8F;
        System.out.println(b2);
        System.out.println("float最小值："+Float.MIN_VALUE);
        System.out.println("float最大值："+Float.MIN_VALUE);
        //1.字符型
        // char 内存占2字节(byte)=16位(bit)
        char c = 'a';
        System.out.println(c);
        //1.布尔型
        // boolean 内存占1字节(byte)=8位(bit)
        boolean d = true;
        System.out.println(d);
        boolean v = false;
        System.out.println(v);
    }
}
