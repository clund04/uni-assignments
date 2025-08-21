public class Main {
    public static void main(String[] args) {
        // Testataan PersonID-luokkaa
        PersonID person = new PersonID();

        // Testataan henkilötunnuksen asettamista ja virheiden tarkistamista
        System.out.println(person.setPersonID("221199-123A")); // Pitäisi tulostaa "Ok"
        System.out.println(person.setPersonID("300299-123B")); // Pitäisi tulostaa "Invalid birthday!"
        System.out.println(person.setPersonID("120398+567X")); // Pitäisi tulostaa "Ok"
        System.out.println(person.setPersonID("abcdef-ghijk")); // Pitäisi tulostaa "Invalid birthday!"
        System.out.println(person.setPersonID("221199-123B")); // Pitäisi tulostaa "Incorrect check mark!"

        // Testataan Course-luokkaa
        Course course1 = new Course("Java Programming", 811322, 'A', ConstantValues.MANDATORY, 2, 5.0, true);

        // Käytetään Course-luokan metodeja
        System.out.println("Course Name: " + course1.getName());
        System.out.println("Course Code: " + course1.getCourseCode());
        System.out.println("Course Base: " + course1.getCourseBase());
        System.out.println("Course Type: " + course1.getCourseTypeString());
        System.out.println("Course Period: " + course1.getPeriod());
        System.out.println("Course Credits: " + course1.getCredits());

        // Testataan kopiointia
        Course course2 = new Course(course1); // Kopioi course1
        System.out.println("Course 2: " + course2.toString());

        StudentCourse studentCourse1 = new StudentCourse(course1, 5, 2023);

        // Testataan StudentCourse-luokan metodeja
        System.out.println("StudentCourse Testit:");
        System.out.println("---------------------");
        System.out.println("Course: " + studentCourse1.getCourse());
        System.out.println("Grade Number: " + studentCourse1.getGradeNum());
        System.out.println("Year Completed: " + studentCourse1.getYear());
        System.out.println("Is Passed: " + studentCourse1.isPassed());
        System.out.println("ToString: " + studentCourse1.toString());

        // Testataan eri arvosanoja
        studentCourse1.setGrade(0);
        System.out.println("\nTest: Hylätty kurssi (0)");
        System.out.println("Is Passed: " + studentCourse1.isPassed());

        studentCourse1.setGrade('F');
        System.out.println("\nTest: Hylätty kurssi ('F')");
        System.out.println("Is Passed: " + studentCourse1.isPassed());

        studentCourse1.setGrade(3);
        System.out.println("\nTest: Hyväksytty kurssi (3)");
        System.out.println("Is Passed: " + studentCourse1.isPassed());

        studentCourse1.setYear(2025);
        System.out.println("\nTest: Vuoden asettaminen (2025)");
        System.out.println("Year Completed: " + studentCourse1.getYear());

        Degree degree = new Degree();
        degree.setDegreeTitle("Tietojenkäsittelytiede");
        degree.setTitleOfThesis("Koneoppiminen ja tietoturva");

        // Luodaan kursseja
        Course course1 = new Course("Ohjelmointi 1", 5.0, 'P');
        Course course2 = new Course("Tietokannat", 5.0, 'A');
        Course course3 = new Course("Tietoturva", 5.0, 'S');

        // Luodaan opiskelijakurssit
        StudentCourse studentCourse1 = new StudentCourse(course1, 5, 2023);
        StudentCourse studentCourse2 = new StudentCourse(course2, 'A', 2023);
        StudentCourse studentCourse3 = new StudentCourse(course3, 3, 2024);

        // Lisätään kurssit tutkintoon
        degree.addStudentCourse(studentCourse1);
        degree.addStudentCourse(studentCourse2);
        degree.addStudentCourse(studentCourse3);

        // Tulostetaan tutkinnon tiedot
        System.out.println(degree);

        // Testataan opintopisteiden laskentaa
        System.out.println("Yhteensä opintopisteitä: " + degree.getCredits());
        System.out.println("Pohjan 'P' mukaan: " + degree.getCreditsByBase('P'));
        System.out.println("Pohjan 'A' mukaan: " + degree.getCreditsByBase('A'));
        System.out.println("Pohjan 'S' mukaan: " + degree.getCreditsByBase('S'));
    }
}
    

