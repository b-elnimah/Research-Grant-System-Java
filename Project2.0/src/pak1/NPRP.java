package pak1;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class NPRP extends Project{
		
	public NPRP() {
		super.setTeam(new ArrayList<Researcher>());
		// TODO Auto-generated constructor stub
	}

	private Researcher Lead_PI;
	
	
	public double PersonnelCost() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	
	// Getters And Setters
	public Researcher getLead_PI() {
		return this.Lead_PI;
	}

	public void setLead_PI(Researcher Lead_PI) {
		this.Lead_PI = Lead_PI;
	}

}
