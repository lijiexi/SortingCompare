package suanyanTech.teachAssist;

import java.awt.Color;
import java.util.ArrayList;

public class QuickPanel extends ChartPn implements Runnable{
    private ArrayList<Element> ls;
    
	public QuickPanel(ArrayList<Element> eles) {
		// TODO Auto-generated constructor stub
		super(eles);
		setSortKind("Quick Sort",2);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		ls=getNums();
		int len=ls.size();
		quick(1,len-1);
		
		ls.get(0).setCol(Color.BLACK);
		for(int i=1;i<len;i++)
			ls.get(i).setCol(Color.BLUE);
		recover(ls);
	}
	
	private void quick(int head,int end) {
		  
		if(head>=end)
			return;
		 
		 int standard=ls.get(head).getVal();
		 ls.get(head).setCol(Color.RED);
		  ls.get(0).setCol(Color.red);   
		  try {
			Thread.sleep(300);
		 } catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		 }
		  replace(0,head);
	      setQuick(ls,head,standard,end-head+1);
         ls.get(head).setCol(Color.BLACK);
         setNums(ls);
	      
         int left=head;
         int right=end;
         
         while(left<right) {
        	 while(left<right&&ls.get(right).getVal()>=standard) {
        		 ls.get(right).setCol(Color.PINK);
        		 setNums(ls);
        		 try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		 ls.get(right).setCol(Color.BLACK);
        		 right--;	 
        	 }
        	 ls.get(right).setCol(Color.PINK);
        	 setNums(ls);
        	 try {
				Thread.sleep(500);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
        	//ls.get(right).setCol(Color.BLACK);
        	 
        
        	 if(right!=left) {
        		 ls.get(left).setCol(Color.GREEN); 
            	 ls.get(right).setCol(Color.GREEN);
            	 replace(left,right);
            	 setNums(ls);
            	 try {
    				Thread.sleep(500);
    			} catch (InterruptedException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}	  	 
        	 }
        	 ls.get(left).setCol(Color.BLACK); 
        	 ls.get(right).setCol(Color.BLACK); 
         	 setNums(ls);
        
        	 while(left<right&&ls.get(left).getVal()<standard) {
        		 ls.get(left).setCol(Color.YELLOW);
        		 setNums(ls);
        		 try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		 ls.get(left).setCol(Color.BLACK);
        		 left++;
        	 }
        	 ls.get(left).setCol(Color.YELLOW);
        	 setNums(ls);
        	 try {
 				Thread.sleep(500);
 			} catch (InterruptedException e2) {
 				// TODO Auto-generated catch block
 				e2.printStackTrace();
 			}
        	 
        	 if(right!=left) {
        		 ls.get(left).setCol(Color.GREEN); 
            	 ls.get(right).setCol(Color.GREEN);
            	 replace(right,left);
            	 setNums(ls);
            	 try {
    				Thread.sleep(500);
    			} catch (InterruptedException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}	
        	 }
        	 ls.get(left).setCol(Color.BLACK); 
        	 ls.get(right).setCol(Color.BLACK); 
         	 setNums(ls); 
        	 
         }
         
         replace(left,0);
         ls.get(0).setVal(0);
         ls.get(0).setId(0);
         setNums(ls);	
         
         quick(head,left);
         quick(left+1,end);
	}
	
	private void replace(int i,int j) {
		   ls.get(i).setId(ls.get(j).getId());
	       ls.get(i).setVal(ls.get(j).getVal());
	}
	

}
