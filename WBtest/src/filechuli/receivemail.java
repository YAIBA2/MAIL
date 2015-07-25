package filechuli;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;

import RSA.RSAUtils1;

public class receivemail {
	public static void main(String[] args) throws Exception {
	FileOutputStream clear=new FileOutputStream("E://邮箱/接受邮件/jieguo.txt");
	clear.close();
	FileOutputStream clear1=new FileOutputStream("E://邮箱/签名/jieguo.txt");
	clear1.close();
	
	String filename="E:/邮箱/签名/canshu.txt";
	socketsend a1=new socketsend(filename);
	
	BufferedReader in1 = new BufferedReader(new FileReader("E:/邮箱/接受邮件/canshu.txt"));
	String mail=in1.readLine();
	in1.close();
	BufferedReader in2 = new BufferedReader(new FileReader("E://邮箱/接受密钥/RSA_priv.dat"));//读密钥
	String pri;
	StringBuffer sb = new StringBuffer(); 
	while ((pri = in2.readLine())!=null) {
		System.out.println(pri);
		sb.append(pri);
	}
	in2.close();
	pri=sb.toString();
	String plainText = RSAUtils1.decrypt(mail, RSAUtils1.getPrivateKey(pri));
	
	BufferedReader in0 = new BufferedReader(new FileReader("E:/邮箱/接受数据/huancun.txt"));
	String zhuangtai=in0.readLine();
	if(Integer.parseInt(zhuangtai)==0){
		String key;
		StringBuffer sb0 = new StringBuffer();
		while ((key = in0.readLine())!=null) {
			sb0.append(key);
		}
		in0.close();
		key=sb0.toString();
		
	int hash=plainText.hashCode();
	String hashcode=String.valueOf(hash);
	
	BufferedReader in3 = new BufferedReader(new FileReader("E://邮箱/签名/qianming.txt"));
	String qianming=in3.readLine();
	in3.close();
	
	String hashcode1=RSAUtils1.encrypt(qianming, 
			RSAUtils1.getPublicKey(key));
	if(hashcode.equals(hashcode1)){
		FileOutputStream out0=new FileOutputStream("E://邮箱/签名/jieguo.txt");//插入
		PrintStream p0=new PrintStream(out0);
		p0.println("0");
		p0.close();
		out0.close();
	}else{
		FileOutputStream out1=new FileOutputStream("E://邮箱/签名/jieguo.txt");//插入
		PrintStream p1=new PrintStream(out1);
		p1.println("1");
		p1.close();
		out1.close();
	}
	}
	if(Integer.parseInt(zhuangtai)==9){
		FileOutputStream out3=new FileOutputStream("E://邮箱/签名/jieguo.txt");//插入
		PrintStream p3=new PrintStream(out3);
		p3.println("9");
		p3.close();
		out3.close();
	}
	
	FileOutputStream out2=new FileOutputStream("E://邮箱/接受邮件/jieguo.txt");//插入
	PrintStream p2=new PrintStream(out2);
	p2.println(plainText);
	p2.close();
	out2.close();
	
	/*BufferedReader in = new BufferedReader(new FileReader("E://邮箱/接受邮件/canshu.txt"));
	String zhanghuming=in.readLine();
	String mailID=in.readLine();
	in.close();
	filemail.receivemail0(zhanghuming, mailID);
	String filename="E:/邮箱/接受邮件/receivemail0.txt";
	socketsend a1=new socketsend(filename);
	//socket从登陆文件夹中将请求发出            0
	//传送结果                                                  1
	
	BufferedReader in1 = new BufferedReader(new FileReader("E:/邮箱/接受数据/huancun.txt"));
	String zhuangtai=in1.readLine();
	if(Integer.parseInt(zhuangtai)==0){
		String jijianren=in1.readLine();
		String zhuti=in1.readLine();
		in1.readLine();
		String mail=in1.readLine();
		in1.close();
		//System.out.println(key);
		BufferedReader in2 = new BufferedReader(new FileReader("E://邮箱/接受密钥/RSA_priv.dat"));//读密钥
		String pri;
		StringBuffer sb = new StringBuffer(); 
		while ((pri = in2.readLine())!=null) {
			System.out.println(pri);
			sb.append(pri);
		}
		in2.close();
		pri=sb.toString();
		String plainText = RSAUtils1.decrypt(mail, RSAUtils1.getPrivateKey(pri)); 
		FileOutputStream out=new FileOutputStream("E://邮箱/接受邮件/jieguo.txt");
		PrintStream p=new PrintStream(out);
		p.println("0");
		p.println(jijianren);
		p.println(zhuti);
		p.close();
		out.close();
		FileOutputStream out1=new FileOutputStream("E://邮箱/接受邮件/mail.txt");
		PrintStream p1=new PrintStream(out1);
		p1.println(plainText);
		p1.close();
		out1.close();
	}
	if(Integer.parseInt(zhuangtai)==1){
		FileOutputStream out=new FileOutputStream("E:/邮箱/接受邮件/jieguo.txt");
		PrintStream p=new PrintStream(out);	
		p.println("1");
		p.close();
		out.close();
		in1.close();
		return;
	}
	if(Integer.parseInt(zhuangtai)==9){
		FileOutputStream out=new FileOutputStream("E:/邮箱/接受邮件/jieguo.txt");
		PrintStream p=new PrintStream(out);	
		p.println("9");
		p.close();
		out.close();
		in1.close();
		return;
	}*/
	}
}
