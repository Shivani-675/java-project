class student{
    String name;
    int age;
    char grade;
}
public class class1{
    public static void main(String[] args) {
        student studsnt1=new student();
        student studsnt2=new student();
        studsnt1.name="john";
        studsnt1.age=18;
        studsnt1.grade='A';
        studsnt2.name="john";
        studsnt2.age=18;
        studsnt2.grade='A';
        System.out.println("student name:"+studsnt1.name);
        System.out.println("age:"+studsnt1.age);
        System.out.println("grade:"+studsnt1.grade);
        System.out.println("student name:"+studsnt2.name);
        System.out.println("age:"+studsnt2.age);
        System.out.println("grade:"+studsnt2.grade);
    }
}