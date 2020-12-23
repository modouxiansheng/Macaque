package classloader;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class StandardExecutorClassLoader extends URLClassLoader {
    private final static String baseDir = System.getProperty("user.dir") + File.separator + "ext" + File.separator;
    
    public StandardExecutorClassLoader(String name) {
    	super(new URL[] {}, null); // 将 Parent 设置为 null
    	
    	loadResource(name);
    }
    
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
    	// 测试时可打印看一下
//    	System.out.println("Class loader: " + name);
    
    	return super.loadClass(name);
    }
    
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            return super.findClass(name);
        } catch(ClassNotFoundException e) {
            return StandardExecutorClassLoader.class.getClassLoader().loadClass(name);
        }
    }
    
    private void loadResource(String name) {
    	String jarPath = name;
    	
    	// 加载对应版本目录下的 Jar 包
    	tryLoadJarInDir(jarPath);
    	// 加载对应版本目录下的 lib 目录下的 Jar 包
    	tryLoadJarInDir(name);
    }
    
    private void tryLoadJarInDir(String name) {
    	File file = new File(name);
		this.addURL(file);
    }
    
    private void addURL(File file) {
    	try {
    		super.addURL(new URL("file", null, file.getCanonicalPath()));
    	} catch (MalformedURLException e) {
    		e.printStackTrace();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }

}