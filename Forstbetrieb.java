
public class Forstbetrieb{

    public final String fName;
    private MyList ernter;

    public Forstbetrieb(String name){
    	if (name == null)
			throw new IllegalArgumentException("Forstbetrieb, Forstbetrieb: name darf nicht NULL sein!");
        this.fName = name;
        this.ernter = new MyList();
    }

    //ASSERT: Holzvollernter hve darf nicht NULL sein!
    public void addErnter(Holzvollernter hve){
    	if (hve == null)
			throw new IllegalArgumentException("Holzvollernter, addErnter: Holzvollernter darf nicht NULL sein!");
        this.ernter.add(hve);
    }

    //Possible assert?: id darf nicht < 0 sein?
    public void removeErnter(int id){


        Holzvollernter toBeRemoved = this.getErnter(id);
        ernter.remove(toBeRemoved);

    }
    //Possible assert?: id darf nicht < 0 sein?
    public Holzvollernter getErnter(int id){
    	Node currentNode = ernter.getHead();
    	while(currentNode != null){
    		Holzvollernter element = (Holzvollernter)currentNode.getElement();
    		if(element.getID() == id){
    			return element;
    		}
    		currentNode = currentNode.getNext();
    	}
    	return null;
    }

    public String getName(){
    	return this.fName;
    }

    public MyList getErnterList(){

        return this.ernter;
    }

    public SchnitzelSchneidTriple getAverageBetriebsStundenByKopf(){
        int schnitzelCounter = 0;
        int schneidCounter = 0;

        double schnitzelBetriebsstunden = 0;
        double schneidBetriebsstunden = 0;
        double allBetriebsstunden = 0;

        Node currentNode = ernter.getHead();
        
        while(currentNode != null){
            Holzvollernter h = (Holzvollernter)currentNode.getElement();

            if(h.getArbeitskopf() instanceof Schneidkopf){
                schneidCounter++;
                schneidBetriebsstunden += h.getBetriebsstunden();
            }else if(h.getArbeitskopf() instanceof Schnitzelkopf){
                schnitzelCounter++;
                schnitzelBetriebsstunden += h.getBetriebsstunden();
            }

            allBetriebsstunden += h.getBetriebsstunden();
            currentNode = currentNode.getNext();
        }   

        allBetriebsstunden = (ernter.size() <= 0)?0:(allBetriebsstunden/ernter.size());
        schnitzelBetriebsstunden = (schnitzelCounter <= 0)?0:(schnitzelBetriebsstunden / schnitzelCounter);
        schneidBetriebsstunden = (schneidCounter <= 0)?0:(schneidBetriebsstunden / schneidCounter);

        return new SchnitzelSchneidTriple(allBetriebsstunden, schnitzelBetriebsstunden, schneidBetriebsstunden);
    }

    public SchrittRadTriple getAverageBetriebsStundenByArt(){
        int schreiterCounter = 0;
        int radCounter = 0;

        double schreiterBetriebsstunden = 0;
        double radBetriebsstunden = 0;
        double allBetriebsstunden = 0;

        Node currentNode = ernter.getHead();
        while(currentNode != null){
            Holzvollernter h = (Holzvollernter)currentNode.getElement();

            if(h instanceof Radernter){
                radCounter++;
                radBetriebsstunden += h.getBetriebsstunden();
            }else if(h instanceof Schreiter){
                schreiterCounter++;
                schreiterBetriebsstunden += h.getBetriebsstunden();
            }

            allBetriebsstunden += h.getBetriebsstunden();
            currentNode = currentNode.getNext();
        }   

        allBetriebsstunden = (ernter.size() <= 0)?0:(allBetriebsstunden / ernter.size());
        schreiterBetriebsstunden = (schreiterCounter <= 0)?0:(schreiterBetriebsstunden / schreiterCounter);
        radBetriebsstunden = (radCounter <= 0)?0:(radBetriebsstunden / radCounter);

        return new SchrittRadTriple(allBetriebsstunden, schreiterBetriebsstunden, radBetriebsstunden);
    }

    public SchnitzelSchneidTriple getAverageSpentDistanceByKopf(){
        int schnitzelCounter = 0;
        int schneidCounter = 0;
        int radernterCounter = 0;

        double schnitzelDistance = 0;
        double schneideDistance = 0;
        double totalDistance = 0;

        Node currentNode = ernter.getHead();
        while(currentNode != null){
            if(currentNode.getElement() instanceof Radernter){
                Radernter r = (Radernter)currentNode.getElement();
                radernterCounter++;
                totalDistance += r.getWegstrecke();
                if(r.getArbeitskopf() instanceof Schnitzelkopf){
                    schnitzelCounter++;
                    schnitzelDistance += r.getWegstrecke();
                }else if(r.getArbeitskopf() instanceof Schneidkopf){
                    schneidCounter++;
                    schneideDistance += r.getWegstrecke();
                }
            }

            currentNode = currentNode.getNext();
        }
        totalDistance = (radernterCounter <= 0)?0:(totalDistance / radernterCounter);
        schnitzelDistance = (schnitzelCounter <= 0)?0:(schnitzelDistance / schnitzelCounter);
        schneideDistance = (schneidCounter <= 0)?0:(schneideDistance / schneidCounter);

        return new SchnitzelSchneidTriple(totalDistance, schnitzelDistance, schneideDistance);
    }

