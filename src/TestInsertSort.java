public class TestInsertSort {
    public static void InsertSort(int[]a){
        int x=a.length;
        for(int i=1;i<x;i++){
            for(int j=i;j>0&&a[j-1]>a[j];j--){
                int temp=a[j];
                a[j]=a[j-1];
                a[j-1]=temp;
            }
        }
    }

    public static void main(String[]args){
        
    }
}
