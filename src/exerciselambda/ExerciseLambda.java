
package exerciselambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExerciseLambda {

    public static void main(String[] args) {
       
        List<Person> people=Arrays.asList(
                new Person("zabi","Sajjad",17),
                new Person("Umer","farooq",12),
                new Person("Hassan","Farooq",12),
                new Person("Wasif","Sajjad",18)
        );
        //1:Sort the list
        
        Collections.sort(people, (p1,p2)->p1.getFirstName().compareTo(p2.getFirstName()));
        printConditionally(people,p->true);     // for printing all values.
        printConditionally(people,p->p.getFirstName().startsWith("W"));// values starting with B
        
        // functional way
        printConditionally(people, new Condition(){
            @Override
            public boolean test(Person p) {
            return p.getFirstName().startsWith("W");
            }
       });
            printConditionally(people, new Condition(){
            @Override
            public boolean test(Person p) {
            return p.getFirstName().startsWith("B");
            }
        
        
        });
        printAll(people);
    }

    interface Condition{
        boolean test(Person p);
    }
    
    private static void printConditionally(List<Person> people,Condition condition) {
        for(Person p: people)
            if(condition.test(p))
            System.out.println(p);
    }
     public static void printAll(List<Person> people) {
       
        for(Person p: people)
            System.out.println(p);
    }
    
}
