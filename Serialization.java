import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// What is Serialization?

// Serialization is a way to take an object and convert it into a byte stream.
// This can then be later deserialized to create a copy of that object.

// Uses:

// - Save states (in video games for example).
//   - It might not be the most efficient or fast method, but it would work
// - Creating a duplicate of an object without having to create a designated copy method.
// - Store the state of an object in a way that is easy to transfer

public class Serialization {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        Course course = new Course();
        course.SetCourseName( "Art" );
        course.SetStudent( "Jimmy" );
        course.SetGrade( 95 );
        
        // Serializes, and writes to file.
        FileOutputStream fileOutputStream = new FileOutputStream( "storage.txt" );
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(course);
        objectOutputStream.flush();
        objectOutputStream.close();
        
        System.out.println( "Course 1: " + course.GetCourseName() + ", " + course.GetStudent() + ", " + course.GetGrade() );
        
        // Gets from file, deserializes and uses to make a second object with the same values.
        FileInputStream fileInputStream = new FileInputStream( "storage.txt" );
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Course courseCopy = (Course) objectInputStream.readObject();
        objectInputStream.close(); 
        
        // Second course has the same name and student values, but grade is reset to 0 because it is transient.
        System.out.println( "Course 2: " + courseCopy.GetCourseName() + ", " + courseCopy.GetStudent() + ", " + courseCopy.GetGrade() );
        
    }
    
    public static class Course implements Serializable {
        
        String courseName;
        String student;
        // A transient variable will not be serialized,
        // and will thus reset to its default value.
        transient int grade;
        
        public void SetCourseName( String value ) {
            courseName = value;
        }
        public void SetStudent( String value ) {
            student = value;
        }
        public void SetGrade( int value ) {
            grade = value;
        }
        
        public String GetCourseName() {
            return courseName;
        }
        public String GetStudent() {
            return student;
        }
        public int GetGrade() {
            return grade;
        }
        
    }
    
}
