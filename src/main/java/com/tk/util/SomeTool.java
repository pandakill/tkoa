package com.tk.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import com.tk.util.PrintWriter_escape;

import com.alibaba.fastjson.JSON;

/**
 * @类说明 一些通用工具的封装
 * @创建者 panda
 * @创建时间 2015年7月5日
 * @修改者 
 * @修改时间 
 */
public class SomeTool {
	
	/**
	 * n位随机数
	 * 
	 * @param n
	 *            随机数的位数
	 * @return n位随机数
	 */
	public static int rand(int n)
	{
		// n位随机数
		int max = 1;
		for (int i = 0; i < n; i++)
		{
			max *= 10;
		}
		int t;
		do
		{
			t = (int) Math.ceil(Math.random() * max);
		} while (!(t >= max / 10 - 1 && t <= max - 1));
		return t;
	}

	/**
	 * 对应javascript的escape()函数, 加码后的串可直接使用javascript的unescape()进行解码
	 * 
	 * @param src
	 * @return
	 */
	public static String escape(String src)
	{
		int i;
		char j;
		StringBuffer tmp = new StringBuffer();
		tmp.ensureCapacity(src.length() * 6);
		for (i = 0; i < src.length(); i++)
		{
			j = src.charAt(i);
			if (Character.isDigit(j) || Character.isLowerCase(j)
					|| Character.isUpperCase(j))
				tmp.append(j);
			else if (j < 256)
			{
				tmp.append("%");
				if (j < 16)
					tmp.append("0");
				tmp.append(Integer.toString(j, 16));
			}
			else
			{
				tmp.append("%u");
				tmp.append(Integer.toString(j, 16));
			}
		}
		return tmp.toString();
	}

	/**
	 * 对应javascript的unescape()函数, 可对javascript的escape()进行解码
	 * 
	 * @param src
	 * @return
	 */
	public static String unescape(String src)
	{
		StringBuffer tmp = new StringBuffer();
		tmp.ensureCapacity(src.length());
		int lastPos = 0, pos = 0;
		char ch;
		while (lastPos < src.length())
		{
			pos = src.indexOf("%", lastPos);
			if (pos == lastPos)
			{
				if (src.charAt(pos + 1) == 'u')
				{
					ch = (char) Integer.parseInt(
							src.substring(pos + 2, pos + 6), 16);
					tmp.append(ch);
					lastPos = pos + 6;
				}
				else
				{
					ch = (char) Integer.parseInt(
							src.substring(pos + 1, pos + 3), 16);
					tmp.append(ch);
					lastPos = pos + 3;
				}
			}
			else
			{
				if (pos == -1)
				{
					tmp.append(src.substring(lastPos));
					lastPos = src.length();
				}
				else
				{
					tmp.append(src.substring(lastPos, pos));
					lastPos = pos;
				}
			}
		}
		return tmp.toString();
	}

	/**
	 * 获取网页-Post方式_返回utf8格式
	 * 
	 * @param u
	 *            服务地址url
	 * @param keyvalue
	 *            向服务端发送key = value对
	 * @return 获取网页Html
	 * @throws Exception
	 */
	public static String doPostGetHtml(String u, String keyvalue)
			throws Exception
	{
		// 服务地址
		URL url = new URL(u);

		// 设定连接的相关参数
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		OutputStreamWriter out = new OutputStreamWriter(
				connection.getOutputStream(), "UTF-8");

		// 向服务端发送key = value对
		out.write(keyvalue);

		out.flush();
		out.close();

		// 获取服务端的反馈
		String strLine = "";
		String strResponse = "";
		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		while ((strLine = reader.readLine()) != null)
		{
			strResponse += strLine + "\n";
		}

		strResponse = new String(strResponse.getBytes(), "UTF-8");
		// strResponse = new String(strResponse.getBytes(), "utf-8");
		strResponse = replaceBlank(strResponse);
		// System.out.println(strResponse);
		return strResponse;
	}

	/**
	 * 获取加密网页-Post方式_返回utf8格式
	 * 
	 * @param u
	 *            服务地址url
	 * @param keyvalue
	 *            向服务端发送key = value对
	 * @return 解密网页Html
	 * @throws Exception
	 */
	public static String doPostGetHtml_unescape(String u, String keyvalue)
			throws Exception
	{
		return unescape(doPostGetHtml(u, keyvalue));
	}

