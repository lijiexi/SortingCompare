package suanyanTech.teachAssist;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class SelectPanel extends ChartPn implements Runnable{

	public SelectPanel(ArrayList<Element> eles) {
	    super(eles);
	    setSortKind("Select Sort",0);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		ArrayList<Element> ls=getNums();
		int loop=0;
		int len=ls.size();
		
      for( ;loop<len-2;loop++) {
  	    int minid=1+loop;
  	    int min=ls.get(minid).getVal();	    
  		for(int i=minid+1;i<len;i++) {
  			 ls.get(i).setCol(Color.green);
  			 ls.get(minid).setCol(Color.red);
  			    setNums(ls);
  			    try {
  					Thread.sleep(1000);
  				} catch (InterruptedException e) {
  					// TODO Auto-generated catch block
  					e.printStackTrace();
  				}
  			
  		    if(ls.get(i).getVal()<min) {
  		    	ls.get(minid).setCol(Color.BLACK);
  		    	ls.get(i).setCol(Color.red);
  			    setNums(ls);
  			    try {
  					Thread.sleep(1000);
  				} catch (InterruptedException e) {
  					// TODO Auto-generated catch block
  					e.printStackTrace();
  				}
  			    min=ls.get(i).getVal();
  		    	minid=i;
  		    } 
  		    ls.get(i).setCol(Color.BLACK);
  		}
  		
  		Collections.swap(ls,1+loop, minid);
  		ls.get(1+loop).setCol(Color.BLUE);
  		ls.get(len-1).setCol(Color.BLACK);
      }
      ls.get(len-1).setCol(Color.BLUE);
      setNums(ls);
	}

}
