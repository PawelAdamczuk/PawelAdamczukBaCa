//Pawel Adamczuk
package pl.uj.p2.wyjatki;

import java.io.Serializable;

public class WyjatekMunchkina extends Exception implements Serializable {

  public WyjatekMunchkina(String arg0) {
    super(arg0);
  }
}
