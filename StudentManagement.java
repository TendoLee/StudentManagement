/**
 * 这是学生管理系统的初始版本，后续会加入更多功能
 * 累二
 */
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
class StudentManagement
{
    static List<Student>StudentList=new LinkedList<Student>();
    static int numofstudent=0;//记录学生总人数
    public static void main(String[] args) { select(StudentList); }
    static void printStulist()
    {
        for (int p=0;p<numofstudent-1;p++)
        {
            System.out.println(StudentList.get(p).getName()+"  "+StudentList.get(p).getIdentity()+"  "+StudentList.get(p).getGrade());
        }
        select(StudentList);
    }//打印学生信息
    public static void select(List<Student>StudentList)
    {
        System.out.println("欢迎来到T.L学生管理系统");
        System.out.println("     1：增加学生       ");
        System.out.println("     2：删除学生       ");
        System.out.println("     3：修改信息       ");
        System.out.println("     4：查询学生       ");
        System.out.println("     5: 成绩排序       ");
        System.out.println(" 学生总数："+numofstudent+"人");
        System.out.println("(●°u°●)您想选择的操作是：");

        Scanner op=new Scanner(System.in);
        int option=op.nextInt();
        switch (option)
        {
            case 1:
                System.out.println("请输入学生的姓名：");
                Scanner addName=new Scanner(System.in);
                String name=addName.nextLine();
                System.out.println("请输入学生的学号：");
                Scanner addIdentity=new Scanner(System.in);
                String identity=addIdentity.nextLine();
                System.out.println("请输入学生的性别：");
                Scanner addGender=new Scanner(System.in);
                String gender=addGender.nextLine();
                System.out.println("请输入学生的成绩：");
                Scanner addGrade=new Scanner(System.in);
                int grade=addGrade.nextInt();
                StudentList.add(new Student(name,identity,gender,grade));
                numofstudent++;//记录学生人数
                System.out.println("****添加完成****  ");
                select(StudentList);
                break;
            case 2:
                System.out.println("请输入需要删除学生的学号：      ");
                Scanner comStu=new Scanner(System.in);
                String  didentity=comStu.nextLine();
                boolean dfound = false;
                for (int i = 0; i < StudentList.size(); i++)
                {
                    if(didentity.equals(StudentList.get(i).getIdentity()))
                    {
                        System.out.println("找到该学生，正在删除---");
                        StudentList.remove(i);
                        numofstudent--;
                        System.out.println("****删除完成****");
                        dfound =true;
                    }
                }
                if(!dfound)
                {
                    System.out.println("没有查照到该学生");
                    System.out.println("请重新选择操作");
                }
                select(StudentList);
                break;
            case 3:
                System.out.println("请输入需要修改的学生学号");
                Scanner ajStu=new Scanner(System.in);
                String aidentity=ajStu.nextLine();
                boolean afound=false;
                for (int j=0;j<StudentList.size();j++)
                {
                    if(aidentity.equals(StudentList.get(j).getIdentity()))
                    {
                        System.out.println("找到该学生，请选择需要修改的信息：");
                        System.out.println("1.姓名："+StudentList.get(j).getName());
                        System.out.println("2.学号："+StudentList.get(j).getIdentity());
                        System.out.println("3.性别："+StudentList.get(j).getGender());
                        System.out.println("4.成绩："+StudentList.get(j).getGrade());
                        Scanner ajOption=new Scanner(System.in);
                        int adjust=ajOption.nextInt();
                        switch (adjust)
                        {
                            case 1:
                                System.out.println("请输入新的姓名：");
                                Scanner xna=new Scanner(System.in);
                                String xname=xna.nextLine();
                                StudentList.get(j).setName(xname);
                                break;
                            case 2:
                                System.out.println("请输入新的学号：");
                                Scanner xid=new Scanner(System.in);
                                String xidertity=xid.nextLine();
                                StudentList.get(j).setIdentity(xidertity);
                                break;
                            case 3:
                                System.out.println("请输入正确的性别：");
                                Scanner xge=new Scanner(System.in);
                                String xgender=xge.nextLine();
                                StudentList.get(j).setGender(xgender);
                                break;
                            case 4:
                                System.out.println("请输入正确的成绩：");
                                Scanner xgr=new Scanner(System.in);
                                int xgrade=xgr.nextInt();
                                StudentList.get(j).setGrade(xgrade);
                                break;
                            default:
                                System.out.println("输入有误，请重新输入");
                                select(StudentList);
                                break;
                        }
                        afound=true;
                        System.out.println("****修改成功****");
                    }
                }
                if(!afound)
                {
                    System.out.println("没有查找到该学生");
                    System.out.println("请重新选择操作");
                }
                select(StudentList);
                break;
            case 4:
                System.out.println("请输入需要查询的学生信息");
                Scanner res=new Scanner(System.in);
                String research=res.nextLine();
                boolean rfound=false;
                for (int k=0;k<StudentList.size();k++)
                {
                    if (research.equals(StudentList.get(k).getIdentity())||research.equals(StudentList.get(k).getName()))
                    {
                        System.out.println("找到该学生，信息如下：");
                        System.out.println("1.姓名：" + StudentList.get(k).getName());
                        System.out.println("2.学号：" + StudentList.get(k).getIdentity());
                        System.out.println("3.性别：" + StudentList.get(k).getGender());
                        System.out.println("4.成绩：" + StudentList.get(k).getGrade());
                        rfound=true;
                        System.out.println("****查找完成****");
                    }
                    if(!rfound)
                    {
                        System.out.println("没有查找到该学生");
                        System.out.println("请重新选择操作");
                    }
                }
                select(StudentList);
                break;
            case 5:
                int temp;
                int length=numofstudent-1;
                System.out.println("请输入需要排序的方式：");
                System.out.println("输入 A ：从高到低");
                System.out.println("输入 B ：从低到高");
                Scanner aorb=new Scanner(System.in);
                String y_sort=aorb.nextLine();
                switch (y_sort)
                {
                    case "A":
                    for (int s1=0;s1<length;s1++)
                        for (int s2=0;s2<length-s1;s2++)
                        {
                            if (StudentList.get(s2).getGrade() < StudentList.get(s2+1).getGrade())
                            {
                                temp=StudentList.get(s2).getGrade();
                                StudentList.get(s2).setGrade(StudentList.get(s2+1).getGrade());
                                StudentList.get(s2+1).setGrade(temp);
                            }
                        }
                    break;
                    case "":
                        for (int s1=0;s1<length;s1++)
                            for (int s2 = 0; s2 < length - s1; s2++)
                            {
                                if (StudentList.get(s2).getGrade() > StudentList.get(s2 + 1).getGrade())
                                {
                                    temp = StudentList.get(s2).getGrade();
                                    StudentList.get(s2).setGrade(StudentList.get(s2 + 1).getGrade());
                                    StudentList.get(s2 + 1).setGrade(temp);
                                }
                            }
                        break;
                    default:
                        System.out.println("输入有误，请重新输入");
                        break;
                }
                System.out.println("****排序完成****");
                System.out.println("是否需要显示学生名单？yes/no");
                Scanner prts=new Scanner(System.in);
                String prtsort=prts.nextLine();
                switch (prtsort)
                {
                    case "yes":
                        printStulist();
                        break;
                    case "no":
                        break;
                    default:
                        System.out.println("输入有误，请重新输入");
                        break;
                }
                select(StudentList);
                break;
            default:
                System.out.println("输入有误，请重新输入");
                select(StudentList);
                break;
        }
    }
}
class Student
{
    private String name;
    private String identity;
    private String gender;
    private int grade;
    private int numofstudent;
    public Student(String name, String identity, String gender, int grade)
    {
        this.name=name;
        this.identity=identity;
        this.gender=gender;
        this.grade=grade;
    }
    public String getName()
    {
        return name;
    }
    public String getIdentity()
    {
        return identity;
    }
    public String getGender()
    {
        return gender;
    }
    public int getGrade()
    {
        return grade;
    }
    public int getNumofstudent(){return numofstudent;}


    public void setName(String name) { this.name=name; }
    public void setIdentity(String identity)
    {
        this.identity=identity;
    }
    public void setGender(String gender)
    {
        this.gender=gender;
    }
    public void setGrade(int grade)
    {
        this.grade=grade;
    }
    public void setNumofstudent(int numofstudent) { this.numofstudent=numofstudent; }
}
