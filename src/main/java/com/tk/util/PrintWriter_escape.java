package com.tk.util;

import java.io.PrintWriter;
import java.io.Writer;

/**
 * 
 * @类功能说明：加密传送
 * @类修改者：panda
 * @修改日期：
 * @修改说明：
 * @公司名称：深圳市穗鑫网络购物有限公司
 * @作者：panda
 * @创建时间：2015-3-23 下午9:00:36
 * @版本：V1.0
 */

public class PrintWriter_escape extends PrintWriter {
	
	public PrintWriter_escape(Writer psOut)
	{
		super(psOut);
	}
	/**
	 * SomeApp.escape加密发送
	 * 
	 * @param s
	 */
	public void write(String s)
	{
//		super.write(SomeTool.escape(s));
		super.write(s);
	}

}
