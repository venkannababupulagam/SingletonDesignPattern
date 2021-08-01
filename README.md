Singleton Design Pattern restricts the instantiation of a class to one 'single' object. 
In order to achieve that:
1. Make the Default Constructor as Private                                   
private ClassName(){}

2. Create a private static Class type Variable and Initialize it with new keyword                     
private static ClassName obj = null; 
po
3. Create a public static (for global access) get class instance method with class return type                 
public static ClassName getClassName(){                  
    if(obj==null){                                                   
    new ClassName();                                                   
    }                                                       
    return obj;                                                
    } 