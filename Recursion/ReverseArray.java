public class ReverseArray {
    public static void reverseArray(int arr[]) {
        // code here
        f(0,arr);
    }
    
    static void f(int i,int[] arr){
        if(i>=arr.length/2) return;
        
        int t=arr[i];
        arr[i]=arr[arr.length-1-i];
        arr[arr.length-1-i]=t;
        
        f(i+1,arr);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reverseArray(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}