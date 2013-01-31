package cc.ywxm.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;

public class FileUtils
{
	private static Logger log = Logger.getLogger(FileUtils.class);

	/**
	 * 删除文件
	 * 
	 * @param filePath
	 * @return
	 */
	public static Boolean removeFile(String filePath)
	{

		File f = new File(filePath);
		if (f.exists())
		{
			boolean b = f.delete();
			if (b == true)
			{
				if (log.isDebugEnabled())
				{
					log.debug(filePath + "删除成功");
				}
			} else
			{
				if (log.isDebugEnabled())
				{
					log.debug(filePath + "删除失败");
				}
			}
			return b;

		}
		return false;
	}

	/**
	 * 拷贝文件
	 * 
	 * @param sourcePath
	 * @param descPath
	 * @return
	 */
	public static Boolean coppyFile(String sourcePath, String descPath)
	{
		Boolean flag = false;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try
		{
			// 创建源文件路径【sourcePath】
			// 【从源文件中读取数据的数据流 fis】
			fis = new FileInputStream(sourcePath);
		} catch (FileNotFoundException e)
		{
			if (log.isDebugEnabled())
			{
				log.debug("系统找不到源文件，请确认以下路径是否正确： " + sourcePath);
			}
			e.printStackTrace();
			return flag;
		}
		File file = new File(descPath);
		if (!file.exists())
		{// 如果目标路径不存在
			createFiles(descPath);
		}
		try
		{// 创建目录文件【descPath】
			// 【写入目标文件中的数据流 fos】
			fos = new FileOutputStream(file);
		} catch (FileNotFoundException e)
		{
			if (log.isDebugEnabled())
			{
				log.debug("目标文件创建失败：" + descPath);
			}
			return flag;
		}
		int c = 0;
		byte buffer[] = new byte[1024];
		try
		{
			while ((c = fis.read(buffer)) != -1)
			{
				fos.write(buffer);
			}
			flag = true;
			if (log.isDebugEnabled())
			{
				log.debug("恭喜你!文件拷贝成");
			}
		} catch (IOException e)
		{
			if (log.isDebugEnabled())
			{
				log.debug("文件写入失败：" + e.getLocalizedMessage());
			}
			return flag;
		}
		// 关闭输入输出流
		try
		{
			fos.close();
			fis.close();
		} catch (IOException e)
		{
			if (log.isDebugEnabled())
			{
				log.debug("关闭输入输出流: " + e.getLocalizedMessage());
			}
			return flag;
		}
		return flag;
	}

	/**
	 * 拷贝文件
	 * 
	 * @param sourcePath
	 * @param descPath
	 * @return
	 */
	public static Boolean coppyFile(File sourceFile, String descPath)
	{
		Boolean flag = false;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try
		{
			// 创建源文件路径【sourcePath】
			// 【从源文件中读取数据的数据流 fis】
			fis = new FileInputStream(sourceFile);
		} catch (FileNotFoundException e)
		{
			if (log.isDebugEnabled())
			{
				log.debug("系统找不到源文件，请确认以下路径是否正确： "
						+ sourceFile.getAbsolutePath());
			}
			e.printStackTrace();
			return flag;
		}
		File file = new File(descPath);
		if (!file.exists())
		{// 如果目标路径不存在
			createFiles(descPath);
		}
		try
		{
			// 创建目录文件【descPath】
			// 【写入目标文件中的数据流 fos】
			fos = new FileOutputStream(file);
		} catch (FileNotFoundException e)
		{
			if (log.isDebugEnabled())
			{
				log.debug("目标文件创建失败：" + descPath);
			}
			return flag;
		}
		int c = 0;
		byte buffer[] = new byte[1024];
		try
		{
			while ((c = fis.read(buffer)) != -1)
			{
				fos.write(buffer);
			}
			flag = true;
			if (log.isDebugEnabled())
			{
				log.debug("恭喜你!文件拷贝成");
			}
		} catch (IOException e)
		{
			if (log.isDebugEnabled())
			{
				log.debug("文件写入失败：" + e.getLocalizedMessage());
			}
			return flag;
		}
		// 关闭输入输出流
		try
		{
			fos.close();
			fis.close();
		} catch (IOException e)
		{
			if (log.isDebugEnabled())
			{
				log.debug("关闭输入输出流: " + e.getLocalizedMessage());
			}
			return flag;
		}
		return flag;
	}

