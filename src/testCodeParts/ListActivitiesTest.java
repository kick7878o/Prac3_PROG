package testCodeParts;

import activities.*;
    public class ListActivitiesTest {
    private ListOfActivities listOfActivities;

    
    public void setUp() {
        listOfActivities = new ListOfActivities();
        // Add test activities to listOfActivities as needed
   }

   public void testAddActivity(){
      // Si generamos el codigo de esta forma con el String code, no puede llamar a la funcion ya que está dentro de una clase y tendriamos que crear una variable con una Actividad ya sea talk o lo q sea
      // Y ademas llamar tipo algo.generateActvityCode()
      String code;
      code =generateActvityCode();

      //Si lo hacemos de esta forma generando con un null en lugar de act_code, podemos crear la actividad sino no se puede llamando a la funcion para generarlo directamente
          Talk activ= new Talk("Yo,",null, "TALK", "Swim", 43001, 15, "Swimmers");
      // una vez generamos la actividad, le creamos el activity code ya que ahora si podemos llamarlo
          activ.generateActivityCode();

      
      // SOLUCION PROPUESTA

         // Por ejemplo pones algun nombre de entidad (como son constantes le enseñas la lista con entidades disponibles y ya)
         String entityName;

         // Generas el codigo segun el nombre de la entidad
         String code2;
         do { // Haces un bucle para ver si existe o no el codigo en la lista actual
            code2 = generateActivityCodes(entityName);
         } while (listOfActivities.checkActivCode(code2) == true); 

         // Creas la actividad con el codigo generado y entidad seleccionada + datos que sean
         Talk activ2 = new Talk("Pepito", code2, "Cafeina", "ESPAÑA",
          43098, 15, entityName);

         // Añades la actividad a la lista
         listOfActivities.addActivity(activ2);

      // Y fin


   }
   private static String generateActivityCodes(String entityName) {
      // New substring with their first 3 letters: URVASB -> aux = URV
      String aux = entityName.substring(0,2).toUpperCase();
      // Generate random number between 100 & 900
      int num = 100 + (int) (Math.random() * 900);

      return aux + num;
  }
}