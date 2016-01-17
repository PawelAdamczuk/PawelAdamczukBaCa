//Pawel Adamczuk
package pl.uj.p2.uzbrojenie;

import pl.uj.p2.InterfejsMunchkina;

public class Miecz implements Bron {

  public Miecz() {
  }

  @Override
  public boolean czyMoznaUzbroicMunchkina(InterfejsMunchkina munchkin) {
    return true;
  }

  @Override
  public int policzPremie(InterfejsMunchkina munchkin) {
    return 2;
  }

}
