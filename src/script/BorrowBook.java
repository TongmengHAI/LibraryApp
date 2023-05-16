package script;

public class BorrowBook {
    private int id;
    private String title;
    private String studentname;
    private int qnt;
    private String borrowdate;
    private String deadline;
    private String returndate;
    
    public BorrowBook(int a,String b, String c, int d, String e, String f,String g){
        this.id = a;
        this.title = b;
        this.studentname = c;
        this.qnt = d;
        this.borrowdate = e;
        this.deadline = f;
        this.returndate = g;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setStudentname(String name){
        this.studentname = name;
    }
    public void setQnt(int qnt){
        this.qnt = qnt;
    }
    public void setBorrowdate(String bd){
        this.borrowdate = bd;
    }
    public void setDeadline(String db){
        this.deadline = db;
    }
    public void setReturndate(String rd){
        this.returndate = rd;
    }
    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getStudentname(){
        return studentname;
    }
    public int getQnt(){
        return  qnt;
    }
    public String getBorrowdate(){
        return borrowdate;
    }
    public String getDeadline(){
        return deadline;
    }
    public String getReturndate(){
        return returndate;
    }
}
