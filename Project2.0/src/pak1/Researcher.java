package pak1;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class Researcher implements Serializable {
	
	@Override
	public String toString() {
		return String.format("Researcher  \n  id= %s,\n  Title= %s\n", id, Title);
	}

	private	int id;
	private String Title;
	private String Typ;
	public abstract double getPayment(Project x);
	
	public String toSave(){
		return  String.format(getTitle()+","
				+ getId()+","+getTyp()+",");
			
		}
	
	
	// Getters And Setters
	public int getId() {
		return id;
	}

	public String getTitle() {
		return Title;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getTyp() {
		return Typ;
	}

	public void setTyp(String type) {
		Typ = type;
	}

}
