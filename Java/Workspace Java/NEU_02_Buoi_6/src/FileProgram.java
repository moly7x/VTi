import java.io.IOException;

public class FileProgram {
	public static void main(String[] args) throws IOException {
		String filePath = "C:\\Users\\pc\\Desktop\\BasicInformation1.txt";
//		FileManager fileManager = new FileManager(filePath);
//		System.out.println("is file exists? " + fileManager.checkFileExist());
//		System.out.println(fileManager.renameFile("C:\\Users\\pc\\Desktop\\BasicInformation1.txt"));

		FileIOManager fileIOManager = new FileIOManager();
		// fileIOManager.readFileByInputStream(filePath);

		// fileIOManager.writeFileByOutputStream(filePath, "Noi Dung Can ghi");

		fileIOManager.downloadFile("https://lh3.googleusercontent.com/proxy/HIcmRap4GzuvBiCL-vXMfS9bZ5cZ2Gpfm5_QzhYiz7i-NX3uZ5boYyjjF8YaHgYf3tMrwXk1EB5XMuSH7NaZSu9fjitW95XZmn5h_21IWG2JBdGdyM9Ja5A",
				"C:\\Users\\pc\\Desktop\\");

	}
	
	/**
	 * 
	 */
}
