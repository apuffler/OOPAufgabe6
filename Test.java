/**
 *Arbeitsaufteilung: 
 *  Stefan Buttenhauser: 
 *  Armin Puffler: Assertions für alle Klassen, Klassendiagramm (mit Hilfe der Kollegen), general Help
 *  Jovan Zivanovic: DoubleTriple.java, Test.java, SchnitzelSchneidTriple.java, SchrittRadTriple.java, MyList.java, Node.java
 *
 */
public class Test {
    public static void main(String[] args) {
        Gemeinde gemeinde1 = new Gemeinde("Am Stetten");
        Forstbetrieb f1 = new Forstbetrieb("F. und Sohne");

        Schreiter s1 = new Schreiter(10, new Schnitzelkopf(3),0);
        Radernter r1 = new Radernter(20, new Schneidkopf(100.4), 10);

        f1.addErnter(r1);
        f1.addErnter(s1);

        gemeinde1.addForstbetrieb(f1);

        SchnitzelSchneidTriple a = f1.getAverageBetriebsStundenByKopf();
        System.out.println("Gemeinde: " + gemeinde1.getName());
        System.out.println("Forstbetrieb: " + f1.getName());
        System.out.println("All: " + a.first + "  Schnitzel: " + a.second + "  Schneid: " + a.third);

        //Hinzufügen eines weiteren Forstbetriebes zur ersten Gemeinde mit einigen Schreitern 
        Forstbetrieb f2 = new Forstbetrieb("Baum weg");
        Schreiter s2 = new Schreiter(23, new Schnitzelkopf(10), 10);
        Schreiter s3 = new Schreiter(1, new Schneidkopf(2.4), 1);
        Schreiter s4 = new Schreiter(12, new Schnitzelkopf(9), 12);
        Schreiter s5 = new Schreiter(1, new Schnitzelkopf(1), 10);
        Radernter r2 = new Radernter(5, new Schnitzelkopf(2), 2);

        f2.addErnter(s2);
        f2.addErnter(s3);
        f2.addErnter(s4);
        f2.addErnter(s5);
        f2.addErnter(r2);

        gemeinde1.addForstbetrieb(f2);
        System.out.println("Forstbetrieb: " + f2.getName());
        SchnitzelSchneidTriple b = f2.getAverageBetriebsStundenByKopf();
        System.out.println("All: " + b.first + "  Schnitzel: " + b.second + "  Schneid: " + b.third);

        System.out.println("Anzahl der Försterbetriebe in der erste Gemeinde: " + gemeinde1.getForstbetriebCount());
        System.out.println("Löschen eines Betriebes...");
        //Der Forstbetrieb 'F-. und Sohne' ist konkurs geganngen und wird aus der Gemeinde rausgelöscht
        gemeinde1.removeForstBetrieb("F. und Sohne");
        System.out.println("Anzahl der Försterbetriebe in der ersten Gemeinde: " + gemeinde1.getForstbetriebCount());

        System.out.println("Der Betrieb 'Baum Weg' bekommt einen neuen Radernter mit Schnitzelkopf, verliert aber ihren ersten Schreiter");
        f2.removeErnter(2);
        f2.addErnter(new Radernter(20, new Schnitzelkopf(4), 2));
        System.out.println("Neue Statistik über die Betriebsstunden des Betriebes 'Baum Weg'");
        SchnitzelSchneidTriple c = f2.getAverageBetriebsStundenByKopf();
        System.out.println("All: " + c.first + "  Schnitzel: " + c.second + "  Schneid: " + c.third);


        Gemeinde gemeinde2 = new Gemeinde("Cestin");
        Forstbetrieb cestin_betrieb1 = new Forstbetrieb("Cestin Brüder");
        Forstbetrieb cestin_betrieb2 = new Forstbetrieb("Cestin Töchter");
        Forstbetrieb cestin_betrieb3 =  new Forstbetrieb("Cestin Dummköpfe");
        Forstbetrieb cestin_betrieb4 = new Forstbetrieb("Cestin Hacker");

        for(int i = 0; i < 10; i++){
            int betriebsstunden = (int)Math.random() * 40;
            int schneidkopfdicke = (int)Math.random() * 20;
            int thirdArg = (int)Math.random() * 100;
            cestin_betrieb1.addErnter(new Schreiter(betriebsstunden, new Schnitzelkopf(schneidkopfdicke), thirdArg));
        }

        for(int i = 0; i < 30; i++){
            int betriebsstunden = (int)Math.random() * 40;
            int schneidkopfdicke = (int)Math.random() * 20;
            int thirdArg = (int)Math.random() * 100;
            cestin_betrieb2.addErnter(new Schreiter(betriebsstunden, new Schnitzelkopf(schneidkopfdicke), thirdArg));
        }

        for(int i = 0; i < 4; i++){
            int betriebsstunden = (int)Math.random() * 40;
            int schneidkopfdicke = (int)Math.random() * 20;
            int thirdArg = (int)Math.random() * 100;
            cestin_betrieb3.addErnter(new Schreiter(betriebsstunden, new Schnitzelkopf(schneidkopfdicke), thirdArg));
        }

        gemeinde2.addForstbetrieb(cestin_betrieb1);
        gemeinde2.addForstbetrieb(cestin_betrieb2);
        gemeinde2.addForstbetrieb(cestin_betrieb3);
        gemeinde2.addForstbetrieb(cestin_betrieb4);


        MyList l = gemeinde2.forstbetrieb;
        Node currentNode = l.getHead();
        while(currentNode != null){
            Forstbetrieb cur = (Forstbetrieb)currentNode.getElement();
            System.out.println("Forstbetrieb: " + cur.getName());
            currentNode = currentNode.getNext();
        }

        gemeinde2.removeForstBetrieb("Cestin Hacker");
        System.out.println("Die Gemeinde Cestin hat nun vier Forstbetriebe, doch einer davon wird nicht verwendet und daher gelöscht");

        currentNode = l.getHead();
        while(currentNode != null){
            Forstbetrieb cur = (Forstbetrieb)currentNode.getElement();
            System.out.println("Forstbetrieb: " + cur.getName());
            currentNode = currentNode.getNext();
        }

        //Löschen aller Betriebe in Gemeinde2
        gemeinde2.removeForstBetrieb("Cestin Töchter");
        gemeinde2.removeForstBetrieb("Cestin Brüder");
        gemeinde2.removeForstBetrieb("Cestin Dummköpfe");

        System.out.println("Gemeinde Cestin hat " + gemeinde2.getForstbetriebCount() + " Forstbetriebe");
        System.out.println("ALL STATISTICAL VALUES");
        //Gemeinde 1
        MyList gemeinde1ForstBet = gemeinde1.forstbetrieb;
        Node gemeinde1Current = gemeinde1ForstBet.getHead();
        while(gemeinde1Current != null){
            Forstbetrieb ad = (Forstbetrieb)gemeinde1Current.getElement();
            System.out.println("Forstbetrieb: " + ad.getName());

            SchnitzelSchneidTriple stat_1 = f1.getAverageBetriebsStundenByKopf();
            SchrittRadTriple stat_2 = f1.getAverageBetriebsStundenByArt();
            SchnitzelSchneidTriple stat_3 = f1.getAverageSpentDistanceByKopf();
            SchnitzelSchneidTriple stat_4 = f1.getAverageStepsByKopf();
            SchrittRadTriple stat_5 = f1.getAverageTreeThicknessForSchnitzelkopf();
            SchrittRadTriple stat_6 = f1.getAverageTreeThicknessForSchneidkopf();
            System.out.println("Betriebsstunden nach Auftragskopf: ");
            System.out.println("All: " + stat_1.first + "  Schnitzel: " + stat_1.second + "  Schneid: " + stat_1.third);
            System.out.println("Betriebsstunden nach Ernterart: ");
            System.out.println("All: " + stat_2.first + "  Schreiter: " + stat_2.second + "  Radernter: " + stat_2.third);
            System.out.println("Distanz nach Auftragskopf: ");
            System.out.println("All: " + stat_3.first + "  Schnitzel: " + stat_3.second + "  Schneid: " + stat_3.third);
            System.out.println("Schritte nach Auftragskopf: ");
            System.out.println("All: " + stat_4.first + "  Schnitzel: " + stat_4.second + "  Schneid: " + stat_4.third);
            System.out.println("Baumdicke für Schnitzelkopf: ");
            System.out.println("All: " + stat_5.first + "  Schreiter: " + stat_5.second + "  Radernter: " + stat_5.third);
            System.out.println("Baumdicke für Schneidkopf: ");
            System.out.println("All: " + stat_6.first + "  Schreiter: " + stat_6.second + "  Radernter: " + stat_6.third);
            gemeinde1Current = gemeinde1Current.getNext();
        } 
    }
}