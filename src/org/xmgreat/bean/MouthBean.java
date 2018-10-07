package org.xmgreat.bean;

public class MouthBean {
      private int oneweek;
  	  private int twoweek;
      private int triweek;
      private int fourweek;
      private int fivweek;
      public MouthBean(int oneweek, int twoweek, int triweek, int fourweek, int fivweek) {
		super();
		this.oneweek = oneweek;
		this.twoweek = twoweek;
		this.triweek = triweek;
		this.fourweek = fourweek;
		this.fivweek = fivweek;
	}
	public int getOneweek() {
		return oneweek;
	}
	public void setOneweek(int oneweek) {
		this.oneweek = oneweek;
	}
	public int getTwoweek() {
		return twoweek;
	}
	public void setTwoweek(int twoweek) {
		this.twoweek = twoweek;
	}
	public int getTriweek() {
		return triweek;
	}
	public void setTriweek(int triweek) {
		this.triweek = triweek;
	}
	public int getFourweek() {
		return fourweek;
	}
	public void setFourweek(int fourweek) {
		this.fourweek = fourweek;
	}
	public int getFivweek() {
		return fivweek;
	}
	public void setFivweek(int fivweek) {
		this.fivweek = fivweek;
	}

}
