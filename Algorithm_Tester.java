import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public interface Algorithm_Tester <Type>{
    
    /* Generates {numeric} values for test cases. 
    
       Parameter(s)
     * bool signed -> Indicates whether negative values should also be generated 
     * int cardinality -> Indicates how many values should be produced. No limit is indicated by 0.
     * int lower_bound -> Specifies lower bound if a range must be satisfied. 
     * int upper_bound -> Specifies upper bound if a range must be satisfied. 
     */ 
    public void primitive_obj_generator(boolean signed, int cardinality, int lower_bound, int upper_bound){


        
    }
    

    public int[] nonprimitive_obj_generator(<Type> obj_type, int cardinality, int lower_bound, int upper_bound){


        String obj_className = obj_type.getClass().getName();

        //Display non-primitive data type being used to generate test cases 
        System.out.println("Generating test values of type {" + obj + "}"); 


        /*
         * Generally, the forName() class method imports the target 
         * object's identity/contents so that the JVM recognizes it to be initialized here. 
         */

        System.out.println("Importing object...");

        Class<?> obj_class = null;

        try{

            obj_class = Class.forName(obj_className); 
        }

        catch(ClassNotFoundException class_error){

            System.out.println("Could not find the object's class. Terminating program...");
            System.exit(1);
        }

        System.out.println("Object imported. Displaying all available constructors...");


        /*
         *The JVM now recognizes the class, or the object definition. We can now dynamically allocate it.
         *
         *An nonprimitive object can have many constructors with varying parameters. 
         *Therefore, our algorithm tester must present all of the possible 
         *constructors and their associated parameters so that the user can provide the 
         *correct information needed to begin creating test cases with the object. 
         */

          dynamic_allocation_byUser(); 
        

        //Create logic to accept input and handle as needed. Remember, we want to dynamically allocate the object.
        


        //We now know the object type, preferred constructor and parameters to be entered. Begin generating. 

        Object initialized_obj = obj_class.getDeclaredConstructor();


    }

    public Parameter<?>[] dynamic_allocation_byUser(){
        
        

    }



    public void display_class_constructors(Class<?> obj_class){

        /*
        It is possible that the user already knows the specific constructor they want to use, 
        in other words, the arguments. 
        */
        

        /*User does not know constructor in advance -> Let's display constructors and their parameters.
          To access the constructors of a class we must use the Method subclass of Reflection. 
          Attributes from the Method class will allow us to retrieve all methods associated with our 
          non-primitive object, but we only want the constructors. 
        */
        display_class_constructors(constructors);


        //Get all possible constructors & associated parameters, then display them if necessary. 
        Constructor<?>[] obj_constructors = null;
        
        try{
            
            constructors = obj_class.getConstructors(); 
        }

        catch(SecurityException sException){

            System.out.println("Could not retrieve constructors from object class. Terminating tester...");
            System.exit(1);
        }


        System.out.println("Method Signature\t\tParameters\t\t\tTypes\n----------------\t\t----------\t\t\t-----");
        for(Constructor<?> constructor : obj_constructors){

            System.out.printf("%-32s", method.getName());
            
            Parameter[] params = constructor.getParameters();
            Class<?>[]  param_types = constructor.getParameterTypes();

            String param_str = "";

            for(Parameter param : params){

                param_str += param.getName() + " "; 
            }

            System.out.printf("%-28s", param_str);
            
            for(Class<?> param_type : param_types){

                System.out.printf("%-5s", param_type.getSimpleName());
               
            }
            

            System.out.println();

        }
        
        return;
    }
}
