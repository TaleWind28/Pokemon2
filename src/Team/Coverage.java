package Team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Coverage extends Team{
    List <String> coverage = new ArrayList<>();
    //copertura di defaul
    public Coverage(){}

    //copertura con input //aggiustare perchè si dimentica della debolezza al folleto, però è perfetto per le gen prima della sesta:)
    public Coverage(Tipo[] typing){
        for(int i = 0;i<typing.length;i++){
            for(int j =0;j<typing[i].effective.length;j++){
                this.coverage.add(typing[i].effective[j]);
            }
        }
    }
    //stampo la copertura
    public void print(){
        for(String type : this.coverage){
            System.out.print(type+" ");
        }
        System.out.println("");
    }

    public String buildStep(){
        //caso base
        if (this.coverage.size()>=18){
            //stampo la copertura completata
            //this.print();
            return "Done";
        }
        //aggiorno la copertura
        updateCoverage();
        //preparo le mappe
        Map<String, Integer> type = new HashMap<>(Tipo.typed);
        List<String> typeNeed = new ArrayList<>();
        Set<String> chiavi = Tipo.typed.keySet();
        boolean found = false;
        //controllare i tipi già battuti,ossia cercare nella coverage cosa manca
        for(String nomeKey:chiavi){//scorro la lista
            for(String typeIn:this.coverage){//scorro il keyset
                if(typeIn.equals(nomeKey)){//controllo che i nomi siano diversi
                    found = true;
                    break; 
                }
            }
            //ricerca senza successo
            if (!found){
                //devo ancora battere questo tipo
                typeNeed.add(nomeKey);
            }
            //resetto found per le ricerche successive
            found = false;

        }

        //aggiustare la mappa per capire quale tipo conviene prendere dopo
        for(Tipo typeNext:Tipo.arrayTipi){//ciclo sui tipi
            for(String typeName:typeNext.effective){//ciclo sulle superefficacie
                for(String nomeNeed:typeNeed){//ciclo sui tipi da battere
                    if(typeName.equals(nomeNeed)){//se il tipo appartiene alle superefficacie allora vado avanti
                        type.put(typeNext.nome,type.get(typeNext.nome)+1);//incremento il numero di tipi battuti dal tipo che sto analizzando
                        break;
                    }
                
                }
            }            
        }
        //scelgo il tipo che ne batte di più
        Set<String> chiaviTipo = type.keySet();
        int tipiMax = -1;
        String key = new String();
        for(String tipoMigliore:chiaviTipo){
            int tipiAct = type.get(tipoMigliore);
            if (tipiAct > tipiMax){
                key = tipoMigliore;
                tipiMax = tipiAct;
            }
        }

        /*Sotto Funziona*/
        found = false;

        return key;
    }

    public void updateCoverage(){
        boolean found = false;
        for(String key:this.team){
            for(Tipo typeBeat:Tipo.arrayTipi){//controllo tutti i tipi
                if(typeBeat.nome.equals(key)){//controllo che il tipo sia quello scelto
                    for(String tipo:typeBeat.effective){//scorro i tipi che batte
                        for(String tipoCoperto:this.coverage){//ciclo sulla copertura
                            if(tipoCoperto.equals(tipo)){//controllo che non siano nella copertura
                                found = true;//se appartengono termino la ricerca
                                break;
                            }
                        }
                        if (!found){//ricerca senza successo -> tipo da aggiungere
                            this.coverage.add(tipo);
                        }
                        //resetto found
                        found = false;
                    }
                }
            }
        }
    }

    public void build(){
        //caso base
        String typeChosen = new String(buildStep());
        if(typeChosen.equals("Done")){
            return;
        }
        boolean found = false;
        for(String tipoSquadra:this.team){
            if(tipoSquadra.equals(typeChosen)){
               found = true;
               break; 
            }
        }
        if (!found){
            System.out.print(typeChosen+" ");
            this.team.add(typeChosen);
        }
        
        //chiamata ricorsiva
        build();
        return;
    }

}


