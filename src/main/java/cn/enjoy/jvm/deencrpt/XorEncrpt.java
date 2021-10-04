package cn.enjoy.jvm.deencrpt;

import java.io.*;

public class XorEncrpt {
    
    private void xor(InputStream in , OutputStream out)throws Exception{
        int ch;
        while (-1 != (ch = in.read())) {
            ch = ch ^ 0xff;
            out.write(ch);
        }
    }
    
    /*加密方法*/
    public void encrypt(File src, File des)throws Exception {
        FileInputStream in = new FileInputStream(src);
        FileOutputStream out = new FileOutputStream(des);

        xor(in, out);
        in.close();
        out.close();
    }
    
    public byte[] decrypt(File src ) throws Exception{
        FileInputStream in = new FileInputStream(src);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        xor(in, bos);
        byte[] data = bos.toByteArray();
        return data;
    }

    public static void main(String[] args)throws Exception {
        File src = new File("");
        File dest = new File("");
        XorEncrpt demoEncryptUtil = new XorEncrpt();
        demoEncryptUtil.encrypt(src,dest);
        System.out.println("加密完成");
    }
    
}
