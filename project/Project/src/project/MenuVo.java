package project;

public class MenuVo {
	private long nember;
	private String tour;
	
	
	public MenuVo() {}
	
	public MenuVo( String tour) {
		super();
		this.nember = nember;
		this.tour = tour;
	}
	
	
	public MenuVo(long nember, String tour) {
		super();
		this.nember = nember;
		this.tour = tour;
	}

	public long getNember() {
		return nember;
	}

	public void setNember(long nember) {
		this.nember = nember;
	}

	public String getTour() {
		return tour;
	}

	public void setTour(String tour) {
		this.tour = tour;
	}

	@Override
	public String toString() {
		return nember +"."+ tour;
	}
	
	
	

}
