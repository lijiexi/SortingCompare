package suanyanTech.teachAssist;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

public class ChartPn extends JPanel {
	private ArrayList<Element> nums = new ArrayList<Element>();
	private ArrayList<Element> numd = new ArrayList<Element>();
	private int downst;
	private String sortkind = "";
	private int paintkind=0;// 0 for normal; 1 for merge; 2 for quick; 3 for heap 
    
	private int linewid=0;
	private int ltrwid=0;
	private int linestand;

	public ChartPn(ArrayList<Element> eles) {
		int id, val;
		for (int i = 0; i < eles.size(); i++) {
			id = eles.get(i).getId();
			val = eles.get(i).getVal();
			nums.add(new Element(id, val));
		}
	}
	
	private void normal(Graphics g) {
		g.drawString(sortkind, 5, 15);
		int stx = 5;
		int sty = getHeight() - 15;
		int preHei = (getHeight() - 15) / 20;
		int barWid = (getWidth() - 10) / 10;
		int id, val;
		Color col;
		Iterator<Element> it = nums.iterator();
		Element cur = null;
		int i = 0;

		while (it.hasNext()) {
			cur = it.next();
			id = cur.getId();
			val = cur.getVal();
			col = cur.getCol();
			g.setColor(col);
			g.drawRect(stx + i * barWid, sty - preHei * val, barWid, preHei * val);
			g.drawString(String.valueOf(cur.getId()), stx + i * barWid + 2, sty + 10);
			i++;
		}
	}
	
	private void quick(Graphics g) {
		normal(g);
		
		int barWid = (getWidth() - 10) / 10;
		int sx=5+ltrwid*barWid;
		int ex=linewid*barWid+sx;
		int sy=(getHeight() - 15)-((getHeight() - 15) / 20)*linestand;
		int ey=sy;
		g.setColor(Color.RED);
		g.drawLine(sx,sy, ex, ey);
	}
	
	private void merge(Graphics g) {
		g.drawString(sortkind, 5, 15);
		int ustx = 5;
		int usty = (getHeight() - 15) / 2;
		int barWid = (getWidth() - 10) / 10;
		int dstx = 5 + downst * barWid;
		int dsty=getHeight() - 15;
		int preHei = (getHeight() - 15) / 20 / 2;
		int id, val;
		Color col;
		Iterator<Element> it = nums.iterator();
		Element cur = null;
		int i = 0;
		while (it.hasNext()) {
			cur = it.next();
			id = cur.getId();
			val = cur.getVal();
			col = cur.getCol();
			g.setColor(col);
			g.drawRect(ustx + i * barWid, usty - preHei * val, barWid, preHei * val);
			g.drawString(String.valueOf(id), ustx + i * barWid + 2, usty + 10);
			i++;
		}
       
		if(numd!=null) {
			int did, dval;
			Color dcol;
			Iterator<Element> dit =numd.iterator();
			Element dcur = null;
			int di = 0;
			while (dit.hasNext()) {
				dcur = dit.next();
				did = dcur.getId();
				dval = dcur.getVal();
				dcol =dcur.getCol();
				g.setColor(dcol);
				g.drawRect(dstx + di * barWid, dsty - preHei * dval, barWid, preHei *dval);
				g.drawString(String.valueOf(did), dstx + di * barWid + 2, dsty + 10);
				di++;
			}	
		}
		
		g.setColor(Color.BLACK);
		g.drawLine(ustx, usty, ustx + 10 * barWid, usty);
		g.drawLine(5, getHeight() - 15, ustx + 10 * barWid, getHeight() - 15);
	}

	public void paint(Graphics g) {
		super.paint(g);

		if (paintkind==0) {
			normal(g);
		} 
		else if(paintkind==1){
			merge(g);
		}else if(paintkind==2) {
			quick(g);
		}

	}

	public void setHalf(ArrayList<Element> up, ArrayList<Element> down, int ds) {
		this.nums = up;
		this.numd = down;
		this.downst = ds;
		this.paintkind=1;
		super.repaint();
	}

	public void recover(ArrayList<Element> up) {
		this.nums = up;
		this.paintkind=0;
		super.repaint();
	}
   
	public void setQuick(ArrayList<Element> Nums,int ltrnum,int standard,int len) {
		this.nums=Nums;
		this.ltrwid=ltrnum;
		this.linestand=standard;
		this.linewid=len;
	}
	
	public void setSortKind(String kind,int paintkind) {
		this.sortkind = kind;
		this.paintkind=paintkind;
		super.repaint();
	}

	public void setNums(ArrayList<Element> modNums) {
		nums = modNums;
		super.repaint();
	}

	public ArrayList<Element> getNums() {
		return this.nums;
	}

}
