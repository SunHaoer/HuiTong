package testUrl;

import java.io.File;
import java.net.URL;

import org.junit.Test;

//主要用于测试：编译文件所在的路径
public class TestUrl {

	@Test
	public void test01() {
		//获取db-oracle.properties的编译之后的路径
		URL url = ClassLoader.getSystemClassLoader().getResource("db-oracle.properties");
		//使用File类去描述 该文件
		File file = new File(url.getPath());
		//获取文件的路径信息
		System.out.println("项目运行时的路径"+file.getPath());
		//使用File描述 该文件的上级根目录
		File parentFile = new File(file.getParent());
		//输出上级目录所在的路径
		System.out.println("项目运行时的根目录"+parentFile.getPath());
	}
}
