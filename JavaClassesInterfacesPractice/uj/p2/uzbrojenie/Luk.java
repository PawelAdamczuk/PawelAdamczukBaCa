//Pawel Adamczuk
package pl.uj.p2.uzbrojenie;

import pl.uj.p2.InterfejsMunchkina;
import pl.uj.p2.Rasa;

public class Luk implements Bron {

  public Luk() {
  }

  @Override
  public boolean czyMoznaUzbroicMunchkina(InterfejsMunchkina munchkin) {
    if (munchkin.pobierzRasa() == Rasa.Elf || munchkin.pobierzRasa() == Rasa.Gnom)
      return true;
    else
      return false;
  }

  @Override
  public int policzPremie(InterfejsMunchkina munchkin) {
      return 3;
  }

}
