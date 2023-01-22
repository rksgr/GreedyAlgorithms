import java.util.Scanner;

public class MinRefills {
    static int minRefills(int tot_dist, int max_dist_full_tank, int [] stops){
        int minRefills = 0;
        if( stops[0] > max_dist_full_tank) return -1;
        int dist_with_rem_fuel = max_dist_full_tank - stops[0];
        for(int i = 0; i < (stops.length - 1); i++){
            // If distance between two stops is more than
            // what could be travelled with tank full
            if((stops[ i + 1] - stops [ i]) > max_dist_full_tank) return -1;
            if(( stops[ i + 1] - stops[ i ]) <= dist_with_rem_fuel){
                dist_with_rem_fuel -= ( stops[ i + 1] - stops[ i ]);
            }else{
                dist_with_rem_fuel = max_dist_full_tank - (stops[ i + 1] - stops[ i ]);
                minRefills++;
            }
        }
        // If distance between last stop and destination is more than
        // what could be travelled with tank full
        if((tot_dist - stops[stops.length - 1]) > max_dist_full_tank ){
            return -1;
        }
        if((tot_dist - stops[stops.length - 1]) > dist_with_rem_fuel ){
            minRefills++;
        }
        return minRefills;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        //System.out.println("First ke neeche"+ d);
        // sc = new Scanner(System.in);
        int m = sc.nextInt();
        //System.out.println("Second ke neeche" + m);
        // sc = new Scanner(System.in);
        int n = sc.nextInt();
        //System.out.println("Third ke neeche" + n);
        int[] stops = new int[n];
        //String stops_str =  sc.next();
        //String[] stops_str_arr = stops_str.split(" ");
        for(int i = 0; i < n; i++){
            stops[i] = sc.nextInt();
          //  System.out.println("Loop ke andar: "+ stops[i]);
        }
        //System.out.println("loop ke neeche");
        System.out.println(minRefills(d,m,stops));
    }
}
