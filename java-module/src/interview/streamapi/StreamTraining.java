package interview.streamapi;

import interview.streamapi.domain.Department;
import interview.streamapi.domain.Developer;
import interview.streamapi.domain.Project;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTraining {

    static void main() {
        Developer d1 = new Developer("Ivan", 22, List.of("Java", "SQL"), 2500);
        Developer d2 = new Developer("Anna", 28, List.of("Java", "Spring", "Docker"), 4500);
        Developer d3 = new Developer("Max", 35, List.of("Python", "Kubernetes"), 5000);
        Developer d4 = new Developer("Egor", 24, List.of("Java", "React"), 3200);
        Developer d5 = new Developer("Lana", 30, List.of("Python", "Django", "SQL"), 4200);

        Project p1 = new Project("FinTech App", List.of(d1, d2, d4), true);
        Project p2 = new Project("Legacy CRM", List.of(d1, d5), false);
        Project p3 = new Project("NextGen AI", List.of(d3, d2), true);

        Department department = new Department("IT Global", List.of(p1, p2, p3));

        // 1. Получить список имен разрабов чья зп больше 3000 без дупликатов
        List<String> namesOver3000 = department.projects().stream()
                .flatMap(p -> p.team().stream())
                .filter(d -> d.salary() > 3000)
                .map(Developer::name)
                .distinct()
                .toList();
        System.out.println("Developers earning more than 3000: " + namesOver3000);

        // 2. Работа с вложенностью через flatMap
        //Из объекта Department вытащить единый список (Set) всех уникальных навыков (skills) всех разработчиков, которые работают над активными проектами.
        Set<String> uniqueSkillsActiveProjects = department.projects().stream()
                .filter(Project::isActive) // фильтруем активные проекты
                .flatMap(p -> p.team().stream())
                .flatMap(d -> d.skills().stream())
                //.distinct() // if using List needs to call to filter uniques
                .collect(Collectors.toSet());
        System.out.println("Unique skills of people working on active projects: " + uniqueSkillsActiveProjects);

        // 3. Поиск и опционалы
        // Найти любого разработчика старше 25 лет, у которого в навыках есть "Java". Если такой найден — вернуть его имя, если нет — бросить исключение RuntimeException.
        Developer anyJavaDev = department.projects().stream()
                .flatMap(p -> p.team().stream())
                .filter(d -> d.age() > 25 && d.skills().contains("Java"))
                .findAny()
                .orElseThrow(RuntimeException::new);
        System.out.println("Any java dev" + anyJavaDev);

        // 4. Сложная группировка:
        //Сгруппировать всех разработчиков отдела по их навыкам. На выходе должна быть Map<String, List<Developer>>, где ключ — это название навыка (например, "Docker"), а значение — список ребят, которые им владеют.
        //(Подсказка: тут тоже понадобится flatMap, но внутри collect).


        // 5. Агрегация и статистика (Senior-ish):
        //Посчитать среднюю зарплату разработчиков во всем отделе, но только тех, кто задействован более чем в одном проекте.
        // 5.1 Using quantity map
        Map<Developer, Long> quantityMap = department.projects().stream()
                .flatMap(p -> p.team().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        double averageSalary = quantityMap.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .mapToDouble(e -> e.getKey().salary())
                .average()
                .orElse(0.0);
        System.out.println("5.1 Average Salary: " + averageSalary);

        // 5.2 Using collect
        averageSalary = department.projects().stream()
                .flatMap(p -> p.team().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .mapToDouble(entry -> entry.getKey().salary())
                .average()
                .orElse(0.0);
        System.out.println("5.2 Average Salary: " + averageSalary);
    }
}
