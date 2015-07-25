package filechuli;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class filemail {
public static void writeaddress(String sendname,String sendaddress) throws IOException{
	FileOutputStream out=new FileOutputStream("E:/” œ‰/Õ®—∂¬º/address.txt",true);
	PrintStream p=new PrintStream(out);
	p.println(sendname+":"+sendaddress);
	p.close();
	out.close();
}
public static StringBuilder readaddress() throws IOException{
	BufferedReader in = new BufferedReader(new FileReader("E:/” œ‰/Õ®—∂¬º/address.txt"));
	String d;
	StringBuilder e=new StringBuilder();
	while ((d=in.readLine())!=null) {
		e.append(d+'\n');
	}
	in.close();
	return e;
}
public static void deleteaddress(String sendname,String sendaddress) throws IOException{
	BufferedReader in = new BufferedReader(new FileReader("E:/” œ‰/Õ®—∂¬º/address.txt"));
	String d;
	List <String> e=new ArrayList<String>();
	while ((d=in.readLine())!=null) {
		e.add(d);
	}
	in.close();
	e.remove(sendname+":"+sendaddress);
	FileOutputStream out=new FileOutputStream("E:/” œ‰/Õ®—∂¬º/address.txt");
	PrintStream p=new PrintStream(out);
	for (int i = 0; i < e.size(); i++) {
	p.println(e.get(i));
	}
	p.close();
	out.close();
}

public static void buildsendmail0(String fajianren,String shoujianren) throws IOException{
	FileOutputStream out=new FileOutputStream("E:/” œ‰/∑¢ÀÕ” º˛/buildsendmail0.txt");
	PrintStream p=new PrintStream(out);
	p.println("5");
	p.println(fajianren);
	p.println(shoujianren);
	p.close();
	out.close();
}

public static void buildsendmail1(String fajianren,String shoujianren,String zhuti,String cipherText,String hashtest) throws IOException{
	FileOutputStream out=new FileOutputStream("E:/” œ‰/∑¢ÀÕ” º˛/buildsendmail1.txt");
	PrintStream p=new PrintStream(out);
	p.println("10");
	p.println(fajianren);
	p.println(shoujianren);
	p.println(zhuti);
	p.println();
	p.println(cipherText);
	p.println(hashtest);
	p.close();
	out.close();
}

public static void loginmail0(String zhanghuming,String mima) throws IOException{
	FileOutputStream out=new FileOutputStream("E:/” œ‰/µ«¬Ω/loginmail0.txt");
	PrintStream p=new PrintStream(out);
	p.println("2");
	p.println(zhanghuming);
	p.println(mima);
	p.close();
	out.close();
}

public static void registermail(String zhanghuming,String mima) throws IOException{
	FileOutputStream out=new FileOutputStream("E:/” œ‰/◊¢≤·/registermail.txt");
	PrintStream p=new PrintStream(out);
	p.println("1");
	p.println(zhanghuming);
	p.println(mima);
	p.close();
	out.close();
}

public static void receivemail0(String zhanghuming,String mailID) throws IOException{
	FileOutputStream out=new FileOutputStream("E:/” œ‰/Ω” ‹” º˛/receivemail0.txt");
	PrintStream p=new PrintStream(out);
	p.println("6");
	p.println(zhanghuming);
	p.println(mailID);
	p.close();
	out.close();
}

	public static void receivemailbox0(String zhanghuming) throws IOException{
		FileOutputStream out=new FileOutputStream("E:/” œ‰/ ’º˛º–/receivemailbox0.txt");
		PrintStream p=new PrintStream(out);
		p.println("4");
		p.println(zhanghuming);
		p.close();
		out.close();
	
}

	public static void deletemail0(String zhanghuming,String mailID) throws IOException{
		FileOutputStream out=new FileOutputStream("E:/” œ‰/” º˛…æ≥˝/deletemail0.txt");
		PrintStream p=new PrintStream(out);
		p.println("8");
		p.println(zhanghuming);
		p.println(mailID);
		p.close();
		out.close();
	
}
}
