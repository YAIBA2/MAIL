package RSA;
import java.io.ByteArrayInputStream; 
import java.io.FileInputStream; 
import java.io.FileOutputStream;
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.URLDecoder; 
import java.net.URLEncoder; 
import java.security.KeyFactory; 
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey; 
import java.security.PublicKey; 
import java.security.interfaces.RSAPrivateKey; 
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec; 

import javax.crypto.Cipher; 

import sun.misc.BASE64Decoder; 
import sun.misc.BASE64Encoder;

public class RSAUtils1 {
	public static String publicKey;
	public static String privateKey;
	/** 

     * �㷨���� 

     */ 
    private final static String RSA = "RSA";
     

    /** 

     * ���ܺ���ֽڷָ����� 

     */ 

    private final static int encryptSepLength = 256; 

     

    /** 

     * �����ֽڷָ����� 

     */ 

    private final static int plainSepLneght = 100;  

 

    private static byte[] encrypt(byte[] text, PublicKey pubRSA) 
            throws Exception { 
        Cipher cipher = Cipher.getInstance(RSA); 
        cipher.init(Cipher.ENCRYPT_MODE, pubRSA); 
        return cipher.doFinal(text); 
    } 
    
    private static byte[] encrypt1(byte[] text, PrivateKey rk) 
            throws Exception { 
        Cipher cipher = Cipher.getInstance(RSA); 
        cipher.init(Cipher.ENCRYPT_MODE, rk); 
        return cipher.doFinal(text); 
    } 

 

