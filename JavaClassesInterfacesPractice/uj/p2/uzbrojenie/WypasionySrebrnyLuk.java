//Pawel Adamczuk
package pl.uj.p2.uzbrojenie;

import pl.uj.p2.InterfejsMunchkina;
import pl.uj.p2.Klasa;
//import pl.uj.p2.Rasa;

public class WypasionySrebrnyLuk extends Luk implements Bron, Srebrny {

  public WypasionySrebrnyLuk() {
    // TODO Auto-generated constructor stub
  }
  
  @Override
  public boolean czyMoznaUzbroicMunchkina(InterfejsMunchkina munchkin) {
    if (super.czyMoznaUzbroicMunchkina(munchkin) && munchkin.pobierzKlasa() != Klasa.Len && munchkin.pobierzKlasa() != Klasa.Osilek)
      return true;
    else
      return false;
  }
  
  @Override
  public int policzPremie(InterfejsMunchkina munchkin) {
      if (munchkin.pobierzRasa() == null)
        return super.policzPremie(munchkin);
      else
      {
        return super.policzPremie(munchkin) * munchkin.pobierzRasa().pobierzPremie();
      }   
  }
}
