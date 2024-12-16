package com.solvd.airportmanager.airport;

import com.solvd.airportmanager.passenger.Ticket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.Set;
import java.util.function.Function;

public class TaxCalculateService {

    public static final BigDecimal DUBAI_TAX_RATE = BigDecimal.valueOf(0.05); //5% tax on ticket sales
    private static final Logger LOGGER = LogManager.getLogger(TaxCalculateService.class);

    public BigDecimal calculateTax(Set<Ticket> tickets, Function<Ticket, BigDecimal> taxFunction) {
        if (tickets == null || tickets.isEmpty()) {
            throw new IllegalArgumentException("Ticket list is empty or null!");
        }
        LOGGER.info("Starting tax calculation for {} tickets.", tickets.size());

        // Total tax for each ticket
        BigDecimal totalTax = tickets.stream()
                .map(taxFunction)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        LOGGER.info("Total tax calculated: {}$", totalTax);
        return totalTax;
    }
}
