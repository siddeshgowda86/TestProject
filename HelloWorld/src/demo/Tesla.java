package demo;

import java.util.*;



class Tesla{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value of n");
        int n=sc.nextInt();
        int[] diffs=new int[n];
       // int max=diffs[0];
        //int min=diffs[0];
        System.out.println("Enter array elements");
        for(int i=0;i<n;i++)
        {
            diffs[i]=sc.nextInt();
        }
        System.out.println("Array Elements are");
        for(int i:diffs){
        	
        	System.out.println(i);
        	
        }
        
        
       int[] ans=tesla(n,diffs);
      // System.out.println(ans[0]+" "+ans[1]);
        
       
    }

    static int[] tesla(int n,int[] diffs){

        int[] ans=new int[n];
        int ispeed=1500;

        int max=ans[0];
        int min=ans[0];
         for(int i=0;i<ans.length;i++){
            ans[0]=ispeed+diffs[0];
            ans[1]=ans[0]+diffs[1];
            ans[2]=ans[1]+diffs[2];
            ans[3]=ans[2]+diffs[3];
            ans[4]=ans[3]+diffs[4];
         }
         for(int i=0;i<n;i++) {
        	 System.out.println(ans[i]);
         }
         for(int i=1;i<ans.length;i++){
            if(ans[i]>max)
            {
                max =ans[i];
                
            }
         }
         System.out.println("max"+max);
         for(int i=1;i<ans.length;i++) {
            if(ans[i]<min)
            {
                min= ans[i];
               
         }
         }
            System.out.println("min" +min);
         
        return ans;
    }
}

	
