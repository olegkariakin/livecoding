package interview.streamapi;

import interview.streamapi.domain.Department;
import interview.streamapi.domain.Developer;
import interview.streamapi.domain.Project;

import java.util.*;
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

        //4.1 using flatting pairs
        var entires = department.projects().stream()
                .flatMap(p -> p.team().stream())
                .distinct() // Уникальные девелоперы
                .flatMap(dev -> dev.skills().stream()
                        .map(skill -> new AbstractMap.SimpleEntry<>(skill, dev)))
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())
                ));
        System.out.println("4.1 Entries: " + entires);

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
        System.out.println(STR."5.2 Average Salary: \{averageSalary}");

        //Задача 6: Текстовый отчет
        //Составь строку, в которой перечислены названия всех проектов через запятую и пробел, но только тех, в которых участвует больше 2-х разработчиков.
        //        Зачем это нужно: потренировать фильтрацию по размеру вложенного списка и Collectors.joining.
        String projectsWithMoreTwoDevs = department.projects().stream()
                .filter(p -> p.team().size() > 2)
                .map(Project::title)
                .collect(Collectors.joining(", "));
        System.out.println("6. Project titles with more two devs: " + projectsWithMoreTwoDevs);

        //Задача 7: Карта «Имя — Зарплата»
        // Создай Map<String, Double>, где ключ — имя разработчика, а значение — его зарплата. Если разработчик встречается в нескольких проектах (дублируется в стриме), оставь того, у кого зарплата выше.
        //        Зачем это нужно: разобраться с аргументами Collectors.toMap (в частности, с mergeFunction).
        Map<String, Double> developers = department.projects().stream()
                .flatMap(p -> p.team().stream())
                .collect(Collectors.toMap(
                        Developer::name,
                        Developer::salary,
                        (existing, replacement) -> Math.max(existing, replacement)
                ));
        System.out.println("7. Developers groupped by salary: " + developers);

        //Задача 8: Проверка квалификации
        //Проверь, правда ли, что в каждом активном проекте есть хотя бы один разработчик, знающий "Java". На выходе должен быть boolean.
        //        Зачем это нужно: потренировать предикаты внутри allMatch и anyMatch.
        boolean allActiveProjectsHaveJava = department.projects().stream()
                .filter(Project::isActive)
                .allMatch(p -> p.team().stream()
                        .anyMatch(d -> d.skills().contains("Java"))
                );
        System.out.println("8. Do all active projects contains a java dev: " + allActiveProjectsHaveJava);

        // Задача 9: Статистика по возрасту
        // Найди разницу между самым старшим и самым молодым разработчиком в отделе.
        //        Зачем это нужно: познакомиться с IntSummaryStatistics или методами min/max для примитивных стримов.
        IntSummaryStatistics stats = department.projects().stream()
                .flatMap(p -> p.team().stream())
                .distinct()
                .mapToInt(Developer::age)
                .summaryStatistics();
        System.out.println(STR."9. Вся статистика: \{stats}");
        System.out.println(STR."9. Разница в возрасте между самым возрастным и молодым: \{stats.getMax() - stats.getMin()}");

        // Задача 10: Плоский список всех имен (уникальный)
        // Собери все имена разработчиков в одну строку (String), отсортируй их по алфавиту и приведи к верхнему регистру.
        String allNames = department.projects().stream()
                .flatMap(p -> p.team().stream())
                .map(Developer::name)
                .distinct()
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.joining(" "));
        System.out.println("10 all distinct names sorted(asc) and capitalized: " + allNames);

        // 11. Сортировки
        // Из задачи 10 Собери уникальные имена в строку, но отсортируй их по длине имени (от коротких к длинным),
        // а если длина одинаковая — тогда по алфавиту в обратном порядке.
        String namesCompared = department.projects().stream()
                .flatMap(p -> p.team().stream())
                .map(Developer::name)
                .sorted(Comparator
                        .comparingInt(String::length) // сначала сортировка по длине, короткие - вперед
                        .thenComparing(Comparator.reverseOrder()) // если есть одинаковые - в обратном порядке
                )
                .collect(Collectors.joining(" "));
        System.out.println("11. Names compared: " + namesCompared);

        //12. Кастомная сортировка
        // Сортируем чтобы содержащие "а" шли первыми
        String namesAfirst = department.projects().stream()
                .flatMap(p -> p.team().stream())
                .map(Developer::name)
                .sorted((n1, n2) -> {
                    boolean s1HasA = n1.toLowerCase().contains("a");
                    boolean s2HasA = n2.toLowerCase().contains("a");
                    if (s1HasA && !s2HasA) return -1;
                    if (!s1HasA && s2HasA) return 1;
                    return n1.compareTo(n2);
                })
                .collect(Collectors.joining(" "));
        System.out.println("12. Names A first: " + namesAfirst);
    }
}
