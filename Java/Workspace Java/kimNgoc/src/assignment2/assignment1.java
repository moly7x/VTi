package assignment2;

import java.util.Scanner;

public class assignment1 {

    static final String topleft = "*";
    static final String topright = "*";
    static final String horizontal = "*";
    static final String vertical = "*";
    static final String botleft = "*";
    static final String botright = "*";

    static void decimalToBinary(Scanner scanner) {
        // Input n
        System.out.println("Input number: ");
        int n = -1;
        boolean firstTime = true;
        while (n < 0) {
            if (firstTime) {
                firstTime = false;
            } else {
                System.out.println("Number input must greater than 0\nInput number: ");
            }
            n = readInt(scanner, "Input must be Integer! Please input again!\nInput number: ");
        }

        String result = new String();

        while (n > 0) {
            result = result.concat(String.valueOf(n % 2));
            n = n / 2;
        }

        for (int i = result.length() - 1; i >= 0; i--) {
            System.out.print(result.charAt(i));
        }
        System.out.println();
    }

    static void computeSquareRoot(Scanner scanner) {
        // Input n and m
        boolean firstTime;

        // Input M
        System.out.println("Input M: ");
        int m = -1;
        firstTime = true;
        while (m < 0) {
            if (firstTime) {
                firstTime = false;
            } else {
                System.out.println("M must greater than 0\nInput M: ");
            }
            m = readInt(scanner, "M must be Integer! Please input again!\nInput M: ");
        }

        // Input N
        System.out.println("Input N: ");
        int n = -1;
        firstTime = true;
        while (!(1 <= n && n <= 5)) {
            if (firstTime) {
                firstTime = false;
            } else {
                System.out.println("N must greater than 0 and smaller than 6\nInput N: ");
            }
            n = readInt(scanner, "N must be Integer! Please input again!\nInput N: ");
        }

        double result = 0;
        for (int i = 1; i <= n; ++i) {
            result = Math.sqrt(result + m);
        }

        System.out.printf("%.2f\n", result);
    }

    static void solveQuadratic(Scanner scanner) {
        // Input a,b,c
        boolean firstTime;

        // Input a
        System.out.println("Input a: ");
        float a = readFloat(scanner, "a must be Float! Please input again!\nInput a: ");

        // Input b
        System.out.println("Input b: ");
        float b = readFloat(scanner, "b must be Float! Please input again!\nInput b: ");

        // Input c
        System.out.println("Input c: ");
        float c = readFloat(scanner, "c must be Float! Please input again!\nInput c: ");

        if (a == 0 && b == 0) {
            System.out.println("Can't slove!!");
        } else if (a == 0) {
            System.out.printf("The given equation has one solution is %.2f.", -c / b);
        } else {
            double delta = b * b - 4 * a * c;

            if (delta > 0) {
                double x = ((-b - Math.sqrt(delta)) / (2 * a));
                System.out.printf("The given equation has two solutions are %.2f and %.2f.", x, -b / a - x);
            } else if (delta == 0) {
                double x = ((-b - Math.sqrt(delta)) / (2 * a));
                System.out.printf("The given equation has one solution is %.2f.", x);
            } else {
                System.out.println("The given equation has no reals solution.");
            }
        }
    }

    static void printTriangle(Scanner scanner) {
        // Input n
        System.out.println("Input N: ");
        int n = -1;
        boolean firstTime = true;
        while (!(1 <= n && n <= 5)) {
            if (firstTime) {
                firstTime = false;
            } else {
                System.out.println("Number input must greater than 0 and smaller than 6\nInput N: ");
            }
            n = readInt(scanner, "Input must be Integer! Please input again!\nInput N: ");
        }

        String[] triangle = {"*", "***", "*****", "*******", "*********"};

        for (int i = 0; i < n; ++i) {
            System.out.printf("%" + (n - i + triangle[i].length() - 1) + "s\n", triangle[i]);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int choice = createMainMenu(scanner);

            switch (choice) {
                case 1:
                    decimalToBinary(scanner);
                    break;
                case 2:
                    computeSquareRoot(scanner);
                    break;
                case 3:
                    solveQuadratic(scanner);
                    break;
                case 4:
                    printTriangle(scanner);
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                    break;
            }
        }
    }

    // input
    static int readInt(Scanner scanner, String errorMessage) {
        while (!scanner.hasNextInt()) {
            System.out.println(errorMessage);
            scanner.next(); // this is important!
        }
        return scanner.nextInt();
    }

    static float readFloat(Scanner scanner, String errorMessage) {
        while (!scanner.hasNextFloat()) {
            System.out.println(errorMessage);
            scanner.next(); // this is important!
        }
        return scanner.nextFloat();
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

    // menu utils
    static int choices(Scanner scanner) {
        while (true) {
            return readInt(scanner, "Input must be Integer! Please input again!\nYour choice: ");
        }
    }

    static int createMainMenu(Scanner scanner) {
        int choice = 0;
        while (true) {
            // printing menu
            String[] menu = new String[]{"1- Convert decimal integer to binary",
                "2- Compute a consecutive square root",
                "3- Solve a quadratic equation",
                "4- Print a triangle",
                "5- Exit"};
            
            System.out.println();
            
            createBox(menu);
            System.out.printf("Your choice: \n");

            choice = choices(scanner);
            if (choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5) {
                return choice;
            } else {
                System.out.println("\nChoice must only form 1 to 5\n");
            }
        }
    }
}
