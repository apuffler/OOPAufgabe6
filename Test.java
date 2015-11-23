
public class Test {

    public static void main(String[] args) {
        Schreiter s = new Schreiter(0, new Schneiden(10.5), 0);
        Radernter r = new Radernter(0, new Schnitzeln(4), 0.5);

        s.incSchritte(50);
        s.incBetriebsstunden(1);
        r.incWegstrecke(123.4);
        r.incBetriebsstunden(2);

        //System.out.println("Schreiter: id: " + s.id + ", Betriebsstunden: " + s.getBetriebsstunden() + ", Schritte: " + s.getSchritte());
        //System.out.println("Raeder: id: " + r.id + ", Betriebsstunden: " + r.getBetriebsstunden() + ", Wegstrecke: " + r.getWegstrecke());

        s.aendereEinsatz(new Schnitzeln(4));
        r.aendereEinsatz(new Schneiden(10.5));
        System.out.println("-----------------------------");
        //System.out.println("Schreiter: id: " + s.id + ", Betriebsstunden: " + s.getBetriebsstunden() + ", Schritte: " + s.getSchritte());
        //System.out.println("Raeder: id: " + r.id + ", Betriebsstunden: " + r.getBetriebsstunden() + ", Wegstrecke: " + r.getWegstrecke());

        Forstbetrieb fb = new Forstbetrieb("Forstbetrieb 1");
        MyList ml = new MyList();
        for (int i = 0; i < 10; i++){
            ml.add(new Schreiter(i, new Schneiden(i+1), i));
            ml.add(new Radernter(i, new Schnitzeln(i), i));
            fb.addErnter(new Schreiter(i, new Schneiden(i + 1), i));
            fb.addErnter(new Radernter(i, new Schnitzeln(i), i));
            fb.addErnter(new Radernter(i, new Schneiden(i + 1), i));
            fb.addErnter(new Schreiter(i, new Schnitzeln(i), i));
        }
        Node n = ml.head;
        while (n != null){
            if(n instanceof Schreiter){
                System.out.println("Schreiter: id: " + ((Schreiter) n).id + ", Betriebsstunden: " + ((Schreiter) n).getBetriebsstunden() + ", Schritte: " + ((Schreiter) n).getSchritte());
            }else if(n instanceof Radernter){
                System.out.println("Raeder: id: " + ((Radernter) n).id + ", Betriebsstunden: " + ((Radernter) n).getBetriebsstunden() + ", Wegstrecke: " + ((Radernter) n).getWegstrecke());
            }
            n = n.next;
        }

        System.out.println("-------------");
        System.out.println(fb.getBetriebsstundenEinsatz());
        System.out.println(fb.getBetriebsstundenTyp());
        System.out.println(fb.getSchneiderLaenge());
        System.out.println(fb.getSchnitzlerDicker());
        System.out.println(fb.getSchritte());
        System.out.println(fb.getWegstrecke());
    }
}