	/**
	 * 获取网页-Get方式-返回utf8格式
	 * 
	 * @param u
	 *            服务地址url
	 * @param keyvalue
	 *            向服务端发送key = value对
	 * @return 获取网页Html
	 * @throws Exception
	 */
	public static String doGetGetHtml(String u, String key)
			throws UnsupportedEncodingException, IOException
	{
		String u2 = u;
		if (null != key)
		{
			u2 = u2 + "?" + key;
		}
		// 取得资源对象
		URL url = new URL(u2);
		// 生成连接对象
		URLConnection uc = url.openConnection();
		uc.setDoOutput(true);
		// 发出连接
		uc.connect();
		String temp;
		final StringBuffer sb = new StringBuffer();
		final BufferedReader in = new BufferedReader(new InputStreamReader(
				url.openStream(), "utf8"));
		while ((temp = in.readLine()) != null)
		{
			sb.append(temp);
		}
		in.close();
		// System.out.println(sb);
		return String.valueOf(sb);
	}

	/**
	 * 去除一些制表符<br/>
	 * \\s*|\t|\r|\n
	 * 
	 * @param str
	 * @return
	 */
	public static String replaceBlank(String str)
	{
		String dest = "";

		if (str != null)
		{
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}

	/**
	 * 从一个JSON得到一个List,<br/>
	 * 该List对象的size若不为空，<br/>
	 * 则有一个Java对象在该List中.<br/>
	 * JSON字符串格式缺"[]"
	 * 
	 * @param <T>
	 * 
	 * @param jsonString
	 *            String
	 * @param clazz
	 *            Class
	 * @return
	 */
	public static List getJsonToObject(String jsonString, Class clazz)
	{
		List list = new ArrayList();
		try
		{
			list = (List) JSON.parseArray("[" + jsonString + "]", clazz);
		} catch (Exception e)
		{
		}

		return list;
	}

	/**
	 * 从一个JSON得到一个List,<br/>
	 * 该List对象的size若不为空，<br/>
	 * 则有Java对象组在该List中.<br/>
	 * JSON字符串格式正常
	 * 
	 * @param jsonString
	 *            String
	 * @param clazz
	 *            Class
	 * @return
	 */
	public static List getJsonToObjectArray(String jsonString, Class clazz)
	{
		List list = new ArrayList();
		try
		{
			list = JSON.parseArray(jsonString, clazz);
		} catch (Exception e)
		{
		}

		return list;
	}

	/**
	 * out_print 同servlet的方式out.print<br/>
	 * 但有16进制加密打印
	 * 
	 * @param str
	 *            String,要打印的字符串
	 */
	public static void out_print(String str)
	{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		PrintWriter_escape out;
		try
		{
			out = new PrintWriter_escape(response.getWriter());
			// String json = JSON.toJSONString(objeact);
			out.write(str);
			out.flush();
			out.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 获取系统时间
	 * 
	 * @return 2015年03月20日 00:00:00
	 */
	public static String getDateCN()
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
		String date = format.format(new Date(System.currentTimeMillis()));
		return date;
	}

	/**
	 * 获取系统时间
	 * 
	 * @return 2015-03-20 00:00:00
	 */
	public static String getDateEN()
	{
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1 = format1.format(new Date(System.currentTimeMillis()));
		return date1;
	}
	
	public static boolean writeFile( String fileName, String content ){
		try{
			File file = new File( fileName );
			
			if( !file.exists() ){
				file.createNewFile();
			}
			
//			FileWriter fileWriter = new FileWriter( file.getName(), true );
//			BufferedWriter bufferedWriter = new BufferedWriter( fileWriter );
//			bufferedWriter.newLine();
//			bufferedWriter.write( content );
//			bufferedWriter.close();
			FileOutputStream fileOutputStream = new FileOutputStream(fileName,true);
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter( fileOutputStream, "UTF-8" );
			outputStreamWriter.write(content);
			outputStreamWriter.close();
			
			return true;
			
		}catch (Exception e) {
			System.out.println( "SomeTool -> writeFile -> catch:" + e );
			return false;
		}finally{
		}
	}
	
	/**
	 * @方法说明 传入2015-05-04日期格式,将其分割成年月日的int数组
	 * @创建者 panda
	 * @创建日期 2015年7月11日 上午12:22:46
	 * @修改者 
	 * @修改时间 
	 * @return int[]
	 */
	public static int[] spiltDate(String date,String type){
        String[] stringArray = date.split(type);
        int[] dateArray = new int[3];
        for (int i = 0; i < stringArray.length; i++) {
        	dateArray[i] = Integer.parseInt(stringArray[i]);
        }
		return dateArray;
	}
	
}
