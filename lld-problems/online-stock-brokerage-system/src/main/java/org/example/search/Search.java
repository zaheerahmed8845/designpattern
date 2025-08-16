package org.example.search;

import org.example.entity.Stock;

import java.util.Optional;

public interface Search {
    Optional<Stock> searchSymbol(String symbol);
}
