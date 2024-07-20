package modelos;

public class Constructors {
	private int constructorId;
	private String constructorRef;
	private String name;
	private String nationality;
	private String url;
	
	public Constructors(int constructorId, String constructorRef, String name, String nationality, String url) {
		super();
		this.constructorId = constructorId;
		this.constructorRef = constructorRef;
		this.name = name;
		this.nationality = nationality;
		this.url = url;
	}

	public int getConstructorId() {
		return constructorId;
	}

	public void setConstructorId(int constructorId) {
		this.constructorId = constructorId;
	}

	public String getConstructorRef() {
		return constructorRef;
	}

	public void setConstructorRef(String constructorRef) {
		this.constructorRef = constructorRef;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
    public String toString() {
        return String.format("%-10d %-15s %-20s %15s %-30s",
                constructorId, constructorRef, name, nationality, url);
    }
	
}
