package exceptions;

public class FullSpotsWorkshop extends Exception {
   public FullSpotsWorkshop (String wName) {
      super("\t<<<<< The workshop " +wName+ " is full >>>>>");
   }
}
