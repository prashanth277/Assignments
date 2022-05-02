package com.service;


import com.model.Intern;

import java.util.List;

public interface InternService {
    List<Intern> getInterns();
    Intern createIntern(Intern intern);
    Intern deleteIntern(Intern intern);
    Intern updateIntern(Intern intern);

}
