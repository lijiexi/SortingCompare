package suanyanTech.teachAssist;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class BubblePanel extends ChartPn implements Runnable {

	public BubblePanel(ArrayList<Element> eles) {	
		// TODO Auto-generated constructor stub
		super(eles);
		setSortKind("Bubble Sort",0);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		ArrayList<Element> ls = super.getNums();

		int len = ls.size();
		
		for (int loop = 0; loop < len-2; loop++) {
			int i=1;
			ls.get(1).setCol(Color.RED);
			for (; i + 1 < len - loop; i++) {
				ls.get(i - 1).setCol(Color.BLACK);
				ls.get(i + 1).setCol(Color.RED);
				setNums(ls);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (ls.get(i).getVal() > ls.get(i + 1).getVal()) {
					Collections.swap(ls, i, i + 1);
					setNums(ls);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			ls.get(len-2-loop).setCol(Color.BLACK);
			ls.get(len-1-loop).setCol(Color.BLUE);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setNums(ls);
		}
		ls.get(1).setCol(Color.BLUE);
		setNums(ls);
	}

}
