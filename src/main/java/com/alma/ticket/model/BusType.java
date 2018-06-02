package com.alma.ticket.model;

import javax.persistence.*;
import java.io.Serializable;

/*
* Типы автобусов
* */
public enum  BusType implements Serializable {
    CITY, // городской
    INTER_CITY // междугородний
}
