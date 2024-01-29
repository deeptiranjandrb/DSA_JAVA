import java.io.*;
import java.util.*;

class Pair {
    int first, second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
public class Solution {
    public static void main(String[] args){
        System.out.println("Printing the solution");
        int n = 100;
        HashMap<Integer, ArrayList<Pair>> store = new HashMap<Integer, ArrayList<Pair>>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int result = i * i * i + j * j * j;
                if(store.containsKey(result)){
                   store.get(result).add(new Pair(i, j));
                }else{
                    ArrayList<Pair> list = new ArrayList<Pair>();
                    list.add(new Pair(i, j));
                    store.put(result, list);
                }
                
            }
        }
        store.forEach((key, value) -> {
           for(int i = 0; i < value.size(); i++){
               for(int j = 0; j < value.size(); j++){
                   System.out.println("pairs:("+value.get(i).first+","+value.get(i).second+"), ("+value.get(j).first+","+value.get(j).second+")");
               }
           }
        });
        //System.out.println("mappings of the elements are: " + store);
    }
}