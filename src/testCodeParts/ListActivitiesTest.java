package testCodeParts;

import activities.*;
    public class ListActivitiesTest {
    private ListOfActivities listOfActivities;

    
    public void setUp() {
        listOfActivities = new ListOfActivities();
        // Add test activities to listOfActivities as needed
   }

   public void testAddActivity(){

         // Create the entity Names
         String entityName = "SDTT";
         String entityName2 = "ADET";
         String entityName3 = "TFTT";
         String entityName4 = "NOPQ";
         String entityName5 = "UFDT";

         // Generate the code depending on the entity name for each entity
         // First one
         String code;
         do { // Make the do while to see if it exists in the actual list
            code = generateActivityCodes(entityName);
         } while (listOfActivities.checkActivCode(code) == true); 
        // Second one
         String code2;
         do { // Make the do while to see if it exists in the actual list
            code2 = generateActivityCodes(entityName);
         } while (listOfActivities.checkActivCode(code2) == true); 
         // Third one
         String code3;
         do { // Make the do while to see if it exists in the actual list
            code3 = generateActivityCodes(entityName);
         } while (listOfActivities.checkActivCode(code3) == true); 
         // Fourth one
         String code4;
         do { // Make the do while to see if it exists in the actual list
            code4 = generateActivityCodes(entityName);
         } while (listOfActivities.checkActivCode(code4) == true); 
         // Fifth one
         String code5;
         do { // Make the do while to see if it exists in the actual list
            code5 = generateActivityCodes(entityName);
         } while (listOfActivities.checkActivCode(code5) == true); 



         // Generate the activity with each corresponent dadas.
         Talk activ = new Talk("Sergi", code, "Historia guide", "Tarragona",
          43098, 15, entityName);
          
         Visits activ2 = new Visits(true, true, code2, "Historia guide", "Tarragona", 
         43098, 16, entityName2);

         Talk activ3 = new Talk("Marcos", code, "Science talk", "Madrid", 28040 , 18, entityName3);

         Visits activ4 = new Visits(false, false, code2, "Visit route", "Lleida", 
         25003, 17, entityName4);

         Talk activ5 = new Talk("Paula", code, "Tecnologic Talk", "Malaga",
          29001, 19, entityName5);

         // Añades la actividad a la lista
         listOfActivities.addActivity(activ);
         listOfActivities.addActivity(activ2);
         listOfActivities.addActivity(activ3);
         listOfActivities.addActivity(activ4);
         listOfActivities.addActivity(activ5);

         System.out.println("We will have the activities:"+ listOfActivities.toString());
      
         // Start with the tests

         // First: see how many TALK we have

        System.out.println("We will have"+listOfActivities.getNumberTalks()+"TALK's");

        // Followed by see how many Visits do we have

        System.out.println("We will have"+listOfActivities.getNumberVisits()+"Visits");

        // And finally how many Workshops we have 

        System.out.println("We will have"+listOfActivities.getNumberWorkShops()+"Workshops");

        // Now we will try to filter by Visits

        listOfActivities.filterByVisits();

        System.out.println("We will have the activities filtered by Visits:"+ listOfActivities.toString());

        // Test if we have an activity in the day 17

        System.out.println("We have the activity"+ listOfActivities.getActivityByDay(17)+"In the day 17");

   }
   private static String generateActivityCodes(String entityName) {
      // New substring with their first 3 letters: URVASB -> aux = URV
      String aux = entityName.substring(0,2).toUpperCase();
      // Generate random number between 100 & 900
      int num = 100 + (int) (Math.random() * 900);

      return aux + num;
  }
}