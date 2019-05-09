package suanyanTech.teachAssist;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

public class ShellPanel extends ChartPn implements Runnable {

	private final Color[] cols = { null, Color.BLUE, Color.RED, Color.orange};

	public ShellPanel(ArrayList<Element> eles) {
		// TODO Auto-generated constructor stub
		super(eles);
		setSortKind("Shell Sort",0);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		ArrayList<Element> ls = getNums();
		int len = ls.size();
		// 3
		// 2 yellow
		// 1 blue
		for (int wid = 3; wid > 0; wid--) {
			ls.get(1).setCol(cols[wid]);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int cur = 1+wid; cur < len; cur += wid) {
                Collections.swap(ls,cur,0);
                for(int i=1;i<cur;i+=wid) {
                	ls.get(i).setCol(cols[wid]);
                }
                setNums(ls);
                try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
                int curnum=ls.get(0).getVal();
                int p=1;
                for(;p<cur;p+=wid) {
                	if(ls.get(p).getVal()>curnum)
                		break;
                }
                for(int j=cur;j>p;j-=wid) {
                	 Collections.swap(ls, j, j-wid);
                	 setNums(ls);
                	 try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
                Collections.swap(ls, p, 0);
                ls.get(p).setCol(cols[wid]);
                setNums(ls);  
                try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
