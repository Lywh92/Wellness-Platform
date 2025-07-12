package hpbao.domain.goal;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public enum PeriodType {
    directInput,
    specificDate,
    daily,
    weekly,
    monthly;
}







