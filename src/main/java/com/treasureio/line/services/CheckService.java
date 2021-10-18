package com.treasureio.line.services;

import com.treasureio.line.exception.CheckNotFoundException;
import com.treasureio.line.models.Check;

import java.util.List;

public interface CheckService {

    public Check saveCheck(Check check);

    public List<Check> fetchCheckList();

    public Check fetchCheckById(Long checkId) throws CheckNotFoundException;
}
