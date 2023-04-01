package ro.pao.application;

import ro.pao.model.ExampleClass;
import ro.pao.service.ExampleService;
import ro.pao.service.impl.ExampleServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * In Meniu se fac operatiile care pot lua informatii din toate dintre servicile definite.
 * De exemplu, avem definit mai jos `private final ExampleService exampleService = new ExampleServiceImpl();`
 *
 * In cazul in care aveam definit mai multe servicii, la fel, faceam o initializare a serviciile si astfel apelam metode din serviciu.
 */
public class Menu {

    private static Menu INSTANCE;

    private final ExampleService exampleService = new ExampleServiceImpl();

    public static Menu getInstance() {
        return (INSTANCE == null ? new Menu() : INSTANCE);
    }

    public void intro() {
        String intro = """
                Intro example
                """;

        System.out.println(intro);

        ExampleClass exampleClass = ExampleClass.builder()
                .id(UUID.randomUUID())
                .creationDate(LocalDate.now()) // data de azi
                .updateDate(LocalDate.now())
                .deleteDate(LocalDate.now())
                .build();

        exampleService.addOnlyOne(exampleClass);

        List<ExampleClass> exampleServiceList = List.of(
                ExampleClass.builder()
                        .id(UUID.randomUUID())
                        .creationDate(LocalDate.of(2023, 03, 22))
                        .updateDate(LocalDate.now())
                        .build(),
                ExampleClass.builder()
                        .id(UUID.randomUUID())
                        .creationDate(LocalDate.of(2023, 03, 22))
                        .updateDate(LocalDate.now())
                        .build()
        );

        exampleService.addAllFromGivenList(exampleServiceList);

        System.out.println("Inainte de stergere: ");
        exampleService.getAllFromList()
                .forEach(elementFromList -> System.out.println(elementFromList));


        System.out.println("Dupa modificare: ");
        exampleClass.setUpdateDate(LocalDate.of(2, 2, 2));
        exampleService.modificaElementById(exampleClass.getId(), exampleClass);
        exampleService.getAllFromList()
                .forEach(elementFromList -> System.out.println(elementFromList));

        System.out.println("Dupa stergere: ");
        exampleService.removeElementById(exampleClass.getId());
        exampleService.getAllFromList()
                .forEach(elementFromList -> System.out.println(elementFromList));
    }
}
