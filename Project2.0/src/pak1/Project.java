package pak1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

@SuppressWarnings("serial")
public  abstract class Project implements Serializable {
	

	private int id;
	private String title;
	private int duration;
	private Calendar startDate;
	private String status;
	private ArrayList<Researcher> team ;
	public abstract  double PersonnelCost(); 
	
	
	
	public void AddResearcher(Researcher x)
	{
		team.add(x);
	}

	
	@Override
	public String toString() {
		return "Project [ id= " + id + ", title= " + title + ", duration= "
				+ duration  + ", status= " + status
				+ ", team= " + team.size() +"\nstartDate= "+startDate.getTime() +"]\n";
	}
	
	public String toSave(){
		return  String.format(getTitle()+","
				+ getId()+","
				+ getDuration()+","
				+ getStartDate().toString()+","  
				+ getStatus() +","
				+ getTeam().size()  +",");
			
		}
	
	
	// Getters And Setters
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public int getDuration() {
		return duration;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public String getStatus() {
		return status;
	}

	
	public ArrayList<Researcher> getTeam() {
		return team;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTeam(ArrayList<Researcher> team) {
		this.team = team;
	}
	
	
	
	
}
