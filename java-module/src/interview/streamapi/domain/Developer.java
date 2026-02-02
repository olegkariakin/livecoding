package interview.streamapi.domain;

import java.util.List;

public record Developer(String name, int age, List<String> skills, double salary) {}
