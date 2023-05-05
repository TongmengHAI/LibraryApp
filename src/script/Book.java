package script;

public class Book {
    private int id;
    private String name;
    private double price;
    private int qnt;
    private String type;
    public Book(int id,String n, double p,int q,String t){
        this.id = id;
        this.name = n;
        this.price = p;
        this.qnt=q;
        this.type = t;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public int getQnt(){
        return qnt;
    }
    public String getType(){
        return type;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setQnt(int qnt){
        this.qnt = qnt;
    }
    public void setType(String type){
        this.type = type;
    }
}
