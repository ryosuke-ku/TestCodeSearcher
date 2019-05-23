package filenamelistsample;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestCodeMapping{

	public static void main(String[] args) throws IOException{
		String dir_path = "C:\\Users\\ryosuke-ku\\Desktop\\sample_project";  //検索開始したいフォルダのPath
		String extension = "Test.java";   //検索したいTestファイルの拡張子(今回は"<クラス名+Test>"をテストコードとする)
		String slash ="/";

		List<String> data;
		data = file_search(dir_path, extension);

		List<String> data2;
		data2 = file_search2(dir_path, extension);

		List<String> str = new ArrayList<>();
		List<String> str0 = new ArrayList<>();
		List<String> str1 = new ArrayList<>();
		List<String> str2 = new ArrayList<>();
		List<String> str3 = new ArrayList<>();
		List<String> data3 = new ArrayList<>();
		List<String> data4 = new ArrayList<>();
		List<String> data5 = new ArrayList<>();

		for(int i =0 ;i<data.size(); i++){

			str0.add(data.get(i).substring(0, 36)); //D:/ryosuke-ku/data_set/Git_20161108
			str1.add(data.get(i).substring(37-1));  //xwiki_xwiki-enterprise/xwiki-enterprise/xwiki-enterprise-test/xwiki-enterprise-test-ui/src/test/it/org/xwiki/test/ui/PreviewTest.java
			str2.add(str1.get(i).substring(0, str1.get(i).indexOf("/"))); //xwiki_xwiki-enterprise

			str.add(str0.get(i) + str2.get(i)); //D:/ryosuke-ku/data_set/Git_20161108/xwiki_xwiki-enterprise
			str3.add(data2.get(i).replace("Test", "")); //Preview.java
//			System.out.println(str.get(i));
			System.out.println(str3.get(i));

			data3.add(file_search3(str.get(i),str3.get(i)));
//			System.out.println(data3.get(i));
			System.out.println(data3.get(i).length());

			data4.add(data3.get(i).substring(data3.get(i).lastIndexOf("/"),data3.get(i).length()));
			System.out.println(data4.get(i));
//			System.out.println(data4.get(i).length());

			data5.add(data.get(i).substring(data.get(i).lastIndexOf("/"),data.get(i).length()).replace("Test", ""));
			System.out.println(data5.get(i));
//			System.out.println(data5.get(i).length());

			if(data4.get(i).equals(data5.get(i))){
				System.out.println(data3.get(i) + "," + data.get(i));
			}else{
				System.out.println("等しくない");
			}
//			System.out.println(data3.get(i) + "," + data.get(i));

		}

	}

	static List<String> testpath = new ArrayList<>();
	public static List<String> file_search(String path, String extension){

		File dir = new File(path);
		File files[] = dir.listFiles();

		for(int i=0; i<files.length; i++){

			String file_name = files[i].getName();
			if(file_name.endsWith(extension)){  //file_nameの最後尾(拡張子)が指定のものならば出力
				testpath.add(path+"/"+file_name);
			}else if(files[i].isDirectory()){  //ディレクトリなら再帰を行う
				file_search(path+"/"+file_name, extension);
			}
		}
		return testpath;
	}


	static List<String> codepath = new ArrayList<>();
	public static List<String> file_search2(String path, String extension){

		File dir2 = new File(path);
		File files2[] = dir2.listFiles();

		for(int i=0; i<files2.length; i++){

			String file_name = files2[i].getName();
			if(file_name.endsWith(extension)){  //file_nameの最後尾(拡張子)が指定のものならば出力
				codepath.add(file_name);
			}else if(files2[i].isDirectory()){  //ディレクトリなら再帰を行う
				file_search2(path+"/"+file_name, extension);
			}
		}
		return codepath;
	}


//	static String testpath3;
	public static String file_search3(String path3, String extension3){
		String testpath3=null;
		File dir = new File(path3);
		File files3[] = dir.listFiles();
		for(int i=0; i<files3.length; i++){

			String file_name = files3[i].getName();
			if(file_name.endsWith(extension3)){  //file_nameの最後尾(拡張子)が指定のものならば出力
				testpath3 = path3+"/"+file_name;
//				System.out.println("tespath3:"+testpath3);
				return testpath3;
			}else if(files3[i].isDirectory()){  //ディレクトリなら再帰を行う
				testpath3 = file_search3(path3+"/"+file_name, extension3);
				if(testpath3!=null) return testpath3;
			}
		}
		return testpath3;
	}
}


