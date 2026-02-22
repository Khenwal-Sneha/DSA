class Solution {
    static int lis(int arr[]) {
       List<Integer> li=new ArrayList<>();
       for(int i=0;i<arr.length;i++){
           bs(li,arr[i]);
       }
       return li.size();
    }
    
    static void bs(List<Integer> li,int n){
        if(li.size()==0){
            li.add(n);
            return;
        }
        
        if(li.get(li.size()-1)<n) li.add(n);
        
        int l=0;
        int h=li.size()-1;
        while(l<=h){
            int m=(l+h)/2;
            
            if(li.get(m)==n) return;
            else if(li.get(m)<n){
                l=m+1;
            }else h=m-1;
        }
        li.set(l,n);
    }
}