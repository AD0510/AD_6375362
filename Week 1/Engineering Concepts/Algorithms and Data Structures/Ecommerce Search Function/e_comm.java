import java.util.*;

class Product{
    int ProductID;
    String ProductName, category;
    public Product(int ProductID, String ProductName, String category){
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.category = category;
    }
}
class e_comm {
    static Product[] products = new Product[100];
    static int size = -1;
    static ArrayList<Product> list=new ArrayList<>();//This will be used for linear search;
    public static void add_product(Product p){
        if(size + 1 >= products.length){
            //In case the array size is not sufficient, then doubling the array size
           /* Product temp[]=new Product[products.length*2];
            for(int i=0; i<products.length; i++){
                temp[i]=products[i];
            }
            products = temp;*/
            products = Arrays.copyOf(products, products.length * 2);
        }
        //In order to make searching technique easy, let's add the products in a sorted order
        list.add(p);
        if(size!=-1 && p.ProductID < products[size].ProductID){
            int index = size;
            while(index!=-1 && p.ProductID < products[index].ProductID ) {
                index--;
            }
            for(int i = size+1; i > index && i>0; i--) {
                products[i] = products[i - 1];
            }
            products[index+1] = p;
            size++;
        }
        else
            products[++size] = p;
    }
    public static int search_product(int productID,int decide){
        int steps=0;
        Scanner sc=new Scanner(System.in);
        if(decide == 0){
        System.out.println("Press 1 for Linear search");
        System.out.println("Press 2 for Binary Search");
        decide=sc.nextInt();
        }
        switch(decide){
            case 1://Linear Search
            steps=0;
            for(int i=0;i<list.size();i++){
                steps++;//used for counting number of steps
                  if(list.get(i).ProductID==productID){
                    System.out.println("Number of steps taken for Linear search = "+steps);
                    return i;
                  }
            }
            break;
            case 2://Binary Search
            steps=0;
            int L=0, R=size;
            while(L<=R){
                steps++;//used for counting number of steps
                int mid = (L+R)/2;
                if(products[mid].ProductID == productID){
                    System.out.println("Number of steps taken for Binary search = "+steps);
                    return mid;
                }
                else if(products[mid].ProductID < productID){
                    L=mid+1;
                }
                else{
                    R=mid-1;
                }
            }
            break;
        }
        System.out.println("Number of steps taken = "+steps);
        return -1;
    }
    public static void remove_product(int productID){
        if(size == -1){
            System.out.println("oops!!! product database is empty");
            return;
        }
        int location = search_product(productID,2);//first searching the product from the product set
        int list_location = search_product(productID,1);
        list.remove(list_location);
        if(location == -1){
            System.out.println("oops!! No such product not found");
            return;
        }
        System.out.println("Removing product "+productID+" from index"+location);
        for(int i=location+1;i<products.length;i++){
            products[i-1]=products[i];
        }
        size--;
        System.out.println("Product removed successfully");
    }
    public static void display_products(){
        System.out.println("\nYour product list as per sequence of adding:");
        for(int i = 0; i<list.size(); i++){
            System.out.println(list.get(i).ProductID+"\t"+list.get(i).ProductName+"\t"+list.get(i).category);
        }
        System.out.println("\nYour product list in sorted fashion:");
        for(int i = 0; i<=size; i++){
            System.out.println(products[i].ProductID+"\t"+products[i].ProductName+"\t"+products[i].category);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int choice=0;
        int productID=0;
        String productName="";
        String category="";
        boolean flag=true;
        while(flag) {
            System.out.println("Press 1 to add a product");
            System.out.println("Press 2 to search for a product");
            System.out.println("Press 3 to remove a product");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the product ID");
                    productID = sc.nextInt();
                    System.out.println("Enter the product name");
                    productName = sc.next();
                    System.out.println("Enter the category");
                    category = sc.next();

                    add_product(new Product(productID, productName, category));
                    break;

                case 2:
                    System.out.println("Enter the product ID");
                    productID = sc.nextInt();
                    int location = search_product(productID,0);
                    if(location == -1){
                        System.out.println("oops!! No such product not found");
                    }
                    else {
                        System.out.println("Product "+productID+" found at index "+location);
                    }
                    break;
                case 3:
                    System.out.println("Enter the product ID");
                    productID = sc.nextInt();
                    remove_product(productID);
                    break;
                default: System.out.println("Invalid choice");

            }
            display_products();
            System.out.println("Do you want to continue (true/false)?)");
            flag = sc.nextBoolean();
        }

    }
}