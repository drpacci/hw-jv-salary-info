package core.basesyntax;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SalaryInfo {
    private final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public String getSalaryInfo(String[] names, String[] data, String dateFrom, String dateTo) {
        StringBuilder salaryInfo = new StringBuilder();
        LocalDate from = LocalDate.parse(dateFrom, FORMATTER);
        LocalDate to = LocalDate.parse(dateTo, FORMATTER);

        salaryInfo.append("Report for period ").append(dateFrom).append(" - ").append(dateTo).append("\n");

        for (String name : names) {
            int salary = 0;
            for (String datum : data) {
                String[] parts = datum.split("\\s+");
                LocalDate currentDate = LocalDate.parse(parts[0], FORMATTER);
                if (name.equals(parts[1])) {
                    if (!currentDate.isBefore(from) && !currentDate.isAfter(to)) {
                        salary += Integer.parseInt(parts[2]) * Integer.parseInt(parts[3]);
                    }
                }
            }
            salaryInfo.append(name)
                    .append(" - ")
                    .append(salary)
                    .append("\n");
        }
        return salaryInfo.toString();
    }
}
