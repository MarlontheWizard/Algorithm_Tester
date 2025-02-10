import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import java.util.Scanner;

public class Tester_Implementation{

    public static void main(String[] args) throws IOException{

        Driver();

        Class<?> clazz = null;
        Constructor<?>[] cnsts = null; 

        System.out.println();
        try {
            
            clazz  = Class.forName("java.lang.String");
        
        } 

        catch(ClassNotFoundException e){

            //TODO Auto-generated catch block
            e.printStackTrace();
        }



        try{
            
            cnsts = clazz.getConstructors();

        }

        catch(SecurityException e){

            e.printStackTrace();

        }

        Method[] meth = clazz.getMethods();

        /*for(Constructor<?> constructor: cnsts){

            System.out.println(constructor.toString());



        }*/

    
        System.out.println("Method Signature\t    Parameters\t\t        Types\t\t\t   ID\n----------------\t    ----------\t\t        -----\t\t\t   --");
        
        
        int constructor_count = 1;
        
        for(Constructor<?> metho : cnsts){

            System.out.printf("%-28s", metho.getName());
            
            Parameter[] params = metho.getParameters();
            Class<?>[]  param_types = metho.getParameterTypes();


            String param_str = "";

            for(Parameter param : params){

                param_str += param.getName() + " "; 
            }

            System.out.printf("%-28s", param_str);
            
            String type_str = "";

            for(Class<?> param_type : param_types){

                type_str += param_type.getSimpleName() + " ";
               
            }

            System.out.printf("%-28s", type_str);

            System.out.printf("%-5s", constructor_count);

            constructor_count += 1;

            System.out.println();

        }

        System.out.println("\n      ID  Argument(s)\tCaution: [Multiple arguments should be seperated by a {SPACE}]");
        System.out.println("      --  -----------\n");
        System.out.print("Input: ");
         
        Scanner scanner = new Scanner(System.in); 
        
        int selected_constructorID = Integer.parseInt(scanner.next()); 
        
        int parameter_count = cnsts[selected_constructorID-1].getParameterCount() + 1;

        Object[] constructor_arguments = new Object[parameter_count]; 


        for(int argument_index = 0; argument_index < parameter_count; argument_index++){

            
            String token = scanner.next();


            if(assertInteger(token)){

                constructor_arguments[argument_index] = Integer.parseInt(token); 
            }

            else if(assertFloat(token)){

                constructor_arguments[argument_index] = Double.parseDouble(token);
            }

            else{ //String token does not refer to a numeric value, treat as string. 

            }


            
        }

        scanner.close();


        

        

        

        



    }

    /*public Parameter<?>[] dynamic_allocation_byUser(){
        
        

    }*/

    public static Boolean assertInteger(String token){

        try{                                //String refers to a numeric value.

            int numeric_argument = Integer.parseInt(token);

            return true;
        }

        catch(NumberFormatException error){ //String does not refer to a numeric value. 
            
            return false;
        }
        
    }

    public static Boolean assertFloat(String token){

        try{                                //String refers to a numeric value.

            double numeric_argument = Double.parseDouble(token);
            
            return true;
        }

        catch(NumberFormatException error){ //String does not refer to a numeric value. 
            
            return false;
        }

    }

    public static void Driver() throws IOException{

        Message();

        Scanner scanner = new Scanner(System.in);

        System.out.println("1) Simple/Express \t 2) Manual \t 3) Update Test Case Quantity");

        int quantity = 10; 
        int mode = scanner.nextInt();
        
        System.out.println();

        if(mode == 3){

            System.out.print("Insert Test Case Quantity: ");
            quantity = scanner.nextInt();
            System.out.println();
        }

        
        
       
        scanner.close();
        
    }

    public static void Message(){

        System.out.println();

        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("| Author: Marlon Dominguez                                                  |"); 
        System.out.println("| Contact: Marlon.dominguez307@gmail.com                                    |");
        System.out.println("|                                                                           |"); 
        System.out.println("|Welcome to the Java Algorithm Tester! This interface provides the needed   |");
        System.out.println("|methods for generating and running test cases on an algorithm. Reference   |");
        System.out.println("|types are supported as long as the Tester can locate the object. If the    |");
        System.out.println("|objects are not imported, make sure that they are in the same file         |");
        System.out.println("|directory as the Tester.                                                   |");
        System.out.println("|                                                                           |"); 
        System.out.println("|Step 1: After initializing the tester, choose whether...                   |");
        System.out.println("|        A)you would like to quickly generate test cases. This option       |");
        System.out.println("|          prompts the Tester to use the default constructor of every       |");
        System.out.println("|          object involved (parameter arguments). **Simple Option           |");
        System.out.println("|                                                                           |");
        System.out.println("|        B)you would like to have a say in which constructor is to be used  |");
        System.out.println("|          for generating the objects. This option should be used if you are|");
        System.out.println("|          certain that the default constructor of an object or more is not |");
        System.out.println("|          used to initialize it, allowing manual config. **Manual Option   |");
        System.out.println("|                                                                           |");  
        System.out.println("|Step 2: Input number of test cases to generate. If no amount is specified  |");
        System.out.println("|        then a default amount (10) is used.                                |");
        System.out.println("|                                                                           |"); 
        System.out.println("|Step 3: Check Test_Cases.txt in current file directory.                    |");
        System.out.println("|                                                                           |"); 
        System.out.println("|                                Happy Testing!                             |"); 
        System.out.println("|Version: 1.0.2                                                             |"); 
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println();
    
    
    }
}
