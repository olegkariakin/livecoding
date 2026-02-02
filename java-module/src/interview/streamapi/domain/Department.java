package interview.streamapi.domain;

import java.util.List;

public record Department(String name, List<Project> projects) {}
