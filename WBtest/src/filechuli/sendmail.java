package filechuli;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;

import RSA.RSAUtils1;

public class sendmail {
public static void main(String[] args) throws Exception {
	BufferedReader in = new BufferedReader(new FileReader("E:/邮箱/发送邮件/canshu.txt"));
	String fajianren=in.readLine();
	String shoujianren=in.readLine();
	String zhuti=in.readLine();
	String mail;
	StringBuffer sb = new StringBuffer(); 
	System.out.println(zhuti);
	while ((mail = in.readLine())!=null) {
		sb.append(mail+'\n');
	}
	in.close();
	mail=sb.toString();
	filemail.buildsendmail0(fajianren, shoujianren);
	String filename="E:/邮箱/发送邮件/buildsendmail0.txt";
	socketsend a=new socketsend(filename);
	//socket发送                                             0
	
	//得到结果                                                 1
	//RSAUtils.builtKey();*/
	BufferedReader in1 = new BufferedReader(new FileReader("E:/邮箱/接受数据/huancun.txt"));
	String zhuangtai=in1.readLine();
	if(Integer.parseInt(zhuangtai)==0){
		String key;
		StringBuffer sb1 = new StringBuffer();
		while ((key = in1.readLine())!=null) {
			sb1.append(key);
		}
		key=sb1.toString();
		//System.out.println(key);
		/*FileOutputStream out=new FileOutputStream("E://邮箱/接受密钥/RSA_publ1.dat");
		PrintStream p=new PrintStream(out);
		p.println(key);
		p.close();
		out.close();*/
		String cipherText = RSAUtils1.encrypt(mail, 
				RSAUtils1.getPublicKey(key)); 
		//filemail.buildsendmail1(zhuti, cipherText);
		filemail.buildsendmail1(fajianren, shoujianren, zhuti, cipherText);
		in1.close();
	}
	if(Integer.parseInt(zhuangtai)==1){
		FileOutputStream out=new FileOutputStream("E:/邮箱/发送邮件/jieguo.txt");
		PrintStream p=new PrintStream(out);	
		p.println("1");
		p.close();
		out.close();
		in1.close();
		return;
	}
	if(Integer.parseInt(zhuangtai)==9){
		FileOutputStream out=new FileOutputStream("E:/邮箱/发送邮件/jieguo.txt");
		PrintStream p=new PrintStream(out);	
		p.println("9");
		p.close();
		out.close();
		in1.close();
		return;
	}
	//加密处理
	/*FileInputStream f = new FileInputStream("E://邮箱/接受密钥/RSA_publ.dat"); 
    ObjectInputStream b = new ObjectInputStream(f); 
    RSAPublicKey prk = (RSAPublicKey) b.readObject(); 
	String cipherText = RSAUtils.encrypt(mail, 
			RSAUtils.getPublicKey()); 
	filemail.buildsendmail1(zhuti, cipherText);*/
	filename="E:/邮箱/发送邮件/buildsendmail1.txt";
	socketsend a1=new socketsend(filename);

	//socket(存成的文件路径)执行，发送邮件。     0
	
	//传送结果存成结果.txt                    1
	/*FileOutputStream out=new FileOutputStream("E:/邮箱/发送邮件/jieguo.txt");
	PrintStream p=new PrintStream(out);	
	String jieguo = null;//这里由socket返回
	p.println(jieguo);
	p.close();
	out.close();*/
	
	
}
}
