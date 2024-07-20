package demo;

import java.util.List;

import repositorios.QueryRepositorio;
import modelos.ConstructorMaxPoint;
import modelos.DriverMaxPoint;

public class Main {

    public static void main(String[] args) {
        QueryRepositorio queryRepository = new QueryRepositorio();
        List<DriverMaxPoint> results = queryRepository.getDriversMaxPoint("jdbc:mysql://localhost/formula1", "root", "");

        System.out.println("\n\n");
        for (DriverMaxPoint rs : results) {
            System.out.println(rs.getDriverName() + "\t" + rs.getPoints());
        }
        System.out.println("+------------+-----------------+---------+-------+-----------------+-----------------+------------+-----------------+--------------------------------+");
        List<ConstructorMaxPoint> results1 = queryRepository.getConstructorsMaxPoints("jdbc:mysql://localhost/formula1", "root", "");

        for (ConstructorMaxPoint cm : results1) {
            System.out.println(cm.getConstructorname() + "\t" + cm.getPoints());
        }
    }
}

//        System.out.println("Tabla de Conductores:");
//        System.out.println("+------------+-----------------+---------+-------+-----------------+-----------------+------------+-----------------+--------------------------------+");
//        System.out.println("| DriverId   | DriverRef       | Number  | Code  | Forename        | Surname         | DOB        | Nationality     | URL                            |");
//        System.out.println("+------------+-----------------+---------+-------+-----------------+-----------------+------------+-----------------+--------------------------------+");
//
//        for (Driver driver : drivers) {
//            System.out.printf("| %-10d | %-15s | %-7d | %-5s | %-15s | %-15s | %-10s | %-15s | %-30s |\n",
//                    driver.getDriverId(), driver.getDriverRef(), driver.getNumber(), driver.getCode(),
//                    driver.getForename(), driver.getSurname(), driver.getDob(), driver.getNationality(), driver.getUrl());
//        }
//
//        System.out.println("+------------+-----------------+---------+-------+-----------------+-----------------+------------+-----------------+--------------------------------+");
//
//        ConstructorsRepository constructorsRepository = new ConstructorsRepository();
//        List<Constructors> constructors = constructorsRepository.getAllConstructors();
//
//        System.out.println("\nTabla de Constructores:");
//        System.out.println("+----------------+-----------------+---------------------+-----------------+--------------------------------+");
//        System.out.println("| ConstructorId  | ConstructorRef  | Name                | Nationality     | URL                            |");
//        System.out.println("+----------------+-----------------+---------------------+-----------------+--------------------------------+");
//
//        for (Constructors constructor : constructors) {
//            System.out.printf("| %-14d | %-15s | %-20s | %-15s | %-30s |\n",
//                    constructor.getConstructorId(), constructor.getConstructorRef(), constructor.getName(),
//                    constructor.getNationality(), constructor.getUrl());
//        }
//
//        System.out.println("+----------------+-----------------+---------------------+-----------------+--------------------------------+");


