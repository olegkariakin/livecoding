package interview.streamapi.domain;

import java.util.List;

public record Project(String title, List<Developer> team, boolean isActive) {}
