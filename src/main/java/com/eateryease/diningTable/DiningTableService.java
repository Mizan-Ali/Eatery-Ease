package com.eateryease.diningTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiningTableService {

    @Autowired
    private DiningTableRepository diningTableRepository;
}
