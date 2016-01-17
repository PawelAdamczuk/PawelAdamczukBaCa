//Pawel Adamczuk
package pl.uj.p2;

import java.io.Serializable;

public enum Rasa implements Serializable, Comparable<Rasa> {
  Czlowiek(new String[] {}, 4),
  Elf(new String[] {"Palladyn"}, 3),
  Gnom(new String[] {"Osilek"}, 5),
  Krasnolud(new String[] {"Szpieg"}, 2),
  Ork(new String[] {"Szpieg", "Mag"}, 1);
  
  private String[] nieakceptowalneKlasy;
  private int premiaDoPoziomu;
  
  Rasa (String[] klasy, int poziom) {
    this.nieakceptowalneKlasy = klasy;
    this.premiaDoPoziomu = poziom;
  }
  
  public boolean czyKlasaAkceptowalna(Klasa klasa) {
    if (klasa == null)
      return true;
    for (String tempKlasa : this.nieakceptowalneKlasy)
    {
      if (klasa.name().equals(tempKlasa))
        return false;
    }
    return true;
  }
  
  public int pobierzPremie() {
    return this.premiaDoPoziomu;
  }

}