	/**
	 * 非根路径中创建文件，即多层文件夹是 前提是: path必须一个正确的路径 拷贝单个文件
	 * 
	 * @param path文件
	 */
	public static Boolean createFiles(String path)
	{
		Boolean flag = false;
		File file = null;
		if (!path.equals("") || path != null)
		{
			file = new File(path);
			if (!file.exists())
			{
				// 创建目录
				File fileDir = new File(file.getParent());
				fileDir.mkdirs();
				if (log.isDebugEnabled())
				{
					log.debug("上层文件夹： " + fileDir);
				}
				try
				{
					flag = file.createNewFile();// 在已有文件路径上直接创建文件
					if (log.isDebugEnabled())
					{
						log.debug("文件名称：" + file);
					}
				} catch (IOException e)
				{
					if (log.isDebugEnabled())
					{
						log.debug("创建文件失败：" + e.getLocalizedMessage());
					}
					e.printStackTrace();
				}
			} else
			{
				if (log.isDebugEnabled())
				{
					log.debug("【" + path + "】：" + "该文件已经存在");
				}
			}
		}
		return flag;
	}

	/**
	 * 拷贝整个文件夹下的文件
	 * 
	 * @param sourcePath
	 * @param descPath
	 * @return
	 */
	public static Boolean coppyAllFile(String sourcePath, String descPath)
	{
		Boolean flag = false;
		// 创建源文件夹文件对象
		File fileSource = new File(sourcePath);
		if (fileSource.isDirectory())
		{// 如果源文件家对象是一个目录
			// 创建目标
			File file = new File(descPath);
			if (!file.exists())
			{// 如果目标路径不存在
				createAllFiles(descPath);
			}
			// 得到源文件的所有文件
			File[] files = fileSource.listFiles();
			for (File file2 : files)
			{
				coppyAllFile(file2.toString(), descPath + "/" + file2.getName());
			}
		} else
		{
			coppyFile(sourcePath, descPath);
		}
		return flag;
	}

	/**
	 * 非根路径中创建文件，即多层文件夹是 前提是: path必须一个正确的路径 拷贝整个文件
	 * 
	 * @param path文件
	 */
	public static Boolean createAllFiles(String path)
	{
		Boolean flag = false;
		File file = null;
		if (!path.equals("") || path != null)
		{
			file = new File(path);
			if (!file.exists())
			{
				// 创建目录
				File fileDir = new File(file.getParent());
				fileDir.mkdirs();
				// System.out.println("上层文件夹： " + fileDir);
			} else
			{
				if (log.isDebugEnabled())
				{
					log.debug("【" + path + "】：" + "该文件已经存在");
				}
			}
		}
		return flag;
	}

	/**
	 * 替换掉文件路径中的正斜杠
	 * 
	 * @param path
	 * @return
	 */
	public String conversPath(String path)
	{
		return path.replace("\\", "/");
	}

	public static void copyFile(String src, String dest)
	{
		// 创建源文件输入流对象
		FileInputStream in = null;
		try
		{
			in = new FileInputStream(src);
		} catch (FileNotFoundException e)
		{
			if (log.isDebugEnabled())
			{
				log.debug("源文件不存在，请确认：" + e.getLocalizedMessage());
			}
		}
		// 创建目标文件
		File file = new File(dest);
		// 如果该文件不存在，则必须创建该文件
		if (!file.exists())
		{
			try
			{
				file.createNewFile();
				if (log.isDebugEnabled())
				{
					log.debug("文件创建成功：" + file.getPath());
				}
			} catch (IOException e)
			{
				if (log.isDebugEnabled())
				{
					log.debug("创建文件失败：" + e.getLocalizedMessage());
				}
			}
		}
		// 创建文件输出流对象
		FileOutputStream out = null;
		try
		{
			out = new FileOutputStream(file);
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		int c;
		byte buffer[] = new byte[1024];
		try
		{
			while ((c = in.read(buffer)) != -1)
			{
				for (int i = 0; i < c; i++)
				{
					out.write(buffer[i]);
				}
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		try
		{
			in.close();
			out.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}