    public final static String encrypt(String text, PublicKey uk) { 
        StringBuffer sbf = new StringBuffer(200); 
        try { 
            text = URLEncoder.encode(text, "UTF-8");//�������ԭ����Ϊ��֧�ֺ��֡����ֺ�Ӣ�Ļ���,���ܷ�����ͬ�� 
            byte[] plainByte = text.getBytes(); 
            ByteArrayInputStream bays = new ByteArrayInputStream(plainByte); 
            byte[] readByte = new byte[plainSepLneght]; 
            int n = 0; 
            //֧�ֳ���117�ֽڣ���ÿ�μ���100�ֽڡ� 
            while ((n = bays.read(readByte)) > 0) { 
                if (n >= plainSepLneght) { 
                    sbf.append(byte2hex(encrypt(readByte, uk))); 
                } else { 
                    byte[] tt = new byte[n];                      
                    for (int i = 0; i < n; i++) { 
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
    
    public final static String encrypt1(String text, PrivateKey rk) { 
        StringBuffer sbf = new StringBuffer(200); 
        try { 
            text = URLEncoder.encode(text, "UTF-8");//�������ԭ����Ϊ��֧�ֺ��֡����ֺ�Ӣ�Ļ���,���ܷ�����ͬ�� 
            byte[] plainByte = text.getBytes(); 
            ByteArrayInputStream bays = new ByteArrayInputStream(plainByte); 
            byte[] readByte = new byte[plainSepLneght]; 
            int n = 0; 
            //֧�ֳ���117�ֽڣ���ÿ�μ���100�ֽڡ� 
            while ((n = bays.read(readByte)) > 0) { 
                if (n >= plainSepLneght) { 
                    sbf.append(byte2hex(encrypt1(readByte, rk))); 
                } else { 
                    byte[] tt = new byte[n];                      
                    for (int i = 0; i < n; i++) { 
                        tt[i] = readByte[i]; 
                    } 
                    sbf.append(byte2hex(encrypt1(tt, rk))); 
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
             //�˴�֮������ 256��������128��ԭ������Ϊ��һ��16���е�ת����������128��Ϊ��256 
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
    
    
    public final static String decrypt1(String data, PublicKey uk) { 
        String rrr = ""; 
        StringBuffer sb = new StringBuffer(100); 
        try { 
            ByteArrayInputStream bais = new ByteArrayInputStream( 
                    data.getBytes()); 
             //�˴�֮������ 256��������128��ԭ������Ϊ��һ��16���е�ת����������128��Ϊ��256 
             byte[] readByte = new byte[256]; 
            int n = 0; 
            while ((n = bais.read(readByte)) > 0) { 
                if (n >= encryptSepLength) { 
                    sb.append(new String(decrypt1(hex2byte(readByte), uk))); 
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
    
    private static byte[] decrypt1(byte[] src, PublicKey uk) throws Exception { 
        Cipher cipher = Cipher.getInstance(RSA); 
        cipher.init(Cipher.DECRYPT_MODE, uk); 
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
            throw new IllegalArgumentException("���Ȳ���ż��"); 
        byte[] b2 = new byte[b.length / 2]; 
        for (int n = 0; n < b.length; n += 2) { 
            String item = new String(b, n, 2); 
            b2[n / 2] = (byte) Integer.parseInt(item, 16); 
        } 
        return b2; 
    } 

 

   /* public static PrivateKey getPrivateKey() { 
        try { 
            FileInputStream f = new FileInputStream("E://����/������Կ/RSA_priv.dat"); 
            ObjectInputStream b = new ObjectInputStream(f); 
            RSAPrivateKey prk = (RSAPrivateKey) b.readObject(); 
            return prk; 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 

       return null; 
    } */

    public static PrivateKey getPrivateKey(String priKey) { 
        try { 
            String PrivateKeyStr =priKey; 
            byte[] keyBytes; 
            keyBytes = new BASE64Decoder().decodeBuffer(PrivateKeyStr); 
            //X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes); 
            PKCS8EncodedKeySpec keySpec  = new PKCS8EncodedKeySpec(keyBytes); 
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");              
            PrivateKey privateKey = keyFactory.generatePrivate(keySpec); 
            return privateKey; 

        } catch (Exception e) { 
            e.printStackTrace(); 
        } 

        return null;
}

    public static PublicKey getPublicKey(String pubKey) { 
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
}
    
    public static void builtKey() throws Exception{ 
	    KeyPairGenerator kpg=KeyPairGenerator.getInstance("RSA"); 
	          kpg.initialize(1024); 
	          KeyPair kp=kpg.genKeyPair(); 
	          PublicKey pbkey=kp.getPublic(); 
	          PrivateKey prkey=kp.getPrivate(); 
	          publicKey  = (new BASE64Encoder()).encode(pbkey.getEncoded()); 
	          privateKey  = (new BASE64Encoder()).encode(prkey.getEncoded());
	          FileOutputStream f2 = new FileOutputStream("E://����/������Կ/RSA_priv.dat"); 
	          PrintStream p=new PrintStream(f2);
	          p.println(privateKey);
	          p.close();
	          f2.close();
	          FileOutputStream f3 = new FileOutputStream("E://����/������Կ/RSA_publ.dat"); 
	          PrintStream p1=new PrintStream(f3);
	          p1.println(publicKey);
	          p1.close();
	          f3.close();
	           
	          System.out.println(pbkey.getEncoded());
	         System.err.println("��:"+publicKey); 
	         System.err.println("˽:"+privateKey); 
	  }
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		RSAUtils1.builtKey(); 
	     try { 
	             String plaintext = "�ֻ����̻��ڴ�ʩ���ֻ��������ڵ�һ��������������ֻ�������©���������ֻ���������Ӧ�����ֻ������ƽ׶Σ������ļ��ٱ����ֻ�©���ĳ��֣��Ӹ����϶ž��ֻ�������ͨѶ������Ӫ�̻��ڴ�ʩ���ֻ��Ĵ󲿷�������ͨ����Ӫ�̵����ؽ��д��͡�ͨѶ��Ӫ���ں������ؽ���ɱ���ͷ���������Ч����ֹ�ֻ���������ɢ������ͨѶ��Ӫ��Ӧ�ü�ǿ����������������ϵ�ɱ�������ͷ���ǽ�����ã��Թ������ݽ���ɸѡ�����ֻ�������ɱ��ҡ���С��ֻ��û����ڴ�ʩ����ʹ�������ֻ��������ֻ��İ�ȫ��֤�������ܡ��г��������ֻ��Ĳ���ϵͳ���죬����������ͬ����Ҫ���ֻ��ϰ�װ������Ӧ������ʱ����ȥ�ٷ���վ���أ���Ϊ�ٷ���վ��������ȫ�Եļ���Ƿǳ������ġ��������Դ������ֻ���������������ɵ��ж�����"; 
	             System.out.println("plaintextt.getByte().length:" 
	                     + plaintext.getBytes().length); 
	             String cipherText = RSAUtils1.encrypt(plaintext, 
	RSAUtils1.getPublicKey(publicKey)); 
	            /* String cipherText = RSAUtils.encrypt(plaintext, 
	            			RSAUtils.getPublicKey());*/
	             System.out.println("cipherText:" + cipherText); 
	             System.err.println("cipherText lenght:" + cipherText.length()); 
	             System.err.println("cipherText byte[]:"+ cipherText.getBytes().length); 
	             String plainText = RSAUtils1.decrypt(cipherText, RSAUtils1.getPrivateKey(privateKey)); 
	             System.out.println("��Ҫ�����ֶ�:" + plaintext); 
	             System.out.println("���ܺ��ֶ�:" + plainText); 
	         } catch (Exception e) { 
	             e.printStackTrace(); 
	         }   
	}

}