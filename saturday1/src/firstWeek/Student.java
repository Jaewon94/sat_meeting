package firstWeek;

import java.io.Serializable;

public class Student implements Comparable<Student>,Serializable {

	private static final long serialVersionUID = 6185737144872509403L;
	private static int count = 1001;
	private int idx; 
	private String name;
	private int kor, eng, mat, total;
	private double avg;
	private char grade;
	private int rank;
	
	public Student(String name, int kor, int eng, int mat) {
		idx = count++;
		this.name = name;
		this.kor =kor;
		this.eng = eng;
		this.mat = mat;
		
		this.total = kor+eng+mat;
		this.avg = total / 3.0;
		if(avg >= 90) {
			grade = 'A';
		} else if (avg >= 80) {
			grade = 'B';
		} else if (avg >= 70) {
			grade = 'C';
		} else if (avg >= 60) {
			grade = 'D';
		} else {
			grade = 'F';
		}
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Student.count = count;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	@Override
	public String toString() {
		return String.format(" %s (평균 : %.2f, 학점 : %c학점)",name, avg, grade);
	}

	@Override
	public int compareTo(Student o) {
		return o.total -this.total;
	}

}