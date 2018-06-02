package com.alma.ticket.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/*
* Базовый класс для всех DAO
* содержит  crud методы
* */
@Repository
@Transactional
public abstract class BaseDAO {
    @Autowired
    protected SessionFactory sessionFactory;


}
