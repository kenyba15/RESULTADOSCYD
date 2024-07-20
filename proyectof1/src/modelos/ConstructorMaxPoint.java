package modelos;

public class ConstructorMaxPoint {
	private String Constructorname;
	private float points;
	
	public ConstructorMaxPoint(String constructorname, float points) {
		super();
		Constructorname = constructorname;
		this.points = points;
	}
	public String getConstructorname() {
		return Constructorname;
	}
	public void setConstructorname(String constructorname) {
		Constructorname = constructorname;
	}
	public float getPoints() {
		return points;
	}
	public void setPoints(float points) {
		this.points = points;
	}

	
}
