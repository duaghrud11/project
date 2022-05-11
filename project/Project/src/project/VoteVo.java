package project;


public class VoteVo {
	
	private String im;
	private int menu_num;
	private int vote_num;
	
	
	
	
	
	
	public String getIm() {
		return im;
	}






	public void setIm(String im) {
		this.im = im;
	}






	public VoteVo(String im) {
		super();
		this.im = im;
	}






	public VoteVo(int vote_num) {
		super();
		
		this.vote_num = vote_num;
	}

	public VoteVo(String im, int vote_num) {
		super();
		this.im = im;
		this.vote_num = vote_num;
	
	}
	
	
	public VoteVo(int menu_num, int vote_num) {
		super();
		this.menu_num = menu_num;
		this.vote_num = vote_num;
	}


	public int getMenu_num() {
		return menu_num;
	}


	public void setMenu_num(int menu_num) {
		this.menu_num = menu_num;
	}


	public int getVote_num() {
		return vote_num;
	}


	public void setVote_num(int vote_num) {
		this.vote_num = vote_num;
	}


	@Override
	public String toString() {
		return im + "=====> " + vote_num +"ǥ";
	}
	
	
	
	
	
}