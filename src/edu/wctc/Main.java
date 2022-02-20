package edu.wctc;

import java.io.*;
import java.util.Scanner;

public class Main {
    private static Scanner keyboard = new Scanner(System.in);
    private static PaintCalculator paintCalc = new PaintCalculator();

    public static void main(String[] args) {
        boolean cont = true;
        while (cont){
            printMenu();
            switch (keyboard.nextInt()){
                case 1:
                    createRoom();
                    break;
                case 2:
                    System.out.println(paintCalc.toString());
                    break;
                case 3:
                    try {
                        readFile();
                    } catch (IOException e) {
                        System.out.println("We could not find the given file!");
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        System.out.println("We could not find the paintCalculator class in this file!");
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    try {
                        writeFile();
                    } catch (IOException e) {
                        System.out.println("We could not find the given file!");
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    cont = false;
                    break;
            }
        }
    }

    private static void printMenu(){
        System.out.println("1. Add room\n2. View rooms\n3. Read rooms from file\n4. Write rooms to file\n5. Exit program");
    }

    private static double promptForDimension(String dimensionName){
        if (dimensionName.equals("Width")){
            System.out.print("Please enter the width of your room: ");
            return keyboard.nextDouble();
        } else if (dimensionName.equals("Length")){
            System.out.print("Please enter the length of your room: ");
            return keyboard.nextDouble();
        } else if (dimensionName.equals("Height")){
            System.out.print("Please enter the height of your room: ");
            return keyboard.nextDouble();
        } else {
            System.out.println("An error occurred");
            return 0;
        }
    }

    private static void createRoom(){
        double width = promptForDimension("Width");
        double length = promptForDimension("Length");
        double height = promptForDimension("Height");

        paintCalc.addRoom(width, length, height);
    }

    private static void readFile() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("paintCalculator.dat"));
        paintCalc = (PaintCalculator) ois.readObject();
        ois.close();
    }

    private static void writeFile() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("paintCalculator.dat"));
        oos.writeObject(paintCalc);
        oos.close();
    }
}
