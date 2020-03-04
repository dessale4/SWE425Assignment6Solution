package edu.mum.cs.cs425.demos.studentrecordsmgmtapp;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model.Student;

public class MyStudentRecordsMgmtApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student[] studentList = {new Student(110001, "Dave", 1951, 11, 18), 
									new Student(110002, "Anna", 1990, 12, 7),
									new Student(110003, "Erica", 1974, 01, 31),
									new Student(110004, "Carlos", 2009, 8, 22),
									new Student(110005, "Bob", 1990, 3, 5)
								};
		printListOfStudents(studentList);
		
		System.out.println("===================");
		
		getListOfPlatinumAlumniStudents(studentList).forEach(System.out::println);	
		
		System.out.println("===================");
		int[] intArray = {7,5,35, 28, 25,21};
		
		printHelloWorld(intArray);
		System.out.println("===================");
		System.out.println("Second biggest integer is " + findSecondBiggest(intArray));
		
		
	}
	
	public static void printListOfStudents(Student[] stu) {
		if(stu==null|| stu.length==0) {
			System.out.println("No list of students provided");
		}

		List<Student> stds= Stream.of(stu)
				.sorted(Comparator.comparing(Student::getName)).collect(Collectors.toList());
		stds.forEach(System.out::println);
	}


public static List<Student> getListOfPlatinumAlumniStudents(Student[] stu){
	
	List<Student> stds=Stream.of(stu).filter(s->LocalDate.now().getYear()-s.getDateOfAdmission().getYear()>=30)
			.sorted(Comparator.comparing(Student::getDateOfAdmission).reversed()).collect(Collectors.toList());

return stds;
}

public static void printHelloWorld(int[] intArr) {
	for (int i : intArr) {
		if(i%5==0) System.out.println("Hello");
		if(i%7==0) System.out.println("World");
		if(i%5==0 && i%7==0 ) System.out.println("Hello World");
	}
	
}

public static int findSecondBiggest(int[] intArr) {
	int fBiggest=intArr[0];
	int sBiggest=intArr[1];
	int temp=0;
	for (int i = 1; i < intArr.length; i++) {
			if(intArr[i]>fBiggest) {
				temp=fBiggest;
				fBiggest = intArr[i];
				sBiggest=temp;
				}else if(intArr[i]<fBiggest) {
					if(intArr[i]>sBiggest) {
						sBiggest=intArr[i];
					}
					
				}
			
		}
	
	return sBiggest;
}

}






