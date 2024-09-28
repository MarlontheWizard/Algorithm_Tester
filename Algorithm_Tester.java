public interface Algorithm_Tester <Type>{
    
    /* Generates {numeric} values for test cases. 
    
       Parameter(s)
     * bool signed -> Indicates whether negative values should also be generated 
     * int cardinality -> Indicates how many values should be produced. No limit is indicated by 0.
     * int lower_bound -> Specifies lower bound if a range must be satisfied. 
     * int upper_bound -> Specifies upper bound if a range must be satisfied. 
     */ 
    public void numeric_generator(boolean signed, int cardinality, int lower_bound, int upper_bound){




    }
    

    public int[] obj_generator(<Type> obj_type, int cardinality, int lower_bound, int upper_bound){

        String obj = obj_type.getClass().getSimpleName();


        /*
         * Generally, the forName() class method imports the target 
         * object's identity/contents so that the JVM recognizes it to be initialized here. 
         */
        Class<?> obj_class = Class.forName(obj); 

        /*
         *The JVM now recognizes the class, or the . we can dynamically allocate it.
         *
         *A class can have many constructors with varying paramaters. 
         *
          
        Object initialized_obj = obj_class.getDeclaredConstructor()


    }
}
