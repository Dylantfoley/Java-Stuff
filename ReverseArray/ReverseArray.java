package MinElementInArray;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] array = {6,4,32,21,6,7,8,3,12,77};
        System.out.println(Arrays.toString(array) + "is normal order");
        int i;
        int count = 0;
        int[] revArray = new int[array.length];
        for(i= array.length-1; i >= 0; i--){
            revArray[count] = array[i];
            count++;
        }
        System.out.println(Arrays.toString(revArray) + "is reversed order");
        }
    }

