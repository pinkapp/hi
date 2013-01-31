package cc.ywxm.excel;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;

import cc.ywxm.utils.BeanRefUtil;

/**
 * 利用开源组件POI3.0.2动态导出EXCEL文档 转载时请保留以下信息，注明出处！
 * 
 * @author leno
 * @version v1.0
 * @param <T>
 *            应用泛型，代表任意一个符合javabean风格的类
 *            注意这里为了简单起见，boolean型的属性xxx的get器方式为getXxx(),而不是isXxx()
 *            byte[]表jpg格式的图片数据
 */
public class ExportExcel<T>
{

	public void exportExcel(Collection<T> dataset, OutputStream out)
	{
		exportExcel("测试POI导出EXCEL文档", null, dataset, out, "yyyy-MM-dd");
	}

	public void exportExcel(String[] headers, Collection<T> dataset,
			OutputStream out)
	{
		exportExcel("测试POI导出EXCEL文档", headers, dataset, out, "yyyy-MM-dd");
	}

	public void exportExcel(String[] headers, Collection<T> dataset,
			OutputStream out, String pattern)
	{
		exportExcel("测试POI导出EXCEL文档", headers, dataset, out, pattern);
	}

	/**
	 * 指定字段导出excel
	 * 
	 * @author HuangDecai
	 * @since 2012-12-25 11:24:41
	 * @param title
	 *            Sheet标题
	 * @param headers
	 *            文档头数组
	 * @param dataset
	 *            数据集合
	 * @param fields
	 *            字段数组
	 * @param out
	 *            输出流
	 * @param datePattern
	 *            日期格式
	 */
	public void exportExcel(String title, String[] headers, Collection<T> dataset,
			String[] fields, OutputStream out, String datePattern)
	{
		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 生成一个表格
		HSSFSheet sheet = workbook.createSheet(title);
		// 设置表格默认列宽度为15个字节
		sheet.setDefaultColumnWidth(15);
		// 生成一个样式
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		// 设置这些样式
		cellStyle.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
		cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		// 生成一个字体
		HSSFFont font = workbook.createFont();
		font.setColor(HSSFColor.VIOLET.index);
		font.setFontHeightInPoints((short) 12);
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		// 把字体应用到当前的样式
		cellStyle.setFont(font);
		// 生成并设置另一个样式
		HSSFCellStyle cellStyle2 = workbook.createCellStyle();
		cellStyle2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
		cellStyle2.setFillPattern(CellStyle.SOLID_FOREGROUND);
		cellStyle2.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle2.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle2.setBorderRight(CellStyle.BORDER_THIN);
		cellStyle2.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle2.setAlignment(CellStyle.ALIGN_CENTER);
		cellStyle2.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		// 生成另一个字体
		HSSFFont font2 = workbook.createFont();
		font2.setBoldweight(Font.BOLDWEIGHT_NORMAL);
		// 把字体应用到当前的样式
		cellStyle2.setFont(font2);

		HSSFFont font3 = workbook.createFont();
		font3.setColor(HSSFColor.BLUE.index);

		// 声明一个画图的顶级管理器
		HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
		// 定义注释的大小和位置,详见文档
		HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0,
				0, 0, 0, (short) 4, 2, (short) 6, 5));
		// 设置注释内容
		// comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
		// 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
		comment.setAuthor("亿网星漫（软件）公司");

		// Iterator<T> it = dataset.iterator();
		HSSFRow row = null;
		int index = 0;
		if (headers != null)
		{
			row = sheet.createRow(0);
			index++;
			for (int i = 0; i < headers.length; i++)
			{
				String header = headers[i];
				if (header != null)
				{
					HSSFCell cell = row.createCell(i);
					cell.setCellStyle(cellStyle);
					HSSFRichTextString text = new HSSFRichTextString(header);
					cell.setCellValue(text);
				}
			}
		}

		for (Iterator<T> iterator = dataset.iterator(); iterator.hasNext();)
		{
			T t = iterator.next();
			row = sheet.createRow(index);
			// 字段-值map
			Map<String, Object> fieldValueMap = BeanRefUtil.getFieldValueMap(t);
			if (fields == null)
			{
				break;
			}
			for (int i = 0; i < fields.length; i++)
			{
				HSSFCell cell = row.createCell(i);
				cell.setCellStyle(cellStyle2);
				Object value = fieldValueMap.get(fields[i]);
				if (value == null)
				{
					continue;
				}
				if (value instanceof Boolean)
				{
					cell.setCellValue((Boolean) value);
				} else if (value instanceof Date)
				{
					SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
					cell.setCellValue(sdf.format((Date) value));
				} else if (value instanceof String)
				{
					cell.setCellValue((String) value);
				} else if (value instanceof Double)
				{
					cell.setCellValue((Double) value);
				} else if (value instanceof Integer)
				{
					cell.setCellValue((Integer) value);
				} else if (value instanceof Short)
				{
					cell.setCellValue((Short) value);
				} else if (value instanceof Long)
				{
					cell.setCellValue((Long) value);
				} else
				{
					cell.setCellValue(value.toString());
				}
			}
			index++;
		}

		try
		{
			workbook.write(out);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 这是一个通用的方法，利用了JAVA的反射机制，可以将放置在JAVA集合中并且符号一定条件的数据以EXCEL 的形式输出到指定IO设备上
	 * 
	 * @param title
	 *            表格标题名
	 * @param headers
	 *            表格属性列名数组
	 * @param dataset
	 *            需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。此方法支持的
	 *            javabean属性的数据类型有基本数据类型及String,Date,byte[](图片数据)
	 * @param out
	 *            与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中
	 * @param pattern
	 *            如果有时间数据，设定输出格式。默认为"yyy-MM-dd"
	 */
	@SuppressWarnings(
	{ "unchecked", "deprecation" })
	public void exportExcel(String title, String[] headers,
			Collection<T> dataset, OutputStream out, String pattern)
	{
		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 生成一个表格
		HSSFSheet sheet = workbook.createSheet(title);
		// 设置表格默认列宽度为15个字节
		sheet.setDefaultColumnWidth((short) 15);
		// 生成一个样式
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		// 设置这些样式
		cellStyle.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
		cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		// 生成一个字体
		HSSFFont font = workbook.createFont();
		font.setColor(HSSFColor.VIOLET.index);
		font.setFontHeightInPoints((short) 12);
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		// 把字体应用到当前的样式
		cellStyle.setFont(font);
		// 生成并设置另一个样式
		HSSFCellStyle cellStyle2 = workbook.createCellStyle();
		cellStyle2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
		cellStyle2.setFillPattern(CellStyle.SOLID_FOREGROUND);
		cellStyle2.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle2.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle2.setBorderRight(CellStyle.BORDER_THIN);
		cellStyle2.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle2.setAlignment(CellStyle.ALIGN_CENTER);
		cellStyle2.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		// 生成另一个字体
		HSSFFont font2 = workbook.createFont();
		font2.setBoldweight(Font.BOLDWEIGHT_NORMAL);
		// 把字体应用到当前的样式
		cellStyle2.setFont(font2);

		HSSFFont font3 = workbook.createFont();
		font3.setColor(HSSFColor.BLUE.index);

		// 声明一个画图的顶级管理器
		HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
		// 定义注释的大小和位置,详见文档
		HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0,
				0, 0, 0, (short) 4, 2, (short) 6, 5));
		// 设置注释内容
		comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
		// 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
		comment.setAuthor("leno");

		// 产生表格标题行
		HSSFRow row = sheet.createRow(0);
		for (short i = 0; i < headers.length; i++)
		{
			HSSFCell cell = row.createCell(i);
			cell.setCellStyle(cellStyle);
			HSSFRichTextString text = new HSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}

		// 遍历集合数据，产生数据行
		Iterator<T> it = dataset.iterator();
		int index = 0;
		while (it.hasNext())
		{
			index++;
			row = sheet.createRow(index);
			T t = it.next();
			// 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
			Field[] fields = t.getClass().getDeclaredFields();
			for (short i = 0; i < fields.length; i++)
			{
				HSSFCell cell = row.createCell(i);
				cell.setCellStyle(cellStyle2);
				Field field = fields[i];
				String fieldName = field.getName();
				String getMethodName = "get"
						+ fieldName.substring(0, 1).toUpperCase()
						+ fieldName.substring(1);
				try
				{
					Class tCls = t.getClass();
					Method getMethod = tCls.getMethod(getMethodName,
							new Class[] {});
					Object value = getMethod.invoke(t, new Object[] {});
					// 判断值的类型后进行强制类型转换
					String textValue = null;
					// if (value instanceof Integer) {
					// int intValue = (Integer) value;
					// cell.setCellValue(intValue);
					// } else if (value instanceof Float) {
					// float fValue = (Float) value;
					// textValue = new HSSFRichTextString(
					// String.valueOf(fValue));
					// cell.setCellValue(textValue);
					// } else if (value instanceof Double) {
					// double dValue = (Double) value;
					// textValue = new HSSFRichTextString(
					// String.valueOf(dValue));
					// cell.setCellValue(textValue);
					// } else if (value instanceof Long) {
					// long longValue = (Long) value;
					// cell.setCellValue(longValue);
					// }
					if (value instanceof Boolean)
					{
						boolean bValue = (Boolean) value;
						textValue = "男";
						if (!bValue)
						{
							textValue = "女";
						}
					} else if (value instanceof Date)
					{
						Date date = (Date) value;
						SimpleDateFormat sdf = new SimpleDateFormat(pattern);
						textValue = sdf.format(date);
					} else if (value instanceof byte[])
					{
						// 有图片时，设置行高为60px;
						row.setHeightInPoints(60);
						// 设置图片所在列宽度为80px,注意这里单位的一个换算
						sheet.setColumnWidth(i, (short) (35.7 * 80));
						// sheet.autoSizeColumn(i);
						byte[] bsValue = (byte[]) value;
						HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0,
								1023, 255, (short) 6, index, (short) 6, index);
						anchor.setAnchorType(2);
						patriarch.createPicture(anchor, workbook.addPicture(
								bsValue, Workbook.PICTURE_TYPE_JPEG));
					} else
					{
						// 其它数据类型都当作字符串简单处理
						if (value != null)
						{
							textValue = value.toString();
						}
					}
					// 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
					if (textValue != null)
					{
						Pattern p = Pattern.compile("^//d+(//.//d+)?$");
						Matcher matcher = p.matcher(textValue);
						if (matcher.matches())
						{
							// 是数字当作double处理
							cell.setCellValue(Double.parseDouble(textValue));
						} else
						{
							HSSFRichTextString richString = new HSSFRichTextString(
									textValue);
							richString.applyFont(font3);
							cell.setCellValue(richString);
						}
					}
				} catch (SecurityException e)
				{
					e.printStackTrace();
				} catch (NoSuchMethodException e)
				{
					e.printStackTrace();
				} catch (IllegalArgumentException e)
				{
					e.printStackTrace();
				} catch (IllegalAccessException e)
				{
					e.printStackTrace();
				} catch (InvocationTargetException e)
				{
					e.printStackTrace();
				} finally
				{
					// 清理资源
				}
			}

		}
		try
		{
			workbook.write(out);
		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}
}