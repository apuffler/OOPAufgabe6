
public class Forstbetrieb extends Node{

    public final String fName;
    public MyList ernter;

    public Forstbetrieb(String name){
        this.fName = name;
        this.ernter = new MyList();
    }

    public void addErnter(Holzvollernter hve){
        this.ernter.add(hve);
    }

    public void removeErnter(Holzvollernter hve){
        // todo: how to do this best?
    }

    public String getBetriebsstundenEinsatz(){
        double sumschneiden = 0, sumschnitzeln = 0, anzschneiden = 0, anzshnitzln = 0;
        Node n = this.ernter.head;
        while (n != null){
            if(n instanceof Holzvollernter){
                if(((Holzvollernter) n).getArbeitskopf() instanceof Schneiden){
                    sumschneiden += ((Holzvollernter) n).getBetriebsstunden();
                    anzschneiden++;
                }else if(((Holzvollernter) n).getArbeitskopf() instanceof Schnitzeln){
                    sumschnitzeln += ((Holzvollernter) n).getBetriebsstunden();
                    anzshnitzln++;
                }
            }
            n = n.next;
        }
        return "Durchschnittliche Betriebsstunden:\nGesamt: " + ((sumschneiden+sumschnitzeln)/(anzschneiden+anzshnitzln)) + "\nSchneider: "
                + (sumschneiden/anzschneiden) + "\nSchnitzler: " + (sumschnitzeln/anzshnitzln);
    }

    public String getBetriebsstundenTyp(){
        double sums = 0, sumr = 0, anzs = 0, anzr = 0;
        Node n = this.ernter.head;
        while (n != null){
            if(n instanceof Schreiter){
                sums += ((Schreiter) n).getBetriebsstunden();
                anzs++;
            }else if(n instanceof Radernter){
                sumr += ((Radernter) n).getBetriebsstunden();
                anzr++;
            }
            n = n.next;
        }
        return "Durchschnittliche Betriebsstunden:\nSchreiter: " + (sums/anzs) + "\nRadernter: " + (sumr/anzr);
    }

    public String getWegstrecke(){
        double sumschneiden = 0, sumschnitzeln = 0, anzschneiden = 0, anzshnitzln = 0;
        Node n = this.ernter.head;
        while (n != null){
            if(n instanceof Radernter){
                if(((Radernter) n).getArbeitskopf() instanceof Schneiden){
                    sumschneiden += ((Radernter) n).getWegstrecke();
                    anzschneiden++;
                }else if(((Radernter) n).getArbeitskopf() instanceof Schnitzeln){
                    sumschnitzeln += ((Radernter) n).getWegstrecke();
                    anzshnitzln++;
                }
            }
            n = n.next;
        }
        return "Durchschnittliche Wegstrecke der Radernter:\nGesamt: " + ((sumschneiden+sumschnitzeln)/(anzschneiden+anzshnitzln)) + "\nSchneider: "
                + (sumschneiden/anzschneiden) + "\nSchnitzler: " + (sumschnitzeln/anzshnitzln);
    }

    public String getSchritte(){
        double sumschneiden = 0, sumschnitzeln = 0, anzschneiden = 0, anzshnitzln = 0;
        Node n = this.ernter.head;
        while (n != null){
            if(n instanceof Schreiter){
                if(((Schreiter) n).getArbeitskopf() instanceof Schneiden){
                    sumschneiden += ((Schreiter) n).getSchritte();
                    anzschneiden++;
                }else if(((Schreiter) n).getArbeitskopf() instanceof Schnitzeln){
                    sumschnitzeln += ((Schreiter) n).getSchritte();
                    anzshnitzln++;
                }
            }
            n = n.next;
        }
        return "Durchschnittliche Wegstrecke der Radernter:\nGesamt: " + ((sumschneiden+sumschnitzeln)/(anzschneiden+anzshnitzln)) +
                "\nSchneider: " + (sumschneiden/anzschneiden) + "\nSchnitzler: " + (sumschnitzeln/anzshnitzln);
    }

    public String getSchneiderLaenge(){
        double smin = Integer.MAX_VALUE, smax = -1, rmin = Integer.MAX_VALUE, rmax = -1;
        Node n = this.ernter.head;
        while (n != null){
            if(n instanceof Holzvollernter){
                if(((Holzvollernter) n).getArbeitskopf() instanceof Schneiden) {
                    if (n instanceof Schreiter) {
                        smin = (smin < ((Schreiter) n).getArbeitskopfDetails()) ? smin : ((Schreiter) n).getArbeitskopfDetails();
                        smax = (smax > ((Schreiter) n).getArbeitskopfDetails()) ? smax : ((Schreiter) n).getArbeitskopfDetails();
                    } else if (n instanceof Radernter) {
                        rmin = (rmin < ((Radernter) n).getArbeitskopfDetails()) ? rmin : ((Radernter) n).getArbeitskopfDetails();
                        rmax = (rmax > ((Radernter) n).getArbeitskopfDetails()) ? rmax : ((Radernter) n).getArbeitskopfDetails();
                    }
                }
            }
            n = n.next;
        }
        return "Stuecklaenge der Schneider:\nGesamt: Min: " + ((smin < rmin) ? smin : rmin) + ", Max: " + ((smax > rmax) ? smax : rmax) +
                "\nSchreiter: Min: " + smin + ", Max: " + smax + "\nRadernter: Min: " + rmin + ", Max: " + rmax;
    }

    public String getSchnitzlerDicker(){
        double sums = 0, sumr = 0, anzs = 0, anzr = 0;
        Node n = this.ernter.head;
        while (n != null){
            if(n instanceof Holzvollernter){
                if(((Holzvollernter) n).getArbeitskopf() instanceof Schnitzeln) {
                    if (n instanceof Schreiter) {
                        sums += ((Schreiter) n).getArbeitskopfDetails();
                        anzs++;
                    } else if (n instanceof Radernter) {
                        sumr += ((Radernter) n).getArbeitskopfDetails();
                        anzr++;
                    }
                }
            }
            n = n.next;
        }
        return "Durchschnittliche Baumdicke der Schnitzler:\nGesamt: " + ((sums+sumr)/(anzs+anzr)) + "\nSchreiter: " + (sums/anzs)
                + "\nRadernter: " + (sumr/anzr);
    }
}