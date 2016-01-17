//Pawel Adamczuk
package pl.uj.p2.uzbrojenie;

import pl.uj.p2.InterfejsMunchkina;
//import pl.uj.p2.Rasa;

public class StalowyMieczJednoreczny extends MieczJednoreczny implements Stalowy, Bron {

  public StalowyMieczJednoreczny() {
  }
  
  @Override
  public int policzPremie(InterfejsMunchkina munchkin) {
    if (munchkin.pobierzKlasa() == null)
      return super.policzPremie(munchkin);
    else
      return super.policzPremie(munchkin) * munchkin.pobierzKlasa().pobierzPremie();
  }
}
