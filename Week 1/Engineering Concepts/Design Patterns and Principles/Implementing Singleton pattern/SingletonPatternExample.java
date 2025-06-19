//We know a singleton class is one whose constructor shouldn't be called from any other class
//Here Logger is used as a singleton class
class Logger{
    int c=0;
   private Logger(){
    c++;
    System.out.println("I am inside the constructor of Logger(The singleton class)\nI will appear only once in your output no matter how many instances you create");
    System.out.println("I am called only "+c+" time");
   }
   
   private static Logger Instance;

   //Creating a public method to get the instance of Logger class
   public static Logger getInstance(){
      //we will return the instance if object of logger is created
      if(Instance==null){
        // that is if no objects are created
        //This if will be true only once, when for the first time this method will be called
        Instance = new Logger();//We are calling the constructor of logger inside the same class
      }
      return Instance;
   }
}
public class SingletonPatternExample{
    public static void main(String[] args){
        Logger log=Logger.getInstance();//calling getInstance method for the first time
        Logger log2=Logger.getInstance();
        Logger log3=Logger.getInstance();//All are pointing to the same object
    }
}