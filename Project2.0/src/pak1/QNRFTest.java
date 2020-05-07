package pak1;

import java.util.ArrayList;
import java.io.*;



public class QNRFTest {

	private static ArrayList<Project> Projects= new ArrayList<Project>();
	private static ArrayList<Researcher> Researchers= new ArrayList<Researcher>(); 
	// getter
	public ArrayList<Researcher> getResearcher() {
		return Researchers;
	}

	public ArrayList<Project> getProjects() {
		return Projects;
	}


	// The implemntations


	@SuppressWarnings("unchecked")
	public void ReadFile ()
	{
		FileInputStream cin = null;
		try {
			cin= new FileInputStream("Projects.oob");
			ObjectInputStream in = new ObjectInputStream(cin);
			Projects= (ArrayList<Project>) in.readObject();
			cin.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		try {
			cin= new FileInputStream("Researchers.oob");
			ObjectInputStream in = new ObjectInputStream(cin);
			Researchers= (ArrayList<Researcher>) in.readObject();
			cin.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	public void SaveFiles ()
	{
		if(Projects==null)throw new NullPointerException("The projects ArrayList is null");
		else{
		
				FileOutputStream fout;
				try {
					fout = new FileOutputStream("Projects.oob");
					ObjectOutputStream oos= new ObjectOutputStream(fout);
					oos.writeObject(Projects);
					fout.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			
		}
		
		
		if(Researchers==null)throw new NullPointerException("The projects ArrayList is null");
		else{
		
				FileOutputStream fout;
				try {
					fout = new FileOutputStream("Researchers.oob");
					ObjectOutputStream oos= new ObjectOutputStream(fout);
					oos.writeObject(Researchers);
					fout.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			
		}
	}



	

	public boolean newRA(String name, int ID,Type type, int hours)
	{
		boolean x=true;
		if(!Researchers.isEmpty())
			for(Researcher R : Researchers)
			{
				if(ID==R.getId())
					x=false;
			}
		if(x)
		{
			RA researcher=new RA();
			researcher.setTitle(name);
			researcher.setId(ID);
			researcher.setHours(hours);
			researcher.setType(type);
			researcher.setTyp("RA");
			Researchers.add(researcher);
			return x;
		}
		return x;
	}


	public boolean newUnder(String name, int ID,String Major)
	{
		boolean x=true;
		for(int i=0; i<Researchers.size();i++)
		{
			if(ID==Researchers.get(i).getId())
				x=false;
		}
		if(x)
		{
			UnderGraduate researcher=new UnderGraduate();
			researcher.setTitle(name);
			researcher.setId(ID);
			researcher.setMajor(Major);
			researcher.setTyp("UnderGraduate");
			Researchers.add(researcher);
			return x;
		}
		return x;
	}

	public boolean newFaculty(String name, int ID, int salary)
	{
		boolean x=true;
		for(int i=0; i<Researchers.size();i++)
		{
			if(ID==Researchers.get(i).getId())
				x=false;
		}
		if(x)
		{
			Faculty researcher=new Faculty();
			researcher.setTitle(name);
			researcher.setId(ID);
			researcher.setSalary(salary);
			researcher.setTyp("Faculty");
			Researchers.add(researcher);
			return x;
		}
		return x;


	}

	public boolean newPostDoc(String name, int ID, int salary)
	{
		boolean x=true;
		for(int i=0; i<Researchers.size();i++)
		{
			if(ID==Researchers.get(i).getId())
				x=false;
		}
		if(x)
		{
			Post_Doc researcher=new Post_Doc();
			researcher.setTitle(name);
			researcher.setId(ID);
			researcher.setSalary(salary);
			Researchers.add(researcher);
			researcher.setTyp("Post_Doc");
			return x;
		}
		return x;


	}


	/*public String SearchByResearcher(Researcher researcher)
	{
		String string="";

		for(int i=0; i<Projects.size();i++)
		{
			for(int j=0; j<Projects.get(i).getTeam().size();j++)
			{
				if(Projects.get(i).getTeam().get(j).getId()==researcher.getId())
				{
					string+=new String(Projects.get(i).toString());
					string+="\n\n";
				
				}
			}
		}
		return string;
	}*/

	public String CostOfAProject(Project project)
	{

		String string="";
		int i=0;
		for(; i<Projects.size();i++)
			if(Projects.get(i).getId()==project.getId())
				break;

		string+=new String(Projects.get(i).toString()+": \n\n");

		for(int j=0; j<Projects.get(i).getTeam().size();j++)
		{
			string+=new String(Projects.get(i).getTeam().get(j).toString()+"  Payment= "+(Projects.get(i).getTeam().get(j).getPayment(Projects.get(i))));
			string+=" \n 	}\n\n";
		}

		return string;
	}

	public String CostOfAllProjects()
	{
		String string="";

		for(int i=0; i<Projects.size();i++)
		{
			string+=new String(Projects.get(i).toString()+": \n");

			for(int j=0; j<Projects.get(i).getTeam().size();j++)
			{
				string+= (Projects.get(i).getTeam().get(j).toString()+"Payment= "+Projects.get(i).getTeam().get(j).getPayment(Projects.get(i))+"\n\n");
			}
		}
		return string;
	}

	
	public Double CalculatePayment(Researcher researcher, Project project)
	{
		return researcher.getPayment(project);
	}

	public ArrayList<Researcher> getUREP()
	{
		ArrayList <Researcher> arr= new ArrayList <Researcher>();
		for(Researcher r: Researchers) 
			if(r instanceof Faculty || r instanceof UnderGraduate )
				arr.add(r);
		return arr;
	}

	public ArrayList<Researcher> getNPRP()
	{
		ArrayList <Researcher> arr= new ArrayList <Researcher>();
		for(Researcher r: Researchers) 
			if(!(r instanceof UnderGraduate) )
				arr.add(r);
		return arr;
	}





}

