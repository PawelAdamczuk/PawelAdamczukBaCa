//Pawel Adamczuk
package pl.uj.p2;
import pl.uj.p2.uzbrojenie.Bron;
import pl.uj.p2.wyjatki.*;

public interface InterfejsMunchkina {
  Bron pobierzBron();
  Rasa pobierzRasa();
  Klasa pobierzKlasa();
  int pobierzSamPoziom();
  int policzCalkowityPoziom();
  void przyjmijBron(Bron bron) throws NiedozwoloneUzbrojenie;
  void przyjmijRase(Rasa rasa) throws NiedozwolonaRasa, NiedozwoloneUzbrojenie;
  void przyjmijKlase(Klasa klasa) throws NiedozwolonaKlasa, NiedozwoloneUzbrojenie;
}
