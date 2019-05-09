package suanyanTech.teachAssist;

import java.awt.GridLayout;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;

public class SortHome {
	
	public static void main(String[] args) {
		ArrayList<Element> nums=new ArrayList<Element>();
		nums.add(new Element(0,0));
		for(int i=1;i<10;i++) {
			nums.add(new Element(i,(int) (Math.random() * 100000) % 20 + 1));
		}
		
	   BubblePanel bp=new BubblePanel(nums);
	   SelectPanel sp=new SelectPanel(nums);
	   InsertPanel ip=new InsertPanel(nums);
	   ShellPanel shp=new ShellPanel(nums);
	   MergePanel mp=new MergePanel(nums);
	   QuickPanel qp=new QuickPanel(nums);
	   
	      
	   JFrame fm=new JFrame("Teach Assist");
	   fm.setLayout(new GridLayout(2,3));
	   fm.add(bp);
	   fm.add(sp);
	   fm.add(ip);
	   fm.add(shp);
	   fm.add(mp);
	   fm.add(qp);
	
	   fm.setSize(400,300);
	   fm.setLocationRelativeTo(null);
	   fm.setVisible(true);
	   
        
       Thread bt=new Thread(bp);
       Thread st=new Thread(sp);
       Thread it=new Thread(ip);
       Thread sht=new Thread(shp);
       Thread mt=new Thread(mp);
       Thread qt=new Thread(qp);
	   bt.start();
	   st.start();
	   it.start();
	   sht.start();
	   mt.start();
	   qt.start();
	}
}
