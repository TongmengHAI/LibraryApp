package script;

public class BorrowBook {
    private int id;
    private String studentid;
    private String title;
    private String studentname;
    private String gender;
    private String department;
    private int qnt;
    private String borrowdate;
    private String deadline;
    private String returndate;
    private int bookid;
    private String img;

    public BorrowBook(){}
    public BorrowBook(int a,String b, String c, int d, String e, String f,String g){
        this.id = a;
        this.title = b;
        this.studentname = c;
        this.qnt = d;
        this.borrowdate = e;
        this.deadline = f;
        this.returndate = g;
    }
    public BorrowBook(int a,String b, String c, int d, String e, String f,String g,String h,int i,String j,String k){
        this.id = a;
        this.title = b;
        this.studentname = c;
        this.qnt = d;
        this.borrowdate = e;
        this.deadline = f;
        this.gender = g;
        this.department = h;
        this.bookid = i;
        this.studentid = j;
        this.img = k;
    }
    public void setImg(String k){
        this.img = k;
    }
    public String getImg(){return img;}
    public String getStudentid(){return studentid;}
    public void setStudentid(String i){
        this.studentid = i;
    }
    public int getBookid(){return bookid;}
    public void setBookid(int id){
        this.bookid = id;
    }
    public void setGender(String g){
        this.gender = g;
    }
    public String getGender() {return gender;}
    public void setDepartment(String de){
        this.department = de;
    }
    public String getDeparment(){return department;}
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
