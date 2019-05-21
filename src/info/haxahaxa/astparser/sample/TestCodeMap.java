
package info.haxahaxa.astparser.sample;

import java.io.File;
import java.util.HashMap;


/**
 * クラス名やフィールド，メソッドの概要を表示するサンプル
 *
 * @author satanabe1
 *
 */
public class TestCodeMap {
	public static void main(String[] args) throws Exception {

		String dir_path = "D:/ryosuke-ku/data_set/Git_20161108/xwiki_xwiki-enterprise";  //検索開始したいフォルダのPath
		String extension = "Test.java";   //検索したいTestファイルの拡張子(今回は"<クラス名+Test>"をテストコードとする)

		String data[];
		data = file_search(dir_path, extension);

		for(int i =0 ;i<data.length; i++) {
			System.out.println(data[i]);
		}


		String data2[];
		data2 = production_code_search(dir_path, extension);


		String data7;
		data7 = file_search3(dir_path, extension);
		System.out.println(data7);

		HashMap<String,String> map = new HashMap<String,String>();

		String[] str1 = new String[10000000];
		String[] str2 = new String[10000000];
		String[] str3 = new String[10000000];
		String[] str4 = new String[10000000];
		String[] str5 = new String[10000000];

		String[] data5 = new String[10000000];

		for(int i=0;i<data.length;i++) {

			str1[i] = data[i].substring(0, 36);
			System.out.println(str1[i]);

			str2[i] = data[i].substring(37-1);
			str3[i] = str2[i].substring(0, str2[i].indexOf("/"));

			str4[i] = data2[i].replace("Test", "");
			System.out.println(str4[i]);

			str5[i] = str1[i] + str3[i];
			System.out.println(str5[i]);

//			String data5[];
//			data5 = file_search3(str5,str4);
//			System.out.println(data5);
//			map.put(data5[i], data[i]);
//
//			FileWriter fw = new FileWriter("Mapping_data.txt",true);
//			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
//			SourceFile sourceFile = new SourceFile(data[i]);
//			pw.println(data5[i] + "," + map.get(data5[i]));
//			System.out.println(data5[i] + "," + map.get(data5[i]));
			String t = "D:/ryosuke-ku/data_set/Git_20161108/vishnun_SHOPAHOLIC";
			String s = "Calculator.java";

			data5 = file_search(t,s);
			System.out.println(data5[i]);
			System.out.println("-------------");
		}






//		String data4[];
//		data4 = production_code_search2(dir_path, extension);

//		 HashMap<String,String> map = new HashMap<String,String>();

//		for(int i=0;i<data.length;i++) {
//
//			String data3 = data2[i].replace("Test", "");
//			map.put(data3, data[i]);

//			String[] data5 = file_search2(data4[i], data3);
//			System.out.println(data5);

//			FileWriter fw = new FileWriter("Mapping_data.txt",true);
//			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
//			SourceFile sourceFile = new SourceFile(data[i]);
//			pw.println(data3 + "," + map.get(data3));
//			System.out.println(data3 + "," + map.get(data3));



//		}


	}


	static String[] FilePath = new String[10000000];
	static int k=0;

	public static String[] file_search(String path, String extension){
		File dir = new File(path);
		File files[] = dir.listFiles();
		for(int i=0; i<files.length; i++){

			String file_name = files[i].getName();
			if(file_name.endsWith(extension)){  //file_nameの最後尾(拡張子)が指定のものならば出力
				FilePath[k] = path+"/"+file_name;
				k++;
			}else if(files[i].isDirectory()){  //ディレクトリなら再帰を行う
				file_search(path+"/"+file_name, extension);
			}
		}
		return FilePath;
	}

	public static String[] file_search2(String path, String extension){
		File dir = new File(path);
		File files[] = dir.listFiles();
		for(int i=0; i<files.length; i++){

			String file_name = files[i].getName();
			if(file_name.endsWith(extension)){  //file_nameの最後尾(拡張子)が指定のものならば出力
				FilePath[k] = path+"/"+file_name;
				k++;
			}else if(files[i].isDirectory()){  //ディレクトリなら再帰を行う
				file_search2(path+"/"+file_name, extension);
			}
		}
		return FilePath;
	}


	static String fp;

	public static String file_search3(String path, String extension){
		File dir = new File(path);
		File files[] = dir.listFiles();
		for(int i=0; i<files.length; i++){

			String file_name = files[i].getName();
			if(file_name.endsWith(extension)){  //file_nameの最後尾(拡張子)が指定のものならば出力
				fp = path+"/"+file_name;

			}else if(files[i].isDirectory()){  //ディレクトリなら再帰を行う
				file_search3(path+"/"+file_name, extension);
			}
		}
		return fp;
	}


	static String[] CodePath = new String[10000000];
	static int t=0;

	public static String[] production_code_search(String path, String extension){
		File dir = new File(path);
		File files[] = dir.listFiles();
		for(int i=0; i<files.length; i++){

			String file_name = files[i].getName();
			if(file_name.endsWith(extension)){  //file_nameの最後尾(拡張子)が指定のものならば出力
				CodePath[t] = file_name;
				t++;
			}else if(files[i].isDirectory()){  //ディレクトリなら再帰を行う
				production_code_search(path+"/"+file_name, extension);
			}
		}
		return CodePath;
	}

	public static String[] production_code_search2(String path, String extension){
		File dir = new File(path);
		File files[] = dir.listFiles();
		for(int i=0; i<files.length; i++){

			String file_name = files[i].getName();
			if(file_name.endsWith(extension)){  //file_nameの最後尾(拡張子)が指定のものならば出力
				CodePath[t] = path+"/"+file_name;
				t++;
			}else if(files[i].isDirectory()){  //ディレクトリなら再帰を行う
				production_code_search2(path+"/"+file_name, extension);
			}
		}
		return CodePath;
	}
}


