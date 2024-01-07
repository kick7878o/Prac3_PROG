package testCodeParts;

import entities.Entity;
import entities.ListEntities;

public class ListEntitiesTest {
   public static void main(String[] args) {
        System.out.println("ListEntities Test");

        testConstructor();
        testGettersAndSetters();
        testAddEntity();
        testToString();
        testShowEntityName();
   }

   public static void testConstructor() {
        System.out.println("Testing constructor");

        int size = 5;
        ListEntities listEntities = new ListEntities(size);
    
        // Verificar que la longitud del arreglo de entidades sea la correcta
        System.out.println("Constructor - Length of entity list: " + (listEntities.getEntityList().length == size ? "Passed" : "Failed"));
    
        // Verificar que todas las posiciones del arreglo estén inicializadas a null al principio
        boolean allNullAtStart = true;
        for (Entity entity : listEntities.getEntityList()) {
            if (entity != null) {
                allNullAtStart = false;
                break;
            }
        }
        System.out.println("Constructor - All elements initialized to null at the start: " + (allNullAtStart ? "Passed" : "Failed"));
   }

   public static void testGettersAndSetters() {
        System.out.println("Testing getters and setters");

        ListEntities listEntities = new ListEntities(5);
        int nElem = listEntities.getnElem();
        Entity[] entityList = listEntities.getEntityList();

        // Verificar que los getters devuelven los valores correctos
        System.out.println("getnElem test: " + (nElem == 0 ? "Passed" : "Failed"));
        System.out.println("getEntityList test: " + (entityList.length == 5 ? "Passed" : "Failed"));
   }

   public static void testAddEntity() {
        System.out.println("Testing addEntity");

        ListEntities listEntities = new ListEntities(5);
        Entity entity1 = new Entity("Entity1", "123456789", "1@gmail.com");
        listEntities.addEntity2List(entity1);

        // Verificar que la entidad se agregó correctamente
        System.out.println("addEntity test: " + (listEntities.getnElem() == 1 ? "Passed" : "Failed"));
   }

   public static void testToString() {
        System.out.println("Testing toString");

        ListEntities listEntities = new ListEntities(5);
        Entity entity1 = new Entity("Entity1", "123456789", "1@gmail.com");
        Entity entity2 = new Entity("Entity2", "987654321", "2@gmail.com");
        listEntities.addEntity2List(entity1);
        listEntities.addEntity2List(entity2);

        // Verificar que toString devuelve la representación de cadena correcta
        String expectedString = "Entity List => Elements: 2\n" +
                "\n   [1] -> " + entity1 + "\n" +
                "\n   [2] -> " + entity2 + "\n";
        System.out.println("toString test: " + (listEntities.toString().equals(expectedString) ? "Passed" : "Failed"));
   }

   public static void testShowEntityName() {
        System.out.println("Testing showEntityName");

        ListEntities listEntities = new ListEntities(5);
        Entity entity1 = new Entity("Entity1", "123456789", "1@gmail.com");
        Entity entity2 = new Entity("Entity2", "987654321", "2@gmail.com");
        listEntities.addEntity2List(entity1);
        listEntities.addEntity2List(entity2);

        // Verificar que showEntityName devuelve la representación de cadena correcta
        String expectedString = "Available Entities: \n1. " + entity1.getName() + "\n" +
                "2. " + entity2.getName() + "\n";
        System.out.println("showEntityName test: " + (listEntities.showEntityName().equals(expectedString) ? "Passed" : "Failed"));
   }
}
