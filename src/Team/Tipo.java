package Team;
import java.util.Map;
import java.util.HashMap;

public class Tipo {
    String nome;
    String[] effective;
    String[] weak;
    //Map<String, Integer> typed = new HashMap<>();

    public Tipo(String nome, String[] effective, String[] weak){
        this.nome = nome;
        this.effective = effective;
    }
    //mappa per memorizzare i tipi pokemon ed agevolare la creazione di coperture
    public static Map<String, Integer> typed = new HashMap<>();
    static{
        typed.put("normale", 0);
        typed.put("lotta", 0);
        typed.put("volante", 0);
        typed.put("veleno", 0);
        typed.put("terra", 0);
        typed.put("roccia", 0);
        typed.put("coleottero", 0);
        typed.put("spettro", 0);
        typed.put("acciaio", 0);
        typed.put("fuoco", 0);
        typed.put("acqua", 0);
        typed.put("erba", 0);
        typed.put("elettro", 0);
        typed.put("psico", 0);
        typed.put("ghiaccio", 0);
        typed.put("drago", 0);
        typed.put("buio", 0);
        typed.put("folletto", 0);
    }

    //Dichiarazione dei tipi pokemon
    public static final Tipo normale = new Tipo("normale",new String[]{" "} , new String[]{"lotta"});
    public static final Tipo lotta = new Tipo("lotta",new String[]{"acciaio","roccia","ghiaccio","normale","buio"},new String[]{"psico","volante","folletto"});
    public static final Tipo volante = new Tipo("volante",new String[]{"lotta","erba","coleottero"},new String[]{"roccia","elettro","ghiaccio"});
    public static final Tipo veleno = new Tipo("veleno",new String[]{"folletto","erba"},new String[]{"psico","terra"});
    public static final Tipo terra = new Tipo("terra",new String[]{"acciaio","roccia","veleno","elettro","fuoco"},new String[]{"acqua","ghiaccio","erba"});
    public static final Tipo roccia = new Tipo("roccia",new String[]{"volante","coleottero","fuoco","ghiaccio"},new String[]{"acqua","acciaio","erba","lotta","terra"});
    public static final Tipo coleottero = new Tipo("coleottero",new String[]{"erba","psico","buio"},new String[]{"roccia","fuoco","volante"});
    public static final Tipo spettro = new Tipo("spettro",new String[]{"psico","spettro"},new String[]{"spettro","buio"});
    public static final Tipo acciaio = new Tipo("acciaio",new String[]{"ghiaccio","roccia","folletto"},new String[]{"terra","fuoco","lotta"});
    public static final Tipo fuoco = new Tipo("fuoco",new String[]{"erba","coleottero","ghiaccio","acciaio"},new String[]{"terra","acqua","roccia"});
    public static final Tipo acqua = new Tipo("acqua",new String[]{"fuoco","terra","roccia"},new String[]{"elettro","erba"});
    public static final Tipo erba = new Tipo("erba",new String[]{"terra","roccia","acqua"},new String[]{"veleno","fuoco","volante","ghiaccio","coleottero"});
    public static final Tipo elettro = new Tipo("elettro",new String[]{"volante","acqua"},new String[]{"terra"});
    public static final Tipo psico = new Tipo("psico",new String[]{"veleno","lotta"},new String[]{"coleottero","buio","spettro"});
    public static final Tipo ghiaccio = new Tipo("ghiaccio",new String[]{"volante","erba","terra","drago"},new String[]{"lotta","fuoco","acciaio","roccia"});
    public static final Tipo drago = new Tipo("drago",new String[]{"drago"},new String[]{"drago","ghiaccio","folletto"});
    public static final Tipo buio = new Tipo("buio",new String[]{"spettro","psico"},new String[]{"lotta","coleottero","folletto"});
    public static final Tipo folletto = new Tipo("folletto",new String[]{"drago","buio","lotta"},new String[]{"acciaio","veleno"});
    //array di tipi utilizzato per le coperture
    public static final Tipo[] arrayTipi = {normale,lotta,volante,veleno,terra,roccia,coleottero,spettro,acciaio,fuoco,acqua,erba,elettro,psico,ghiaccio,drago,buio,folletto};
}