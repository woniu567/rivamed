package jsonParse;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


/**
 * <p>标题: CreateFileUtil.java</p>
 * <p>业务描述:区域医疗集成组开发 </p>
 * <p>公司:瑞华康源</p>
 * <p>版权:dhcc2014</p>
 * @author 唐兴平
 * @date 2015年5月22日
 * @version V1.0 
 */
public class FileUtil {

	/**
     * 创建文件
     * 
     */
	 public static boolean createFile(String destFileName) {  
	        File file = new File(destFileName);  
	        if(file.exists()) {  
	            System.out.println("创建单个文件" + destFileName + "失败，目标文件已存在！");  
	            return false;  
	        }  
	        if (destFileName.endsWith(File.separator)) {  
	            System.out.println("创建单个文件" + destFileName + "失败，目标文件不能为目录！");  
	            return false;  
	        }  
	        //判断目标文件所在的目录是否存在  
	        if(!file.getParentFile().exists()) {  
	            //如果目标文件所在的目录不存在，则创建父目录  
	            System.out.println("目标文件所在目录不存在，准备创建它！");  
	            if(!file.getParentFile().mkdirs()) {  
	                System.out.println("创建目标文件所在目录失败！");  
	                return false;  
	            }  
	        }  
	        //创建目标文件  
	        try {  
	            if (file.createNewFile()) {  
	                System.out.println("创建单个文件" + destFileName + "成功！");  
	                return true;  
	            } else {  
	                System.out.println("创建单个文件" + destFileName + "失败！");  
	                return false;  
	            }  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	            System.out.println("创建单个文件" + destFileName + "失败！" + e.getMessage());  
	            return false;  
	        }  
	    }  
	     
	    /**
	     * 创建目录
	     * 
	     */
	    public static boolean createDir(String destDirName) {  
	        File dir = new File(destDirName);  
	        if (dir.exists()) {  
	            System.out.println("创建目录" + destDirName + "失败，目标目录已经存在");  
	            return false;  
	        }  
	        if (!destDirName.endsWith(File.separator)) {  
	            destDirName = destDirName + File.separator;  
	        }  
	        //创建目录  
	        if (dir.mkdirs()) {  
	            System.out.println("创建目录" + destDirName + "成功！");  
	            return true;  
	        } else {  
	            System.out.println("创建目录" + destDirName + "失败！");  
	            return false;  
	        }  
	    }  
	     
	    /**
	     * 创建临时文件
	     * 
	     */
	    public static String createTempFile(String prefix, String suffix, String dirName) {  
	        File tempFile = null;  
	        if (dirName == null) {  
	            try{  
	                //在默认文件夹下创建临时文件  
	                tempFile = File.createTempFile(prefix, suffix);  
	                //返回临时文件的路径  
	                return tempFile.getCanonicalPath();  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	                System.out.println("创建临时文件失败！" + e.getMessage());  
	                return null;  
	            }  
	        } else {  
	            File dir = new File(dirName);  
	            //如果临时文件所在目录不存在，首先创建  
	            if (!dir.exists()) {  
	                if (!FileUtil.createDir(dirName)) {  
	                    System.out.println("创建临时文件失败，不能创建临时文件所在的目录！");  
	                    return null;  
	                }  
	            }  
	            try {  
	                //在指定目录下创建临时文件  
	                tempFile = File.createTempFile(prefix, suffix, dir);  
	                return tempFile.getCanonicalPath();  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	                System.out.println("创建临时文件失败！" + e.getMessage());  
	                return null;  
	            }  
	        }  
	    }
	    
	    /**
	     * 递归删除目录下的所有文件及子目录下所有文件
	     * @param dir 将要删除的文件目录
	     * @return boolean Returns "true" if all deletions were successful.
	     *                 If a deletion fails, the method stops attempting to
	     *                 delete and returns "false".
	     */
	    public static boolean deleteDir(File dir) {
	        if (dir.isDirectory()) {
	            String[] children = dir.list();
	            //递归删除目录中的子目录下
	            for (int i=0; i<children.length; i++) {
	                boolean success = deleteDir(new File(dir, children[i]));
	                if (!success) {
	                    return false;
	                }
	            }
	        }
	        // 目录此时为空，可以删除
	        return dir.delete();
	    }
	    
