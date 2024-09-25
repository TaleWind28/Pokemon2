package Team;

import java.util.ArrayList;
import java.util.List;

public class Team {
    public List <String> team;
    
    public Team(){
        this.team = new ArrayList<>();
    }

    //stampo il team
    public void printTeam(){
        for(String membro: this.team){
            System.out.print(membro+" ");
        }
        System.out.print("\n");
    }
}
