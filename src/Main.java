import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File file = new File("student.txt");
        List <Student> students = new ArrayList<>();
        students.add(new Student(1,"nam", 20));
        students.add(new Student(2,"Hoàng", 21));
        students.add(new Student(3,"Lực", 22));
        students.add(new Student(4,"Nguyên", 23));
        students.add(new Student(5,"Tuấn", 24));
        students.add(new Student(6,"Huy", 25));
        //Ghi file
        writeToFile(file,students);
        //Đọc file
        List<Student> studentList = readDataFromFile(file);
        for (Student st: studentList) {
            System.out.println(st);
        }
    }

    public static void writeToFile(File file, List<Student> students) {
        FileOutputStream stream;
        try {
            stream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            BufferedOutputStream bufSt = new BufferedOutputStream(stream);
            ObjectOutputStream oos = new ObjectOutputStream(bufSt);
            oos.writeObject(students);
            oos.close();
        } catch (IOException e) {
            System.err.println("Lỗi");
        }
        try {
            stream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Student> readDataFromFile(File file){
        List<Student> students = new ArrayList<>();
        FileInputStream stream;
        try {
            stream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try{
            BufferedInputStream bufInSt = new BufferedInputStream(stream);
            ObjectInputStream ois = new ObjectInputStream(bufInSt);
            students = (List<Student>) ois.readObject();
            stream.close();
            ois.close();
        }catch(Exception ex){
            System.err.println("Lỗi");
        }
        return students;
    }
}
