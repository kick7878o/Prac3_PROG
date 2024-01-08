package exceptions;

public class NoReservationFound extends Exception {
   public NoReservationFound (String message) {
      super(message);
   }
}