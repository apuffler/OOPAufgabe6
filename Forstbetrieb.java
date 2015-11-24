
public class Forstbetrieb{

    public final String fName;
    private MyList ernter;

    public Forstbetrieb(String name){
        this.fName = name;
        this.ernter = new MyList();
    }

    public void addErnter(Holzvollernter hve){
        this.ernter.add(hve);
    }

    public void removeErnter(int id){
        Holzvollernter toBeRemoved = this.getErnter(id);
        ernter.remove(toBeRemoved);
    }

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

    public AverageBetriebsstundenByKopf getAverageBetriebsStundenByKopf(){
        int schnitzelCounter = 0;
        int schneidCounter = 0;

        float schnitzelBetriebsstunden = 0;
        float schneidBetriebsstunden = 0;
        float allBetriebsstunden = 0;

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

        allBetriebsstunden /= ernter.size();
        schnitzelBetriebsstunden /= schnitzelCounter;
        schneidBetriebsstunden /= schneidCounter;

        return new AverageBetriebsstundenByKopf(allBetriebsstunden, schneidBetriebsstunden, schnitzelBetriebsstunden);
    }

    public AverageBetriebsstundenByArt getAverageBetriebsStundenByArt(){
        int schreiterCounter = 0;
        int radCounter = 0;

        float schreiterBetriebsstunden = 0;
        float radBetriebsstunden = 0;
        float allBetriebsstunden = 0;

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

        allBetriebsstunden /= ernter.size();
        schreiterBetriebsstunden /= schreiterCounter;
        radBetriebsstunden /= radCounter;

        return new AverageBetriebsstundenByArt(allBetriebsstunden, schreiterBetriebsstunden, radBetriebsstunden);
    }

    public AverageSpentDistanceByKopf getAverageSpentDistanceByKopf(){
        int schnitzelCounter = 0;
        int schneidCounter = 0;
        int radernterCounter = 0;

        float schnitzelDistance = 0;
        float schneideDistance = 0;
        float totalDistance = 0;

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
        totalDistance /= radernterCounter;
        schnitzelDistance /= schnitzelCounter;
        schneideDistance /= schneidCounter;

        return new AverageSpentDistanceByKopf(totalDistance, schneideDistance, schnitzelDistance);
    }

    public AverageStepsByKopf getAverageStepsByKopf(){
        int schnitzelCounter = 0;
        int schneidCounter = 0;
        int schreiterCounter = 0;

        float schnitzelSteps = 0;
        float schneideSteps = 0;
        float totalSteps = 0;

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
        totalSteps /= schreiterCounter;
        schnitzelSteps /= schnitzelCounter;
        schneideSteps /= schneidCounter;

        return new AverageStepsByKopf(totalSteps, schneideSteps, schnitzelSteps);
    }

    public AverageTreeThicknessForSchnitzelkopf getAverageTreeThicknessForSchnitzelkopf(){
        int schnitzelCounter = 0;
        int radCounter = 0;
        int schreitCounter = 0;

        float totalThickness = 0;
        float radThickness = 0;
        float schreitThickness = 0;

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
        totalThickness /= schnitzelCounter;
        schreitThickness /= schreitCounter;
        radThickness /= radCounter;
        return new AverageTreeThicknessForSchnitzelkopf(totalThickness, schreitThickness, radThickness);
    }
    
    public AverageTreeThicknessForSchneidkopf getAverageTreeThicknessForSchneidkopf(){
        int schneidCounter = 0;
        int radCounter = 0;
        int schreitCounter = 0;

        float totalThickness = 0;
        float radThickness = 0;
        float schreitThickness = 0;

        Node currentNode = ernter.getHead();
        while(currentNode != null){
            Holzvollernter h = (Holzvollernter)currentNode.getElement();
            if(h.getArbeitskopf() instanceof Schneidkopf){
                Schreiter s = (Schreiter)currentNode.getElement();
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
        totalThickness /= schneidCounter;
        schreitThickness /= schreitCounter;
        radThickness /= radCounter;
        return new AverageTreeThicknessForSchneidkopf(totalThickness, schreitThickness, radThickness);
    }
/*
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
    }*/
}