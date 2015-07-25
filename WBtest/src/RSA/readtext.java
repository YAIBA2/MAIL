package RSA;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class readtext {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("E://邮箱/接受密钥/RSA_priv.dat"));
		String pri;
		StringBuffer sb = new StringBuffer(); 
		while ((pri = in.readLine())!=null) {
			System.out.println(pri);
			sb.append(pri);
		}
		in.close();
		pri=sb.toString();
		BufferedReader in1 = new BufferedReader(new FileReader("E://邮箱/接受密钥/RSA_publ.dat"));
		String pub;
		StringBuffer sb1 = new StringBuffer(); 
		while ((pub = in1.readLine())!=null) {
			System.out.println(pub);
			sb1.append(pub);
		}
		in1.close();
		pub=sb1.toString();
		String plaintext = "15233727";
        System.out.println("plaintextt.getByte().length:" 
                + plaintext.getBytes().length); 
        /*String cipherText = RSAUtils1.encrypt(plaintext, 
RSAUtils1.getPublicKey(pub)); */
        String cipherText=RSAUtils1.encrypt1(plaintext,RSAUtils1.getPrivateKey(pri));
       /* String cipherText = RSAUtils.encrypt(plaintext, 
       			RSAUtils.getPublicKey());*/
        System.out.println("cipherText:" + cipherText); 
        System.err.println("cipherText lenght:" + cipherText.length()); 
        System.err.println("cipherText byte[]:"+ cipherText.getBytes().length); 
        //String plainText = RSAUtils1.decrypt(cipherText, RSAUtils1.getPrivateKey(pri)); 
        String plainText=RSAUtils1.decrypt1(cipherText, RSAUtils1.getPublicKey(pub));
        System.out.println("需要加密字段:" + plaintext); 
        System.out.println("解密后字段:" + plainText); 
		

	}

}
