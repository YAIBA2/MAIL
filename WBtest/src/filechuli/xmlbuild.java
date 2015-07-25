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

		  Element root = doc.createElement("�ʼ���Ϣ"); 
		  doc.appendChild(root); // ����Ԫ����ӵ��ĵ��� 

		  // ��ȡѧ����Ϣ 
		  
		   // ����һ��ѧ�� 
		   Element stu = doc.createElement("�ʼ�"); 
		   //stu.setAttribute("�Ա�", s.getSex()); 
		   root.appendChild(stu);// �������   

		   // �����ı������ڵ� 
		   Element name = doc.createElement("�ռ���"); 
		   stu.appendChild(name); 
		   Text tname = doc.createTextNode(sendname); 
		   name.appendChild(tname); 
		   
		   //�����ı�����ڵ� 
		   Element age = doc.createElement("����"); 
		   stu.appendChild(age); // ��age��ӵ�ѧ���ڵ��� 
		   Text tage = doc.createTextNode(topic); 
		   age.appendChild(tage); // ���ı��ڵ����age�ڵ��� 
		   
		 //�����ı�����ڵ� 
		   Element context = doc.createElement("�ʼ�����"); 
		   stu.appendChild(context); // ��age��ӵ�ѧ���ڵ��� 
		   Text tcontext = doc.createTextNode(mail); 
		   context.appendChild(tcontext); // ���ı��ڵ����age�ڵ��� 
		   
		  try { 
		   FileOutputStream fos = new FileOutputStream(outfile); 
		   OutputStreamWriter outwriter = new OutputStreamWriter(fos); 
		   // ((XmlDocument)doc).write(outwriter); //���� 
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

		  Element root = doc.createElement("��Կ��Ϣ"); 
		  doc.appendChild(root); // ����Ԫ����ӵ��ĵ��� 

		  // ��ȡѧ����Ϣ 
		  
		   // ����һ��ѧ�� 
		   Element stu = doc.createElement("mi"); 
		   //stu.setAttribute("�Ա�", s.getSex()); 
		   root.appendChild(stu);// �������   

		   // �����ı������ڵ� 
		   Element name = doc.createElement("����������"); 
		   stu.appendChild(name); 
		   Text tname = doc.createTextNode(sendname); 
		   name.appendChild(tname); 
		   
		   //�����ı�����ڵ� 
		   Element age = doc.createElement("����"); 
		   stu.appendChild(age); // ��age��ӵ�ѧ���ڵ��� 
		   Text tage = doc.createTextNode(topic); 
		   age.appendChild(tage); // ���ı��ڵ����age�ڵ��� 
		   
		 //�����ı�����ڵ� 
		   Element context = doc.createElement("�ʼ�����"); 
		   stu.appendChild(context); // ��age��ӵ�ѧ���ڵ��� 
		   Text tcontext = doc.createTextNode(mail); 
		   context.appendChild(tcontext); // ���ı��ڵ����age�ڵ��� 
		   
		  try { 
		   FileOutputStream fos = new FileOutputStream(outfile); 
		   OutputStreamWriter outwriter = new OutputStreamWriter(fos); 
		   System.out.println(doc);
		   // ((XmlDocument)doc).write(outwriter); //���� 
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
			  String outfile = "E://����/�����ʼ�/mail.xml"; 
			  t.writeXMLFile(outfile,"295948","��׳","dfsdfdsfsdfsdf");  
		}
}
