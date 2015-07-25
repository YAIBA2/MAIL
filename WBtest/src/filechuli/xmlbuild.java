package filechuli;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
public class xmlbuild {
	public static void writeXMLFile(String outfile,String sendname,String topic,String mail) { 
		  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); 
		  DocumentBuilder builder = null; 
		  try { 
		   builder = dbf.newDocumentBuilder(); 
		  } catch (Exception e) { 
		  } 
		  Document doc = builder.newDocument(); 

		  Element root = doc.createElement("邮件信息"); 
		  doc.appendChild(root); // 将根元素添加到文档上 

		  // 获取学生信息 
		  
		   // 创建一个学生 
		   Element stu = doc.createElement("邮件"); 
		   //stu.setAttribute("性别", s.getSex()); 
		   root.appendChild(stu);// 添加属性   

		   // 创建文本姓名节点 
		   Element name = doc.createElement("收件人"); 
		   stu.appendChild(name); 
		   Text tname = doc.createTextNode(sendname); 
		   name.appendChild(tname); 
		   
		   //创建文本年龄节点 
		   Element age = doc.createElement("主题"); 
		   stu.appendChild(age); // 将age添加到学生节点上 
		   Text tage = doc.createTextNode(topic); 
		   age.appendChild(tage); // 将文本节点放在age节点上 
		   
		 //创建文本年龄节点 
		   Element context = doc.createElement("邮件内容"); 
		   stu.appendChild(context); // 将age添加到学生节点上 
		   Text tcontext = doc.createTextNode(mail); 
		   context.appendChild(tcontext); // 将文本节点放在age节点上 
		   
		  try { 
		   FileOutputStream fos = new FileOutputStream(outfile); 
		   OutputStreamWriter outwriter = new OutputStreamWriter(fos); 
		   // ((XmlDocument)doc).write(outwriter); //出错！ 
		   callWriteXmlFile(doc, outwriter, "gb2312"); 
		   outwriter.close(); 
		   fos.close(); 
		  } catch (Exception e) { 
		   e.printStackTrace();
		  } 
	}
		  
	/*private void writeXMLFilekey(String outfile,String RSAfilename) { 
		  
		  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); 
		  DocumentBuilder builder = null; 
		  try { 
		   builder = dbf.newDocumentBuilder(); 
		  } catch (Exception e) { 
		  } 
		  Document doc = builder.newDocument(); 

		  Element root = doc.createElement("密钥信息"); 
		  doc.appendChild(root); // 将根元素添加到文档上 

		  // 获取学生信息 
		  
		   // 创建一个学生 
		   Element stu = doc.createElement("mi"); 
		   //stu.setAttribute("性别", s.getSex()); 
		   root.appendChild(stu);// 添加属性   

		   // 创建文本姓名节点 
		   Element name = doc.createElement("发件人姓名"); 
		   stu.appendChild(name); 
		   Text tname = doc.createTextNode(sendname); 
		   name.appendChild(tname); 
		   
		   //创建文本年龄节点 
		   Element age = doc.createElement("主题"); 
		   stu.appendChild(age); // 将age添加到学生节点上 
		   Text tage = doc.createTextNode(topic); 
		   age.appendChild(tage); // 将文本节点放在age节点上 
		   
		 //创建文本年龄节点 
		   Element context = doc.createElement("邮件内容"); 
		   stu.appendChild(context); // 将age添加到学生节点上 
		   Text tcontext = doc.createTextNode(mail); 
		   context.appendChild(tcontext); // 将文本节点放在age节点上 
		   
		  try { 
		   FileOutputStream fos = new FileOutputStream(outfile); 
		   OutputStreamWriter outwriter = new OutputStreamWriter(fos); 
		   System.out.println(doc);
		   // ((XmlDocument)doc).write(outwriter); //出错！ 
		   callWriteXmlFile(doc, outwriter, "gb2312"); 
		   outwriter.close(); 
		   fos.close(); 
		  } catch (Exception e) { 
		   e.printStackTrace();
		  } 
	}*/
	
		  public static void callWriteXmlFile(Document doc, Writer w, String encoding) { 
			  try { 
			   Source source = new DOMSource(doc); 

			   Result result = new StreamResult(w); 

			   Transformer xformer = TransformerFactory.newInstance() 
			     .newTransformer(); 
			   xformer.setOutputProperty(OutputKeys.ENCODING, encoding); 
			   xformer.transform(source, result); 

			  } catch (TransformerConfigurationException e) { 
			   e.printStackTrace(); 
			  } catch (TransformerException e) { 
			   e.printStackTrace(); 
			  } 
			} 
		  public static void main(String args[]) { 
			  xmlbuild t = new xmlbuild(); 
			  String outfile = "E://邮箱/发送邮件/mail.xml"; 
			  t.writeXMLFile(outfile,"295948","马壮","dfsdfdsfsdfsdf");  
		}
}
