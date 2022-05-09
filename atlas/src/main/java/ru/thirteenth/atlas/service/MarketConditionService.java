package ru.thirteenth.atlas.service;


import ru.thirteenth.atlas.model.FearAndGreedModel;

import java.net.URISyntaxException;

public interface MarketConditionService {



    public FearAndGreedModel getFearAndGreedIndex() throws URISyntaxException;
}
