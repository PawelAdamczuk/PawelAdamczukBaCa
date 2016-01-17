//Pawel Adamczuk
package pl.uj.p2;

import pl.uj.p2.uzbrojenie.Bron;
import pl.uj.p2.wyjatki.NiedozwolonaKlasa;
import pl.uj.p2.wyjatki.NiedozwolonaRasa;
import pl.uj.p2.wyjatki.NiedozwoloneUzbrojenie;
import pl.uj.p2.uzbrojenie.*;

public class Munchkin implements InterfejsMunchkina {
  
  private Bron bron;
  private Klasa klasa;
  private int poziom;
  private Rasa rasa;
  

  public Munchkin() {
    bron = null;
    klasa = null;
    poziom = 1;
    rasa = null;
  }
  
  public Munchkin(int poziom) {
    bron = null;
    klasa = null;
    this.poziom = Math.max(0, poziom);
    rasa = null;
  }

  @Override
  public Bron pobierzBron() {
    return this.bron;
  }

  @Override
  public int pobierzSamPoziom() {
    return this.poziom;
  }

  @Override
  public int policzCalkowityPoziom() {
    int sum = 0;
    sum += this.poziom;
    if (this.rasa != null)
      sum += this.rasa.pobierzPremie();
    if (this.klasa != null)
      sum += this.klasa.pobierzPremie();
    if (this.bron != null)
    {
      if (bron instanceof Srebrny && this.klasa == Klasa.Palladyn)
        sum += 25;
      if (bron instanceof Stalowy && this.rasa == Rasa.Ork)
        sum += 20;
      sum += this.bron.policzPremie(this);
    }
    
    return sum;
  }
  
  public void przyjmijBron(Bron bron) throws NiedozwoloneUzbrojenie {
    if (bron != null && !bron.czyMoznaUzbroicMunchkina(this))
      throw new NiedozwoloneUzbrojenie("Niedozwolone uzbrojenie");
    else
      this.bron = bron;
  }
  
  public void przyjmijRase(Rasa rasa) throws NiedozwolonaRasa, NiedozwoloneUzbrojenie {
    if (rasa != null && this.klasa != null && !this.klasa.czyRasaAkceptowalna(rasa))
      throw new NiedozwolonaRasa("blah blah blah");
    else
    {
      this.rasa = rasa;
      if (this.bron != null && !this.bron.czyMoznaUzbroicMunchkina(this))
      {
        this.bron = null;
        throw new NiedozwoloneUzbrojenie("Niedozwolone uzbrojenie");
      }
    }
  }
  
  public void przyjmijKlase(Klasa klasa) throws NiedozwolonaKlasa, NiedozwoloneUzbrojenie {
    if (klasa != null && this.rasa != null && !this.rasa.czyKlasaAkceptowalna(klasa))
      throw new NiedozwolonaKlasa("blah blah blah");
    else
    {
      this.klasa = klasa;
      if (this.bron != null && !this.bron.czyMoznaUzbroicMunchkina(this))
      {
        this.bron = null;
        throw new NiedozwoloneUzbrojenie("Niedozwolone uzbrojenie");
      }
    }
  }
  
  public Rasa pobierzRasa() {
    return this.rasa;
  }
  
  public Klasa pobierzKlasa() {
    return this.klasa;
  }
  
  public void zwiekszSamPoziom(int delta) {
    this.poziom = Math.max(0, this.poziom + delta);
//    if (this.poziom + delta >= 0)
//      this.poziom += delta;
  }
  
  public void zmniejszSamPoziom(int delta) {
    this.poziom = Math.max(0, this.poziom - delta);
//    if (this.poziom - delta >= 0)
//      this.poziom -= delta;
  }

}
