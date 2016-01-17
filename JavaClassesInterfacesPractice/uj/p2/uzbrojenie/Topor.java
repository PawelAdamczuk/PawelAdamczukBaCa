//Pawel Adamczuk
package pl.uj.p2.uzbrojenie;

import pl.uj.p2.InterfejsMunchkina;
import pl.uj.p2.Klasa;

public class Topor implements Bron {

  public Topor() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public boolean czyMoznaUzbroicMunchkina(InterfejsMunchkina munchkin) {
    if (munchkin.pobierzKlasa() == Klasa.Szpieg)
      return false;
    else
      return true;
  }

  @Override
  public int policzPremie(InterfejsMunchkina munchkin) {    
      if (munchkin.pobierzKlasa() == Klasa.Osilek)
        return 10;
      else
        return 5;
  }

}
