//Pawel Adamczuk
package pl.uj.p2;
import pl.uj.p2.wyjatki.*;
import pl.uj.p2.uzbrojenie.*;
public class Source {

  public Source() {
  }

  public static void main(String[] args) {
    Munchkin m = new Munchkin();
    System.out.println(m.pobierzSamPoziom());
    System.out.println(m.pobierzKlasa());
    System.out.println(m.pobierzRasa());
    System.out.println(m.pobierzBron());
    System.out.println(m.policzCalkowityPoziom());

    try {
        m.przyjmijRase(Rasa.Gnom);
        System.out.println(m.pobierzRasa());
        System.out.println(m.policzCalkowityPoziom());
    } catch (WyjatekMunchkina e) {
        System.out.println("Nie mo¿na przyj¹æ rasy Gnoma");
    }

    try {
        m.przyjmijKlase(Klasa.Osilek);
        System.out.println(m.pobierzRasa());
        System.out.println(m.policzCalkowityPoziom());
    } catch (WyjatekMunchkina e) {
        System.out.println("Nie mo¿na przyj¹æ klasy Osi³ek");
    }

    try {
        m.przyjmijBron(new Miecz());
        System.out.println(m.pobierzBron() != null);
        System.out.println(m.policzCalkowityPoziom());
    } catch (WyjatekMunchkina e) {
        System.out.println("Nie mo¿na uzbroiæ Munchkina w miecz");
    }
  }

}