	    /**
	     * 读取文件内容
	     * 
	     */
	    public static String readFile(String filePath) throws IOException {
	        StringBuffer sb = new StringBuffer();
	        readToBuffer(sb, filePath);
	        return sb.toString();
	    }
	    
	    /**
	     * 将内容写入到文件中（可选追加/覆盖）
	     * @param filePath 文件路径
	     * @param content 文件内容
	     * @param append 追加为true,覆盖为false
	     * @throws IOException 异常
	     * @author txp
	     * @date 2016-11-7
	     */
	    public static void writeFile(String filePath, String content, boolean append) throws IOException {
	    	OutputStreamWriter osr = new OutputStreamWriter(new FileOutputStream(filePath,append), "UTF-8");
 	        BufferedWriter bw= new BufferedWriter(osr);
 	        bw.write(content); // 向文件写内容
 	        bw.close();
 	        osr.close();
	    }
	    
	    /**
	     * 将文本文件中的内容读入到buffer中
	     * @param buffer buffer
	     * @param filePath 文件路径
	     * @throws IOException 异常
	     * @author txp
	     * @date 2016-11-7
	     */
	    public static void readToBuffer(StringBuffer buffer, String filePath) throws IOException {
	        String line; // 用来保存每行读取的内容
	        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "UTF-8");
	    	BufferedReader br= new BufferedReader(isr);
	        line = br.readLine(); // 读取第一行
	        while (line != null) { // 如果 line 为空说明读完了
	            buffer.append(line); // 将读到的内容添加到 buffer 中
	            buffer.append("\n"); // 添加换行符
	            line = br.readLine(); // 读取下一行
	        }
	        br.close();
	        isr.close();
	    }
	    
	    public static byte[] readResourceFromJar(String jarFile, String file) {
			byte[] arr_result = null;
			String jarFileNew = null;
			try {
				if (jarFile.startsWith("file:/")) {
					jarFileNew = jarFile.substring(5);
				}
				ZipFile zipFile = new ZipFile(jarFileNew);
				try {
					ZipEntry zipEntry = zipFile.getEntry(file.replace("!","").replace(jarFile, "").replaceFirst("/", ""));
					if (zipEntry == null) {
						return null;
					}
					BufferedInputStream fin = new BufferedInputStream(zipFile.getInputStream(zipEntry), 8192);
					ByteArrayOutputStream fout = new ByteArrayOutputStream(8192);
					try {
						byte[] data = new byte[8192];
						int count = 0;

						while (count >= 0) {
							count = fin.read(data);
							if (count > 0) {
								fout.write(data, 0, count);
							}
						}
						arr_result = fout.toByteArray();
					} finally {
						fin.close();
						fout.close();
					}
				} finally {
					zipFile.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return arr_result;
		}
	    
		/** 
		* 方法名:          getWebRootPath
		* 方法功能描述:    获取JavaWeb项目根路径
		* 注意事项:   
		* @param:         
		* @return:        String
		* @Author:        wangxien
		* @Create Date:   2018年9月17日 上午11:26:38
		*/
		public static String getWebRootPath(){
			String path = FileUtil.class.getResource("/").getPath();
			path=path.substring(1, path.indexOf("WEB-INF/classes"));
			String[] items=path.split("/");
			StringBuilder root=new StringBuilder();
			int len=items.length-1;
			for(int index=0;index<len;index++) {
				root.append(items[index]);
				if(index!=len-1) {
					root.append("/");	
				}
			}
			return "/"+root.toString();
		}
		
		
		//获取项目平级路径，文件统一放在此路径下
		public static String getFilePath() {
			String path=FileUtil.class.getClassLoader().getResource("application.yml").getPath();
			path=path.substring(0, path.indexOf("classes"));
			File file=new File(path);
			path=file.getParentFile().getParentFile().getPath().replace("file:", "");
			return path+File.separator+"sourceFile";
		}
		
		
		public static String getFilePath(File file) {
			String path=file.getPath().replace("file:", "");
			return path;
		}

}
