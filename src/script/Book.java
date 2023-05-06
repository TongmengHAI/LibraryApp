package script;

public class Book {
    private int id;
    private String name;
    private double price;
    private int qnt;
    private String type;
    private String author;
    public Book(int id,String n, double p,int q,String t,String a){
        this.id = id;
        this.name = n;
        this.price = p;
        this.qnt=q;
        this.type = t;
        this.author = a;
    }
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String a){
        this.author = a;
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
