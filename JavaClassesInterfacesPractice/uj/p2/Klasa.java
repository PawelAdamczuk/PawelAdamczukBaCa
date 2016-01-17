//Pawel Adamczuk
package pl.uj.p2;

import java.io.Serializable;

public enum Klasa implements Serializable, Comparable<Klasa> {
  Len(new String[] {}, -1),
  Mag(new String[] {"Ork", "Gnom"}, 4),
  Osilek(new String[] {"Gnom"}, 5),
  Palladyn(new String[] {"Elf"}, 2),
  Szpieg(new String[] {"Ork", "Krasnolud"}, 2);
  
  private String[] nieakceptowalneRasy;
  private int premiaDoPoziomu;
  
  Klasa (String[] rasy, int poziom) {
    this.nieakceptowalneRasy = rasy;
    this.premiaDoPoziomu = poziom;
  }
  
  public boolean czyRasaAkceptowalna(Rasa rasa) {
    if (rasa == null)
      return true;
    for (String tempRasa : this.nieakceptowalneRasy)
    {
      if (rasa.name().equals(tempRasa))
        return false;
    }
    return true;
  }
  
  public int pobierzPremie() {
    return this.premiaDoPoziomu;
  }

}
