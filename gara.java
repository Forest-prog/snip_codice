public class Disabile extends Persona{
    private String nameC;
    private String surnameC;
    public Disabile(String name,String surname,String tel,int age,String nameC,String surnameC){
        super(name,surname,tel,age);
        this.nameC=nameC;
        this.surnameC=surnameC;
    }
    public void setNameC(String nameC){
        this.nameC=nameC;
    }
    public String getNameC(){
        return this.nameC;
    }
    public void setSurnameC(String surnameC){
        this.surnameC=surnameC;
    }
    public String getSurnameC(){
        return this.surnameC;
    }
    public String toString(){
        return "ciao sono "+name+" "+surname+" sono accompagnaot da "+nameC+" "+surnameC;
    }
}
public class Persona{
    protected String name;
    protected String surname;
    protected String tel;
    protected int age;
    public Persona(String name,String surname,String tel,int age){
        this.name=name;
        this.surname=surname;
        this.tel=tel;
        this.age=age;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public void setSurname(String surname){
        this.surname=surname;
    }
    public String getSurname(){
        return this.surname;
    }
    public void setTel(String tel){
        this.tel=tel;
    }
    public String getTel(){
        return this.tel;
    }
    public void setAge(int Age){
        this.age=age;
    }
    public int getAge(){
        return this.age;
    }
    public String toString(){
        return "Ciao sono "+name+" "+surname+" tel:"+tel+" età "+age;
    }
}
import java.time.LocalDate;
import java.util.ArrayList;
public class Gara{
    protected String name;
    protected String description;
    protected LocalDate date;
    protected ArrayList<Persona> lista= new ArrayList<Persona>();
    public Gara(String name,String description,LocalDate date,ArrayList<Persona> lista){
        this.name=name;
        this.description=description;
        this.date=date;
        this.lista=lista;
    }
}
}