    public SchnitzelSchneidTriple getAverageStepsByKopf(){
        int schnitzelCounter = 0;
        int schneidCounter = 0;
        int schreiterCounter = 0;

        double schnitzelSteps = 0;
        double schneideSteps = 0;
        double totalSteps = 0;

        Node currentNode = ernter.getHead();
        while(currentNode != null){
            if(currentNode.getElement() instanceof Schreiter){
                Schreiter s = (Schreiter)currentNode.getElement();
                schreiterCounter++;
                totalSteps += s.getSchritte();
                if(s.getArbeitskopf() instanceof Schnitzelkopf){
                    schnitzelCounter++;
                    schnitzelSteps += s.getSchritte();
                }else if(s.getArbeitskopf() instanceof Schneidkopf){
                    schneidCounter++;
                    schneideSteps += s.getSchritte();
                }
            }

            currentNode = currentNode.getNext();
        }
        totalSteps = (schreiterCounter <= 0)?0:(totalSteps / schreiterCounter);
        schnitzelSteps = (schnitzelCounter <= 0)?0:(schnitzelSteps / schnitzelCounter);
        schneideSteps = (schneidCounter <= 0)?0:(schneideSteps / schneidCounter);

        return new SchnitzelSchneidTriple(totalSteps, schnitzelSteps, schneideSteps);
    }

    public SchrittRadTriple getAverageTreeThicknessForSchnitzelkopf(){
        int schnitzelCounter = 0;
        int radCounter = 0;
        int schreitCounter = 0;

        double totalThickness = 0;
        double radThickness = 0;
        double schreitThickness = 0;

        Node currentNode = ernter.getHead();
        while(currentNode != null){
            Holzvollernter h = (Holzvollernter)currentNode.getElement();
            if(h.getArbeitskopf() instanceof Schnitzelkopf){
                Schreiter s = (Schreiter)currentNode.getElement();
                schnitzelCounter++;
                totalThickness += h.getArbeitskopfDetails();
                if(currentNode.getElement() instanceof Schreiter){
                    schreitCounter++;
                    schreitThickness += h.getArbeitskopfDetails();
                }else if(currentNode.getElement() instanceof Radernter){
                    radCounter++;
                    radThickness += h.getArbeitskopfDetails();
                }
            }

            currentNode = currentNode.getNext();
        }
        totalThickness = (schnitzelCounter <= 0)?0:(totalThickness / schnitzelCounter);
        schreitThickness = (schreitCounter <= 0)?0:(schreitThickness / schreitCounter);
        radThickness = (radCounter <= 0)?0:(radThickness / radCounter);
        return new SchrittRadTriple(totalThickness, schreitThickness, radThickness);
    }
    
    public SchrittRadTriple getAverageTreeThicknessForSchneidkopf(){
        int schneidCounter = 0;
        int radCounter = 0;
        int schreitCounter = 0;

        double totalThickness = 0;
        double radThickness = 0;
        double schreitThickness = 0;

        Node currentNode = ernter.getHead();
        while(currentNode != null){
            Holzvollernter h = (Holzvollernter)currentNode.getElement();
            if(h.getArbeitskopf() instanceof Schneidkopf){
                Holzvollernter s = (Holzvollernter)currentNode.getElement();
                schneidCounter++;
                totalThickness += h.getArbeitskopfDetails();
                if(currentNode.getElement() instanceof Schreiter){
                    schreitCounter++;
                    schreitThickness += h.getArbeitskopfDetails();
                }else if(currentNode.getElement() instanceof Radernter){
                    radCounter++;
                    radThickness += h.getArbeitskopfDetails();
                }
            }

            currentNode = currentNode.getNext();
        }
        totalThickness = (schneidCounter <= 0)?0:(totalThickness / schneidCounter);
        schreitThickness = (schreitCounter <= 0)?0:(schreitThickness / schreitCounter);
        radThickness = (radCounter <= 0)?0:(radThickness / radCounter);
        return new SchrittRadTriple(totalThickness, schreitThickness, radThickness);
    }

/*    public String getBetriebsstundenEinsatz(){
        double sumschneiden = 0, sumschnitzeln = 0, anzschneiden = 0, anzshnitzln = 0;
        Node n = this.ernter.head;
        while (n != null){
            if(n instanceof Holzvollernter){
                if(((Holzvollernter) n).getArbeitskopf() instanceof Schneidkopf){
                    sumschneiden += ((Holzvollernter) n).getBetriebsstunden();
                    anzschneiden++;
<<<<<<< Updated upstream
 
                }else if(((Holzvollernter) n).getArbeitskopf() instanceof Schnitzeln){
=======
                }else if(((Holzvollernter) n).getArbeitskopf() instanceof Schnitzelkopf){
>>>>>>> Stashed changes
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
                if(((Radernter) n).getArbeitskopf() instanceof Schneidkopf){
                    sumschneiden += ((Radernter) n).getWegstrecke();
                    anzschneiden++;
                }else if(((Radernter) n).getArbeitskopf() instanceof Schnitzelkopf){
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
                if(((Schreiter) n).getArbeitskopf() instanceof Schneidkopf){
                    sumschneiden += ((Schreiter) n).getSchritte();
                    anzschneiden++;
                }else if(((Schreiter) n).getArbeitskopf() instanceof Schnitzelkopf){
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
                if(((Holzvollernter) n).getArbeitskopf() instanceof Schneidkopf) {
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
                if(((Holzvollernter) n).getArbeitskopf() instanceof Schnitzelkopf) {
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
    }*/
}