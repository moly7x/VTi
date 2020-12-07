package assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Assignment2 {
	
	// box mark
	static final String topleft = "*";
    static final String topright = "*";
    static final String horizontal = "*";
    static final String vertical = "*";
    static final String botleft = "*";
    static final String botright = "*";
	
	static List<Product> products = new ArrayList<Product>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
        while (true) {
            int choice = createMainMenu(scanner);

            switch (choice) {
                case 1:
                	addProduct(scanner);
                    break;
                case 2:
                	displayProduct(products);
                    break;
                case 3:
                	deleteProduct(scanner);
                    break;
                case 4:
                	searchProduct(scanner);
                    break;
                case 5:
                	sortProduct();
                    break;
                case 6:
                	saveFile(scanner);
                    break;
                case 7:
                	readFile(scanner);
                    break;
                case 8:
                	scanner.close();
                    System.exit(0);
                    break;
            }
        }
	}
	
	//add new product to list
	static void addProduct(Scanner scanner) {
		// Add new product to list
		products.add(new Product(scanner));

		// If this is first item then id = 1 else id = lastID + 1
		if (products.size() == 1) {
			products.get(products.size() - 1).id = products.size();
		} else {
			products.get(products.size() - 1).id = products.get(products.size() - 2).id + 1;
		}
	}
	
	//print table of product
	static void displayProduct(List<Product> result) {
		// Print header
		System.out.printf(String.format("\n%45s\n", " ").replace(" ", "-"));
		System.out.printf("|%-5s|%-17s|%-10s|%-8s|\n", "Id", "Product name", "Price", "Quantity");

		// Print element
		for (int i = 0; i < result.size(); ++i) {
			System.out.printf(String.format("%45s\n", " ").replace(" ", "-"));
			System.out.printf("|%-5s|%-17s|%-10.2f|%-8d|\n", result.get(i).id, result.get(i).name, result.get(i).price,
					result.get(i).quantity);
		}
	}
	
	//delete product of list
	static void deleteProduct(Scanner scanner) {
		// Display proudut before delete
		displayProduct(products);
		// Get id product wanna delete
		System.out.print("\nId of product you wanna delete: ");
		int id = readInt(scanner, "Input must be Integer!! Try again\nId of product you wanna delete: ");

		// remove element has that id
		boolean check = false;
		int i = 0;
		while (i < products.size()) {
			if (products.get(i).id == id) {
				products.remove(i);
				check = true;
			} else {
				++i;
			}
		}

		// If delete at least 1 element say success else say fail
		if (check) {
			System.out.printf("\nDELETE SUCCESSFULLY!!");
			displayProduct(products);
		} else {
			System.out.printf("\nCan't find that id!! Can't delete!\n");
		}
	}
	
	//search product
	static void searchProduct(Scanner scanner) {
		List<Product> result = new ArrayList<Product>();

		// Get keyword
		System.out.printf("\nInput keyword to find: ");
		String keyWord = scanner.nextLine();

		// If found product add it to result list
		for (int i = 0; i < products.size(); ++i) {
			if (products.get(i).name.contains(keyWord)) {
				result.add(products.get(i));
			}
		}

		// If list size = 0 return can't find
		if (result.size() != 0) {
			displayProduct(result);
		} else {
			System.out.println("Can't find that product!!");
		}
	}
	
	//save product to file
	static void saveFile(Scanner scanner) {
		// get folder link
		String folder = getFolder(scanner);

		// get link to file
		File file = processFile(scanner, folder, true, "Name file to save: ", "\nThis file name has already exits! Do you want to override it?\n1- Yes\n2- No\nYour choice: ");

		try {
			//create new file
			file.createNewFile();
			PrintWriter printWriter = new PrintWriter(file.getAbsoluteFile());

			// save to file
			for (int i = 0; i < products.size(); ++i) {
				printWriter.printf("%d\n", products.get(i).id);
				printWriter.printf("%s\n", products.get(i).name);
				printWriter.printf("%.2f\n", products.get(i).price);
				printWriter.printf("%d\n", products.get(i).quantity);
			}
			printWriter.close();
			System.out.printf("File has been Saved.\n");
		} catch (IOException ex) {
			System.out.println("An error occurred.");
		}
	}
	
	//read product from save file
	static void readFile(Scanner scanner) {
		System.out.print("\nThis action will delete all product you are working. Are you sure?\n");
		System.out.println("1- Yes");
		System.out.println("2- No");
		System.out.print("Your choice: ");
		int temp = getChoice(scanner, 2);
		// if choice = 2 return to menu
		if (temp == 2) {
			return;
		}

		// get folder link
		String folder = getFolder(scanner);

		// get link to file
		File file = processFile(scanner, folder, false, "Name file to open: ",
				"This file name has not been exits. Try again!\nName file to open: ");

		try {
			Scanner scanFile = new Scanner(file);

			// empty list
			products.clear();
			// temps product
			Product temps;
			// open file
			while (scanFile.hasNextLine()) {
				temps = new Product(scanFile.nextInt());
				scanFile.nextLine();
				temps.name = scanFile.nextLine();
				temps.price = scanFile.nextFloat();
				scanFile.nextLine();
				temps.quantity = scanFile.nextInt();
				scanFile.nextLine();
				products.add(temps);
			}
			scanFile.close();
			// display
			System.out.println();
			System.out.println("Loaded file.");
			displayProduct(products);
		} catch (IOException ex) {
			System.out.println("An error occurred.");
		}
	}

	// file utility
	// check file Directory exits or not
	static boolean isFileDirectoryExists(File file) {
		if (file.exists()) {
			return true;
		}
		return false;
	}
	
	//get folder to save or open file
	static String getFolder(Scanner scanner) {
		System.out.print("\nFolder to open: ");
		String folder = scanner.nextLine();

		File file = new File(folder);

		while (!isFileDirectoryExists(file)) {
			System.out.println("This directory is not Exists. Try again!");
			System.out.print("Folder to open: ");
			folder = scanner.nextLine();
			file = new File(folder);
		}

		return folder;
	}
	
	//return File to save if isSaveFile = true or File to open if isSaveFile = false 
	static File processFile(Scanner scanner, String folder, boolean isSaveFile, String message1, String message2) {
		System.out.print(message1);
		String name = scanner.nextLine();

		File file = new File(folder + "\\" + name + ".txt");

		while (isFileDirectoryExists(file) == isSaveFile) {
			System.out.printf(message2);
			if (isSaveFile) {
				int choice = getChoice(scanner, 2);
				if (choice == 1) {
					file.delete();
					return file;
				} else {
					System.out.printf(message1);
				}
			}
			name = scanner.nextLine();
			file = new File(folder + "\\" + name + ".txt");
		}

		return file;
	}

	// input utility
	static int readInt(Scanner scanner, String errorMessage) {
		while (!scanner.hasNextInt()) {
			System.out.printf(errorMessage);
			scanner.next(); // this is important!
		}
		int temp = scanner.nextInt(); //really important
		scanner.nextLine();
		return temp;
	}

	static float readFloat(Scanner scanner, String errorMessage) {
		while (!scanner.hasNextFloat()) {
			System.out.printf(errorMessage);
			scanner.next(); // this is important!
		}
		float temp = scanner.nextFloat(); //really important
		scanner.nextLine();
		return temp;
	}
	
	//choice utility
	//get choice from 1->range
	static int getChoice(Scanner scanner, int range) {
		int temp = -1;
		while (!(1 <= temp && temp <= range)) {
			temp = readInt(scanner, "Input must be Integer!! Try again\nYour choice: ");
			if (!(1 <= temp && temp <= range)) {
				System.out.print("Input must be from 1 to " + range + ". Try again\nYour choice: ");
			}
		}
		return temp;
	}
	
	// menu utility 	
    static int createMainMenu(Scanner scanner) {
        int choice = 0;
        while (true) {
            // printing menu
            String[] menu = new String[]{"1- Add product",
                "2- Display product",
                "3- Delete product",
                "4- Search products by name",
                "5- Sort products by price",
                "6- Save products to file",
                "7- Load products from file",
                "8- Exit"};
            
            System.out.println();
            
            createBox(menu);
            System.out.printf("Your choice: ");

            choice = getChoice(scanner, 9);
            
            return choice;
        }
    }
    
    /*Box utils*/
    static int maxWidth(String[] input) {
        int max = 0;
        for (int index = 0; index < input.length; ++index) {
            if (input[index].length() > max) {
                max = input[index].length();
            }
        }
        return max;
    }

    static void createBox(String[] input) {
        int max = maxWidth(input);

        // Đưa max về chẵn để ko bị sai phần menu
        if (max % 2 == 1) {
            max = max + 1;
        }
        
        // First line
        System.out.printf(topleft);
        // đảo dấu max
        System.out.printf(String.format("%" + -(max / 2 - 2) + "s", " ").replace(" ", horizontal));
        System.out.printf("MENU");
        System.out.printf(String.format("%" + -(max / 2 - 2) + "s", " ").replace(" ", horizontal));
        System.out.printf(topright + "\n");

        for (int index = 0; index < input.length; ++index) {
            System.out.printf(vertical);
            // đảo dấu max thì mới in từ đầu dòng, nếu ko nó sẽ in từ cuối dòng
            System.out.printf(String.format("%" + -max + "s", input[index]));
            System.out.printf(vertical + "\n");
        }

        // Last line
        System.out.printf(botleft);
        System.out.printf(String.format("%" + max + "s", " ").replace(" ", horizontal));
        System.out.printf(botright + "\n");
    }
    
    static void sortProduct() {
    	for (int i = 0; i < products.size() - 1; ++i) {
    		for (int j = i + 1; j < products.size(); ++j) {
    			if (products.get(i).price > products.get(j).price) {
    				Product temp = new Product();
    				assign(temp, products.get(i));
    				assign(products.get(i), products.get(j));
    				assign(products.get(j), temp);
    			}
    		}
    	}
    	System.out.println("Sorted.");
    }
    
    static void assign(Product p1, Product p2) {
    	p1.id = p2.id;
    	p1.name = p2.name;
    	p1.price = p2.price;
    	p1.quantity = p2.quantity;
    }
}

class Product {
	int id;
	String name;
	float price;
	int quantity;

	Product(Scanner scanner) {
		System.out.printf("\nName of product: ");
		this.name = scanner.nextLine();
		System.out.print("Price of product: ");
		this.price = Assignment2.readFloat(scanner, "Input must be Float!! Input again\nPrice of product: ");
		System.out.print("Quantity: ");
		this.quantity = Assignment2.readInt(scanner, "Input must be Integer!! Input again\nQuantity: ");
	}

	Product(int id) {
		this.id = id;
	}
	
	Product() {
	}
	
}
