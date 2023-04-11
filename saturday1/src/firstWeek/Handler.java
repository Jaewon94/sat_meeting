package firstWeek;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class Handler {
	ArrayList<Student> list = new ArrayList<>();
	File f = null;
	public Handler() {
		f = new File("Student.dat");
		
		if(f.exists()) {
			list = load();
		}
	}
	
	@SuppressWarnings("unchecked")
	private ArrayList<Student> load(){
		ArrayList<Student> tmp = null;
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream(f));
			tmp = (ArrayList<Student>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally{
			try{ ois.close(); } catch (Exception e) {}
		}
		
		return tmp;
	}
	
	public void save() {
		if (f.exists()) {
				f.delete();
			}
		try {
			
			
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(list);
			oos.close();
			fos.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int insert(Student st) {
		int result =0;
		if (list.add(st))  {
			result = 1;
		}
		
		return result;
	}
	
	public ArrayList<Student> selectAll() {
		list.sort(null);
		return list;
	}
	public Student selectOne(String name) {
		Student tmp = null;
		for(int i=0;i<list.size();i++) {
			if (name.equals(list.get(i).getName())) {
				tmp = list.get(i);
			}
		}
		return tmp;
	}
	
	public int delete(String name) {
		int result =0;
		for(int i=0; i<list.size();i++) {
			if(name.equals(list.get(i).getName())) {
				list.remove(i);
				result =1;
				break;
			}
		}
		return result;
	}
	
	public void deleteAll() {
		for(int i=list.size()-1; i>=0;i--) {
			list.remove(i);
			}
	}
	


}