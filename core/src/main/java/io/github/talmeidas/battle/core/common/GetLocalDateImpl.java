package io.github.talmeidas.battle.core.common;

import java.time.LocalDate;

import jakarta.inject.Named;


@Named
public class GetLocalDateImpl implements GetLocalDate {

    @Override
    public LocalDate now() {
        return LocalDate.now();
    }
}
