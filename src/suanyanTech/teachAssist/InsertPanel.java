package suanyanTech.teachAssist;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

public class InsertPanel extends ChartPn implements Runnable {

	public InsertPanel(ArrayList<Element> eles) {
		// TODO Auto-generated constructor stub
		super(eles);
		setSortKind("Insert Sort",0);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		ArrayList<Element> ls = getNums();
		int len = ls.size();

		ls.get(1).setCol(Color.BLUE);
		setNums(ls);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int cur = 2; cur < len; cur++) {
			Collections.swap(ls, cur, 0);
			for(int i=1;i<cur;i++) {
				ls.get(i).setCol(Color.BLUE);
			}
			setNums(ls);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int curnum=ls.get(0).getVal();
			int p = 1;
			for (; p< cur; p++) {
                  if(ls.get(p).getVal()>curnum)
                	  break;
			}
			
			for(int j=cur;j>p;j--) {
				Collections.swap(ls, j, j-1);
				setNums(ls);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
			Collections.swap(ls, p, 0);
			ls.get(p).setCol(Color.BLUE);
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
