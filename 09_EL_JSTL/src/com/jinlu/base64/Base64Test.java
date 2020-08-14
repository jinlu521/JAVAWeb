package com.jinlu.base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Base64Test {
    public static void main(String[] args) throws IOException {
        String content ="这是需要Base64编码的内容";
        //创建一个Base64编码器
        BASE64Encoder base64Encoder = new BASE64Encoder();
        //执行Base64编码的操作,把字符串的默认编码转换成Base64编码，火狐浏览器
        String encode = base64Encoder.encode(content.getBytes("UTF-8"));
        System.out.println(encode);

        // 解码， 把base64编码即转换成默认编码
        BASE64Decoder base64Decoder = new BASE64Decoder();
        byte[] bytes = base64Decoder.decodeBuffer(encode);

        String s = new String(bytes, "utf-8");
        System.out.println(s);


    }
}
