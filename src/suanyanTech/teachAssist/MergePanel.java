package suanyanTech.teachAssist;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

public class MergePanel extends ChartPn implements Runnable {

	private ArrayList<Element> ls;

	public MergePanel(ArrayList<Element> eles) {
		// TODO Auto-generated constructor stub
		super(eles);
		setHalf(eles, null, 0);
		setSortKind("Merge Sort",1);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		ls = getNums();
		int len=ls.size();
		MSort(1,len-1);
		//MSort(1,3);
		for(int i=1;i<len;i++)
			ls.get(i).setCol(Color.BLUE);
		recover(ls);
	}

	private void MSort(int i, int j) {
		if (i >= j) {
			ls.get(i).setCol(Color.GREEN);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setHalf(ls,null,0);
			ls.get(i).setCol(Color.BLACK);
			return;
		}
			

		if (j == i + 1) {
			ls.get(i).setCol(Color.GREEN);
			ls.get(i+1).setCol(Color.GREEN);
			setHalf(ls,null,i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if (ls.get(i).getVal() > ls.get(i + 1).getVal()) {
				Collections.swap(ls, i, i + 1);
				setHalf(ls,null,i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	         
			ls.get(i).setCol(Color.BLACK);
			ls.get(i+1).setCol(Color.BLACK);
			return;
		}

		int mid = (i + j) / 2;
		MSort(i, mid);
		MSort(mid + 1, j);
        
		
		ArrayList<Element> dls = new ArrayList<Element>();
        dls.clear();
		int a = i;
		int b = mid + 1;
		while (a <= mid && b <= j) {
			if (ls.get(a).getVal() <= ls.get(b).getVal()) {
				//dls.add(ls.get(a));
				dls.add(new Element(ls.get(a).getId(),ls.get(a).getVal(),Color.red));
				
				ls.get(a).setCol(Color.RED);
				setNums(ls);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ls.get(a).setVal(0);
				setHalf(ls, dls, i);
				a++;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				//dls.add(ls.get(b));
				dls.add(new Element(ls.get(b).getId(),ls.get(b).getVal(),Color.red));
				
				ls.get(b).setCol(Color.RED);
				setNums(ls);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ls.get(b).setVal(0);
				setHalf(ls, dls, i);
				b++;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if(a>mid) {
			for(;b<=j;b++) {
				//dls.add(ls.get(b));
				dls.add(new Element(ls.get(b).getId(),ls.get(b).getVal(),Color.red));
				
				ls.get(b).setCol(Color.RED);
				setNums(ls);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				ls.get(b).setVal(0);
				setHalf(ls, dls, i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else if(b>j){
			for(;a<=mid;a++) {
				//dls.add(ls.get(a));
				dls.add(new Element(ls.get(a).getId(),ls.get(a).getVal(),Color.red));
				
				ls.get(a).setCol(Color.RED);
				setNums(ls);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ls.get(a).setVal(0);
				setHalf(ls,dls,i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		int m=0;
	    for(int k=i;k<=j;k++) {
	    	ls.get(k).setVal(dls.get(m).getVal());
	    	ls.get(k).setId(dls.get(m).getId());
	    	ls.get(k).setCol(Color.BLACK);
	    	//ls.get(k).setCol(Color.BLUE);
	    	dls.get(m).setVal(0);
	    	m++;
	    }
	    
	    setHalf(ls,dls,i);
	    try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	}

}
