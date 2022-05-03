package ru.thirteenth.kryptohouse.service;

import ru.thirteenth.kryptohouse.dto.FearAndGreed;

import java.net.URISyntaxException;

public interface FearAndGreedIndexService {
    FearAndGreed getFearAndGreedIndex() throws URISyntaxException;
}
