import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.awt.Desktop;
import java.io.*;

public class Convertor {
    public static void main(String[] args) throws IOException {
        Scanner usrInput = new Scanner(System.in);
        System.out.println("Welcome to currency converter \n Please choose an option (1/2)");

        char choice = 0;
    do{
            System.out.println("1.Dollars to Shekels\n2.Shekels to Dollars");
            int userAnswer = usrInput.nextInt();

            switch (userAnswer) {
                case 1:

                    System.out.println("Please enter an amount to convert");
                    double usdAmount = usrInput.nextDouble();
                    double number = new USD().calculate(usdAmount);
                    System.out.println(number);

//                    creating list to save the result into it
                    ArrayList<Double> theList = new ArrayList<Double>();
                    theList.add(number);
//                    print the result in arraylist and save the result arraylist in a file named result
                    try {
                        FileWriter fileWriter = new FileWriter("result.txt");
                        fileWriter.write("The result of the currency program:\n");
                        fileWriter.write(String.valueOf(theList));
                        fileWriter.close();
                        System.out.println("The results were transferred.");
                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    System.out.println("Please enter an amount to convert");
                    double ilsAmount = usrInput.nextDouble();
//                    input from user
                    double number1 = new ILS().calculate(ilsAmount);
//                    call the calculate function in ILS class
                    System.out.println(number1);

//                    creating list to save the result into it

                    ArrayList<Double> theList1 = new ArrayList<Double>();
                    theList1.add(number1);
//                    print the result in arraylist and save the result in arraylist
                    try {
                        FileWriter myWrite = new FileWriter("result.txt");
                        myWrite.write("The result of the currency program:\n");
                        myWrite.write(String.valueOf(theList1));
                        myWrite.close();
                        System.out.println("The results were transferred");
                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                    break;
            }

                    System.out.println("Do you want to start over? Y/N");
                    choice = usrInput.next().charAt(0);
                    if (choice == 'N' || choice == 'n'){
                        System.out.println("Thanks for using our currency converter.");
                    String filePath = "result.txt";
//            get the file content and print it
                    String content = new String(Files.readAllBytes(Paths.get(filePath)));
                    System.out.println(content);

//            --------open file result-------
                    try {
//                constructor of file class having file an argument
                        File file = new File("result.txt");
                        if (!Desktop.isDesktopSupported())
//                check if Desktop is supported by Platform or not
                        {
                            System.out.println("not supported");
                            return;
                        }
                        Desktop desktop = Desktop.getDesktop();
                        if (file.exists())
//                    checks file exists or not
                            desktop.open(file);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
//                -------open file result------

                    break;
            }



        }while(choice == 'Y' || choice == 'y') ;
    }
}

