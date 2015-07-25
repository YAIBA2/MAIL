package RSA;
import java.io.ByteArrayInputStream; 
import java.io.FileInputStream; 
import java.io.FileOutputStream;
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream;
import java.net.URLDecoder; 
import java.net.URLEncoder; 
import java.security.KeyFactory; 
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey; 
import java.security.PublicKey; 
import java.security.interfaces.RSAPrivateKey; 
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec; 

import javax.crypto.Cipher; 

import sun.misc.BASE64Decoder; 
import sun.misc.BASE64Encoder;
public class RSAUtils {
	public static String publicKey;
	/** 

     * 算法名称 

     */ 

    private final static String RSA = "RSA"; 

     

    /** 

     * 加密后的字节分隔长度 

     */ 

    private final static int encryptSepLength = 256; 

     

    /** 

     * 明文字节分隔长度 

     */ 

    private final static int plainSepLneght = 100;  

 

    private static byte[] encrypt(byte[] text, PublicKey pubRSA) 
            throws Exception { 
        Cipher cipher = Cipher.getInstance(RSA); 
        cipher.init(Cipher.ENCRYPT_MODE, pubRSA); 
        return cipher.doFinal(text); 
    } 

 

    public final static String encrypt(String text, PublicKey uk) { 
        StringBuffer sbf = new StringBuffer(200); 
        try { 
            text = URLEncoder.encode(text, "UTF-8");//用这个的原因是为了支持汉字、汉字和英文混排,解密方法中同理 
            byte[] plainByte = text.getBytes(); 
            ByteArrayInputStream bays = new ByteArrayInputStream(plainByte); 
            byte[] readByte = new byte[plainSepLneght]; 
            int n = 0; 
            //支持超过117字节，我每次加密100字节。 
            while ((n = bays.read(readByte)) > 0) { 
                if (n >= plainSepLneght) { 
                    sbf.append(byte2hex(encrypt(readByte, uk))); 
                } else { 
                    byte[] tt = new byte[n];                      for (int i = 0; i < n; i++) { 
                        tt[i] = readByte[i]; 
                    } 
                    sbf.append(byte2hex(encrypt(tt, uk))); 
                } 
            } 

        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
        return sbf.toString(); 
    } 

 

    public final static String decrypt(String data, PrivateKey rk) { 
        String rrr = ""; 
        StringBuffer sb = new StringBuffer(100); 
        try { 
            ByteArrayInputStream bais = new ByteArrayInputStream( 
                    data.getBytes()); 
             //此处之所以是 256，而不是128的原因是因为有一个16进行的转换，所以由128变为了256 
             byte[] readByte = new byte[256]; 
            int n = 0; 
            while ((n = bais.read(readByte)) > 0) { 
                if (n >= encryptSepLength) { 
                    sb.append(new String(decrypt(hex2byte(readByte), rk))); 
                } else { 
                } 
            } 
            rrr = URLDecoder.decode(sb.toString(), "UTF-8"); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
        return rrr; 
    } 

 

    private static byte[] decrypt(byte[] src, PrivateKey rk) throws Exception { 
        Cipher cipher = Cipher.getInstance(RSA); 
        cipher.init(Cipher.DECRYPT_MODE, rk); 
        return cipher.doFinal(src); 
    } 

 

    public static String byte2hex(byte[] b) {          String hs = ""; 
        String stmp = ""; 
        for (int n = 0; n < b.length; n++) { 
            stmp = Integer.toHexString(b[n] & 0xFF); 
            if (stmp.length() == 1) 
                hs += ("0" + stmp); 
            else 
                hs += stmp; 
        } 
        return hs.toUpperCase(); 
    } 

 

    public static byte[] hex2byte(byte[] b) { 
        if ((b.length % 2) != 0) 
            throw new IllegalArgumentException("长度不是偶数"); 
        byte[] b2 = new byte[b.length / 2]; 
        for (int n = 0; n < b.length; n += 2) { 
            String item = new String(b, n, 2); 
            b2[n / 2] = (byte) Integer.parseInt(item, 16); 
        } 
        return b2; 
    } 

 

    public static PrivateKey getPrivateKey() { 
        try { 
            FileInputStream f = new FileInputStream("E://邮箱/接受密钥/RSA_priv.dat"); 
            ObjectInputStream b = new ObjectInputStream(f); 
            RSAPrivateKey prk = (RSAPrivateKey) b.readObject(); 
            return prk; 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 

       return null; 
    } 

 //
    public static PublicKey getPublicKey() { 
    	try { 
            FileInputStream f = new FileInputStream("E://邮箱/接受密钥/RSA_publ.dat"); 
            ObjectInputStream b = new ObjectInputStream(f); 
            RSAPublicKey publicKey = (RSAPublicKey) b.readObject();  
            return publicKey; 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 

        return null;
}
    

  /*  public static PublicKey getPublicKey(String pubKey) { 
        try { 
            String publicKeyStr =pubKey; 
            byte[] keyBytes; 
            keyBytes = new BASE64Decoder().decodeBuffer(publicKeyStr); 
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes); 
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");              
            PublicKey publicKey = keyFactory.generatePublic(keySpec); 
            return publicKey; 

        } catch (Exception e) { 
            e.printStackTrace(); 
        } 

        return null;
}*/
    
    public static void builtKey() throws Exception{ 
	    KeyPairGenerator kpg=KeyPairGenerator.getInstance("RSA"); 
	          kpg.initialize(1024); 
	          KeyPair kp=kpg.genKeyPair(); 
	          PublicKey pbkey=kp.getPublic(); 
	          PrivateKey prkey=kp.getPrivate(); 
	          FileOutputStream f2 = new FileOutputStream("E://邮箱/接受密钥/RSA_priv.dat"); 
	          ObjectOutputStream b2 = new ObjectOutputStream(f2); 
	          b2.writeObject(prkey); 
	          FileOutputStream f3 = new FileOutputStream("E://邮箱/接受密钥/RSA_publ.dat"); 
	          ObjectOutputStream b3 = new ObjectOutputStream(f3); 
	          b3.writeObject(pbkey);
	          publicKey  = (new BASE64Encoder()).encode(pbkey.getEncoded()); 
	          System.out.println(pbkey.getEncoded());
	         System.err.println("公:"+publicKey); 
	  }
    public static void main(String args[]) throws Exception{ 
    		RSAUtils.builtKey(); 
	     try { 
	             String plaintext = "手机厂商环节措施：手机病毒存在的一种情况就是利用手机的先天漏洞。所以手机的生产商应该在手机的研制阶段，尽量的减少避免手机漏洞的出现，从根本上杜绝手机病毒。通讯网络运营商环节措施：手机的大部分数据是通过运营商的网关进行传送。通讯运营商在核心网关进行杀毒和防毒可以有效的阻止手机病毒的扩散。所以通讯运营商应该加强网络服务器及网关上的杀毒软件和防火墙的设置，对过往数据进行筛选，把手机病毒扼杀在摇篮中。手机用户环节措施：①使用正版手机，正版手机的安全认证更加严密。市场中智能手机的操作系统各异，防毒能力不同，需要在手机上安装第三方应用软件时尽量去官方网站下载，因为官方网站对软件安全性的检查是非常谨慎的。这样可以大大减少手机由于软件下载造成的中毒现象。"; 
	             System.out.println("plaintextt.getByte().length:" 
	                     + plaintext.getBytes().length); 
	             /*String cipherText = RSAUtils.encrypt(plaintext, 
	RSAUtils.getPublicKey(publicKey)); */
	             String cipherText = RSAUtils.encrypt(plaintext, 
	            			RSAUtils.getPublicKey());
	             System.out.println("cipherText:" + cipherText); 
	             System.err.println("cipherText lenght:" + cipherText.length()); 
	             System.err.println("cipherText byte[]:"+ cipherText.getBytes().length); 
	             String plainText = RSAUtils.decrypt(cipherText, RSAUtils.getPrivateKey()); 
	             System.out.println("需要加密字段:" + plaintext); 
	             System.out.println("解密后字段:" + plainText); 
	         } catch (Exception e) { 
	             e.printStackTrace(); 
	         }  
	     }
}
