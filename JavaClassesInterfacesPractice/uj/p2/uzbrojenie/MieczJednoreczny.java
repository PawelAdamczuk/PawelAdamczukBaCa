//Pawel Adamczuk
package pl.uj.p2.uzbrojenie;

import pl.uj.p2.InterfejsMunchkina;

public class MieczJednoreczny extends Miecz implements Bron {

  public MieczJednoreczny() {
    // TODO Auto-generated constructor stub
  }
  
  @Override
  public int policzPremie(InterfejsMunchkina munchkin) {
    if (munchkin.pobierzRasa() == null)
      return super.policzPremie(munchkin);
    else
      return super.policzPremie(munchkin) * munchkin.pobierzRasa().pobierzPremie();
  }

}
