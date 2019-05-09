package suanyanTech.teachAssist;

import java.awt.Color;

public class Element {
    
	private int id;
	private int val;
	private Color col=Color.BLACK;
	
	
	public Element(int theid,int theval) {
		// TODO Auto-generated constructor stub
		this.id=theid;
		this.val=theval;
	}
	public Element(int theid,int theval,Color cor) {
		// TODO Auto-generated constructor stub
		this.id=theid;
		this.val=theval;
        this.col=cor;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getVal() {
		return val;
	}


	public void setVal(int val) {
		this.val = val;
	}


	public Color getCol() {
		return col;
	}


	public void setCol(Color col) {
		this.col = col;
	}
}
